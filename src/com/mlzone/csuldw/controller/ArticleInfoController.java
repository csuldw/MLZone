package com.mlzone.csuldw.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.github.pagehelper.PageInfo;
import com.mlzone.csuldw.common.DateUtils;
import com.mlzone.csuldw.common.FileUtil;
import com.mlzone.csuldw.common.FileUtil;
import com.mlzone.csuldw.common.ResultModel;
import com.mlzone.csuldw.entity.ArticleInfoEntity;
import com.mlzone.csuldw.entity.vo.ArticleCountStatVo;
import com.mlzone.csuldw.service.IArticleInfoService;
import com.mlzone.csuldw.service.ICommentService;

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

	@Autowired
	ICommentService commentService;

	/**
	 * 新增或更新文章信息
	 * 
	 * Author:liudiwei Date:2017年10月14日
	 * 
	 * @param articleInfoEntity
	 * @return
	 * @since
	 */
	@RequestMapping(value = "/articleInfo/saveOrUpdateArticleInfo.do", produces = "application/json")
	@ResponseBody
	public Map<String, Object> saveOrUpdateArticleInfo(
			@RequestBody ArticleInfoEntity articleInfoEntity) {
		Map<String, Object> resultMap = new HashMap<>();
		try {
			log.info(articleInfoEntity.toString());
			int saveResult = articleInfoService.saveOrUpdateArticleInfo(articleInfoEntity);
			if (saveResult > 0) {
				resultMap.put("result", "success");
			} else {
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
	 * Author:liudiwei Date:2017年10月14日
	 * 
	 * @param id
	 * @return
	 * @since
	 */
	@RequestMapping(value = "/articleInfo/getArticelInfoById.do")
	@ResponseBody
	public Map<String, Object> getArticelInfoById(Integer id) {
		Map<String, Object> resultMap = new HashMap<>();
		try {
			ArticleInfoEntity articleInfoEntity = articleInfoService
					.getArticelInfoById(id);
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
	 * Author:liudiwei Date:2017年10月14日
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @since
	 */
	@RequestMapping(value = "/articleInfo/getArticelInfoList.do", method = { RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> getArticelInfoList(int pageNum, int pageSize,
			@RequestParam(required = false) String title,
			@RequestParam(required = false) String author,
			@RequestParam(required = false) String tags,
			@RequestParam(required = false) String categoryName,
			@RequestParam(required = false) String publicDate,
			@RequestParam(required = false) String keywords,
			@RequestParam(required = false) Integer isPublish) {
		Map<String, Object> resultMap = new HashMap<>();
		try {
			log.info("title:" + title + " | author:" + author + " |tags:"
					+ tags + " |categoryName:" + categoryName
					+ " | publicDate:" + publicDate + " | keywords" + keywords
					+ " | isPublish" + isPublish);
			PageInfo<ArticleInfoEntity> articleInfoList = articleInfoService
					.getArticleInfoListByPage(keywords, author, title,
							publicDate, categoryName, tags, isPublish, pageNum,
							pageSize).toPageInfo();
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
	 * Author:liudiwei Date:2017年10月14日
	 * 
	 * @param id
	 * @return
	 * @since
	 */
	@RequestMapping(value = "/articleInfo/deleteArticleInfoById.do")
	@ResponseBody
	public Map<String, Object> deleteArticleInfoById(Integer id) {
		Map<String, Object> resultMap = new HashMap<>();
		try {
			int deleteResult = articleInfoService.deleteArticleInfoById(id);
			if (deleteResult == 1) {
				resultMap.put("result", "success");
			} else {
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
	 * Author:liudiwei Date:2017年10月15日
	 * 
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
	public Map<String, Object> getArticleInfoListByParams(int pageSize,
			int pageNum, String keywords, String tag, String category) {
		Map<String, Object> resultMap = new HashMap<>();
		try {
			log.info(keywords);
			List<ArticleInfoEntity> articleInfoList = articleInfoService
					.getArticleInfoListByParams(keywords, tag, category,
							pageNum, pageSize);
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
	 * Author:liudiwei Date:2017年10月15日
	 * 
	 * @param keywords
	 * @param tag
	 * @param category
	 * @return
	 * @since
	 */
	@RequestMapping(value = "/articleInfo/countArticleInfoByParams.do")
	@ResponseBody
	public Map<String, Object> countArticleInfoByParams(String keywords,
			String tag, String category) {
		Map<String, Object> resultMap = new HashMap<>();
		try {
			int articleNum = articleInfoService.countArticleInfoByParams(
					keywords, tag, category);
			resultMap.put("articleNum", articleNum);
			resultMap.put("result", "success");

		} catch (Exception e) {
			resultMap.put("result", "error");
			System.out.println(e);
		}
		return resultMap;
	}

	/**
	 * 上传文件
	 * 
	 * Author:liudiwei Date:2017年12月29日
	 * 
	 * @param request
	 * @param file
	 * @return
	 * @since
	 */
	@RequestMapping(value = "/file/uploadFile.do", method = { RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> upLoadProjectFile(HttpServletRequest request,
			@RequestParam("file") CommonsMultipartFile file, 
			@RequestParam(required = false) String uploadType) {
		log.info("uploadType:" + uploadType);
		Map<String, Object> resultMap = new HashMap<>();
		try {
			String fileUploadPath = "/data01/";
			String fullPath = fileUploadPath; // 文件夹路径
			if("article".equals(uploadType)){
				fullPath += "/article/";
			}
			if("images".equals(uploadType)){
				fullPath += "/images/";
			}
			String fileName = file.getOriginalFilename(); //文件名称
			log.info("filePath: " + fullPath + fileName);
//			if(FileUtil.checkFileExist(fullPath, fileName)){
//				log.info(fullPath + "目录下存在该文件：" + fileName);
//				long ts = DateUtils.getCurrentTimestamp();
//				fileName = "f" + ts + "-" + fileName;
//				log.info("保存文件重命名" + fileName);
//			}
			FileUtil.upload(file.getInputStream(), fullPath, fileName);
			resultMap.put("result", "success");
			resultMap.put("filePath", fullPath + fileName);
			log.info("上传文件成功");
		} catch (IOException e) {
			log.error("上传文件异常", e);
			resultMap.put("result", "error");
			resultMap.put("reason", "上传文件异常");
		}
		return resultMap;
	}

	@RequestMapping(value = "/file/deleteFile.do", method = { RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> deleteFile(HttpServletRequest request,
			String filePath) {
		Map<String, Object> resultMap = new HashMap<>();
		try {
			File file = new File(filePath);
			boolean deleteFlag = false;
			if (!file.exists()) {
				log.info("删除文件失败:" + filePath + "不存在！");
				resultMap.put("result", "error");
			} else {
				if (file.isFile()) {
					deleteFlag = FileUtil.deleteFile(filePath);
				}
			}
			if (deleteFlag) {
				resultMap.put("result", "success");
				log.info("文件删除成功");
			}
		} catch (Exception e) {
			log.error("文件删除异常: " + e.toString());
			resultMap.put("result", "error");
			resultMap.put("reason", "文件删除异常");
		}
		return resultMap;
	}

	/**
	 * 获取文章统计数
	 * 
	 * Author:liudiwei Date:2017年12月29日
	 * 
	 * @param queryType
	 * @return
	 * @since
	 */
	@RequestMapping(value = "/article/getArticleCountStatByParam.do", method = { RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> getArticleCountStatByParam(String queryType) {
		Map<String, Object> resultMap = new HashMap<>();
		try {
			List<ArticleCountStatVo> articleCountStat = articleInfoService
					.getArticleCountByParam(queryType);
			resultMap.put("result", "success");
			resultMap.put("articleCountStat", articleCountStat);
		} catch (Exception e) {
			log.error("获取文章数量统计失败" + e.toString());
			resultMap.put("result", "error");
		}
		return resultMap;
	}

	/**
	 * 读取md文件内容
	 * 
	 * Author:liudiwei Date:2017年12月29日
	 * 
	 * @param filePath
	 * @return
	 * @since
	 */
	@RequestMapping(value = "/file/loadContentByPath.do", method = RequestMethod.POST)
	@ResponseBody
	public ResultModel loadContentFromFile(String filePath) {
		ResultModel resultMap = new ResultModel();
		resultMap = FileUtil.loadContentByPath(filePath);
		return resultMap;
	}
}
