//package org.wiulus.spring.cloud.modules.service.invoice;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import org.wiulus.spring.cloud.commons.mybatis.service.impl.CrudServiceImpl;
//import org.wiulus.spring.cloud.modules.dao.invoice.InvoiceDao;
//import org.wiulus.spring.cloud.modules.dto.invoice.InvoiceDTO;
//import org.wiulus.spring.cloud.modules.entity.invoice.InvoiceEntity;
//import org.wiulus.spring.cloud.modules.enums.invoice.InvoiceEnum;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Map;
//
///**
// * @author : WiuLus
// * @Description : 用户发票信息管理
// * @Date :2019/5/24 15:16
// * @Version V1.0
// **/
//@RestController
//@RequestMapping("invoice")
//public class InvoiceServiceImpl extends CrudServiceImpl<InvoiceDao, InvoiceEntity, InvoiceDTO> implements InvoiceService {
//
//    @Autowired
//    private InvoiceDao invoiceDao;
//
//    /**
//     * @author : WiuLus
//     * @Description : 条件构造器
//     * @Date :2019/6/24 15:02
//     * @param params 查询条件
//     * @Version V1.0
//     **/
//    @Override
//    public QueryWrapper<InvoiceEntity> getWrapper(Map<String, Object> params) {
//        String id = (String) params.get("id");
//        String memberId = (String) params.get("memberId");
//
//        QueryWrapper<InvoiceEntity> wrapper = new QueryWrapper<>();
//        wrapper.eq(StringUtils.isNotBlank(id), "id", id);
//        wrapper.eq(StringUtils.isNotBlank(memberId), "member_id", memberId);
//
//        return wrapper;
//    }
//
//    /**
//     * @author : WiuLus
//     * @Description : 保存个人发票信息
//     * @Date :2019/5/25 10:59
//     * @param dto 实体
//     * @Version V1.0
//     **/
//    @Override
//    @PostMapping("personal")
//    public void savePersonalInvoiceTitle(@RequestBody InvoiceDTO dto) {
//
//        //将用户发票下所有发票去掉默认
//        invoiceDao.updateDefault(dto.getMemberId());
//        //审核状态（0未审核，1审核通过，2审核未通过，3审核中）
//        dto.setAuditStatus(InvoiceEnum.AUDIT_STATUS_YES.value());
//        //发票类型（1:普通发票，2:增值税发票，3:电子发票）
//        dto.setInvState(InvoiceEnum.GENERAL_INVOICE.value());
//        //设为默认（默认0:否，1:是）
//        dto.setIsDefault(InvoiceEnum.IS_DEFULT_YES.value());
//
//        //保存个人发票信息
//        save(dto);
//    }
//
//    /**
//     * @author : WiuLus
//     * @Description : 保存单位发票信息
//     * @Date :2019/5/25 10:59
//     * @param dto 实体
//     * @Version V1.0
//     **/
//    @Override
//    @PostMapping("company")
//    public void saveCompanyInvoiceTitle(@RequestBody InvoiceDTO dto) {
//
//        //将用户发票下所有发票去掉默认
//        invoiceDao.updateDefault(dto.getMemberId());
//        //审核状态（0未审核，1审核通过，2审核未通过，3审核中) 增值税发票发票需审核
//        dto.setAuditStatus(InvoiceEnum.AUDIT_STATUS_NO.value());
//        //发票类型（1:普通发票，2:增值税发票，3:电子发票）
//        dto.setInvState(InvoiceEnum.GENERAL_INVOICE.value());
//        //设为默认（默认0:否，1:是）
//        dto.setIsDefault(InvoiceEnum.IS_DEFULT_YES.value());
//
//        //保存单位发票信息
//        save(dto);
//    }
//
//    /**
//     * @author : WiuLus
//     * @Description : 修改个人抬头信息
//     * @Date :2019/5/25 17:53
//     * @param dto 实体
//     * @Version V1.0
//     **/
//    @Override
//    @PutMapping("personal/title")
//    public void updatePersonalInvoiceTitle(@RequestBody InvoiceDTO dto) {
//
//        //发票类型 :1 个人发票 2单位发票
//        dto.setInvType(InvoiceEnum.PERSONAL_INVOICE.value());
//        //审核状态（0未审核，1审核通过，2审核未通过，3审核中）
//        dto.setAuditStatus(InvoiceEnum.AUDIT_STATUS_NO.value());
//        //发票类型（1:普通发票，2:增值税发票，3:电子发票）
//        dto.setInvState(InvoiceEnum.GENERAL_INVOICE.value());
//        //设为默认（默认0:否，1:是）
//        dto.setIsDefault(InvoiceEnum.IS_DEFULT_YES.value());
//
//        //修改个人抬头信息
//        update(dto);
//
//    }
//
//    /**
//     * @author : WiuLus
//     * @Description : 修改单位抬头信息
//     * @Date :2019/5/25 17:53
//     * @param dto 实体
//     * @Version V1.0
//     **/
//    @Override
//    @PutMapping("company/title")
//    public void updateCompanyInvoiceTitle(@RequestBody InvoiceDTO dto) {
//
//        //发票类型 :1 个人发票 2单位发票
//        dto.setInvType(InvoiceEnum.COMPANY_INVOICE.value());
//        //审核状态（0未审核，1审核通过，2审核未通过，3审核中) 增值税发票发票需审核
//        dto.setAuditStatus(InvoiceEnum.AUDIT_STATUS_NO.value());
//        //发票类型（1:普通发票，2:增值税发票，3:电子发票）
//        dto.setInvState(InvoiceEnum.GENERAL_INVOICE.value());
//        //设为默认（默认0:否，1:是）
//        dto.setIsDefault(InvoiceEnum.IS_DEFULT_YES.value());
//
//        //修改单位抬头信息
//        update(dto);
//    }
//
//    /**
//     * @author : WiuLus
//     * @Description : 根据id查询发票信息
//     * @Date :2019/5/30 11:14
//     * @param id 用户发票信息id
//     * @Version V1.0
//     **/
//    @GetMapping("{id}")
//    @Override
//    public InvoiceDTO get(@PathVariable("id") Long id) {
//        return super.get(id);
//    }
//
//    /**
//     * @author : WiuLus
//     * @Description : 查询所有发票信息
//     * @Date :2019/5/30 11:15
//     * @param params 查询条件
//     * @Version V1.0
//     **/
//    @GetMapping("list")
//    @Override
//    public List<InvoiceDTO> list(@RequestParam Map<String, Object> params) {
//        return super.list(params);
//    }
//
//    /**
//     * @author : WiuLus
//     * @Description : 保存发票信息
//     * @Date :2019/5/30 11:15
//     * @param dto 实体
//     * @Version V1.0
//     **/
//    @PostMapping("save")
//    @Override
//    public void save(@RequestBody InvoiceDTO dto) {
//        //获取用户id
//     /*   Long userId = SecurityUser.getUserId();
//        dto.setMemberId(userId);*/
//        super.save(dto);
//    }
//
//    /**
//     * @author : WiuLus
//     * @Description : 修改发票信息
//     * @Date :2019/5/30 11:17
//     * @param dto 实体
//     * @Version V1.0
//     **/
//    @PutMapping("update")
//    @Override
//    public void update(@RequestBody InvoiceDTO dto) {
//        super.update(dto);
//    }
//
//    /**
//     * @author : WiuLus
//     * @Description : 根据ID批量删除
//     * @Date :2019/5/30 11:18
//     * @param ids 用户发票信息id
//     * @Version V1.0
//     **/
//    @DeleteMapping("delete")
//    @Override
//    public void delete(@RequestBody Long[] ids) {
//        super.delete(ids);
//    }
//
//
//    @GetMapping("memberId")
//    public InvoiceDTO findByMemberId(@RequestParam("memberId") Long memberId) {
//        return invoiceDao.findByMemberId(memberId);
//    }
//
//    /**
//     * @author : WiuLus
//     * @Description : 根据ID删除
//     * @Date :2019/5/30 11:18
//     * @param ids 用户发票信息id
//     * @Version V1.0
//     **/
//    @DeleteMapping("id")
//    @Override
//    public void deleteById(@RequestParam("id") Long id){
//        super.deleteById(id);
//    }
//
//
//}