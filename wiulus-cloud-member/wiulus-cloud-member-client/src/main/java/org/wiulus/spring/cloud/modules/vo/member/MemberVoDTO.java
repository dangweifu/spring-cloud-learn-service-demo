package org.wiulus.spring.cloud.modules.vo.member;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.wiulus.spring.cloud.modules.dto.member.MemberDTO;
import org.wiulus.spring.cloud.modules.dto.member.MemberInfoDTO;

/**
 * MemberVoDTO
 * @Description 会员实体vo
 * @author : WiuLuS
 * @Date 2019/5/10 11:50
 * @Version 1.0
 **/
@Data
@ApiModel(description = "MemberVoDTO")
public class MemberVoDTO extends MemberDTO {
    /**
     * 会员详情
     */
    @ApiModelProperty(value = "会员详情")
    MemberInfoDTO memberInfoDTO;
}
