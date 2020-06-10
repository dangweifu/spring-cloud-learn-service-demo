//package org.wiulus.spring.cloud.modules.consumer.member;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import org.wiulus.spring.cloud.mq.constant.MqConstant;
//import org.wiulus.spring.cloud.service.SysSmsService;
//import com.rabbitmq.client.Channel;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import javax.annotation.Resource;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//
///**
// * MqResetPasswdConsumer
// * @Description 修改密码消息队列
// * @author : WiuLuS
// * @Date 2019/5/30 16:47
// * @Version 1.0
// **/
//
//
//@Slf4j
//@Component
//public class MqResetPasswdConsumer {
//
//    @Resource
//    private SysSmsService sysSmsService;
//
//
//    @RabbitHandler
//    @RabbitListener(queues = MqConstant.LEIMINGTECH_RESET_PWD_QUEUE)
//    public void resetPasswd(Channel channel, Message message) throws IOException {
//        String msgText = new String(message.getBody());
//        log.info("接收到重置密码消息，内容为：{}", msgText);
//
//        //解析消息
//        JSONObject jsonObject = JSON.parseObject(msgText);
//        if (jsonObject == null) {
//            return;
//        }
//        Map<String, String> map = (Map) JSON.parse(msgText);
//        //获取短信模板
//        // 待删除 创建对应模板
////        MessageTemplateDTO templateByCode = messageTemplateService.findTemplateByCode(AliyunCodeEnum.TEMPLATECODE_RESET_PASSWD.value());
//        //手机号
//        String mobile = map.get("mobile");
//        //参数
//        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
//        linkedHashMap.put("passwd", map.get("passwd"));
//        String params = JSON.toJSONString(linkedHashMap);
//        //阿里云短信模板编码
//        String code = map.get("tempSmsCode");
//        //发送短信
////       sysSmsService.send(map.get("moblie"), params, TEMPLATECODE_RESET_PASSWORD_VALID_CODE.value());
//        sysSmsService.send(mobile, params, code);
//
//        // ACK手动确认处理消息
//        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
//
//        log.info("重置密码消息处理完毕，手动执行ACK!");
//    }
//}
//
//
