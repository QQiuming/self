package com.example.self.base.sharding.config;

import com.example.self.base.sharding.id.WorkerIdHolder;
import org.redisson.api.RedissonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @descriptions: ShardingConfiguration
 * @author: qiuming
 * @date: 2025/1/19 17:48
 * @version: 1.0
 */
@Configuration
public class ShardingConfiguration {

    @Bean
    public WorkerIdHolder workerIdHolder(RedissonClient redissonClient) {
        return new WorkerIdHolder(redissonClient);
    }

}
