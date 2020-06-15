//package org.wiulus.spring.cloud.modules.dao.invoice;
//
//import org.wiulus.spring.cloud.commons.mybatis.dao.BaseDao;
//import org.wiulus.spring.cloud.modules.dto.invoice.InvoiceDTO;
//import org.wiulus.spring.cloud.modules.entity.invoice.InvoiceEntity;
//import org.apache.ibatis.annotations.Mapper;
//
///**
// * @author : WiuLus
// * @Description : 用户发票信息管理
// * @Date :2019/5/25 10:34
// * @Version V1.0
// **/
//@Mapper
//public interface InvoiceDao extends BaseDao<InvoiceEntity> {
//
//    /**
//     * @author : WiuLus
//     * @Description : 修改当前用户下的发票都为不是默认
//     * @Date :2019/5/25 10:35
//     * @param memberId 用户id
//     * @Version V1.0
//     **/
//    void updateDefault(Long memberId);
//
//    InvoiceDTO findByMemberId(Long memberId);
//
//}