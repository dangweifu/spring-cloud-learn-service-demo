//package org.wiulus.spring.cloud.modules.consumer.member;
//
//import com.alibaba.fastjson.JSONArray;
//import org.wiulus.spring.cloud.modules.dto.log.point.PointLogDTO;
//import org.wiulus.spring.cloud.modules.dto.member.MemberUpdateDTO;
//import org.wiulus.spring.cloud.modules.enums.logs.PointLogEnum;
//import org.wiulus.spring.cloud.modules.service.log.point.PointLogService;
//import org.wiulus.spring.cloud.modules.service.member.MemberInfoService;
//import org.wiulus.spring.cloud.mq.constant.MqConstant;
//import com.rabbitmq.client.Channel;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import javax.annotation.Resource;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.util.List;
//
///**
// * 新增积分/成长值日志消费者
// *
// * @author lixiang
// * @version V1.0
// * @date 2019/12/24 11:08
// **/
//@Slf4j
//@Component
//public class PointLogConsumer {
//
//    @Resource
//    @Qualifier("pointLogService")
//    private PointLogService pointLogService;
//
//    @Resource
//    @Qualifier("memberInfoService")
//    private MemberInfoService memberInfoService;
//
//    @RabbitHandler
//    @RabbitListener(queues = MqConstant.LEIMINGTECH_SAVE_POINT_LOG_QUEUE)
//    public void resetPasswd(Channel channel, Message message) throws IOException {
//        String msgText = new String(message.getBody());
//        log.info("接收到新增积分日志消息，内容为：{}", msgText);
//
//        if (StringUtils.isNotBlank(msgText)) {
//            List<PointLogDTO> pointLogDTOList = JSONArray.parseArray(msgText, PointLogDTO.class);
//            Boolean result = pointLogService.saveBatch(pointLogDTOList);
//            if (result != null && result) {
//                log.info("用户[{}]操作[{}]积分值[{}]增加成功",
//                        pointLogDTOList.get(0).getMemberName(), pointLogDTOList.get(0).getPointValue(), pointLogDTOList.get(0).getPointDesc());
//
//                // 修改用户表中的积分与成长值
//                pointLogDTOList.forEach(pointLogDTO -> {
//
//                    MemberUpdateDTO memberUpdateDTO = new MemberUpdateDTO();
//                    memberUpdateDTO.setId(pointLogDTO.getMemberId());
//
//                    if (PointLogEnum.POINT_TYPE.value() == pointLogDTO.getPointType()) {
//                        // 积分 修改用户可用积分
//                        memberUpdateDTO.setAvailablePoint(pointLogDTO.getPointValue());
//                        memberInfoService.updateByMemberId(memberUpdateDTO);
//                    } else if (PointLogEnum.GROWTH_TYPE.value() == pointLogDTO.getPointType()) {
//                        // 成长值 修改用户成长值
//                        memberUpdateDTO.setGradePoint(pointLogDTO.getPointValue());
//                        memberInfoService.updateByMemberId(memberUpdateDTO);
//                    }
//                });
//            } else {
//                log.error("用户[{}]操作[{}]积分值[{}]增加失败",
//                        pointLogDTOList.get(0).getMemberName(), pointLogDTOList.get(0).getPointValue(), pointLogDTOList.get(0).getPointDesc());
//            }
//        }
//
//        // ACK手动确认处理消息
//        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
//        log.info("新增积分日志消费者处理完毕，手动执行ACK!");
//    }
//}
