package wang.javior.hackathon.tingting.core.impl;

import wang.javior.hackathon.tingting.core.UserHistoryServiceAdapter;
import wang.javior.hackathon.tingting.dao.mapper.UserHistoryMapper;
import wang.javior.hackathon.tingting.dao.model.UserHistoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(rollbackFor = Exception.class)
public class UserHistoryServiceImpl implements UserHistoryServiceAdapter {

    @Autowired
    UserHistoryMapper userHistoryMapper;


    @Override
    public List<UserHistoryDao> getUserHistory(String openId, String bookName) {
        return userHistoryMapper.getUserHistory(openId, bookName, 1000);
    }

    @Override
    public int insertUserHistory(String openId, String bookName, long chapterIndex) {
        return userHistoryMapper.insertUserHistory(openId, bookName, chapterIndex);
    }
}
