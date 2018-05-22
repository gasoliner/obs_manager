package cn.obs.vo;

import cn.obs.po.Orders;

/**
 * Created by Ww on 2018/5/21.
 */
public class VoOrders extends Orders {

    private String voPublish;

    private String voCid;

    private String voAction;

    private String voReceive;

    public VoOrders(Orders orders) {
        this.setOid(orders.getOid());
        this.setName(orders.getName());
        this.setSum(orders.getSum());
        this.setTime(orders.getTime());
        this.setState(orders.getState());
        this.setCid(orders.getCid());
        this.setVar(orders.getVar());
    }

    public VoOrders() {}

    public String getVoReceive() {
        return voReceive;
    }

    public void setVoReceive(String voReceive) {
        this.voReceive = voReceive;
    }

    public String getVoAction() {
        return voAction;
    }

    public void setVoAction(String voAction) {
        this.voAction = voAction;
    }

    public String getVoPublish() {
        return voPublish;
    }

    public void setVoPublish(String voPublish) {
        this.voPublish = voPublish;
    }

    public String getVoCid() {
        return voCid;
    }

    public void setVoCid(String voCid) {
        this.voCid = voCid;
    }
}
