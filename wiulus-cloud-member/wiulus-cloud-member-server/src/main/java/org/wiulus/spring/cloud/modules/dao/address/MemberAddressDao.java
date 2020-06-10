package org.wiulus.spring.cloud.modules.dao.address;

import org.wiulus.spring.cloud.commons.mybatis.dao.BaseDao;
import org.wiulus.spring.cloud.modules.entity.address.MemberAddressEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 会员地址表
 *
 * @author : WiuLuS
 * @email : m13886933623@163.com
 * @Version : 1.0
 */
@Mapper
public interface MemberAddressDao extends BaseDao<MemberAddressEntity> {

    /**
     * 修改地址默认状态
     * @param id
     * @param defaultFlag
     */
    void updateDefaultFlag(@Param("id") Long id, @Param("defaultFlag") Integer defaultFlag);

    /**
     * 根据id将会员地址设为非默认状态
     * @param memberId
     * @param defaultFlag
     */
    void updateDefaultFlagByMemberId(@Param("memberId") Long memberId, @Param("defaultFlag") Integer defaultFlag);

}