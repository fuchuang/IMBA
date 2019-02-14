package com.IMBA.redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class redisConfig {

    private String addressConfig;
    private String addressKeyPrefix;
    private String timeout;
    private String maxRedirections;
    private GenericObjectPoolConfig genericObjectPoolConfig;
    public void setAddressConfig(String addressConfig) {
        this.addressConfig = addressConfig;
    }

    public String getAddressConfig() {
        return addressConfig;
    }

    public void setAddressKeyPrefix(String addressKeyPrefix) {
        this.addressKeyPrefix = addressKeyPrefix;
    }

    public String getAddressKeyPrefix() {
        return addressKeyPrefix;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    public String getTimeout() {
        return timeout;
    }

    public void setMaxRedirections(String maxRedirections) {
        this.maxRedirections = maxRedirections;
    }

    public String getMaxRedirections() {
        return maxRedirections;
    }

    public void setGenericObjectPoolConfig(GenericObjectPoolConfig genericObjectPoolConfig) {
        this.genericObjectPoolConfig = genericObjectPoolConfig;
    }

    public GenericObjectPoolConfig getGenericObjectPoolConfig() {
        return genericObjectPoolConfig;
    }
}
