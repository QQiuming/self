package com.example.self.base.sharding.strategy;

/**
 * @descriptions: DefaultShardingTableStrategy
 * @author: qiuming
 * @date: 2025/1/19 16:11
 * @version: 1.0
 */
public class DefaultShardingTableStrategy implements ShardingTableStrategy {

    public DefaultShardingTableStrategy() {
    }

    @Override
    public int getTable(String externalId,int tableCount) {
        Long id = Long.valueOf(externalId);
        return (int) (id % tableCount);
//        int hashCode = externalId.hashCode();
//        return (int) Math.abs((long) hashCode) % tableCount;
        //  为了性能更好，可以优化成：return (int) Math.abs((long) hashCode) & (tableCount - 1); 具体原理参考 hashmap 的 hash 方法
    }
}
