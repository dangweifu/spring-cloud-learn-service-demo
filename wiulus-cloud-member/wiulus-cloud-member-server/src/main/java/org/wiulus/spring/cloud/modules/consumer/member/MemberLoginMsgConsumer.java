//package org.wiulus.spring.cloud.modules.consumer.member;
//
//import com.alibaba.fastjson.JSONObject;
//import org.wiulus.spring.cloud.modules.dto.member.MemberDTO;
//import org.wiulus.spring.cloud.modules.service.member.MemberService;
//import org.wiulus.spring.cloud.mq.constant.MqConstant;
//import com.rabbitmq.client.Channel;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Component;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import java.io.IOException;
//import java.util.Date;
//import java.util.Map;
//
///**
// * 用户登陆后维护用户登陆信息
// *
// * @author lixiang
// * @version V1.0
// * @Date 2019/11/11 10:12
// **/
//@Slf4j
//@Component
//public class MemberLoginMsgConsumer {
//
//    @Autowired
//    @Qualifier("memberService")
//    private MemberService memberService;
//
//
//    @RabbitHandler
//    @RabbitListener(queues = MqConstant.LEIMINGTECH_USER_LOGIN_MESSAGE_QUEUE)
//    public void updateMemberLoginMsg(Channel channel, Message message) {
//
//        String msgText = new String(message.getBody());
//        log.info("用户登陆后维护用户登陆信息，内容为：{}", msgText);
//
//        MemberDTO memberDTO = new MemberDTO();
//        Map<String, Object> map = (Map<String, Object>) JSONObject.parse(msgText);
//        Long memberId = (Long) map.get("memberId");
//        if (map.get("lastLoginDate") != null) {
//            Long lastLoginDate = (Long) map.get("lastLoginDate");
//            memberDTO.setLastLoginDate(new Date(lastLoginDate));
//        }
//        if(map.get("lastLoginIp") != null){
//            String lastLoginIp = (String) map.get("lastLoginIp");
//            memberDTO.setLastLoginIp(lastLoginIp);
//        }
//        String memberLoginIp = (String) map.get("memberLoginIp");
//        Long memberLoginTime = (Long) map.get("memberLoginTime");
//
//        memberDTO.setId(memberId);
//        memberDTO.setMemberLoginTime(new Date(memberLoginTime));
//        memberDTO.setMemberLoginIp(memberLoginIp);
//        memberService.updateBase(memberDTO);
//
//        // ACK手动确认处理消息
//        try {
//            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
//        } catch (IOException e) {
//            log.error("用户登陆后维护用户登陆信息处理完毕，手动执行ACK失败!");
//            e.printStackTrace();
//        }
//
//        log.info("用户登陆后维护用户登陆消息处理完毕，手动执行ACK完成!");
//    }
//}
