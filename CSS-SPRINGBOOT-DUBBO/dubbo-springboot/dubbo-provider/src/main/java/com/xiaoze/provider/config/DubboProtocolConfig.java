package com.xiaoze.provider.config;

import org.apache.dubbo.config.ProtocolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class DubboProtocolConfig {
    @Value("${dubbo.protocol.port}")
    private String dubbo_port;
    @Value("${rest.protocol.port}")
    private String rest_port;
    private static final Logger LOGGER = LoggerFactory.getLogger(DubboProtocolConfig.class);

    @Bean("dubbo")
    public ProtocolConfig dubboProtocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        int port = Integer.parseInt(dubbo_port);
        LOGGER.info("dubbo provider dubbo port = {}", port);
        protocolConfig.setPort(port);
        protocolConfig.setId("dubbo");
        protocolConfig.setServer(null);
        return protocolConfig;
    }

    @Bean("rest")
    public ProtocolConfig restProtocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("rest");
        int port = Integer.parseInt(rest_port.toString());
        LOGGER.info("dubbo provider rest port = {}", port);
        protocolConfig.setPort(port);
        protocolConfig.setId("rest");
        protocolConfig.setServer("jetty");
        return protocolConfig;
    }
}