package org.wiulus.spring.cloud.modules.service.grade;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.wiulus.spring.cloud.commons.mybatis.service.impl.CrudServiceImpl;
import org.wiulus.spring.cloud.commons.tools.constant.Contants;
import org.wiulus.spring.cloud.commons.tools.page.PageData;
import org.wiulus.spring.cloud.commons.tools.utils.ConvertUtils;
import org.wiulus.spring.cloud.modules.dao.grade.MemberGradeDao;
import org.wiulus.spring.cloud.modules.dto.grade.MemberGradeDTO;
import org.wiulus.spring.cloud.modules.dto.grade.MemberGradeSaveDTO;
import org.wiulus.spring.cloud.modules.entity.grade.MemberGradeEntity;
import org.wiulus.spring.cloud.modules.service.member.MemberInfoService;
import org.apache.commons.lang3.StringUtils;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 会员等级表
 *
 * @author : WiuLuS
 * @email : m13886933623@163.com
 * @Version : 1.0
 */
@RestController("memberGradeService")
@RequestMapping("grade")
public class MemberGradeServiceImpl extends CrudServiceImpl<MemberGradeDao, MemberGradeEntity, MemberGradeDTO> implements MemberGradeService {

    @Resource
    @Qualifier("memberInfoService")
    private MemberInfoService memberInfoService;

    @Override
    public QueryWrapper<MemberGradeEntity> getWrapper(Map<String, Object> params) {
        String id = (String) params.get("id");

        QueryWrapper<MemberGradeEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

    /**
     * 分页
     *
     * @param params :
     * @return :
     */
    @Override
    @GetMapping("page")
    public PageData<MemberGradeDTO> page(@RequestParam Map<String, Object> params) {

        //排序
        params.put(Contants.ORDER_FIELD, "integration");
        params.put(Contants.ORDER, "asc");

        //分页
        IPage<MemberGradeEntity> page = getPage(params, "", false);
        List<MemberGradeDTO> memberGradeDTOList = baseDao.selectMemberGrade(page, params);
        for (MemberGradeDTO memberGradeDTO : memberGradeDTOList) {
            Integer max = baseDao.selectMinNum(memberGradeDTO.getId());
            Long memberNum = memberInfoService.selectMemberNum(memberGradeDTO.getIntegration(), max);
            memberGradeDTO.setMemeberNum(memberNum);
            memberGradeDTO.setMaxIntegration(max);
        }
        //查询
        return getPageData(memberGradeDTOList, page.getTotal(), MemberGradeDTO.class);
    }

    /**
     * 查询列表
     *
     * @param params
     * @return
     */
    @Override
    @GetMapping("list")
    public List<MemberGradeDTO> list(@RequestParam Map<String, Object> params) {
        return super.list(params);
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @Override
    @GetMapping("{id}")
    public MemberGradeSaveDTO getMember(@PathVariable("id") Long id) {
        MemberGradeDTO memberGradeDTO = super.get(id);
        MemberGradeSaveDTO memberGradeSaveDTO = ConvertUtils.
                sourceToTarget(memberGradeDTO, MemberGradeSaveDTO.class);
        Integer max = baseDao.selectMinNum(id);
        memberGradeSaveDTO.setMaxIntegration(max);
        return memberGradeSaveDTO;
    }

    /**
     * 保存
     *
     * @param memberGradeSaveDTO
     */
    @Override
    @PostMapping
    public void save(@RequestBody MemberGradeSaveDTO memberGradeSaveDTO) {
        MemberGradeDTO memberGradeDTO = ConvertUtils.sourceToTarget(memberGradeSaveDTO, MemberGradeDTO.class);
        super.save(memberGradeDTO);
    }

    /**
     * 修改
     *
     * @param memberGradeDTO
     */
    @Override
    @PutMapping
    public void update(@RequestBody MemberGradeDTO memberGradeDTO) {
        super.update(memberGradeDTO);
    }

    /**
     * 逻辑删除
     *
     * @param ids
     */
    @Override
    @DeleteMapping
    public void logicDelete(@RequestBody Long[] ids) {
        super.logicDelete(ids);
    }

    /**
     * 会员等级状态修改
     *
     * @param id
     */
    @Override
    @PutMapping("status/{id}")
    public void updateState(@PathVariable("id") Long id) {
        MemberGradeEntity memberGradeEntity = baseDao.selectById(id);
        String msg = "";
        if (ObjectUtil.isNotNull(memberGradeEntity)) {
            //todo 待添加逻辑
        } else {
            msg = "用户等级不存在";
        }
    }

    /**
     * 查询用户对应等级
     */
    @GetMapping("member/{integration}")
    @Override
    public MemberGradeDTO selectByMemberId(@PathVariable("integration") Integer integration) {
        MemberGradeEntity memberGradeEntity = baseDao.selectByMemberId(integration);
        return ConvertUtils.sourceToTarget(memberGradeEntity, MemberGradeDTO.class);
    }

    /**
     * 校验等级名称是否重复
     *
     * @param gradeName   等级名称
     * @param integration 等级积分
     * @param gradeId     等级ID
     * @return
     */
    @Override
    @GetMapping("verify/name")
    public Integer findNameCount(@RequestParam(value = "gradeName", required = false) String gradeName,
                                 @RequestParam(value = "integration", required = false) Integer integration,
                                 @RequestParam(value = "id", required = false) Long gradeId) {

        return baseDao.findNameCount(gradeName, integration, gradeId);
    }


}