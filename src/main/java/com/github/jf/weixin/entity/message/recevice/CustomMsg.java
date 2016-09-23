package com.github.jf.weixin.entity.message.recevice;

import com.github.jf.weixin.util.MessageBuilder;

public class CustomMsg extends BaseRecevice {

    private String kfAccount;

    public CustomMsg(String kfAccount) {
        this.kfAccount = kfAccount;
    }

    public String getKfAccount() {
        return kfAccount;
    }

    public void setKfAccount(String kfAccount) {
        this.kfAccount = kfAccount;
    }

    @Override
    public String toXml() {
        MessageBuilder mb = new MessageBuilder(super.toXml());
        mb.addData("MsgType", ReceviceType.KF);
        mb.append("<TransInfo>\n");
        mb.addData("KfAccount", kfAccount);
        mb.append("</TransInfo>\n");
        mb.surroundWith("xml");
        return mb.toString();
    }

}
