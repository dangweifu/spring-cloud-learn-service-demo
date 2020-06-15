package org.wiulus.spring.cloud.modules.service.aaaaa;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.wiulus.spring.cloud.commons.tools.constant.PathConstant;
import org.wiulus.spring.cloud.commons.tools.constant.ServiceConstant;
import org.wiulus.spring.cloud.modules.dto.aaaaa.DemoDTO;
import org.wiulus.spring.cloud.modules.service.aaaaa.fallback.DemoServiceFallback;

/**
 * @author : WiuLuS
 * @version : v1.0 06.15.2020
 * @discription :
 * @date : 2020-06-15 15:23:42
 * @email : m13886933623@163.com
 */
@FeignClient(name = ServiceConstant.WIULUS_DEMO_SERVER, path = PathConstant.MEMBER_PATH + "/demo/info", fallback = DemoServiceFallback.class)
public interface DemoService {
    /**
     * add
     * @param dto :
     */
    @PostMapping("add")
    void add(DemoDTO dto) ;
    /**
     * modify
     * @param dto :
     */
    @PostMapping("modify")
    void modify(DemoDTO dto) ;
    /**
     * delete
     * @param ids :
     */
    @PostMapping("del")
    void del(Long[] ids) ;
    /**
     * select
     * @param id :
     * @return : DemoDTO
     */
    @GetMapping("{id}")
    DemoDTO selectBy (@PathVariable("id") Long id);
}
