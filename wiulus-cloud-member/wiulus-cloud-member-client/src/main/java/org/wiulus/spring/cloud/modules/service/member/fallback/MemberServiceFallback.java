package org.wiulus.spring.cloud.modules.service.member.fallback;

import org.wiulus.spring.cloud.commons.tools.exception.ErrorCode;
import org.wiulus.spring.cloud.commons.tools.page.PageData;
import org.wiulus.spring.cloud.modules.dto.member.*;
import org.wiulus.spring.cloud.modules.service.member.MemberService;
import org.wiulus.spring.cloud.modules.vo.member.MemberVoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MemberServiceFallback
 * @Description 用户管理回调
 * @author : WiuLuS
 * @Date 2019/5/28 15:00
 * @Version 1.0
 **/
@Component
@Slf4j
public class MemberServiceFallback implements MemberService {

    @Override
    public PageData<MemberListDTO> page(Map<String, Object> params) {
        return null;
    }

    @Override
    public List<MemberDTO> export(Map<String, Object> params) {
        return null;
    }

    @Override
    public PageData<MemberDTO> pageMessage(Map<String, Object> params) {
        PageData<MemberDTO> page = new PageData<>();
        page.setList(Collections.emptyList());
        return page;
    }

    @Override
    public MemberVoDTO selectMemberById(Long id) {
        return null;
    }

    @Override
    public MemberDTO getById(Long id) {
        return null;
    }

    @Override
    public MemberDTO getMemberPassword(Long id) {
        return null;
    }

    @Override
    public SecurityDTO selectSecurityUserInfo(String username) {
        return null;
    }

    @Override
    public MemberDTO selectMemberByUserName(String userName) {
        return null;
    }


    @Override
    public List<MemberVoDTO> list(Map<String, Object> params) {
        return Collections.emptyList();
    }

    @Override
    public void saveMember(MemberRegisterDTO dto) {

    }

    @Override
    public Boolean selectMemberByUsermaneOrMobile(String memberMobile) {
        return null;
    }

    @Override
    public Boolean selectMemberByMemberEmail(String memberEmail) {
        return null;
    }

    @Override
    public  Map<String, Object> saveMemberLongin(Map<String, Object> params) {
        log.info("用户注册异常，进入fallback，参数{}", params);
        HashMap<String, Object> result = new HashMap<>(2);
        result.put("code", ErrorCode.INTERNAL_SERVER_ERROR);
        result.put("msg", "用户注册异常");
        return result;
    }

    @Override
    public AuthorizationDTO login(LoginDTO login) {
        return null;
    }

    @Override
    public void updatePasswordByMobile(Map<String, Object> params) {

    }

    @Override
    public MemberDTO verifyPasswd(Map<String, Object> params) {
        return null;
    }

    @Override
    public List<MemberDTO> selectAllMember(Integer roleType) {
        return null;
    }

    @Override
    public Map<String, Object> verify(Map<String, Object> params) {
        log.info("校验用户注册提交信息异常，进入fallback，参数{}", params);
        HashMap<String, Object> result = new HashMap<>(2);
        result.put("code", ErrorCode.INTERNAL_SERVER_ERROR);
        result.put("msg", "校验用户注册提交信息异常");
        return result;
    }

    @Override
    public void updateMember(MemberUpdateDTO memberDTO) {

    }

    @Override
    public MemberUpdateDTO selectMemberUpdateDTO(Long id) {
        return null;
    }


    @Override
    public void logicDelete(Long[] ids) {

    }

    @Override
    public Map<String, Object> resetPasswd(Long id, String mobile) {
        return null;
    }

    @Override
    public Map<String, Object> updateState(Long id) {
        return null;
    }

    @Override
    public MemberPersonCenterDTO selectMember(Long id) {
        return null;
    }

    @Override
    public Map<String, Object> updatememberById(MemberDTO memberDTO) {
        return null;
    }

    @Override
    public void updateBase(MemberDTO memberDTO) {

    }

    @Override
    public MemberPhoneDTO selectByMobile(String memberMobile) {
        return null;
    }

    @Override
    public MemberVoDTO getByMobile(String mobile) {
        log.info("根据手机号获取会员信息异常，进入fallback，参数mobile:{}", mobile);
        return null;
    }

    @Override
    public Boolean updateById(MemberDTO dto) {
        return false;
    }

    /**
     * @param params
     * @return void
     * @Description 根据对应的类型添加用户积分和成长值
     * @author : WiuLuS
     * @Date 16:20 2019-12-25
     */
    @Override
    public void savePoint(Map<String, Object> params) {
        log.info("根据对应的类型添加用户积分和成长值异常，进入fallback，参数mobile:{}", params);
    }

    @Override
    public List<MemberDTO> selectPhoneListById(List<Long> memberList) {
        return null;
    }

    @Override
    public IndexMemberDataDTO indexMemberData(String startDateStr, String endDateStr) {
        return null;
    }
}
