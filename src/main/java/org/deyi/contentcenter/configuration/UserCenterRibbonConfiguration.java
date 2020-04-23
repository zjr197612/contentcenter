package org.deyi.contentcenter.configuration;

//@Configuration //配置类
//@RibbonClient(name="user-center",configuration = RibbonConfiguration.class) //适用于服务user-center

import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Configuration;

//ribon配置类
@Configuration
@RibbonClients(defaultConfiguration = NacosWeightdRule.class) //全局配置
public class UserCenterRibbonConfiguration {

}
