package org.deyi.contentcenter.feignclient;

import org.deyi.contentcenter.domain.dto.user.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//@FeignClient(name="user-center", configuration = UserCenterFeignConfiguration.class)
@FeignClient(name="user-center")
//@RequestMapping("/users")
public interface UserCenterFeignClient {
    /**
     * 当调用此方式时,feign将其转换成如下请求：
     * http://user-center/users/{id}
     * @param id
     * @return
     */
    @RequestMapping("/users/{id}")
    UserDTO findById(@PathVariable Integer id);
}
