package com.mlzone.csuldw.common;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class FileUploadUtil
{
	public static void upload(InputStream is, String picSavePath, String fileName) throws IOException
	{

		BufferedInputStream bis = null;
		BufferedOutputStream bio = null;
		try
		{
			File picSaveFolder = new File(picSavePath);

			if (!picSaveFolder.exists())
			{
				picSaveFolder.mkdirs();
			}

			File saveFile = new File(picSaveFolder, fileName);
			if (saveFile.exists())
			{
				saveFile.delete();
			}
			picSaveFolder.createNewFile();

			bis = new BufferedInputStream(is);

			bio = new BufferedOutputStream(new FileOutputStream(saveFile));

			byte[] bt = new byte[1024];
			int len = -1;
			while ((len = bis.read(bt)) != -1)
			{
				bio.write(bt, 0, len);
				bio.flush();
			}
		} finally
		{
			if (is != null)
			{
				try
				{
					is.close();
				} catch (Exception e)
				{
					e.printStackTrace();
				}
				is = null;
			}

			if (bis != null)
			{
				try
				{
					bis.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
				bis = null;
			}

			if (bio != null)
			{
				try
				{
					bio.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
				bio = null;
			}
		}
	}

	public static boolean delete(File file)
	{
		if (file.exists() && file.isFile())
		{
			file.delete();
			return true;
		}

		return false;
	}

	public static boolean delete(String filePath)
	{
		File file = new File(filePath);
		return delete(file);
	}

	public static boolean delete(String fileFolder, String fileName)
	{
		File file = new File(fileFolder, fileName);
		return delete(file);
	}

	public static boolean copy(File in, File out) throws IOException
	{

		BufferedInputStream bis = null;
		BufferedOutputStream bio = null;
		try
		{
			if (!in.exists())
			{
				return false;
			}

			if (!out.exists())
			{
				out.createNewFile();
			}

			bis = new BufferedInputStream(new FileInputStream(in));
			bio = new BufferedOutputStream(new FileOutputStream(out));

			byte[] bt = new byte[1024];
			int len = -1;
			while ((len = bis.read(bt)) != -1)
			{
				bio.write(bt, 0, len);
				bio.flush();
			}

			return true;
		} finally
		{
			if (bis != null)
			{
				try
				{
					bis.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
				bis = null;
			}

			if (bio != null)
			{
				try
				{
					bio.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
				bio = null;
			}
		}
	}

	public static boolean copy(String srcFolder, String srcFileName, String descFolder, String descFileName)
			throws IOException
	{
		File srcFile = new File(srcFolder, srcFileName);
		if (!srcFile.exists())
		{
			return false;
		}

		File descFolderFile = new File(descFolder);
		if (!descFolderFile.exists())
		{
			descFolderFile.mkdirs();
		}

		File descFile = new File(descFolderFile, descFileName);
		if (!descFile.exists())
		{
			descFile.createNewFile();
		}

		return copy(srcFile, descFile);
	}

	public static boolean deleteDir(File dir)
	{
		if (dir.isDirectory())
		{
			String[] children = dir.list();
			// 递归删除目录中的子目录下
			for (int i = 0; i < children.length; i++)
			{
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success)
				{
					return false;
				}
			}
		}
		// 目录此时为空，可以删除
		return dir.delete();
	}

	public static void checkFileExists(String folder, String filePath) throws IOException
	{
		File files = new File(folder);
		File file = new File(filePath);
		if (!files.exists() && !files.isDirectory())
		{
			files.mkdirs();
		}
		if (!file.exists())
		{
			file.createNewFile();
		}
	}

	public static void writeLog(String content, String folder, String filePath)
	{

		File files = new File(folder);
		File file = new File(filePath);
		try
		{
			checkFileExists(files, file);
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			System.out.println(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void checkFileExists(File files, File file) throws IOException
	{
		if (!files.exists() && !files.isDirectory())
		{
			files.mkdirs();
		}
		if (!file.exists())
		{
			file.createNewFile();
		}
	}

}
