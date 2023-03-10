package org.github.foxnic.web.notify.support.sms;

import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.collection.CollectorUtil;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.notify.support.NotifySupport;
import org.github.foxnic.web.proxy.oauth.UserServiceProxy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public abstract class SMSSupport extends NotifySupport {

    /**
     * 按手机号批量发送
     * */
    public abstract void sendByPhoneNumbers(List<String> phoneNumbers, String smsTemplateId, Map<String, String> templateParams);

    public void sendByPhoneNumber(String phoneNumber, String smsTemplateId, Map<String, String> templateParams) {
        this.sendByPhoneNumbers(Arrays.asList(phoneNumber),smsTemplateId,templateParams);
    }

    public void sendByUserIds(List<String> userIds, String smsTemplateId, Map<String, String> templateParams) {
        Result<List<User>> result = UserServiceProxy.api().getByIds(userIds);
        if(result==null)  {
            throw new RuntimeException("无法获得账户信息");
        }
        if(result.failure())  {
            throw new RuntimeException("账户信息获取失败:"+result.message());
        }
        List<String> phones= CollectorUtil.collectList(result.data(),User::getPhone);
        this.sendByPhoneNumbers(phones,smsTemplateId,templateParams);
    }

}
