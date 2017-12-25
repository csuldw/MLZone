package com.mlzone.csuldw.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Properties;

import org.apache.log4j.Logger;

public final class PropertyUtil
{
    private final Logger log = Logger.getLogger(this.getClass());
    
    private Properties properties = null;

    private final static String SYSTEM_PROPERTY = "system"; 
    
    public PropertyUtil()
    {
        this(SYSTEM_PROPERTY);
    }

    public PropertyUtil(String key)
    {
    	InputStream instream = null;
        try
        {
            String filePath = this.getClassPath() + "config/" + key + ".properties";
            
            if (null != filePath && !"".equals(filePath))
            {
                File file = new File(filePath);
                if (file.exists())
                {
                     instream = new FileInputStream(filePath);
                    this.properties = new Properties();

                    properties.load(instream);
                }
                else
                {
                    log.info("属性文件不存在! filePath = " + filePath);
                }
            }
            else
            {
                log.info("属性文件路径为空!");
            }
        }
        catch (IOException e)
        {
        	log.error(e.toString());;
        }finally{
        	if(instream != null){
        		try {
					instream.close();
					instream = null;
				} catch (IOException e) {
				}
        	}
        }
    }

    /**
     * 获得ClassPath的路径.
     * @return String 路径字符串
     * @throws IOException 
     */
    private String getClassPath() throws IOException
    {
        URL url = this.getClass().getResource("/");
        return URLDecoder.decode(url.getPath(), "UTF-8");
    }

    /**
     * 获得key对应的value值.
     * @param key
     * @return String 消息的key所对应的value
     */
    public String getMsg(String key)
    {
        if (null != properties)
        {
            return properties.getProperty(key);
        }
        return null;
    }
}
