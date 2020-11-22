package com.bestoyc.springbootsms.controller;

import com.bestoyc.springbootsms.config.SendSmsProperties;
import com.bestoyc.springbootsms.domain.Sms;
import com.bestoyc.springbootsms.util.SendSmsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SendSmsController
 * @Description TODO
 * @Author oyc
 * @Date 2020/11/22 22:45
 * @Version
 */
@RestController
@RequestMapping("sms")
public class SendSmsController {

    @Autowired
    private SendSmsUtils sendSmsUtils;

    @Autowired
    private SendSmsProperties sendSms;

    @RequestMapping("send")
    public Object sms() {
        try {
            Sms sms = new Sms();
            sms.setMobile(new String[]{"17576019421"});
            sms.setParams(new String[]{"123456","10"});
            sms.setSign(sendSms.getSign());
            sms.setTemplateId(sendSms.getTemplateId());
            sendSmsUtils.sand(sms);
        } catch (Exception e) {
            return "短信发送失败，"+e.getMessage();
        }
        return "短信发送成功";
    }
}