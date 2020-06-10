package org.wiulus.spring.cloud.modules.dao.log;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.wiulus.spring.cloud.commons.mybatis.dao.BaseDao;
import org.wiulus.spring.cloud.modules.dto.log.MemberLoginLogDTO;
import org.wiulus.spring.cloud.modules.entity.log.MemberLoginLogEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 用户登录日志表
 *
 * @author : WiuLuS
 * @email : m13886933623@163.com
 * @Version : 1.0
 */
@Mapper
public interface MemberLoginLogDao extends BaseDao<MemberLoginLogEntity> {

    /**
     * 查询列表
     */
    List<MemberLoginLogDTO> selectMemberList(Page page, @Param("params") Map<String, Object> params);

}