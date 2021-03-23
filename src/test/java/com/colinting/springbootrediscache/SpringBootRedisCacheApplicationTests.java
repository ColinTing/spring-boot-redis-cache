package com.colinting.springbootrediscache;

import com.colinting.springbootrediscache.config.RedisConfig;
import com.colinting.springbootrediscache.domian.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;


import java.io.Serializable;
import java.time.Duration;


@RunWith(SpringRunner.class)
@SpringBootTest
@ConfigurationPropertiesScan("com.colinting.springbootrediscache.config")
class SpringBootRedisCacheApplicationTests {

    @Autowired
    private RedisTemplate<String, String> strRedisTemplate;
    @Autowired
    private RedisTemplate<String, Serializable> serializableRedisTemplate;

    @Test
    public void testString() {
        strRedisTemplate.opsForValue().set("name", "Colin");
        serializableRedisTemplate.expire("name", Duration.ofSeconds(30));
        System.out.println(strRedisTemplate.opsForValue().get("name"));

    }

    @Test
    public void testSerializable() {
        User user=new User(1L, "colin", "男");

        serializableRedisTemplate.opsForValue().set("user", user);
        //设置session的过期时间 时间单位是秒
        serializableRedisTemplate.expire("user", Duration.ofSeconds(30));

        User user2 = (User) serializableRedisTemplate.opsForValue().get("user");
        System.out.println("user:"+user2.getId()+","+user2.getName()+","+user2.getSex());
    }



}
