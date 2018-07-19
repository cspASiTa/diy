package com.hycxkj.production.font;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 陈少平
 * @description
 * @create in 2018/3/29 16:30
 */
@Data
@NoArgsConstructor
public class FontSimpleProduction implements Serializable{

    private long proId;
    private int userId;
    private String userNick;
    private String avatar;
    private String title;
    private int categoryId;
    private String image;
    private int likeCount;
    private byte allowComments;
    private int readnumber;
}
