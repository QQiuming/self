package com.example.self.base.sharding.strategy;

/**
 * @descriptions: ShardingTableStrategy
 * @author: qiuming
 * @date: 2025/1/19 16:11
 * @version: 1.0
 */
public interface ShardingTableStrategy {

    /**
     * 获取分表结果
     *
     * @param externalId 外部id
     * @param tableCount 表数量
     * @return 分表结果
     */
    int getTable(String externalId, int tableCount);
}
