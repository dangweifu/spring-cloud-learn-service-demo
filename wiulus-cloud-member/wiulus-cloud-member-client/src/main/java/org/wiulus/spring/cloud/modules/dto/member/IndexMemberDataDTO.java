package org.wiulus.spring.cloud.modules.dto.member;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xuzhch
 * IndexMemberDataDTO
 * @Description 首页用户数据
 * @Date 2020/3/16/016
 */
@Data
public class IndexMemberDataDTO implements Serializable {
    private Integer newMemberCount;
    private Integer memberCount;
}
