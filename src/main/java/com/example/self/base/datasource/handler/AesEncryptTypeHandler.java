package com.example.self.base.datasource.handler;

import com.example.self.base.util.AesUtil;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @descriptions: AesEncryptTypeHandler
 * @author: qiuming
 * @date: 2025/1/22 14:26
 * @version: 1.0
 */
public class AesEncryptTypeHandler extends BaseTypeHandler<String> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, encrypt(parameter));
    }

    @Override
    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String encrypted = rs.getString(columnName);
        return encrypted == null ? null : decrypt(encrypted);
    }

    @Override
    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String encrypted = rs.getString(columnIndex);
        return encrypted == null ? null : decrypt(encrypted);
    }

    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String encrypted = cs.getString(columnIndex);
        return encrypted == null ? null : decrypt(encrypted);
    }

    /**
     * 加密方法
     * @param data
     * @return
     */
    private String encrypt(String data) {
        // 实现数据加密逻辑
        return AesUtil.encrypt(data);
    }

    /**
     * 解密方法
     * @param data
     * @return
     */
    private String decrypt(String data) {
        // 实现数据解密逻辑
        return AesUtil.decrypt(data);
    }

}
