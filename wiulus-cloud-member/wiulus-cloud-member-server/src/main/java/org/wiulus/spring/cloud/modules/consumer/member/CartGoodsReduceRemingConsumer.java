package org.wiulus.spring.cloud.modules.consumer.member;

import com.alibaba.fastjson.JSON;
//import org.wiulus.spring.cloud.dto.message.FindMessageTemplateDTO;
//import org.wiulus.spring.cloud.dto.message.MessageTextDTO;
//import org.wiulus.spring.cloud.enums.message.AliyunCodeEnum;
//import org.wiulus.spring.cloud.enums.message.MessageEnum;
//import org.wiulus.spring.cloud.modules.dto.cart.CartRemindDTO;
//import org.wiulus.spring.cloud.modules.dto.member.MemberDTO;
import org.wiulus.spring.cloud.modules.service.member.MemberService;
//import org.wiulus.spring.cloud.mq.constant.MqConstant;
//import org.wiulus.spring.cloud.service.SysSmsService;
//import org.wiulus.spring.cloud.service.message.MessageTextService;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 购物车商品降价通知
 *
 * @author chengqian
 * @version V1.0
 * @date2020-2-13 09：10
 **/
@Slf4j
@Component
public class CartGoodsReduceRemingConsumer {

//    @Resource
//    private MessageTextService messageTextService;
//
//    @Resource
//    private SysSmsService sysSmsService;

//    @Resource
    private MemberService memberService;


    /**
     * 购物车商品降价通知
     *
     * @param channel
     * @param message
     * @throws IOException
     */
//    @RabbitHandler
//    @RabbitListener(queues = MqConstant.LEIMINGTECH_GOODS_REDUCE_PRICE_REMIND)
    public void cartGoodsReduceRemind(Channel channel, Message message) throws IOException {
//        String msgText = new String(message.getBody());
//        log.info("购物车降价通知消息接收，内容为:{}", msgText);
//        CartRemindDTO cartRemindDTO = JSON.parseObject(msgText, CartRemindDTO.class);
//        // 获取短信开关
//        FindMessageTemplateDTO findMessageTemplateDTO = messageTextService.getMessageNo(MessageEnum.SEND_MODE_SMS_inner.value(), AliyunCodeEnum.CART_GOODS_REDUCE_REMIND.value());
//        // 查询出用户信息
//        List<MemberDTO> memberDTOList = memberService.selectPhoneListById(cartRemindDTO.getMemberList());
//        if (memberDTOList == null) {
//            log.info("用户信息为空");
//            return;
//        }
//
//
//
//        if (findMessageTemplateDTO != null && findMessageTemplateDTO.getIsSendInner() == 0) {
//            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
//            linkedHashMap.put("goodsName", cartRemindDTO.getSpecName());
//            MessageTextDTO messageTextDTO = new MessageTextDTO();
//            messageTextDTO.setMessageTitle(findMessageTemplateDTO.getTempTitle());
//            messageTextDTO.setLinkedHashMap(linkedHashMap);
//            messageTextDTO.setMessageContent(findMessageTemplateDTO.getTempInnerContent());
//            messageTextDTO.setMessageType(MessageEnum.MESSAGE_TYPE_PRVT.value());
//            messageTextDTO.setReceiverType(MessageEnum.RECEIVER_TYPE_VIP.value());
//            messageTextDTO.setSendMode(new int[]{1});
//            messageTextDTO.setUserName(cartRemindDTO.getUpdateName());
//            messageTextDTO.setCreator(cartRemindDTO.getUpdateName());
//            messageTextDTO.setMemberId(memberDTOList);
//            messageTextService.saveMessage(messageTextDTO);
//
//        }
//
//        if (findMessageTemplateDTO != null && findMessageTemplateDTO.getIsSendSms() == 0) {
//            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
//            if (cartRemindDTO.getSpecName().length() > 15) {
//                String substring = cartRemindDTO.getSpecName().subSequence(0, 15) + "...";
//                linkedHashMap.put("goodsName", substring);
//            } else {
//                linkedHashMap.put("goodsName", cartRemindDTO.getSpecName());
//            }
//
//            Set<String> phoneList = memberDTOList.stream().map(m -> m.getMemberMobile()).collect(Collectors.toSet());
//            List<LinkedHashMap<String, String>> mapList = new ArrayList();
//            mapList.add(linkedHashMap);
//            String params = JSON.toJSONString(mapList);
//            String phone = JSON.toJSONString(phoneList);
//            sysSmsService.sendBatchSms(phone, params, "['wiulus']", findMessageTemplateDTO.getTempSmsCode());
//        }
//
//        // ACK手动确认处理消息
//        channel.basicAck(message.getMessageProperties().
//                getDeliveryTag(), false);
//        log.info("购物车降价通知消息处理完毕，手动执行ACK!");
    }
}
