package com.example.addressbook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Configuration class for setting up Redis in the Spring Boot application.
 */
@Configuration
public class RedisConfig {

    /**
     * Configures a RedisTemplate bean for interacting with Redis.
     *
     * @param redisConnectionFactory The Redis connection factory, automatically provided by Spring Boot.
     * @return A configured RedisTemplate instance.
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        // Creating a RedisTemplate instance
        RedisTemplate<String, Object> template = new RedisTemplate<>();

        // Setting the Redis connection factory, which handles connections to the Redis server
        template.setConnectionFactory(redisConnectionFactory);

        // Configuring the serializer for Redis keys (keys will be stored as plain strings)
        template.setKeySerializer(new StringRedisSerializer());

        // Configuring the serializer for Redis values (values will be stored in JSON format)
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());

        // Returning the configured RedisTemplate bean
        return template;
    }
}
