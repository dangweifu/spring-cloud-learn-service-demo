package org.wiulus.spring.cloud.modules.service.grade;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.wiulus.spring.cloud.commons.tools.constant.PathConstant;
import org.wiulus.spring.cloud.commons.tools.constant.ServiceConstant;
import org.wiulus.spring.cloud.commons.tools.page.PageData;
import org.wiulus.spring.cloud.modules.dto.grade.MemberGradeDTO;
import org.wiulus.spring.cloud.modules.dto.grade.MemberGradeSaveDTO;
import org.wiulus.spring.cloud.modules.service.grade.fallback.MemberGradeServiceFallback;

import java.util.List;
import java.util.Map;

/**
 * 会员等级表
 *
 * @author : WiuLuS
 * @email : m13886933623@163.com
 * @Version : 1.0
 */
@FeignClient(name = ServiceConstant.WIULUS_MEMBER_SERVER,
        path = PathConstant.MEMBER_PATH + "/grade",
        fallback = MemberGradeServiceFallback.class)
public interface MemberGradeService {
    /**
     * 分页
     *
     * @param params
     * @return
     */
    @GetMapping("page")
    PageData<MemberGradeDTO> page(@RequestParam Map<String, Object> params);

    /**
     * 列表
     *
     * @param params
     * @return
     */
    @GetMapping("list")
    List<MemberGradeDTO> list(@RequestParam Map<String, Object> params);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GetMapping("{id}")
    MemberGradeSaveDTO getMember(@PathVariable("id") Long id);

    /**
     * 新增用户等级
     *
     * @param memberGradeDTO
     */
    @PostMapping
    void save(@RequestBody MemberGradeSaveDTO memberGradeDTO);

    /**
     * 修改用户等级
     *
     * @param memberGradeDTO
     */
    @PutMapping
    void update(@RequestBody MemberGradeDTO memberGradeDTO);

    /**
     * 逻辑删除
     *
     * @param ids
     */
    @DeleteMapping
    void logicDelete(@RequestBody Long[] ids);

    /**
     * 修改等级状态
     *
     * @param id
     */
    @PutMapping("status/{id}")
    void updateState(@PathVariable("id") Long id);

    /**
     * 查询用户对应等级
     */
    @GetMapping("member/{integration}")
    MemberGradeDTO selectByMemberId(@PathVariable("integration") Integer integration);

    /**
     * 校验等级名称是否重复
     *
     * @param integration 等级积分
     * @param gradeName   等级名称
     * @param gradeId   等级id
     * @return
     */
    @GetMapping("verify/name")
    Integer findNameCount(@RequestParam(value = "gradeName", required = false) String gradeName,
                          @RequestParam(value = "integration", required = false) Integer integration,
                          @RequestParam(value = "id", required = false) Long gradeId);


}