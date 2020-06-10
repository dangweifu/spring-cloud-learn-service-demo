package org.wiulus.spring.cloud.modules.service.log;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.wiulus.spring.cloud.commons.mybatis.service.impl.CrudServiceImpl;
import org.wiulus.spring.cloud.commons.tools.constant.Contants;
import org.wiulus.spring.cloud.commons.tools.page.PageData;
import org.wiulus.spring.cloud.commons.tools.utils.ConvertUtils;
import org.wiulus.spring.cloud.modules.dao.log.MemberLoginLogDao;
import org.wiulus.spring.cloud.modules.dto.log.MemberLoginLogDTO;
import org.wiulus.spring.cloud.modules.dto.log.MemberLoginLogExcelDTO;
import org.wiulus.spring.cloud.modules.entity.log.MemberLoginLogEntity;
import org.wiulus.spring.cloud.modules.enums.member.LoginLogEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 用户登录日志表
 *
 * @author : WiuLuS
 * @email : m13886933623@163.com
 * @Version : 1.0
 */
@RestController("memberLoginLogService")
@RequestMapping("login/log")
public class MemberLoginLogServiceImpl extends CrudServiceImpl<MemberLoginLogDao, MemberLoginLogEntity, MemberLoginLogDTO> implements MemberLoginLogService {

    @Override
    public QueryWrapper<MemberLoginLogEntity> getWrapper(Map<String, Object> params) {
        String memberIdStr = (String) params.get("memberId");
        Long memberId = null;
        if (StringUtils.isNotBlank(memberIdStr)) {
            memberId = Long.valueOf(memberIdStr);
        }
        String starTime = (String) params.get("starTime");
        String endTime = (String) params.get("endTime");
        String sourceStr = (String) params.get("source");
        Integer source = null;
        if (StringUtils.isNotBlank(sourceStr)) {
            source = Integer.valueOf(sourceStr);
        }
        QueryWrapper<MemberLoginLogEntity> wrapper = new QueryWrapper<>();
        //id/手机号/会员名称
        wrapper.eq(StringUtils.isNotBlank(memberIdStr), "member_id", memberId).or().like(StringUtils.isNotBlank(memberIdStr),"login_name",memberId).or().like(StringUtils.isNotBlank(memberIdStr),"phone_number",memberId);

        wrapper.ge(StringUtils.isNotBlank(starTime), "create_date", starTime);
        wrapper.le(StringUtils.isNotBlank(endTime), "update_date", endTime);
        wrapper.eq(StringUtils.isNotBlank(sourceStr), "source", source);


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
    public PageData<MemberLoginLogDTO> page(@RequestParam Map<String, Object> params) {
        int pageNum = Integer.valueOf(params.get(Contants.PAGE).toString());
        int limit = Integer.valueOf(params.get(Contants.LIMIT).toString());
        Page<MemberLoginLogDTO> goodsListDTOPage = new Page<>(pageNum, limit);
        List<MemberLoginLogDTO> page = baseDao.selectMemberList(
                goodsListDTOPage,
                params

        );
        return new PageData(page, goodsListDTOPage.getTotal());
    }

    /**
     * 查询列表
     *
     * @param params
     * @return
     */
    @Override
    @GetMapping("list")
    public List<MemberLoginLogDTO> list(@RequestParam Map<String, Object> params) {
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
    public MemberLoginLogDTO get(@PathVariable("id") Long id) {
        return super.get(id);
    }

    /**
     * 保存
     *
     * @param dto
     */
    @Override
    @PostMapping
    public void save(@RequestBody MemberLoginLogDTO dto) {
        super.save(dto);
    }

    /**
     * 修改
     *
     * @param dto
     */
    @Override
    @PutMapping
    public void update(@RequestBody MemberLoginLogDTO dto) {
        super.update(dto);
    }

    /**
     * 删除
     *
     * @param ids
     */
    @Override
    @DeleteMapping
    public void delete(@RequestBody Long[] ids) {
        super.delete(ids);
    }

    /**
     * @author : WiuLus
     * @Description : 导出日志
     * @Date :2019/7/4 16:50
     * @param params 查询条件
     * @Version V1.0
     **/
    @GetMapping("export")
    @Override
    public List<MemberLoginLogExcelDTO> export(@RequestParam Map<String, Object> params) {
        params.put(Contants.ORDER_FIELD, Contants.CREATE_DATE);
        params.put(Contants.ORDER, "desc");
        List<MemberLoginLogEntity> list = baseDao.selectList(getWrapper(params));
        ArrayList<MemberLoginLogExcelDTO> excelList = new ArrayList<>();
        for (MemberLoginLogEntity memberLoginLogEntity : list) {
            MemberLoginLogExcelDTO logExcelDTO = ConvertUtils.sourceToTarget(memberLoginLogEntity, MemberLoginLogExcelDTO.class);
            if (memberLoginLogEntity.getSource() == LoginLogEnum.LOGIN_SOURCE_PC.value()) {
                logExcelDTO.setSource("PC登录");
            } else if (memberLoginLogEntity.getSource() == LoginLogEnum.LOGIN_SOURCE_PHONE.value()) {
                logExcelDTO.setSource("手机登录");
            } else if (memberLoginLogEntity.getSource() == LoginLogEnum.LOGIN_SOURCE_OTHER.value()) {
                logExcelDTO.setSource("其他");
            }
            excelList.add(logExcelDTO);
        }
        return excelList;
    }

}
