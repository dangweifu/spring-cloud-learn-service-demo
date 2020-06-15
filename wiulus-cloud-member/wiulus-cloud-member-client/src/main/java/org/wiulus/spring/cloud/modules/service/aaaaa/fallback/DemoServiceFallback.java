package org.wiulus.spring.cloud.modules.service.aaaaa.fallback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.wiulus.spring.cloud.modules.dto.aaaaa.DemoDTO;
import org.wiulus.spring.cloud.modules.service.aaaaa.DemoService;

/**
 * @author : WiuLuS
 * @version : v1.0 06.15.2020
 * @discription :
 * @date : 2020-06-15 15:25:54
 * @email : m13886933623@163.com
 */
@Component
@Slf4j
public class DemoServiceFallback implements DemoService {

    @Override
    public void add(DemoDTO dto) {

    }

    @Override
    public void modify(DemoDTO dto) {

    }

    @Override
    public void del(Long[] ids) {

    }

    @Override
    public DemoDTO selectBy (Long id) {
        return null;
    }
}
