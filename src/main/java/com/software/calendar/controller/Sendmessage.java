package com.software.calendar.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping
public class Sendmessage {

    public boolean sendSMSMessage(@RequestParam("mobile")String mobile, HttpServletRequest request){
        //设置超时时间-可自行调整
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        //初始化ascClient需要的几个参数
        final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
        final String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）
        //替换成你的AK
        final String accessKeyId = "XXXXXXX";//你的accessKeyId,参考本文档步骤2
        final String accessKeySecret = "XXXXXXXXXXXXXXXXXXX";//你的accessKeySecret，参考本文档步骤2
        //初始化ascClient,暂时不支持多region
//        try{
//
//            IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,accessKeySecret);
//            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
//            IAcsClient acsClient = new DefaultAcsClient(profile);
//            //组装请求对象
//            SendSmsRequest smsRequest = new SendSmsRequest();
//            //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式
//            smsRequest.setPhoneNumbers(mobile);
//            //必填:短信签名-可在短信控制台中找到
//            smsRequest.setSignName("XXXXX");
//            //必填:短信模板-可在短信控制台中找到
//            smsRequest.setTemplateCode("SMS_XXXXXXXX");
//
//            int ran = (int)(Math.random()*(9999-1000+1))+1000;//产生1000-9999的随机数
//            String code = String.valueOf(ran);
//            //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
//            smsRequest.setTemplateParam("{\"code\":"+code+"}");
//
//            //把短信验证码存入session
//            session = request.getSession();
//            ValidateCode validateCode = new ValidateCode();
//            validateCode.setMobile(mobile);
//            validateCode.setCode(code);
//            session.setAttribute(mobile,validateCode);
//
//            //可选-上行短信扩展码(无特殊需求用户请忽略此字段)
//            //request.setSmsUpExtendCode("90997");
//            //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
//            //request.setOutId("yourOutId");
//            //请求失败这里会抛ClientException异常
//            SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(smsRequest);
//            System.out.println(sendSmsResponse.getCode());
//            System.out.println(sendSmsResponse.getBizId());
//            System.out.println(sendSmsResponse.getMessage());
//            System.out.println(sendSmsResponse.getRequestId());
//            if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
//                //请求成功
//                System.out.print("success");
//                return true;
//            }
//        }catch (ClientException e){
//            return false;
//        }
//        System.out.print("fail");
//        return false;
        return false;
    }
}
