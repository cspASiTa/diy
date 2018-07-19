package com.hycxkj.production.controller;

import com.github.pagehelper.PageInfo;
import com.hycxkj.common.base.BaseController;
import com.hycxkj.common.base.BaseResult;
import com.hycxkj.common.util.HttpUtil;
import com.hycxkj.production.bean.ProductionComment;
import com.hycxkj.production.font.FontComment;
import com.hycxkj.production.service.ProductionCommentService;
import com.hycxkj.sensitivewdfilter.WordFilter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
* @author 陈少平
* @description
* @create in 2018/03/29 09:47
*/
@Slf4j
@Api(value="作品评论controller",tags= "作品评论接口")
@RestController
@RequestMapping("/api")
public class ProductionCommentController extends BaseController {

    @Autowired
    private ProductionCommentService productionCommentService;

    @ApiResponse(code = 200, message="返回下面4个字段（commentId(评论ID)，content(评论内容)，createTime(评论时间)，userId(用户ID)）")
    @ApiOperation("添加作品的评论信息。前端只需提交ProductionId,userId,content,即可（如果评论有父ID，那么需要提交parentId）")
    @PostMapping("/production/comment")
    public Object insertComment(@ModelAttribute ProductionComment productionComment, HttpServletRequest request, Device device) {
        // 过滤不合法消息
        String content = productionComment.getContent();
        if(!StringUtils.isEmpty(content)) {
            String s = WordFilter.doFilter(content);
            productionComment.setContent(s);
        }
        productionComment.setCreateTime(new Date());
        String agent = HttpUtil.getClientAgent(request, device);
        productionComment.setAgent(agent);
        productionComment.setIp(request.getRemoteAddr());
        productionCommentService.insertSelective(productionComment);
        // 准备返回给客户端的信息
        productionComment.setIp(null);
        productionComment.setAgent(null);
        productionComment.setParentId(null);
        productionComment.setStatus(null);
        productionComment.setProductionId(null);
        BaseResult result = new BaseResult();
        result.setData(productionComment);
        result.setCode(200);
        return result;
    }

    @ApiOperation("分页获取作品的评论信息")
    @GetMapping("/production/comments/{productionId}")
    public Object getProductionCommentsByPage(@ApiParam(value="请求第几页",required = true) @RequestParam Integer pageNum, @ApiParam(value="每次请求多少条数据,默认10") @RequestParam(defaultValue = "10") Integer pageSize, @ApiParam(value="作品的ID",required = true) @RequestParam Long productionId) {
        PageInfo<FontComment> pageInfo = productionCommentService.getProductionCommentsByPage2Font(pageNum, pageSize, productionId);
        BaseResult result = new BaseResult();
        result.setCode(200);
        result.setData(pageInfo.getList());
        return result;
    }

    @DeleteMapping("/production/comment/{commentId}")
    public Object deleteProductionComment(@ApiParam(value="评论的ID",required = true) @RequestParam Long commentId) {
        productionCommentService.deleteById(commentId);
        return putSuccess();
    }
}