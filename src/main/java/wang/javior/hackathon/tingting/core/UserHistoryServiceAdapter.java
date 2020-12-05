package wang.javior.hackathon.tingting.core;


import wang.javior.hackathon.tingting.dao.model.UserHistoryDao;

import java.util.List;

public interface UserHistoryServiceAdapter {


    List<UserHistoryDao> getUserHistory(String openId, String bookName);

    int insertUserHistory(String openId, String bookName, long chapterIndex);
}
