package com.colinting.springbootrediscache.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;


@ConstructorBinding
@ConfigurationProperties(prefix = "redis")
public final class RedisConfig {

    private final int database;

    private final String host;

    private final int port;

    private final String password;

    private final int timeout;

    private final int maxActive;

    private final long maxWaitMillis;

    private final int maxIdle;

    private final int minIdle;

    public RedisConfig(
            int database,
            String host,
            int port,
            String password,
            int timeout,
            int maxActive,
            long maxWaitMillis,
            int maxIdle,
            int minIdle) {
        this.database = database;
        if (host == null) {
            throw new NullPointerException("Null host");
        }
        this.host = host;
        this.port = port;
        if (password == null) {
            throw new NullPointerException("Null password");
        }
        this.password = password;
        this.timeout = timeout;
        this.maxActive = maxActive;
        this.maxWaitMillis = maxWaitMillis;
        this.maxIdle = maxIdle;
        this.minIdle = minIdle;
    }



    public int getDatabase() {
        return database;
    }


    public String getHost() {
        return host;
    }


    public int getPort() {
        return port;
    }


    public String getPassword() {
        return password;
    }


    public int getTimeout() {
        return timeout;
    }


    public int getMaxActive() {
        return maxActive;
    }


    public long getMaxWaitMillis() {
        return maxWaitMillis;
    }


    public int getMaxIdle() {
        return maxIdle;
    }


    public int getMinIdle() {
        return minIdle;
    }

    @Override
    public String toString() {
        return "ConfigProperties{"
                + "database=" + database + ", "
                + "host=" + host + ", "
                + "port=" + port + ", "
                + "password=" + password + ", "
                + "timeout=" + timeout + ", "
                + "maxActive=" + maxActive + ", "
                + "maxWaitMillis=" + maxWaitMillis + ", "
                + "maxIdle=" + maxIdle + ", "
                + "minIdle=" + minIdle
                + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof RedisConfig) {
            RedisConfig that = (RedisConfig) o;
            return this.database == that.getDatabase()
                    && this.host.equals(that.getHost())
                    && this.port == that.getPort()
                    && this.password.equals(that.getPassword())
                    && this.timeout == that.getTimeout()
                    && this.maxActive == that.getMaxActive()
                    && this.maxWaitMillis == that.getMaxWaitMillis()
                    && this.maxIdle == that.getMaxIdle()
                    && this.minIdle == that.getMinIdle();
        }
        return false;
    }

    @Override
    public int hashCode() {
        int h$ = 1;
        h$ *= 1000003;
        h$ ^= database;
        h$ *= 1000003;
        h$ ^= host.hashCode();
        h$ *= 1000003;
        h$ ^= port;
        h$ *= 1000003;
        h$ ^= password.hashCode();
        h$ *= 1000003;
        h$ ^= timeout;
        h$ *= 1000003;
        h$ ^= maxActive;
        h$ *= 1000003;
        h$ ^= (int) ((maxWaitMillis >>> 32) ^ maxWaitMillis);
        h$ *= 1000003;
        h$ ^= maxIdle;
        h$ *= 1000003;
        h$ ^= minIdle;
        return h$;
    }

}
