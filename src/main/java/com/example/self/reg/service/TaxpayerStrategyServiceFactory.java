package com.example.self.reg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @descriptions: TaxpayerStrategyServiceFactory
 * @author: qiuming
 * @date: 2025/1/21 18:01
 * @version: 1.0
 */
@Service
public class TaxpayerStrategyServiceFactory {

    @Autowired
    Map<String,TaxpayerStrategyService> taxpayerStrategyServiceMap = new ConcurrentHashMap<>();

    public TaxpayerStrategyService get(String taxpayerType) {
        String beanName = taxpayerType+ "TaxpayerStrategyService";

        //组装出beanName，并从map中获取对应的bean
        TaxpayerStrategyService service = taxpayerStrategyServiceMap.get(beanName);

        if (service != null) {
            return service;
        } else {
            throw new UnsupportedOperationException(
                    "No ChainService Found With chainType : " + taxpayerType);
        }
    }

}
