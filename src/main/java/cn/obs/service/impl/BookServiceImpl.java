package cn.obs.service.impl;

import cn.obs.mapper.BookMapper;
import cn.obs.po.Book;
import cn.obs.po.BookExample;
import cn.obs.po.Bookkind;
import cn.obs.po.Page;
import cn.obs.service.BookService;
import cn.obs.service.BookkindService;
import cn.obs.vo.VoBook;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ww on 2018/5/11.
 */
@Service("bookService")
public class BookServiceImpl implements BookService {

    @Autowired
    BookkindService bookkindService;

    @Autowired
    BookMapper bookMapper;

    long total = 0L;

    @Override
    public List<Book> list(Page page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        List<Book> list = bookMapper.selectByExample(new BookExample());
        PageInfo<Book> pageInfo = new PageInfo<>(list);
        this.total = pageInfo.getTotal();
        return list;
    }

    @Override
    public int insert(Book record) {
        return bookMapper.insertSelective(record);
    }

    @Override
    public int delete(Integer id) {
        return bookMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Book record) {
        return bookMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public long count() {
        return total;
    }

    @Override
    public List<VoBook> vo(List<Book> list) {
        List<VoBook> list1 = new ArrayList<>();
        for (Book book:
                list) {
            VoBook voBook = new VoBook(book);
            voBook.setVoKind(bookkindService.selectByPrimaryKey(voBook.getKind()).getKind());
            voBook.setVoUrl("<a href = \"#\" onclick=\"showBookPic('" + voBook.getId() + "')\">查看图片</a>");
            list1.add(voBook);
        }
        return list1;
    }

    @Override
    public Book selectByPrimaryKey(Integer id) {
        return bookMapper.selectByPrimaryKey(id);
    }
}
