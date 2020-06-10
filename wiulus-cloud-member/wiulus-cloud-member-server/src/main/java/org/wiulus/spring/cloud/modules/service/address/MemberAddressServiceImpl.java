package org.wiulus.spring.cloud.modules.service.address;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.wiulus.spring.cloud.commons.mybatis.service.impl.CrudServiceImpl;
import org.wiulus.spring.cloud.commons.tools.page.PageData;
import org.wiulus.spring.cloud.commons.tools.utils.ConvertUtils;
import org.wiulus.spring.cloud.modules.dao.address.MemberAddressDao;
import org.wiulus.spring.cloud.modules.dto.address.MemberAddressDTO;
import org.wiulus.spring.cloud.modules.entity.address.MemberAddressEntity;
import org.wiulus.spring.cloud.modules.enums.member.MemberAddressEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 会员地址表
 *
 * @author : WiuLuS
 * @email : m13886933623@163.com
 * @Version : 1.0
 */
@RestController("memberAddressService")
@RequestMapping("address")
public class MemberAddressServiceImpl extends CrudServiceImpl<MemberAddressDao, MemberAddressEntity, MemberAddressDTO> implements MemberAddressService {

    @Override
    public QueryWrapper<MemberAddressEntity> getWrapper(Map<String, Object> params) {
        String id = (String) params.get("id");
        String memberId = (String) params.get("memberId");

        QueryWrapper<MemberAddressEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);
        wrapper.eq(StringUtils.isNotBlank(memberId), "member_id", memberId);
        wrapper.orderByDesc("default_flag");
        return wrapper;
    }

    /**
     * 分页
     *
     * @param params
     * @return
     */
    @Override
    @GetMapping("page")
    public PageData<MemberAddressDTO> page(@RequestParam Map<String, Object> params) {
        return super.page(params);
    }

    /**
     * 列表
     *
     * @param params
     * @return
     */
    @Override
    @GetMapping("list")
    public List<MemberAddressDTO> list(@RequestParam Map<String, Object> params) {
        return super.list(params);
    }

    /**
     * 根据id修改
     *
     * @param id
     * @return
     */
    @Override
    @GetMapping("{id}")
    public MemberAddressDTO get(@PathVariable("id") Long id) {
        return super.get(id);
    }

    /**
     * 保存地址
     *
     * @param memberAddressDTO
     */
    @Override
    @PostMapping
    public void save(@RequestBody MemberAddressDTO memberAddressDTO) {

        MemberAddressEntity memberAddressEntity = ConvertUtils.sourceToTarget(memberAddressDTO, MemberAddressEntity.class);
        insert(memberAddressEntity);
        //设为用户默认地址
        if (memberAddressEntity.getDefaultFlag() == MemberAddressEnum.IS_DEFAULT.value()) {
            this.updateDefaultFlag(memberAddressEntity.getId(), MemberAddressEnum.IS_DEFAULT.value(), memberAddressEntity.getMemberId());
        }

    }

    /**
     * 修改地址
     *
     * @param memberAddressDTO
     */
    @Override
    @PutMapping
    public void update(@RequestBody MemberAddressDTO memberAddressDTO) {
        super.update(memberAddressDTO);
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
     * @author : WiuLus
     * @Description : 根据id删除地址(H5)
     * @Date :2019/7/18 18:48
     * @param id
     * @Version V1.0
     **/
    @DeleteMapping("id")
    @Override
    public void deleteById(@RequestParam("id") Long id) {
        super.deleteById(id);
    }

    /**
     * @Author: LX 17839193044@162.com
     * @Description : 获取用户的默认地址
     * @Date: 2019/6/14 16:45
     * @Version: V1.0
     */
    @Override
    @GetMapping("defalut")
    public MemberAddressDTO findDefalutAddress(@RequestParam("memberId") Long memberId) {

        // 封装查询条件
        QueryWrapper<MemberAddressEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("member_id", memberId);
        wrapper.eq("default_flag", MemberAddressEnum.IS_DEFAULT.value());

        // 查询封装返回
        MemberAddressEntity memberAddressEntity = baseDao.selectOne(wrapper);

        return ConvertUtils.sourceToTarget(memberAddressEntity, MemberAddressDTO.class);
    }

    /**
     * 设置用户默认地址
     *
     * @param id
     * @param defaultFlag
     */
    @PutMapping("default/flag")
    @Override
    public void updateDefaultFlag(@RequestParam("id") Long id,
                                  @RequestParam("defaultFlag") Integer defaultFlag,
                                  @RequestParam("memberId") Long memberId) {

        //修改会员地址的状态为非默认
        baseDao.updateDefaultFlagByMemberId(memberId, MemberAddressEnum.IS_NOT_DEFAULT.value());
        baseDao.updateDefaultFlag(id, defaultFlag);
    }
}