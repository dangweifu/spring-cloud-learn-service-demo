package org.wiulus.spring.cloud.modules.vo.member;

import org.wiulus.spring.cloud.modules.entity.member.MemberEntity;
import org.wiulus.spring.cloud.modules.entity.member.MemberInfoEntity;
import lombok.Data;

/**
 * memberVo
 * @Description
 * @author : WiuLuS
 * @Date 2019/5/10 11:18
 * @Version 1.0
 **/
@Data
public class MemberVo extends MemberEntity {

    /**
     * 会员详情
     */
    MemberInfoEntity memberInfoEntity;
}
