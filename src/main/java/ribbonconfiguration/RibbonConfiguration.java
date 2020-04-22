package ribbonconfiguration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//这个配置类不同被 ContentcenterApplication 扫描到,所以要放到外部
//避免重复扫描，SSM中重复配置可能导致事务失效
//ContentcenterApplication 是父上下文,RibbonConfiguration是子上下文
//对ribbon而言,重复扫描会导致这里的均衡负载规则成为全局的规则,使用与所有的服务而非指定的服务
@Configuration
public class RibbonConfiguration {
    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }
}
