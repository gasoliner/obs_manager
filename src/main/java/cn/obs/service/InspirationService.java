package cn.obs.service;

import cn.obs.po.Inspiration;
import cn.obs.po.Page;
import cn.obs.vo.VoInspiration;

import java.util.List;

/**
 * Created by Ww on 2018/5/11.
 */
public interface InspirationService {
    List<Inspiration> list(Page page);

    int insert(Inspiration record);

    int delete(Integer id);

    int update(Inspiration record);

    long count();

    List<VoInspiration> vo(List<Inspiration> list);

    Inspiration selectByPrimaryKey(Integer id);

}
