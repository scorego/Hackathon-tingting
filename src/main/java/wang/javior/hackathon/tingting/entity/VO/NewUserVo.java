package wang.javior.hackathon.tingting.entity.VO;


import io.swagger.annotations.ApiModel;
import lombok.Data;


@Data
@ApiModel("是否新用户实体")
public class NewUserVo {

    public NewUserVo(String openId) {
        this.openId = openId;
    }

    private String openId;

    private int count;

}
