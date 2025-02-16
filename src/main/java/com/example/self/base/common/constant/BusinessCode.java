package com.example.self.base.common.constant;

/**
 * @descriptions: BusinessCode
 * @author: qiuming
 * @date: 2025/1/19 15:27
 * @version: 1.0
 */
public enum BusinessCode {

    /**
     * 订单
     */
    TAXPAYER_SHARDING(10, 4),
    /**
     * 支付单
     */
    TAXPAYER_REQUEST_SHARDING(11, 4);


    private static final int MAX_CODE = 99;

    private static final int MIN_CODE = 10;

    private int code;

    private int tableCount;

    BusinessCode(int code, int tableCount) {
        if (code > MAX_CODE || code < MIN_CODE) {
            throw new UnsupportedOperationException("unsupport code : " + code);
        }
        this.code = code;
        this.tableCount = tableCount;
    }

    public int tableCount() {
        return tableCount;
    }

    public int code() {
        return code;
    }

    public String getCodeString() {
        return String.valueOf(this.code);
    }

}
