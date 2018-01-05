package com.mlzone.csuldw.common;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	/**
	 * 检查文件是否存在
	 *
	 * Author:liudiwei
	 * Date:2017年12月30日
	 * @param filePath
	 * @return
	 * @since
	 */
	public static boolean checkFileExist(String filePath) {
		boolean isExist = false;
		File saveFile = new File(filePath);
		if (saveFile.exists()) {
			isExist = true;
		}
		return isExist;
	}
	
	/**
	 * 检查文件是否存在 
	 *
	 * Author:liudiwei
	 * Date:2017年12月30日
	 * @param parentDir
	 * @param fileName
	 * @return
	 * @since
	 */
	public static boolean checkFileExist(String parentDir, String fileName) {
		boolean isExist = false;
		File saveFile = new File(parentDir, fileName);
		if (saveFile.exists()) {
			isExist = true;
		}
		return isExist;
	}

	public static void upload(InputStream is, String picSavePath, String fileName) throws IOException {

		BufferedInputStream bis = null;
		BufferedOutputStream bio = null;
		try {
			File picSaveFolder = new File(picSavePath);

			if (!picSaveFolder.exists()) {
				picSaveFolder.mkdirs();
			}

			File saveFile = new File(picSaveFolder, fileName);
			if (saveFile.exists()) {
				saveFile.delete();
			}
			picSaveFolder.createNewFile();

			bis = new BufferedInputStream(is);

			bio = new BufferedOutputStream(new FileOutputStream(saveFile));

			byte[] bt = new byte[1024];
			int len = -1;
			while ((len = bis.read(bt)) != -1) {
				bio.write(bt, 0, len);
				bio.flush();
			}
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				is = null;
			}

			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				bis = null;
			}

			if (bio != null) {
				try {
					bio.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				bio = null;
			}
		}
	}

	public static boolean delete(File file) {
		if (file.exists() && file.isFile()) {
			file.delete();
			return true;
		}

		return false;
	}

	public static boolean delete(String filePath) {
		File file = new File(filePath);
		return delete(file);
	}

	public static boolean delete(String fileFolder, String fileName) {
		File file = new File(fileFolder, fileName);
		return delete(file);
	}

	public static boolean copy(File in, File out) throws IOException {

		BufferedInputStream bis = null;
		BufferedOutputStream bio = null;
		try {
			if (!in.exists()) {
				return false;
			}

			if (!out.exists()) {
				out.createNewFile();
			}

			bis = new BufferedInputStream(new FileInputStream(in));
			bio = new BufferedOutputStream(new FileOutputStream(out));

			byte[] bt = new byte[1024];
			int len = -1;
			while ((len = bis.read(bt)) != -1) {
				bio.write(bt, 0, len);
				bio.flush();
			}

			return true;
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				bis = null;
			}

			if (bio != null) {
				try {
					bio.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				bio = null;
			}
		}
	}

	public static boolean copy(String srcFolder, String srcFileName,
			String descFolder, String descFileName) throws IOException {
		File srcFile = new File(srcFolder, srcFileName);
		if (!srcFile.exists()) {
			return false;
		}

		File descFolderFile = new File(descFolder);
		if (!descFolderFile.exists()) {
			descFolderFile.mkdirs();
		}

		File descFile = new File(descFolderFile, descFileName);
		if (!descFile.exists()) {
			descFile.createNewFile();
		}

		return copy(srcFile, descFile);
	}

	public static boolean deleteDir(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			// 递归删除目录中的子目录下
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success) {
					return false;
				}
			}
		}
		// 目录此时为空，可以删除
		return dir.delete();
	}

	public static void checkFileExists(String folder, String filePath)
			throws IOException {
		File files = new File(folder);
		File file = new File(filePath);
		if (!files.exists() && !files.isDirectory()) {
			files.mkdirs();
		}
		if (!file.exists()) {
			file.createNewFile();
		}
	}

	public static void writeLog(String content, String folder, String filePath) {

		File files = new File(folder);
		File file = new File(filePath);
		try {
			checkFileExists(files, file);
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			System.out.println(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void checkFileExists(File files, File file)
			throws IOException {
		if (!files.exists() && !files.isDirectory()) {
			files.mkdirs();
		}
		if (!file.exists()) {
			file.createNewFile();
		}
	}
	
	/**
	 * 去除空格
	 * 
	 * @author liudiwei
	 * @since 2018年1月5日 
	 * @param str
	 * @return
	 */
	public static String replaceBlank(String str) {  
        String dest = "";  
        if (str!=null) {  
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");  
            Matcher m = p.matcher(str);  
            dest = m.replaceAll("");  
        }  
        return dest;  
    }  
	
	/**
	 * 生成摘要
	 * 
	 * @author liudiwei
	 * @since 2018年1月5日 
	 * @param filePath
	 * @return
	 */
	public static String generateAbstract(String filePath){
		ResultModel result = loadContentByPath(filePath);
		if(result.getCode() == 1000){
			String [] arr = result.getData().toString().split("<!-- more -->");
			String content = replaceBlank(arr[0]);
			if(arr.length > 1){
				return content;
			}
			int len = content.length() > 200 ? 200 : content.length() ;
			return content.substring(0, len);
		}
		return null;
	}
}
