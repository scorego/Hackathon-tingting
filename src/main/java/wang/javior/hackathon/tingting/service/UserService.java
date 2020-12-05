package wang.javior.hackathon.tingting.service;


import wang.javior.hackathon.tingting.core.UserServiceAdapter;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    @Autowired
    UserServiceAdapter userServiceAdapter;

    public int countUserByOpenid(String openId) {
        val cnt = userServiceAdapter.countUserByOpenid(openId);
        return Math.max(0, cnt);
    }

    public int insertUser(String openId) {
        return userServiceAdapter.insertUser(openId);
    }
}
