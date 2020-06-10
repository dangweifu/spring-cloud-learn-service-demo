package org.wiulus.spring.cloud.modules.service.member;

import org.wiulus.spring.cloud.commons.tools.constant.PathConstant;
import org.wiulus.spring.cloud.commons.tools.constant.ServiceConstant;
import org.wiulus.spring.cloud.modules.dto.member.MemberInfoDTO;
import org.wiulus.spring.cloud.modules.dto.member.MemberUpdateDTO;
import org.wiulus.spring.cloud.modules.service.member.fallback.MemberInfoServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 会员详细信息表
 *
 * @author : WiuLuS
 * @email : m13886933623@163.com
 * @Version : 1.0
 */
@FeignClient(name = ServiceConstant.WIULUS_MEMBER_SERVER,
        path = PathConstant.MEMBER_PATH + "/member/info",
        fallback = MemberInfoServiceFallback.class)
public interface MemberInfoService {

    /**
     * 修改用户详情
     */
    @PutMapping("modify")
    void updateByMemberId(@RequestBody MemberUpdateDTO memberUpdateDTO);

    /**
     * 根据id查询用户详情
     *
     * @param id
     * @return
     */
    @GetMapping("{id}")
    MemberInfoDTO get(@PathVariable("id") Long id);

    /**
     * 保存用户详情
     *
     * @param memberInfoDTO
     */
    @PostMapping
    void save(@RequestBody MemberInfoDTO memberInfoDTO);

    /**
     * 修改用户详情
     *
     * @param memberInfoDTO
     */
    @PutMapping
    void update(@RequestBody MemberInfoDTO memberInfoDTO);

    /**
     * 逻辑删除
     *
     * @param ids
     */
    @DeleteMapping
    void logicDelete(@RequestBody Long[] ids);

    /**
     * 根据等级积分查询相应人数
     * @param min  最小
     * @param max  最大
     * @return
     */
    @GetMapping("num")
    Long selectMemberNum(@RequestParam("min") Integer min, @RequestParam("max") Integer max);

    /**
     * 修改会员成长值
     *
     * @param memberId:   会员ID
     * @param gradePoint: 会员等级积分（成长值）
     * @date 2019/12/26 10:34
     * @author lixiangx@wiulus.com
     **/
    @PutMapping("point")
    void updateGradePoint(@RequestParam("memberId") Long memberId,
                          @RequestParam("gradePoint") Integer gradePoint);
}