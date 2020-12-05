package wang.javior.hackathon.tingting.core;


import wang.javior.hackathon.tingting.dao.model.BookBasicInfoDao;
import wang.javior.hackathon.tingting.dao.model.ChapterBasicInfoDao;
import wang.javior.hackathon.tingting.dao.model.ContentBasicInfoDao;

import java.util.List;

public interface BookServiceAdapter {

    BookBasicInfoDao getBookBasicInfoByName(String bookName);

    List<BookBasicInfoDao> queryFuzzBooks(String query, int limit);

    ChapterBasicInfoDao getChapterBasicInfoByBookIdChapterIndex(long bookId, long chapterIndex);

    ContentBasicInfoDao getContentBasicInfoByIds(long bookId, long chapterId);

    List<BookBasicInfoDao> getBookDetails(int limit);

}
