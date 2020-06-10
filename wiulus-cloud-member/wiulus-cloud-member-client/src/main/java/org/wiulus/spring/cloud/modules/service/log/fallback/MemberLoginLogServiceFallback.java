package org.wiulus.spring.cloud.modules.service.log.fallback;

import org.springframework.stereotype.Component;
import org.wiulus.spring.cloud.commons.tools.page.PageData;
import org.wiulus.spring.cloud.modules.dto.log.MemberLoginLogDTO;
import org.wiulus.spring.cloud.modules.dto.log.MemberLoginLogExcelDTO;
import org.wiulus.spring.cloud.modules.service.log.MemberLoginLogService;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * MemberLoginLogServiceFallback
 * @Description 用户登录日志回调
 * @author : WiuLuS
 * @Date 2019/5/30 18:20
 * @Version 1.0
 **/

@Component
public class MemberLoginLogServiceFallback implements MemberLoginLogService {
    @Override
    public PageData<MemberLoginLogDTO> page(Map<String, Object> params) {
        return null;
    }

    @Override
    public List<MemberLoginLogDTO> list(Map<String, Object> params) {
        return Collections.emptyList();
    }

    @Override
    public MemberLoginLogDTO get(Long id) {
        return null;
    }

    @Override
    public void save(MemberLoginLogDTO dto) {

    }

    @Override
    public void update(MemberLoginLogDTO dto) {

    }

    @Override
    public void delete(Long[] ids) {

    }

    @Override
    public List<MemberLoginLogExcelDTO> export(Map<String, Object> params) {
        return Collections.emptyList();
    }
}
