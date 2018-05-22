package cn.obs.service.impl;

import cn.obs.mapper.InspirationMapper;
import cn.obs.po.Inspiration;
import cn.obs.po.InspirationExample;
import cn.obs.po.Page;
import cn.obs.service.ConsumerService;
import cn.obs.service.InspirationService;
import cn.obs.util.TimeUtils;
import cn.obs.vo.VoInspiration;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ww on 2018/5/11.
 */
@Service("inspirationService")
public class InspirationServiceImpl implements InspirationService {

    @Autowired
    ConsumerService consumerService;

    @Autowired
    InspirationMapper inspirationMapper;

    long total = 0L;

    @Override
    public List<Inspiration> list(Page page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        List<Inspiration> list = inspirationMapper.selectByExample(new InspirationExample());
        PageInfo<Inspiration> pageInfo = new PageInfo<>(list);
        this.total = pageInfo.getTotal();
        return list;
    }

    @Override
    public int insert(Inspiration record) {
        return inspirationMapper.insertSelective(record);
    }

    @Override
    public int delete(Integer id) {
        return inspirationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Inspiration record) {
        return inspirationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public long count() {
        return total;
    }

    @Override
    public List<VoInspiration> vo(List<Inspiration> list) {
        List<VoInspiration> list1 = new ArrayList<>();
        for (Inspiration inspiration:
                list) {
            VoInspiration voInspiration = new VoInspiration(inspiration);
            voInspiration.setVoCid(consumerService.selectByPrimaryKey(voInspiration.getCid()).getNickname());
            voInspiration.setVoPublish(TimeUtils.dateToString(voInspiration.getTime()));
            list1.add(voInspiration);
        }
        return list1;
    }

    @Override
    public Inspiration selectByPrimaryKey(Integer id) {
        return inspirationMapper.selectByPrimaryKey(id);
    }

}
