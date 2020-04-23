package org.deyi.contentcenter.configuration;

import feign.Logger;
import org.springframework.context.annotation.Bean;

//feign日志级别配置类
//@Configuration, 写了这个注解，这个类必须放到启动类所在的包外，否则这里的配置会成为一个全局配置
//这个问题任然是父子上下文重复扫描引起的
public class UserCenterFeignConfiguration {
    @Bean
    public Logger.Level level(){
        return Logger.Level.FULL;//打印请求的所有细节
    }
}
