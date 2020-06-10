package org.wiulus.spring.cloud.modules.service.member.fallback;

import org.wiulus.spring.cloud.modules.dto.member.MemberInfoDTO;
import org.wiulus.spring.cloud.modules.dto.member.MemberUpdateDTO;
import org.wiulus.spring.cloud.modules.service.member.MemberInfoService;
import org.springframework.stereotype.Component;

/**
 * MemberInfoServiceFallback
 * @Description 用户详情回调
 * @author : WiuLuS
 * @Date 2019/5/28 15:47
 * @Version 1.0
 **/
@Component
public class MemberInfoServiceFallback implements MemberInfoService {
    @Override
    public void updateByMemberId(MemberUpdateDTO memberUpdateDTO) {

    }

    @Override
    public MemberInfoDTO get(Long id) {
        return null;
    }

    @Override
    public void save(MemberInfoDTO memberInfoDTO) {

    }

    @Override
    public void update(MemberInfoDTO memberInfoDTO) {

    }

    @Override
    public void logicDelete(Long[] ids) {

    }

    @Override
    public Long selectMemberNum(Integer min, Integer max) {
        return null;
    }

    /**
     * 修改会员成长值
     *
     * @param memberId:   会员ID
     * @param gradePoint: 会员等级积分（成长值）
     * @date 2019/12/26 10:34
     * @author lixiangx@wiulus.com
     **/
    @Override
    public void updateGradePoint(Long memberId, Integer gradePoint) {

    }
}
