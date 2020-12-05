package wang.javior.hackathon.tingting.core.impl;

import wang.javior.hackathon.tingting.core.UserServiceAdapter;
import wang.javior.hackathon.tingting.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserServiceAdapter {

    @Autowired
    UserMapper userMapper;

    @Override
    public int countUserByOpenid(String openId) {
        return userMapper.countUserByOpenId(openId);
    }

    @Override
    public int insertUser(String openId) {
        return userMapper.insertUser(openId);
    }

    @Override
    public long countAll() {
        return userMapper.countAll();
    }
}
