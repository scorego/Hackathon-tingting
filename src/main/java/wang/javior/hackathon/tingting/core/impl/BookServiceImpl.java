package wang.javior.hackathon.tingting.core.impl;

import wang.javior.hackathon.tingting.core.BookServiceAdapter;
import wang.javior.hackathon.tingting.dao.mapper.BookBasicInfoMapper;
import wang.javior.hackathon.tingting.dao.mapper.ChapterBasicInfoMapper;
import wang.javior.hackathon.tingting.dao.mapper.ContentBasicInfoMapper;
import wang.javior.hackathon.tingting.dao.model.BookBasicInfoDao;
import wang.javior.hackathon.tingting.dao.model.ChapterBasicInfoDao;
import wang.javior.hackathon.tingting.dao.model.ContentBasicInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(rollbackFor = Exception.class)
public class BookServiceImpl implements BookServiceAdapter {

    @Autowired
    private BookBasicInfoMapper bookBasicInfoMapper;

    @Autowired
    private ChapterBasicInfoMapper chapterBasicInfoMapper;

    @Autowired
    private ContentBasicInfoMapper contentBasicInfoMapper;

    @Override
    public BookBasicInfoDao getBookBasicInfoByName(String bookName) {
        return bookBasicInfoMapper.getBookBasicInfoByName(bookName);
    }

    @Override
    public List<BookBasicInfoDao> queryFuzzBooks(String query, int limit) {
        return bookBasicInfoMapper.queryFuzzBooks(query, limit);
    }

    @Override
    public ChapterBasicInfoDao getChapterBasicInfoByBookIdChapterIndex(long bookId, long chapterIndex) {
        return chapterBasicInfoMapper.getChapterBasicInfoByBookIdChapterIndex(bookId, chapterIndex);
    }

    @Override
    public ContentBasicInfoDao getContentBasicInfoByIds(long bookId, long chapterId) {
        return contentBasicInfoMapper.getContentBasicInfoDaoByIds(bookId, chapterId);
    }

    @Override
    public List<BookBasicInfoDao> getBookDetails(int limit) {
        return bookBasicInfoMapper.getAll(limit);
    }
}
