package com.mlzone.csuldw.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mlzone.csuldw.entity.CommentEntity;
import com.mlzone.csuldw.service.ICommentService;

/**
 * 
 * Date: 2017年10月15日 下午1:50:06 
 * 
 * @author liudiwei 
 * @version  
 * @since JDK 1.7
 */
@Controller
public class CommentController {
	
	private static Logger log = Logger.getLogger(CommentController.class);

	
	@Autowired
	ICommentService commentService;
	
	/**
	 * 插入或更新评论
	 *
	 * Author:liudiwei
	 * Date:2017年10月15日
	 * @param commentEntity
	 * @return
	 * @since
	 */
	@RequestMapping(value = "/comment/saveOrUpdateComment.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> saveOrUpdateComment(CommentEntity commentEntity){
		Map<String, Object> resultMap = new HashMap<>();
		try {
			int saveResult = commentService.saveOrUpdateComment(commentEntity);
			if(saveResult > 0){
				resultMap.put("result", "success");
			}else{
				resultMap.put("result", "error");
				resultMap.put("info", "数据保存失败！"); 

			}
		} catch (Exception e) {
			resultMap.put("result", "error");
			resultMap.put("info", "数据库操作异常！");
			log.info(e.toString());
		}
		return resultMap;
	}
	
	/**
	 * 根据评论ID删除评论
	 *
	 * Author:liudiwei
	 * Date:2017年10月15日
	 * @param id
	 * @return
	 * @since
	 */
	@RequestMapping(value = "/comment/deleteCommentById.do")
	@ResponseBody
	public Map<String, Object> deleteCommentById(Integer id){
		Map<String, Object> resultMap = new HashMap<>();
		try {
			int deleteResult = commentService.deleteCommentById(id);
			if(deleteResult == 1){
				resultMap.put("result", "success");
			}else{
				resultMap.put("result", "success");
			}
		} catch (Exception e) {
			resultMap.put("result", "success");
			System.out.println(e);
		}
		return resultMap;
	}
	
	/**
	 * 根据用户ID获取评论列表
	 *
	 * Author:liudiwei
	 * Date:2017年10月15日
	 * @param userId
	 * @return
	 * @since
	 */
	@RequestMapping(value = "/comment/getCommentListByUserId.do")
	@ResponseBody
	public Map<String, Object> getCommentListByUserId(Integer userId){
		Map<String, Object> resultMap = new HashMap<>();
		try {
			List<CommentEntity> commentList = commentService.getCommentListByUserId(userId);
			resultMap.put("data", commentList);
			resultMap.put("result", "success");
			
		} catch (Exception e) {
			resultMap.put("result", "success");
			System.out.println(e);
		}
		return resultMap;
	}
	
	/**
	 * 根据文章ID获取文章所有评论
	 *
	 * Author:liudiwei
	 * Date:2017年10月15日
	 * @param articleId
	 * @return
	 * @since
	 */
	@RequestMapping(value = "/comment/getCommentListByArticleId.do")
	@ResponseBody
	public Map<String, Object> getCommentListByArticleId(Integer articleId){
		Map<String, Object> resultMap = new HashMap<>();
		try {
			List<CommentEntity> commentList = commentService.getCommentListByArticleId(articleId);
			resultMap.put("data", commentList);
			resultMap.put("result", "success");
			
		} catch (Exception e) {
			resultMap.put("result", "success");
			System.out.println(e);
		}
		return resultMap;
	}
	
	@RequestMapping(value = "/comment/countCommentByArticleId.do")
	@ResponseBody
	public Map<String, Object> countCommentByArticleId(Integer articleId){
		Map<String, Object> resultMap = new HashMap<>();
		try {
			int commentNum = commentService.countCommentByArticleId(articleId);
			resultMap.put("commentNum", commentNum);
			resultMap.put("result", "success");
			
		} catch (Exception e) {
			resultMap.put("result", "success");
			System.out.println(e);
		}
		return resultMap;
	}
}
