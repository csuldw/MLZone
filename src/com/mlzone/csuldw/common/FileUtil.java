package com.mlzone.csuldw.common;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

public class FileUtil
{
	private static Logger log = Logger.getLogger(FileUtil.class);
	
	public static ResultModel loadContentByPath(String path)
	{
		ResultModel result = new ResultModel();
		StringBuffer buffer = null;
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));  
			buffer = new StringBuffer();
			String line = "";
			while ((line = br.readLine()) != null)
			{
				buffer.append(line + "\r\n");
			}
			br.close();
			result.setCode(1000);
			result.setData(buffer.toString());
		} 
		catch (FileNotFoundException e)
		{
			result.setCode(3001);
			log.error("文件不存在: " + e.toString());
		} 
		catch (IOException e)
		{
			result.setCode(3002);
			log.error("IO异常: " + e.toString());
		}
		return result;
	}

}
