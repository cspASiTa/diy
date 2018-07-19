package com.hycxkj.postage.domain;

import com.hycxkj.postage.bean.PostageCarryMode;
import com.hycxkj.postage.bean.PostagePackageCondition;
import com.hycxkj.postage.bean.PostageTemplate;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author 陈少平
 * @description
 * @create in 2018/5/7 16:37
 */
@Data
@NoArgsConstructor
public class PostageDomain implements Serializable{
    private PostageTemplate postageTemplate;
    private List<PostageCarryMode> postageCarryMode;
    private List<PostagePackageCondition> postagePackageCondition;
}
