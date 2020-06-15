package org.wiulus.spring.cloud.modules.dao.member;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.wiulus.spring.cloud.commons.mybatis.dao.BaseDao;
import org.wiulus.spring.cloud.modules.dto.member.*;
import org.wiulus.spring.cloud.modules.entity.member.MemberEntity;
import org.wiulus.spring.cloud.modules.vo.member.MemberVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 会员表
 *
 * @author : WiuLuS
 * @email : m13886933623@163.com
 * @Version : 1.0
 */
@Mapper
public interface MemberDao extends BaseDao<MemberEntity> {

    /**
     * list
     *
     * @param params
     * @return DY 2019.5.10
     */
    List<MemberVo> getList(@Param("params") Map<String, Object> params);

    /**
     * 分页
     *
     * @param page
     * @return
     */
    List<MemberVo> getPage(IPage page, @Param("params") Map<String, Object> params);

    /**
     * 功能描述:
     * <导出会员列表查询>
     *
     * @param params
     * @return 列表数据
     * @Date 2020/1/14 13:54
     * @author weixianchun
     **/
    List<MemberDTO> findListExport(@Param("params") Map<String, Object> params);

    /**
     * 根据id查询用户详情
     *
     * @param id
     * @return
     */
    MemberVo selectMemberById(Long id);


    /**
     * 根据用户名称返回用户信息
     *
     * @param username
     * @return
     */

    MemberEntity selectMemberByUserName(@Param("username") String username);


    /**
     * 根据name查询用户认证信息
     */
    SecurityDTO selectSecurityUserInfo(@Param("userName") String userName);

    /**
     * 根据用户名或手机号查询
     */
    Boolean selectMemberByUsermaneOrMobile(String memberMobile);

    /**
     * 根据邮箱查询是否被注册过
     *
     * @param memberEmail
     * @return
     */
    Boolean selectMemberByMemberEmail(String memberEmail);


    /**
     * 验证用户名密码
     *
     * @param memberName
     * @return
     */
    MemberEntity findByName(@Param("memberName") String memberName);


    /**
     * 根据手机号修改密码
     *
     * @param mobile 手机号
     * @param passwd 密码
     */
    void updatePasswordByMobile(@Param("mobile") String mobile, @Param("passwd") String passwd);

    /**
     * 根据Unionid查询
     *
     * @param unionid
     * @return
     */
    MemberEntity selectByUnionid(@Param("unionid") String unionid);

    /**
     * 根据id查询数据
     *
     * @param id
     * @return
     */
    MemberUpdateDTO selectMemberUpdateDTO(Long id);

    /**
     * @author : WiuLus
     * @Description : 根据手机号查询用户信息
     * @Date :2019/7/23 17:34
     * @param memberMobile 手机号
     * @Version V1.0
     **/
    MemberPhoneDTO selectByMobile(String memberMobile);

    /**
     * 批量查询用户手机号
     *
     * @param memberList
     * @return
     */
    List<MemberDTO> selectPhoneListById(@Param("list") List<Long> memberList);

    IndexMemberDataDTO selectIndexMemberData(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
