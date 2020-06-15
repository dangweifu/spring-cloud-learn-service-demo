//package org.wiulus.spring.cloud.modules.service.invoice;
//
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.*;
//import org.wiulus.spring.cloud.commons.tools.constant.PathConstant;
//import org.wiulus.spring.cloud.commons.tools.constant.ServiceConstant;
//import org.wiulus.spring.cloud.modules.dto.invoice.InvoiceDTO;
//import org.wiulus.spring.cloud.modules.service.invoice.fallback.InvoiceServiceFallback;
//
//import java.util.List;
//import java.util.Map;
//
//
///**
// * @author : WiuLus
// * @Description : 用户发票信息管理
// * @Date :2019/5/24 15:14
// * @Version V1.0
// **/
//@FeignClient(name = ServiceConstant.WIULUS_MEMBER_SERVER,
//        path = PathConstant.MEMBER_PATH + "/invoice",
//        fallback = InvoiceServiceFallback.class)
//public interface InvoiceService {
//
//
//    /**
//     * @author : WiuLus
//     * @Description : 保存个人发票抬头
//     * @Date :2019/5/25 10:53
//     * @param invoiceDTO 实体
//     * @Version V1.0
//     **/
//    @PostMapping("personal")
//    void savePersonalInvoiceTitle(@RequestBody InvoiceDTO invoiceDTO);
//
//    /**
//     * @author : WiuLus
//     * @Description : 保存单位发票抬头
//     * @Date :2019/5/25 10:53
//     * @param invoiceDTO 实体
//     * @Version V1.0
//     **/
//    @PostMapping("company")
//    void saveCompanyInvoiceTitle(@RequestBody InvoiceDTO invoiceDTO);
//
//    /**
//     * @author : WiuLus
//     * @Description : 修改个人发票抬头
//     * @Date :2019/5/25 17:50
//     * @param invoiceDTO 实体
//     * @Version V1.0
//     **/
//    @PutMapping("personal/title")
//    void updatePersonalInvoiceTitle(@RequestBody InvoiceDTO invoiceDTO);
//
//    /**
//     * @author : WiuLus
//     * @Description : 修改单位发票抬头
//     * @Date :2019/5/25 17:51
//     * @param invoiceDTO 实体
//     * @Version V1.0
//     **/
//    @PutMapping("company/title")
//    void updateCompanyInvoiceTitle(@RequestBody InvoiceDTO invoiceDTO);
//
//    /**
//     * @author : WiuLus
//     * @Description : 根据id查询发票信息
//     * @Date :2019/5/30 11:14
//     * @param id 用户发票信息id
//     * @Version V1.0
//     **/
//    @GetMapping("{id}")
//    InvoiceDTO get(@PathVariable("id") Long id);
//
//    /**
//     * @author : WiuLus
//     * @Description : 查询所有发票信息
//     * @Date :2019/5/30 11:15
//     * @param params 查询条件
//     * @Version V1.0
//     **/
//    @GetMapping("list")
//    List<InvoiceDTO> list(@RequestParam Map<String, Object> params);
//
//    /**
//     * @author : WiuLus
//     * @Description : 保存发票信息
//     * @Date :2019/5/30 11:15
//     * @param dto 实体
//     * @Version V1.0
//     **/
//    @PostMapping("save")
//    void save(@RequestBody InvoiceDTO dto);
//
//    /**
//     * @author : WiuLus
//     * @Description : 修改发票信息
//     * @Date :2019/5/30 11:17
//     * @param dto 实体
//     * @Version V1.0
//     **/
//    @PutMapping("update")
//    void update(@RequestBody InvoiceDTO dto);
//
//    /**
//     * @author : WiuLus
//     * @Description : 根据ID删除
//     * @Date :2019/5/30 11:18
//     * @param ids 用户发票信息id
//     * @Version V1.0
//     **/
//    @DeleteMapping("id")
//    void deleteById(@RequestParam("id") Long id);
//
//    /**
//     * @author : WiuLus
//     * @Description : 根据ID删除(批量)
//     * @Date :2019/5/30 11:18
//     * @param ids 用户发票信息id
//     * @Version V1.0
//     **/
//    @DeleteMapping("delete")
//    void delete(@RequestBody Long[] ids);
//
//
//    @GetMapping("memberId")
//    InvoiceDTO findByMemberId(@RequestParam("memberId") Long memberId);
//}