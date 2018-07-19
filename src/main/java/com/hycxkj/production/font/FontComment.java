package com.hycxkj.production.font;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 陈少平
 * @description
 * @create in 2018/4/1 16:33
 */
@Data
@NoArgsConstructor
public class FontComment implements Serializable{
    private Long commentId;
    private String content;
    private Date createTime;
    private Long userId;
    private String userNick;
    private String avatar;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    public Date getCreateTime() {
        return createTime;
    }
}
