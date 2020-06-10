package org.wiulus.spring.cloud.modules.service.address.fallback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.wiulus.spring.cloud.commons.tools.page.PageData;
import org.wiulus.spring.cloud.modules.dto.address.MemberAddressDTO;
import org.wiulus.spring.cloud.modules.service.address.MemberAddressService;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * MemberAddressServiceFallback
 * @Description 用户地址回调
 * @author : WiuLuS
 * @Date 2019/5/29 13:41
 * @Version 1.0
 **/
@Slf4j
@Component
public class MemberAddressServiceFallback implements MemberAddressService {

    @Override
    public PageData<MemberAddressDTO> page(Map<String, Object> params) {
        return null;
    }

    @Override
    public List<MemberAddressDTO> list(Map<String, Object> params) {
        return Collections.emptyList();
    }

    @Override
    public MemberAddressDTO get(Long id) {
        return null;
    }

    @Override
    public void save(MemberAddressDTO memberAddressDTO) {

    }

    @Override
    public void update(MemberAddressDTO memberAddressDTO) {

    }

    @Override
    public void logicDelete(Long[] ids) {

    }

    @Override
    public void deleteById(Long id) {

    }

    /**
     * @Author: LX 17839193044@162.com
     * @Description : 获取用户的默认地址
     * @Date: 2019/6/14 16:45
     * @Version: V1.0
     */
    @Override
    public MemberAddressDTO findDefalutAddress(Long memberId) {
        log.error("调用findDefalutAddress({})执行Fallback", memberId);
        return null;
    }

    @Override
    public void updateDefaultFlag(Long Id, Integer defaultFlag,  Long memberId) {

    }
}
