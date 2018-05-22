package cn.obs.vo;

import cn.obs.po.Book;

/**
 * Created by Ww on 2018/5/21.
 */
public class VoBook extends Book{

    private String voUrl;

    private String voKind;

    public VoBook() {
    }

    public VoBook(Book book) {
        this.setId(book.getId());
        this.setBookname(book.getBookname());
        this.setAuthor(book.getAuthor());
        this.setPublishyear(book.getPublishyear());
        this.setPages(book.getPages());
        this.setPrice(book.getPrice());
        this.setScore(book.getScore());
        this.setContent(book.getContent());
        this.setAuthorinfo(book.getAuthorinfo());
        this.setKind(book.getKind());
        this.setUrl(book.getUrl());
    }

    public String getVoKind() {
        return voKind;
    }

    public void setVoKind(String voKind) {
        this.voKind = voKind;
    }

    public String getVoUrl() {
        return voUrl;
    }

    public void setVoUrl(String voUrl) {
        this.voUrl = voUrl;
    }
}
