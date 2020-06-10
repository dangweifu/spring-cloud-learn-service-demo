package org.wiulus.spring.cloud.modules.dto.log;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 用户登录日志表
 *
 * @author : WiuLuS m13886933623@163.com
 * @Version : 1.0
 */
@Data
public class MemberLoginLogExcelDTO {


    @Excel(name = "会员ID")
    private Long memberId;
    @Excel(name = "会员名称")
    private String loginName;
    @Excel(name = "手机号")
    private String phoneNumber;
    @Excel(name = "操作人ip")
    private String ip;
    @Excel(name = "登录端",replace ={"PC登录_0","手机_1","其他_2" })
    private String source;
    @Excel(name = "操作时间",exportFormat = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    @Excel(name = "操作内容",replace = {"登录成功_0","登陆失败_1"})
    private Integer status;


}
