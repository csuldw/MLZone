package com.mlzone.csuldw.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

public class FileUtil {
	private static Logger log = Logger.getLogger(FileUtil.class);

	public static ResultModel loadContentByPath(String path) {
		ResultModel result = new ResultModel();
		StringBuffer buffer = null;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(path), "UTF-8"));
			buffer = new StringBuffer();
			String line = "";
			while ((line = br.readLine()) != null) {
				buffer.append(line + "\r\n");
			}
			br.close();
			result.setCode(1000);
			result.setData(buffer.toString());
		} catch (FileNotFoundException e) {
			result.setCode(3001);
			log.error("文件不存在: " + e.toString());
		} catch (IOException e) {
			result.setCode(3002);
			log.error("IO异常: " + e.toString());
		}
		return result;
	}

	/**
	 * 删除单个文件
	 * 
	 * @param fileName
	 *            要删除的文件的文件名
	 * @return 单个文件删除成功返回true，否则返回false
	 */
	public static boolean deleteFile(String fileName) {
		File file = new File(fileName);
		// 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
		if (file.exists() && file.isFile()) {
			if (file.delete()) {
				log.info("删除单个文件" + fileName + "成功！");
				return true;
			} else {
				log.info("删除单个文件" + fileName + "失败！");
				return false;
			}
		} else {
			log.info("删除单个文件失败：" + fileName + "不存在！");
			return false;
		}
	}
}
