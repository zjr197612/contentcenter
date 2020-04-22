package org.deyi.contentcenter.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.deyi.contentcenter.dao.content.ShareMapper;
import org.deyi.contentcenter.domain.entity.content.Share;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TestService {
    private final ShareMapper shareMapper;
    @GetMapping("/test")
    public List<Share> listAll(){
//        Share share = new Share().builder()
//                .userId(1)
//                .auditStatus("xxx")
//                .createTime(new Date())
//                .updateTime(new Date())
//                .reason("xxx")
//                .build();
//        shareMapper.insertSelective(share);
        log.info("测试成功");
        return shareMapper.selectAll();
    }
}
