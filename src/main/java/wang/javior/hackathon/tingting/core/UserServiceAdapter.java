package wang.javior.hackathon.tingting.core;




public interface UserServiceAdapter {

    int countUserByOpenid(String openId);

    int insertUser(String openId);

    long countAll();
}
