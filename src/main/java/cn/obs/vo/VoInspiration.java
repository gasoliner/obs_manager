package cn.obs.vo;

import cn.obs.po.Inspiration;

/**
 * Created by Ww on 2018/5/21.
 */
public class VoInspiration extends Inspiration {

    private String voPublish;

    private String voCid;

    public VoInspiration(Inspiration inspiration) {
        this.setInid(inspiration.getInid());
        this.setTitle(inspiration.getTitle());
        this.setContent(inspiration.getContent());
        this.setTime(inspiration.getTime());
        this.setCid(inspiration.getCid());
    }

    public VoInspiration() {}

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
