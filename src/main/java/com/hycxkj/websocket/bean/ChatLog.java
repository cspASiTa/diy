package com.hycxkj.websocket.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.hycxkj.common.annotation.PrimaryKey;
/**
 * 实体类对应的数据表为：  ws_chat_log
 * @author 陈少平
 * @date 2018-04-07 20:51:44
 */
@ApiModel(value ="ChatLog")
public class ChatLog implements Serializable {
    @PrimaryKey
    @ApiModelProperty(value = "唯一标识，自增主键")
    private Long id;

    @ApiModelProperty(value = "发送者Id")
    private Long sendid;

    @ApiModelProperty(value = "接受者Id")
    private Long receiveid;

    @ApiModelProperty(value = "发送内容")
    private String content;

    @ApiModelProperty(value = "发送时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sendtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ws_chat_log
     */
    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSendid() {
        return sendid;
    }

    public void setSendid(Long sendid) {
        this.sendid = sendid;
    }

    public Long getReceiveid() {
        return receiveid;
    }

    public void setReceiveid(Long receiveid) {
        this.receiveid = receiveid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sendid=").append(sendid);
        sb.append(", receiveid=").append(receiveid);
        sb.append(", content=").append(content);
        sb.append(", sendtime=").append(sendtime);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ChatLog other = (ChatLog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSendid() == null ? other.getSendid() == null : this.getSendid().equals(other.getSendid()))
            && (this.getReceiveid() == null ? other.getReceiveid() == null : this.getReceiveid().equals(other.getReceiveid()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getSendtime() == null ? other.getSendtime() == null : this.getSendtime().equals(other.getSendtime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSendid() == null) ? 0 : getSendid().hashCode());
        result = prime * result + ((getReceiveid() == null) ? 0 : getReceiveid().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getSendtime() == null) ? 0 : getSendtime().hashCode());
        return result;
    }
}