package com.example.self.base.sharding.algorithm;

import com.example.self.base.sharding.id.DistributeID;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.shardingsphere.sharding.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.sharding.api.sharding.complex.ComplexKeysShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.sharding.api.sharding.hint.HintShardingValue;

import java.util.Collection;
import java.util.HashSet;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * @descriptions: RegShardingAlgorithm
 * @author: qiuming
 * @date: 2025/1/19 15:36
 * @version: 1.0
 */
public class RegShardingAlgorithm implements ComplexKeysShardingAlgorithm<String>, HintShardingAlgorithm<String> {
    private Properties props;

    private static final String PROP_MAIN_COLUM = "mainColum";

    private static final String PROP_TABLE_COUNT = "tableCount";

    @Override
    public Properties getProps() {
        return props;
    }

    @Override
    public void init(Properties props) {
        this.props = props;
    }


    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, ComplexKeysShardingValue<String> complexKeysShardingValue) {
        Collection<String> result = new HashSet<>();

        String mainColum = props.getProperty(PROP_MAIN_COLUM);

        // 获取分片键的值
        Collection<String> mainColumns = complexKeysShardingValue.getColumnNameAndShardingValuesMap().get(mainColum);

        if (CollectionUtils.isNotEmpty(mainColumns)) {
            for (String colum : mainColumns) {
                String shardingTarget = calculateShardingTarget(colum);
                result.add(shardingTarget);
            }
            return getMatchedTables(result, availableTargetNames);
        }

        complexKeysShardingValue.getColumnNameAndShardingValuesMap().remove(mainColum);
        Collection<String> otherColumns = complexKeysShardingValue.getColumnNameAndShardingValuesMap().keySet();
        if (CollectionUtils.isNotEmpty(otherColumns)) {
            for (String colum : otherColumns) {
                Collection<String> otherColumValues = complexKeysShardingValue.getColumnNameAndShardingValuesMap().get(colum);
                for (String value : otherColumValues) {
                    String shardingTarget = extractShardingTarget(value);
                    result.add(shardingTarget);
                }
            }
            return getMatchedTables(result, availableTargetNames);
        }


        return null;
    }


    @Override
    public Collection<String> doSharding(Collection<String> collection, HintShardingValue<String> hintShardingValue) {
        return null;
    }


    private Collection<String> getMatchedTables(Collection<String> results, Collection<String> availableTargetNames) {
        Collection<String> matchedTables = new HashSet<>();
        for (String result : results) {
            matchedTables.addAll(availableTargetNames.parallelStream().filter(each -> each.endsWith(result)).collect(Collectors.toSet()));
        }
        return matchedTables;
    }


    private String calculateShardingTarget(String orgId) {
        String tableCount = props.getProperty(PROP_TABLE_COUNT);
        return DistributeID.getShardingTable(orgId, Integer.parseInt(tableCount));
    }


    private String extractShardingTarget(String bizId) {
        return DistributeID.getShardingTable(bizId);
    }
}
