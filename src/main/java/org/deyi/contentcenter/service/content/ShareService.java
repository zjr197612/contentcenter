package org.deyi.contentcenter.service.content;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.deyi.contentcenter.dao.content.ShareMapper;
import org.deyi.contentcenter.domain.dto.content.ShareDTO;
import org.deyi.contentcenter.domain.dto.user.UserDTO;
import org.deyi.contentcenter.domain.entity.content.Share;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class ShareService {
    private final ShareMapper shareMapper;
    private final RestTemplate restTemplate;
    private final DiscoveryClient discoveryClient;

    public ShareDTO findById(Integer id){
        Share share = this.shareMapper.selectByPrimaryKey(id);
        //实现一个客户端侧的负载均衡器开始
//        List<ServiceInstance> instances = discoveryClient.getInstances("user-center");//获得所有地址
//
//        List<String> targetURLS=instances.stream()
//                .map(instance -> instance.getUri().toString()+"/users/{id}") //取出每个地址
//                .collect(Collectors.toList());//转成list
//        int i= ThreadLocalRandom.current().nextInt(targetURLS.size());//生成随机数
//        String targetURL=targetURLS.get(i);//随机获取一个地址
//        log.info("请求的地下是:{}", targetURL);
        //实现一个客户端侧的负载均衡器结束

        //ribon会自动将user-center转换成实际地址
        String targetURL="http://user-center/users/{id}";
        UserDTO user=restTemplate.getForObject(targetURL,UserDTO.class,share.getUserId());//访问远程服务

        ShareDTO shareDTO = new ShareDTO();
        BeanUtils.copyProperties(share,shareDTO);
        shareDTO.setWxNickname(user.getWxNickname());
        return shareDTO;
    }

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        UserDTO entity=restTemplate.getForObject("http://localhost:8080/users/1",UserDTO.class,1);//访问远程服务
        System.out.println(entity);
    }
}

