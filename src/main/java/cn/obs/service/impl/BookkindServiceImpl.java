package cn.obs.service.impl;

import cn.obs.mapper.BookkindMapper;
import cn.obs.po.*;
import cn.obs.service.BookkindService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ww on 2018/5/11.
 */
@Service("bookkindService")
public class BookkindServiceImpl implements BookkindService {

    @Autowired
    BookkindMapper bookkindMapper;

    long total = 0L;

    @Override
    public List<Bookkind> list(Page page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        List<Bookkind> list = bookkindMapper.selectByExample(new BookkindExample());
        PageInfo<Bookkind> pageInfo = new PageInfo<>(list);
        this.total = pageInfo.getTotal();
        return list;
    }

    @Override
    public int insert(Bookkind record) {
        return bookkindMapper.insertSelective(record);
    }

    @Override
    public int delete(Integer id) {
        return bookkindMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Bookkind record) {
        return bookkindMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public long count() {
        return total;
    }
}
