package com.mlzone.csuldw.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mlzone.csuldw.entity.StarEntity;
import com.mlzone.csuldw.service.IStarService;

/**
 * 
 * Date: 2017年10月14日 下午11:54:02 
 * 
 * @author liudiwei 
 * @version  
 * @since JDK 1.7
 */
@Controller
public class StarController {
	
	private static Logger log = Logger.getLogger(StarController.class);
	
	@Autowired
	IStarService starService;
	
	/**
	 * 保存点赞
	 *
	 * Author:liudiwei
	 * Date:2017年10月15日
	 * @param starEntity
	 * @return
	 * @since
	 */
	@RequestMapping(value = "/star/saveStar.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> saveStar(StarEntity starEntity){
		Map<String, Object> resultMap = new HashMap<>();
		try {
			int saveResult = starService.saveStar(starEntity);
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
	 * 取消点赞(delete)
	 *
	 * Author:liudiwei
	 * Date:2017年10月15日
	 * @param id
	 * @return
	 * @since
	 */
	@RequestMapping(value = "/star/deleteStarById.do")
	@ResponseBody
	public Map<String, Object> deleteStarById(Integer id){
		Map<String, Object> resultMap = new HashMap<>();
		try {
			int deleteResult = starService.deleteStarById(id);
			if(deleteResult == 1) {
				resultMap.put("result", "success");
			}else{
				resultMap.put("result", "error");
			}
		} catch (Exception e) {
			resultMap.put("result", "error");
			System.out.println(e);
		}
		return resultMap;
	}

	/**
	 * 获取某个评论的点赞总数
	 *
	 * Author:liudiwei
	 * Date:2017年10月15日
	 * @param commentId
	 * @return
	 * @since
	 */
	@RequestMapping(value = "/star/countStarByCommentId.do")
	@ResponseBody
	public Map<String, Object> countStarByCommentId(Integer commentId){
		Map<String, Object> resultMap = new HashMap<>();
		try {
			int starNum = starService.countStarByCommentId(commentId);
			resultMap.put("starNum", starNum);
			resultMap.put("result", "success");
		} catch (Exception e) {
			resultMap.put("result", "success");
			System.out.println(e);
		}
		return resultMap;
	}

}
