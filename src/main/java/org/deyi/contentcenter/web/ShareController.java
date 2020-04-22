package org.deyi.contentcenter.web;

import lombok.RequiredArgsConstructor;
import org.deyi.contentcenter.domain.dto.content.ShareDTO;
import org.deyi.contentcenter.service.content.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shares")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShareController {
    private final ShareService shareService;
    private final DiscoveryClient discoveryClient;
    @GetMapping("/{id}")
    public ShareDTO findById(@PathVariable Integer id){
        return shareService.findById(id);
    }

    @GetMapping("/get")
    public List<ServiceInstance> getDiscovery(){//返回所有名为user-content的信息
        return discoveryClient.getInstances("user-center");
    }
}
