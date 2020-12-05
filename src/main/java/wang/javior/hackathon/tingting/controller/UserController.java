package wang.javior.hackathon.tingting.controller;



import org.springframework.util.StringUtils;
import wang.javior.hackathon.tingting.entity.VO.NewUserVo;
import wang.javior.hackathon.tingting.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/v1/user/")
@Api(tags = "用户相关入口")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("判断一个用户是否首次登录（首次登录count == 0）。如果首次登录，会把用户插入User表")
    @GetMapping("/isNewUser")
    public NewUserVo isNewUser(@RequestParam(required = false) String openId) {
        NewUserVo newUserVo = new NewUserVo(openId);
        if (!StringUtils.isEmpty(openId)) {
            int cnt = userService.countUserByOpenid(openId);
            newUserVo.setCount(cnt);
            if (cnt <= 0) {
                userService.insertUser(openId);
            }
        }
        log.info("isNewUser, openId: [{}], res: [{}]", openId, newUserVo);
        return newUserVo;
    }


}
