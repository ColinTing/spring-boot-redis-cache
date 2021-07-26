package com.colinting.springbootrediscache.redisson;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-boot-redis-cache
 * @description: redis分布式锁
 * {@link: <a href="...">}
 * @author: Colin Ting
 * @create: 2021-07-26 13:10
 **/
@RestController
public class IndexController {


    private final Redisson redisson;


    private final StringRedisTemplate stringRedisTemplate;


    @Autowired
    public IndexController(Redisson redisson, StringRedisTemplate stringRedisTemplate) {
        this.redisson = redisson;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @RequestMapping("/deduct_stock")
    public String deductStock() {
        String lockKey = "product_001";

        RLock redissonLock = redisson.getLock(lockKey);

        try {
            redissonLock.lock();
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
            if (stock > 0) {
                int realStock = stock - 1;
                stringRedisTemplate.opsForValue().set("stock", realStock + "");
                System.out.println("扣减成功， 剩余库存" + realStock);
            } else {
                System.out.println("扣减失败， 库存不足");
            }
        } finally {
            redissonLock.unlock();
        }
        return "end";
    }

}
