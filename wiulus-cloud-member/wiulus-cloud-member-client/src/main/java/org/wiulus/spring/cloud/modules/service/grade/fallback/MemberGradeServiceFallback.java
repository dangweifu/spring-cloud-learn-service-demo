//package org.wiulus.spring.cloud.modules.service.grade.fallback;
//
//import org.springframework.stereotype.Component;
//import org.wiulus.spring.cloud.commons.tools.page.PageData;
//import org.wiulus.spring.cloud.modules.dto.grade.MemberGradeDTO;
//import org.wiulus.spring.cloud.modules.dto.grade.MemberGradeSaveDTO;
//import org.wiulus.spring.cloud.modules.service.grade.MemberGradeService;
//
//import java.util.Collections;
//import java.util.List;
//import java.util.Map;
//
///**
// * MemberGradeServiceImpl
// * @Description 会员管理回调
// * @author : WiuLuS
// * @Date 2019/5/28 18:25
// * @Version 1.0
// **/
//@Component
//public class MemberGradeServiceFallback implements MemberGradeService {
//    @Override
//    public PageData<MemberGradeDTO> page(Map<String, Object> params) {
//        return null;
//    }
//
//    @Override
//    public List<MemberGradeDTO> list(Map<String, Object> params) {
//        return Collections.emptyList();
//    }
//
//    @Override
//    public MemberGradeSaveDTO getMember(Long id) {
//        return null;
//    }
//
//    @Override
//    public void save(MemberGradeSaveDTO memberGradeDTO) {
//
//    }
//
//    @Override
//    public void update(MemberGradeDTO memberGradeDTO) {
//
//    }
//
//    @Override
//    public void logicDelete(Long[] ids) {
//
//    }
//
//    @Override
//    public void updateState(Long id) {
//
//    }
//
//    @Override
//    public MemberGradeDTO selectByMemberId(Integer integration) {
//        return null;
//    }
//
//    @Override
//    public Integer findNameCount(String gradeName, Integer integration, Long gradeId) {
//        return null;
//    }
//
//}
