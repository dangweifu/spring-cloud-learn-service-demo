//package org.wiulus.spring.cloud.modules.consumer.member;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import org.wiulus.spring.cloud.modules.dto.log.MemberLoginLogDTO;
//import org.wiulus.spring.cloud.modules.service.log.MemberLoginLogService;
//import org.wiulus.spring.cloud.mq.constant.MqConstant;
//import com.rabbitmq.client.Channel;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.util.Date;
//import java.util.Map;
//
///**
// * @Author: SWH ab4856812@163.com
// * @Description : 登录日志
// * @Date: 2019/7/17 22:00
// * @Version : V1.0
// */
//@Slf4j
//@Component
//public class MqLoginLogConsumer {
//
//    @Autowired
//    @Qualifier("memberLoginLogService")
//    private MemberLoginLogService memberLoginLogService;
//
//    /**
//     * @Author: SWH ab4856812@163.com
//     * @Description : 增加H5登录日志
//     * @Date: 2019/7/17 21:42
//     * @Version : V1.0
//     */
//    @RabbitHandler
//    @RabbitListener(queues = MqConstant.LEIMINGTECH_USERLOGIN_QUEUE)
//    public void receiverFrontLoingLog(Channel channel, Message message) throws IOException {
//        String msgText = new String(message.getBody());
//        log.info("H5登录日志接收到日志消息，内容为：{}", msgText);
//
//        MemberLoginLogDTO memberLoginLogDTO = new MemberLoginLogDTO();
//        //解析消息
//        JSONObject jsonObject = JSON.parseObject(msgText);
//        if (jsonObject == null) {
//            return;
//        }
//        Map<String, String> map = (Map) JSON.parse(msgText);
//        memberLoginLogDTO.setMemberId(Long.valueOf(map.get("id")));
//        memberLoginLogDTO.setLoginName(map.get("username"));
//        memberLoginLogDTO.setUserAgent(map.get("userAgent"));
//        memberLoginLogDTO.setIp(map.get("userIp"));
//        if (null != map.get("source")){
//        memberLoginLogDTO.setSource(Integer.valueOf(map.get("source")));
//        }
//        memberLoginLogDTO.setCreateDate(new Date());
//        memberLoginLogDTO.setPhoneNumber(map.get("username"));
//        memberLoginLogDTO.setStatus(Integer.valueOf(map.get("status")));
//
//        memberLoginLogService.save(memberLoginLogDTO);
//        // ACK手动确认处理消息
//        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
//
//        log.info("消息处理完毕，手动执行ACK!");
//
//    }
//}
