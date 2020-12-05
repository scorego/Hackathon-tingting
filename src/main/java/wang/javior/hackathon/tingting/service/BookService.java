package wang.javior.hackathon.tingting.service;


import wang.javior.hackathon.tingting.core.BookServiceAdapter;
import wang.javior.hackathon.tingting.dao.model.BookBasicInfoDao;
import wang.javior.hackathon.tingting.entity.VO.BookContentVo;
import wang.javior.hackathon.tingting.entity.VO.BookDetailVo;
import wang.javior.hackathon.tingting.utils.ContentUtil;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
public class BookService {

    @Autowired
    private BookServiceAdapter bookServiceAdapter;

    public void updateBookChapterContent(BookContentVo bookContentVo, String bookName, long chapterIndex) {

        // 1. 获取BookBasicInfo
        BookBasicInfoDao bookBasicInfo = bookServiceAdapter.getBookBasicInfoByName(bookName);
        if (bookBasicInfo == null) {
            return;
        }

        // 2. 获取ChapterBasicInfo
        val bookId = bookBasicInfo.getBookId();
        bookContentVo.setBookId(bookId);

        val chapterBasicInfo = bookServiceAdapter.getChapterBasicInfoByBookIdChapterIndex(bookId, chapterIndex);
        if (chapterBasicInfo == null) {
            return;
        }

        // 3. 获取ContentBasicInfo
        val chapterId = chapterBasicInfo.getChapterId();
        bookContentVo.setChapterId(chapterId);

        val contentBasicInfo = bookServiceAdapter.getContentBasicInfoByIds(bookId, chapterId);
        if (contentBasicInfo == null || StringUtils.isEmpty(contentBasicInfo.getContentText())) {
            return;
        }
        val chapterContent = ContentUtil.cutTextIntoSentences(contentBasicInfo.getContentText());
        bookContentVo.updateContent(chapterContent);
    }


    public BookDetailVo getBookDetailByName(String bookName) {
        BookBasicInfoDao bookBasicInfo = null;
        try {
            bookBasicInfo = bookServiceAdapter.getBookBasicInfoByName(bookName);
        } catch (Exception e) {
            log.warn("getBookDetailByName error, bookName: [{}]", bookName);
        }
        return new BookDetailVo(bookBasicInfo);
    }

    public List<BookDetailVo> queryFuzzBooks(String query, int limit) {
        List<BookDetailVo> bookDetailVos = new ArrayList<>();
        try {
            List<BookBasicInfoDao> bookBasicInfos = bookServiceAdapter.queryFuzzBooks(query, limit);
            for (BookBasicInfoDao basicInfo : bookBasicInfos) {
                bookDetailVos.add(new BookDetailVo(basicInfo));
            }
        } catch (Exception e) {
            log.warn("queryFuzzBooks error, query: [{}]", query);
        }
        return bookDetailVos;
    }

    public List<BookDetailVo> getBookDetails() {
        return getBookDetails(500);
    }

    public List<BookDetailVo> getBookDetails(int limit) {
        limit = Math.max(0, limit);
        val bookInfos = bookServiceAdapter.getBookDetails(limit);
        List<BookDetailVo> bookDetailVos = new ArrayList<>();
        for (BookBasicInfoDao bookInfo : bookInfos) {
            bookDetailVos.add(new BookDetailVo(bookInfo));
        }
        return bookDetailVos;
    }


}
