package com.hycxkj.recommend.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


/**
 * @author 陈少平
 * @description
 * @create in 2018/4/20 7:49
 */
@Data
@NoArgsConstructor
@ApiModel("用户浏览记录的进一步抽象，为了进行用户的喜好分析而创建的实体")
@Document
public class UserLikeLog {

    @ApiModelProperty("唯一标识")
    @Id
    private String id;

    @ApiModelProperty("用户ID")
    private long userId;

    private Date viewTime;

    @ApiModelProperty("作品ID")
    private long proId;

    @ApiModelProperty("作品标题")
    private String title;

    @ApiModelProperty("作品目录")
    private int categoryId;

}
