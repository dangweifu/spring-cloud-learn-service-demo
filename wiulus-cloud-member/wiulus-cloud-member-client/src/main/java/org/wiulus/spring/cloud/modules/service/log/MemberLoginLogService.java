//package org.wiulus.spring.cloud.modules.service.log;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.*;
//import org.wiulus.spring.cloud.commons.tools.constant.PathConstant;
//import org.wiulus.spring.cloud.commons.tools.constant.ServiceConstant;
//import org.wiulus.spring.cloud.commons.tools.page.PageData;
//import org.wiulus.spring.cloud.modules.dto.log.MemberLoginLogDTO;
//import org.wiulus.spring.cloud.modules.dto.log.MemberLoginLogExcelDTO;
//import org.wiulus.spring.cloud.modules.service.log.fallback.MemberLoginLogServiceFallback;
//
//import java.util.List;
//import java.util.Map;
//
///**
// * 用户登录日志表
// *
// * @author : WiuLuS
// * @email : m13886933623@163.com
// * @Version : 1.0
// */
//@FeignClient(name = ServiceConstant.WIULUS_MEMBER_SERVER,
//        path = PathConstant.MEMBER_PATH + "/login/log",
//        fallback = MemberLoginLogServiceFallback.class)
//public interface MemberLoginLogService {
//
//    /**
//     * 分页
//     *
//     * @param params
//     * @return
//     */
//    @GetMapping("page")
//    PageData<MemberLoginLogDTO> page(@RequestParam Map<String, Object> params);
//
//    /**
//     * 查询列表
//     *
//     * @param params
//     * @return
//     */
//    @GetMapping("list")
//    List<MemberLoginLogDTO> list(@RequestParam Map<String, Object> params);
//
//    /**
//     * 根据id查询
//     *
//     * @param id
//     * @return
//     */
//    @GetMapping("{id}")
//    MemberLoginLogDTO get(@PathVariable("id") Long id);
//
//    /**
//     * 保存
//     *
//     * @param dto
//     */
//    @PostMapping
//    void save(@RequestBody MemberLoginLogDTO dto);
//
//    /**
//     * 修改
//     *
//     * @param dto
//     */
//    @PutMapping
//    void update(@RequestBody MemberLoginLogDTO dto);
//
//    /**
//     * 删除
//     *
//     * @param ids
//     */
//    @DeleteMapping
//    void delete(@RequestBody Long[] ids);
//
//    /**
//     * @author : WiuLus
//     * @Description : 导出日志
//     * @Date :2019/7/4 16:50
//     * @param params 查询条件
//     * @Version V1.0
//     **/
//    @GetMapping("export")
//    List<MemberLoginLogExcelDTO> export(@RequestParam Map<String, Object> params);
//}
