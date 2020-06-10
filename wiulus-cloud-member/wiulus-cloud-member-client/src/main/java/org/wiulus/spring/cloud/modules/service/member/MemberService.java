package org.wiulus.spring.cloud.modules.service.member;

import org.wiulus.spring.cloud.commons.tools.constant.ServiceConstant;
import org.wiulus.spring.cloud.commons.tools.page.PageData;
import org.wiulus.spring.cloud.modules.dto.member.*;
import org.wiulus.spring.cloud.modules.vo.member.MemberVoDTO;
import org.wiulus.spring.cloud.modules.service.member.fallback.MemberServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 会员表
 *
 * @author : WiuLuS
 * @email : m13886933623@163.com
 * @Version : 1.0
 */
@FeignClient(name = ServiceConstant.WIULUS_MEMBER_SERVER, path = "member/member", fallback = MemberServiceFallback.class)
public interface MemberService {

    /**
     * 分页查询会员管理列表
     */
    @GetMapping("page")
    PageData<MemberListDTO> page(@RequestParam Map<String, Object> params);

    /**
     *功能描述:
     *  <导出查询>
     *
     * @param params
     * @return
     * @date 2020/1/13 21:03
     * @author weixianchun
     **/
    @GetMapping("export")
    List<MemberDTO> export(@RequestParam Map<String, Object> params);

    /**
     * 功能描述:
     * 〈站内信列表会员查询〉
     *
     * @param params 查询条件
     * @author : WiuLuS
     */
    @GetMapping("page/message")
    PageData<MemberDTO> pageMessage(@RequestParam Map<String, Object> params);

    /**
     * 根据id查询用户详情
     */
    @GetMapping("{id}")
    MemberVoDTO selectMemberById(@PathVariable("id") Long id);

    /**
     * 根据id查询会员信息
     * @param id
     * @return
     */
    @GetMapping("id/{id}")
    MemberDTO getById(@PathVariable("id") Long id);

    /**
     * 功能描述:
     * 〈获得会员密码〉
     *
     * @param id 会员id
     * @author : WiuLuS
     */
    @GetMapping("password/{id}")
    MemberDTO getMemberPassword(@PathVariable("id") Long id);

    /**
     * 根据name查询用户id
     */
    @GetMapping("username")
    SecurityDTO selectSecurityUserInfo(@RequestParam("username") String username);

    /**
     * 根据name查询用户id
     */
    @GetMapping("userName")
    MemberDTO selectMemberByUserName(@RequestParam("userName") String userName);

    /**
     * 查询列表
     */
    @GetMapping("list")
    List<MemberVoDTO> list(@RequestParam Map<String, Object> params);

    /**
     * 保存用户信息
     */
    @PostMapping("register")
    void saveMember(@RequestBody MemberRegisterDTO dto);

    /**
     * 查询用户手机号是否已经注册
     */
    @GetMapping("name/mobile")
    Boolean selectMemberByUsermaneOrMobile(@RequestParam("memberMobile") String memberMobile);

    /**
     * 邮箱是否已经注册
     *
     * @param memberEmail
     * @return
     */
    @GetMapping("email")
    Boolean selectMemberByMemberEmail(@RequestParam("memberEmail") String memberEmail);

    /**
     * 注册用户保存
     *
     * @param params
     */
    @PostMapping
    Map<String, Object> saveMemberLongin(@RequestParam Map<String, Object> params);

    /**
     * 登录
     *
     * @param loginDTO
     * @return
     */
    @PostMapping("login")
    AuthorizationDTO login(@RequestBody LoginDTO loginDTO);

    /**
     * 根据手机号修改密码
     *
     * @param params
     * @return
     */
    @PutMapping("password")
    void updatePasswordByMobile(@RequestParam Map<String, Object> params);

    /**
     * 校验密码
     *
     * @param params
     * @return
     */
    @GetMapping("verify/passwd")
    MemberDTO verifyPasswd(@RequestParam Map<String, Object> params);

    /**
     * 根据用户角色类型查询
     * rolleType   用户角色类型
     *
     * @return
     */
    @GetMapping("all")
    List<MemberDTO> selectAllMember(@RequestParam(value = "roleType", required = false) Integer roleType);

    /**
     * 校验用户是否注册
     *
     * @param params
     * @return
     */
    @GetMapping("verify")
    Map<String, Object> verify(@RequestParam Map<String, Object> params);

    /**
     * 修改用户信息
     *
     * @param memberDTO
     * @return
     */
    @PutMapping
    void updateMember(@RequestBody MemberUpdateDTO memberDTO);

    /**
     * 会员编辑回显
     */
    @GetMapping("edit/{id}")
    MemberUpdateDTO selectMemberUpdateDTO(@PathVariable("id") Long id);
    /**
     * 删除用户信息
     *
     * @param ids
     */
    @DeleteMapping
    void logicDelete(@RequestBody Long[] ids);


    /**
     * 重置密码
     *
     * @param id     会员id
     * @param mobile 手机号
     */
    @PutMapping("reset/passwd")
    Map<String, Object> resetPasswd(@RequestParam("id") Long id, @RequestParam("mobile") String mobile);

    /**
     * 修改用户状态
     *
     * @param id 用户id
     * @return
     */
    @PutMapping("status/{id}")
    Map<String, Object> updateState(@PathVariable("id") Long id);

    /**
     * 根据id获取用户基本信息
     *
     * @param id
     * @return
     */
    @GetMapping("base/{id}")
    MemberPersonCenterDTO selectMember(@PathVariable("id") Long id);

    @PutMapping("update/member")
    Map<String, Object> updatememberById(@RequestBody MemberDTO memberDTO);

    /**
     * member基础信息修改
     *
     * @date 2019/11/11 10:25
     * @author lixiangx@wiulus.com
     **/
    @PutMapping("/base")
    void updateBase(@RequestBody MemberDTO memberDTO);

    /**
     * @author : WiuLus
     * @Description : 根据手机号查询用户信息
     * @Date :2019/7/23 17:34
     * @param memberMobile 手机号
     * @Version V1.0
     **/
    @GetMapping("member/mobile")
    MemberPhoneDTO selectByMobile(@RequestParam("memberMobile") String memberMobile);

    /**
     * @Description  根据手机号查询用户信息
     * @param mobile:
     * @author : WiuLuS
     * @Date 15:24 2019-12-19
     * @return org.wiulus.spring.cloud.modules.vo.member.MemberVoDTO
     */
    @GetMapping("/mobile")
    MemberVoDTO getByMobile(@RequestParam("mobile") String mobile);

    /**
     * @Description  更新用户信息
     * @param dto:
     * @author : WiuLuS
     * @Date 15:39 2019-12-19
     * @return java.lang.Boolean
     */
    @PutMapping("update")
    Boolean updateById(@RequestBody MemberDTO dto);

    /**
     * @Description  根据对应的类型添加用户积分和成长值
     * @author : WiuLuS
     * @Date 16:20 2019-12-25
     * @return void
     */
    @PostMapping("point")
    void savePoint(@RequestParam Map<String, Object> params);

    /**
     * 批量查询用户手机号
     * @param memberList
     * @return
     */
    @PostMapping("batch/phone")
    List<MemberDTO> selectPhoneListById(@RequestBody List<Long> memberList);

    @GetMapping("index/data")
    IndexMemberDataDTO indexMemberData(@RequestParam("startDateStr") String startDateStr, @RequestParam("endDateStr") String endDateStr);
}
