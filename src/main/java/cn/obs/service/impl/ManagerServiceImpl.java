package cn.obs.service.impl;

import cn.obs.mapper.ManagerMapper;
import cn.obs.po.Manager;
import cn.obs.po.ManagerExample;
import cn.obs.po.Page;
import cn.obs.service.ManagerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ww on 2018/5/11.
 */
@Service("managerService")
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    ManagerMapper managerMapper;

    long total = 0L;

    @Override
    public List<Manager> list(Page page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        List<Manager> list = managerMapper.selectByExample(new ManagerExample());
        PageInfo<Manager> pageInfo = new PageInfo<>(list);
        this.total = pageInfo.getTotal();
        return list;
    }

    @Override
    public int insert(Manager record) {
        return managerMapper.insertSelective(record);
    }

    @Override
    public int delete(Integer id) {
        return managerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Manager record) {
        return managerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public long count() {
        return total;
    }

    @Override
    public Manager selectByPrimaryKey(Integer id) {
        return managerMapper.selectByPrimaryKey(id);
    }
}
