package org.deyi.contentcenter.configuration;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.alibaba.nacos.NacosDiscoveryProperties;
import org.springframework.cloud.alibaba.nacos.ribbon.NacosServer;
//自定义均衡负载策略类
@Slf4j
public class NacosWeightdRule extends AbstractLoadBalancerRule {
    @Autowired
    private NacosDiscoveryProperties nacosDiscoveryProperties;
    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {
        //读取配置文件并初始化
    }

    @Override
    public Server choose(Object o) {
        try {
            //ILoadBalancer loadBalancer = this.getLoadBalancer();
            BaseLoadBalancer loadBalancer=(BaseLoadBalancer)this.getLoadBalancer();
            //
            String name=loadBalancer.getName();//获得微服务的名
            NamingService namingService = nacosDiscoveryProperties.namingServiceInstance();//得到服务相关的API
            Instance instance = namingService.selectOneHealthyInstance(name);//nacosClient自动通过基于权重的负载均衡算法，给我们提供一个实例
            log.info("选择port={}, instance={}",instance.getPort(),instance);
            return new NacosServer(instance);
        } catch (NacosException e) {
            e.printStackTrace();
            return null;
        }
    }
}
