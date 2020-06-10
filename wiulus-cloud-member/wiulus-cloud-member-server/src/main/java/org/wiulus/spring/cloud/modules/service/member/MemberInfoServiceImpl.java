package org.wiulus.spring.cloud.modules.service.member;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.wiulus.spring.cloud.commons.mybatis.service.impl.CrudServiceImpl;
import org.wiulus.spring.cloud.modules.dao.member.MemberInfoDao;
import org.wiulus.spring.cloud.modules.dto.member.MemberInfoDTO;
import org.wiulus.spring.cloud.modules.dto.member.MemberUpdateDTO;
import org.wiulus.spring.cloud.modules.entity.member.MemberInfoEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 会员详细信息表
 *
 * @author : WiuLuS
 * @email : m13886933623@163.com
 * @Version : 1.0
 */
@RestController("memberInfoService")
@RequestMapping("member/info")
public class MemberInfoServiceImpl extends CrudServiceImpl<MemberInfoDao, MemberInfoEntity, MemberInfoDTO> implements MemberInfoService {

    @Override
    public QueryWrapper<MemberInfoEntity> getWrapper(Map<String, Object> params) {
        String id = (String) params.get("id");

        QueryWrapper<MemberInfoEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

    /**
     * 根据用户id修改用户详情
     *
     * @param memberUpdateDTO
     */
    @Override
    @PutMapping("modify")
    public void updateByMemberId(@RequestBody MemberUpdateDTO memberUpdateDTO) {

        baseDao.updateByMemberId(memberUpdateDTO);
    }

    /**
     * 根据id查询用户详情
     *
     * @param id
     * @return
     */
    @Override
    @GetMapping("{id}")
    public MemberInfoDTO get(@PathVariable("id") Long id) {
        return super.get(id);
    }

    /**
     * 用户详情保存
     *
     * @param memberInfoDTO
     */
    @Override
    @PostMapping
    public void save(@RequestBody MemberInfoDTO memberInfoDTO) {
        super.save(memberInfoDTO);
    }

    /**
     * 修改用户详情
     *
     * @param memberInfoDTO
     */
    @Override
    @PutMapping
    public void update(@RequestBody MemberInfoDTO memberInfoDTO) {
        super.update(memberInfoDTO);
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
     * 根据等级积分查询相应人数
     *
     * @param min 最小
     * @param max 最大
     * @return
     */
    @GetMapping("num")
    @Override
    public Long selectMemberNum(@RequestParam("min") Integer min, @RequestParam("max") Integer max) {
        return baseDao.selectMemberNum(min, max);
    }


    /**
     * 修改会员成长值
     *
     * @param memberId:   会员ID
     * @param gradePoint: 会员等级积分（成长值）
     * @date 2019/12/26 10:34
     * @author lixiangx@wiulus.com
     **/
    @Override
    @PutMapping("point")
    public void updateGradePoint(@RequestParam("memberId") Long memberId,
                                 @RequestParam("gradePoint") Integer gradePoint) {
        baseDao.updateGradePoint(memberId, gradePoint);
    }

}