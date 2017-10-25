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

import com.github.pagehelper.PageInfo;
import com.mlzone.csuldw.entity.ArticleInfoEntity;
import com.mlzone.csuldw.service.IArticleInfoService;

/**
 * 
 * Date: 2017年10月14日 下午11:02:54 
 * 
 * @author liudiwei 
 * @version  
 * @since JDK 1.7
 */
@Controller
public class ArticleInfoController {
	
	private static Logger log = Logger.getLogger(ArticleInfoController.class);
	
	@Autowired
	private IArticleInfoService articleInfoService;
	
	/**
	 * 新增或更新文章信息
	 *
	 * Author:liudiwei
	 * Date:2017年10月14日
	 * @param articleInfoEntity
	 * @return
	 * @since
	 */
	@RequestMapping(value = "/articleInfo/saveOrUpdateArticleInfo.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> saveOrUpdateArticleInfo(ArticleInfoEntity articleInfoEntity){
		Map<String, Object> resultMap = new HashMap<>();
		try {
			int saveResult = articleInfoService.saveOrUpdateArticleInfo(articleInfoEntity);
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
	 * 根据ID获取文章信息
	 *
	 * Author:liudiwei
	 * Date:2017年10月14日
	 * @param id
	 * @return
	 * @since
	 */
	@RequestMapping(value = "/articleInfo/getArticelInfoById.do")
	@ResponseBody
	public Map<String, Object> getArticelInfoById(Integer id){
		Map<String, Object> resultMap = new HashMap<>();
		try {
			ArticleInfoEntity articleInfoEntity = articleInfoService.getArticelInfoById(id);
			resultMap.put("data", articleInfoEntity);
			resultMap.put("result", "success");
		} catch (Exception e) {
			resultMap.put("result", "error");
			System.out.println(e);
		}
		return resultMap;
	}
	
	/**
	 * 获取所有的文章信息 支持分页
	 *
	 * Author:liudiwei
	 * Date:2017年10月14日
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @since
	 */
	@RequestMapping(value = "/articleInfo/getArticelInfoList.do", method = {RequestMethod.POST})
	@ResponseBody
	public Map<String, Object> getArticelInfoList(int pageNum, int pageSize) {
		Map<String, Object> resultMap = new HashMap<>();
		try {
			PageInfo<ArticleInfoEntity> articleInfoList = articleInfoService.getArticleInfoList(pageNum, pageSize).toPageInfo();
			resultMap.put("data", articleInfoList);
			resultMap.put("result", "success");
		} catch (Exception e) {
			resultMap.put("result", "error");
			e.printStackTrace();
		}
		return resultMap;
	}
	
	/**
	 * 根据ID删除文章信息
	 *
	 * Author:liudiwei
	 * Date:2017年10月14日
	 * @param id
	 * @return
	 * @since
	 */
	@RequestMapping(value = "/articleInfo/deleteArticleInfoById.do")
	@ResponseBody
	public Map<String, Object> deleteArticleInfoById(Integer id){
		Map<String, Object> resultMap = new HashMap<>();
		try {
			int deleteResult = articleInfoService.deleteArticleInfoById(id);
			if(deleteResult == 1){
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
	 * 根据参数获取文章列表
	 *
	 * Author:liudiwei
	 * Date:2017年10月15日
	 * @param keywords
	 * @param tag
	 * @param category
	 * @param pageSize
	 * @param pageNum
	 * @return
	 * @since
	 */
	@RequestMapping(value = "/articleInfo/getArticleInfoListByParams.do")
	@ResponseBody
	public Map<String, Object> getArticleInfoListByParams(String keywords, String tag, String category, int pageSize, int pageNum){
		Map<String, Object> resultMap = new HashMap<>();
		try {
			List<ArticleInfoEntity> articleInfoList = articleInfoService.getArticleInfoListByParams(keywords, tag, category, pageNum, pageSize);
			resultMap.put("data", articleInfoList);
			resultMap.put("result", "success");

		} catch (Exception e) {
			resultMap.put("result", "error");
			System.out.println(e);
		}
		return resultMap;
	}
	
	/**
	 * 根据参数统计文章数量
	 *
	 * Author:liudiwei
	 * Date:2017年10月15日
	 * @param keywords
	 * @param tag
	 * @param category
	 * @return
	 * @since
	 */
	@RequestMapping(value = "/articleInfo/countArticleInfoByParams.do")
	@ResponseBody
	public Map<String, Object> countArticleInfoByParams(String keywords, String tag, String category){
		Map<String, Object> resultMap = new HashMap<>();
		try {
			int articleNum = articleInfoService.countArticleInfoByParams(keywords, tag, category);
			resultMap.put("articleNum", articleNum);
			resultMap.put("result", "success");

		} catch (Exception e) {
			resultMap.put("result", "error");
			System.out.println(e);
		}
		return resultMap;
	}
}
