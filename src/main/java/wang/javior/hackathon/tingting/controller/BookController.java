package wang.javior.hackathon.tingting.controller;


import wang.javior.hackathon.tingting.entity.VO.BookContentVo;
import wang.javior.hackathon.tingting.entity.VO.BookDetailVo;
import wang.javior.hackathon.tingting.entity.VO.BookQueryVo;
import wang.javior.hackathon.tingting.service.BookService;
import wang.javior.hackathon.tingting.service.UserHistoryService;
import wang.javior.hackathon.tingting.utils.RandomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


@Slf4j
@RestController
@RequestMapping("/v1/book/")
@Api(tags = "书籍相关信息入口")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserHistoryService userHistoryService;

    /**
     * 获取指定书名的某一章内容
     *
     * @param chapterIndex 如果 >= 1,表示获取指定章节(1表示从头获取)；如果小于1，表示从上次历史记录开始获取
     */
    @ApiOperation("获取指定书名的某一章内容")
    @GetMapping("/getBookContent")
    public BookContentVo getBookContent(@RequestParam(required = false) String openId,
                                        @RequestParam String bookName,
                                        @RequestParam(required = false, defaultValue = "-1") long chapterIndex) {
        // 如果chapterIndex != 1，获取用户历史记录读到的章节
        long newChapterIndex = chapterIndex;
        if (chapterIndex < 1) {
            newChapterIndex = userHistoryService.getUserHistoryLastChapterIndex(openId, bookName);
        }

        BookContentVo bookContentVo = new BookContentVo(openId, bookName, newChapterIndex);
        bookService.updateBookChapterContent(bookContentVo, bookName, newChapterIndex);
        log.info("getBookContent, openId: [{}], bookName: [{}], chapterIndex: [{}], newChapterIndex: [{}], emptyContent: [{}]", openId, bookName, chapterIndex, newChapterIndex, bookContentVo.isEmptyContent());

        // 如果openId、chapterContent不为空，插入userHistory
        if (!StringUtils.isEmpty(openId) && !bookContentVo.isEmptyContent()) {
            userHistoryService.insertUserHistory(openId, bookContentVo.getBookName(), bookContentVo.getChapterIndex());
        }
        return bookContentVo;
    }


    @ApiOperation("根据bookName获取书籍信息")
    @GetMapping("/getBookDetail")
    public BookDetailVo getBookDetail(@RequestParam(required = false) String openId, @RequestParam String bookName) {
        BookDetailVo bookDetail = bookService.getBookDetailByName(bookName);
        log.info("getBookDetail, openId: [{}], bookName: [{}], BookDetailVo: [{}]", openId, bookName, bookDetail);
        return bookDetail;
    }


    @ApiOperation("随机推荐几本书")
    @GetMapping("/recommendBooks")
    public List<BookDetailVo> recommendBooks(@RequestParam(required = false) String openId,
                                             @RequestParam(required = false, defaultValue = "3") int bookCnt) {

        // 从数据库获取一些书
        List<BookDetailVo> bookDetails = bookService.getBookDetails();

        // 返回的书的数量为小于bookDetails长度的非负数
        val finalBookCnt = Math.min(Math.max(0, bookCnt), bookDetails.size());

        // 随机抽bookCnt本
        List<Integer> randomNums = RandomUtil.getRandomNums(bookDetails.size(), finalBookCnt);
        Set<BookDetailVo> res = new HashSet<>();
        for (Integer randomNum : randomNums) {
            res.add(bookDetails.get(randomNum));
        }
        log.info("getBookDetail, openId: [{}], bookCnt: [{}], finalBookCnt: [{}], randomNums: [{}]", openId, bookCnt, finalBookCnt, randomNums);
        return new ArrayList<>(res);
    }

    @ApiOperation("搜书(模糊查询)")
    @GetMapping("/queryBooks")
    public BookQueryVo queryBooks(@RequestParam(required = false) String openId,
                                  @RequestParam String query,
                                  @RequestParam(required = false, defaultValue = "3") int fuzzCnt) {
        BookDetailVo bookDetail = bookService.getBookDetailByName(query);
        List<BookDetailVo> fuzzBooks = bookService.queryFuzzBooks(query, Math.max(fuzzCnt, 0));
        BookQueryVo bookQueryVo = new BookQueryVo(query, bookDetail, fuzzBooks);
        log.info("queryBooks, openId: [{}], query: [{}], fuzzCnt: [{}], bookQueryVo: [{}]", openId, query, fuzzCnt, bookQueryVo);
        return bookQueryVo;
    }

}
