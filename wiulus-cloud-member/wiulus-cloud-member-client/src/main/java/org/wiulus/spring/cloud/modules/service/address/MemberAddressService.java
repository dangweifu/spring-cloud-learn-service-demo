package org.wiulus.spring.cloud.modules.service.address;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.wiulus.spring.cloud.commons.tools.constant.PathConstant;
import org.wiulus.spring.cloud.commons.tools.constant.ServiceConstant;
import org.wiulus.spring.cloud.commons.tools.page.PageData;
import org.wiulus.spring.cloud.modules.dto.address.MemberAddressDTO;
import org.wiulus.spring.cloud.modules.service.address.fallback.MemberAddressServiceFallback;

import java.util.List;
import java.util.Map;

/**
 * 会员地址表
 *
 * @author : WiuLuS
 * @email : m13886933623@163.como
 * @Version : 1.0
 */
@FeignClient(name = ServiceConstant.WIULUS_MEMBER_SERVER,
        path = PathConstant.MEMBER_PATH + "/address",
        fallback = MemberAddressServiceFallback.class)
public interface MemberAddressService {

    /**
     * 分页
     *
     * @param params
     * @return
     */
    @GetMapping("page")
    PageData<MemberAddressDTO> page(@RequestParam Map<String, Object> params);

    /**
     * 查询列表
     *
     * @param params
     * @return
     */
    @GetMapping("list")
    List<MemberAddressDTO> list(@RequestParam Map<String, Object> params);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GetMapping("{id}")
    MemberAddressDTO get(@PathVariable("id") Long id);

    /**
     * 保存地址
     *
     * @param memberAddressDTO
     */
    @PostMapping
    void save(@RequestBody MemberAddressDTO memberAddressDTO);

    /**
     * 修改地址
     *
     * @param memberAddressDTO
     */
    @PutMapping
    void update(@RequestBody MemberAddressDTO memberAddressDTO);

    /**
     * 删除地址
     *
     * @param ids
     */
    @DeleteMapping
    void logicDelete(@RequestBody Long[] ids);

    /**
     * @author : WiuLus
     * @Description : 根据id删除地址(H5)
     * @Date :2019/7/18 18:48
     * @param id
     * @Version V1.0
     **/
    @DeleteMapping("id")
    void deleteById(@RequestParam("id") Long id);

    /**
     * @Author: LX 17839193044@162.com
     * @Description : 获取用户的默认地址
     * @Date: 2019/6/14 16:45
     * @Version: V1.0
     */
    @GetMapping("defalut")
    MemberAddressDTO findDefalutAddress(@RequestParam("memberId") Long memberId);

    /**
     * 设置用户默认地址
     *
     * @param Id
     * @param defaultFlag
     */
    @PutMapping("default/flag")
    void updateDefaultFlag(@RequestParam("id") Long Id, @RequestParam("defaultFlag") Integer defaultFlag,
                           @RequestParam("memberId") Long memberId);
}