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
 * @create in 2018/4/20 15:09
 */
@Data
@NoArgsConstructor
@ApiModel("用户喜好关键词列表 实体, 默认按照权重从大到小排序")
@Document
public class UserLikeKeyWord implements Comparable<UserLikeKeyWord>{

    @ApiModelProperty("唯一标识")
    @Id
    private String id;

    @ApiModelProperty("用户ID")
    private long userId;

    @ApiModelProperty("关键词")
    private String keyword;

    @ApiModelProperty("权重")
    private double weight;

    @ApiModelProperty("目录")
    private int categoryId;

    private Date cTime;

    /**
     *  不看源代码不知道。TreeSet 的去重仅仅是根据比较器来判断的。
     * @param o
     * @return
     */
    @Override
    public int compareTo(UserLikeKeyWord o) {
        if (this == o) return 0;
        if (Double.compare(o.getWeight(), getWeight()) == 0) {
            if(o.getKeyword().equals(getKeyword())) {
                int categoryId = o.getCategoryId();
                return categoryId > this.categoryId ? 1 : categoryId == this.categoryId? 0 : -1;
            }else {
                long oHashCode = o.getKeyword().hashCode() * o.getCategoryId();
                long thisHashCode = this.getKeyword().hashCode() * this.getCategoryId();
                return oHashCode > thisHashCode ? 1 : oHashCode == thisHashCode? 0 : -1;
            }
        }else {
            return Double.compare(o.getWeight(), getWeight());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserLikeKeyWord)) return false;

        UserLikeKeyWord that = (UserLikeKeyWord) o;

        if (Double.compare(that.getWeight(), getWeight()) != 0) return false;
        if (getCategoryId() != that.getCategoryId()) return false;
        return getKeyword().equals(that.getKeyword());
    }

    @Override
    public int hashCode() {
        int result = this.keyword.hashCode();
        long temp;
        result = 31 * result + getKeyword().hashCode();
        temp = Double.doubleToLongBits(getWeight());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getCategoryId();
        return result;
    }
}
