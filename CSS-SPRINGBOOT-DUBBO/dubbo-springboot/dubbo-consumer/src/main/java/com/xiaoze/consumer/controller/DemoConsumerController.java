package com.xiaoze.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xiaoze.api.service.DemoService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Path;

/**
 * DemoConsumerController
 * 消费者控制层
 *
 * @author xiaoze
 * @date 2018/6/7
 */
@RestController
public class DemoConsumerController {

    @Reference(version = "${demo.service.version}")
    private DemoService demoService;

    @RequestMapping("/sayHello/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return demoService.sayHello(name);
    }
/*    RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(dubboConfig.getDubboAddress());
        registryConfig.setProtocol(SjfwptDubboConstant.PROTOCOL);
        registryConfig.setTimeout(dubboConfig.getTimeOut());

    //set systemId
    ApplicationConfig application = new ApplicationConfig();
        application.setName(dubboConfig.getSystemId());
        application.setId(dubboConfig.getSystemId());
    ReferenceConfig<DemoService> reference = new ReferenceConfig<DemoService>();
        reference.setId("key");
        reference.setApplication("application");
        reference.setRegistry("registryConfig");
        reference.setInterface(interfaceClass);
        reference.setTimeout(dubboConfig.getTimeOut());
        reference.setRetries(0);
        reference.setVersion(dubboConfig.getVersion());
        if (StringUtils.hasText(serviceGroup)) {
        reference.setGroup(serviceGroup);
    }
    //invoke proxy obj
    synchronized (key.intern()) {
        baseSchemaTempalte = reference.get();
        //cache service Obj key
        instanceMapCacheHolder.put(key, baseSchemaTempalte);
    }*/
}
