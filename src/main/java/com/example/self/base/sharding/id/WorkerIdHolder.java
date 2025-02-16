package com.example.self.base.sharding.id;

import org.redisson.api.RAtomicLong;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;

/**
 * @descriptions: WorkerIdHolder
 * @author: qiuming
 * @date: 2025/1/19 17:46
 * @version: 1.0
 */
public class WorkerIdHolder implements CommandLineRunner {

    private RedissonClient redissonClient;

    @Value("${order.client.name:workerId}")
    private String clientName;

    public static long WORKER_ID;

    public WorkerIdHolder(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    @Override
    public void run(String... args) throws Exception {
        RAtomicLong atomicLong = redissonClient.getAtomicLong(clientName);
        WORKER_ID = atomicLong.incrementAndGet() % 32;
    }
}
