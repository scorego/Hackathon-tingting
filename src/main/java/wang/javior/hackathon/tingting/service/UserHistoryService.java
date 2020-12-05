package wang.javior.hackathon.tingting.service;


import wang.javior.hackathon.tingting.core.UserHistoryServiceAdapter;
import wang.javior.hackathon.tingting.dao.model.UserHistoryDao;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;


@Slf4j
@Service
public class UserHistoryService {

    @Autowired
    UserHistoryServiceAdapter userHistoryServiceAdapter;

    public long getUserHistoryLastChapterIndex(String openId, String bookName) {
        val userHistoryList = getLastUserHistory(openId, bookName);
        if (userHistoryList == null) {
            return 1;
        }
        return userHistoryList.getChapterIndex();
    }

    public UserHistoryDao getLastUserHistory(String openId, String bookName) {
        val userHistoryList = userHistoryServiceAdapter.getUserHistory(openId, bookName);
        if (CollectionUtils.isEmpty(userHistoryList)) {
            return null;
        }
        return userHistoryList.get(0);
    }

    public void insertUserHistory(String openId, String bookName, long chapterIndex) {
        userHistoryServiceAdapter.insertUserHistory(openId, bookName, chapterIndex);
    }

}
