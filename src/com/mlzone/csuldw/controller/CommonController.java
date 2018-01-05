package com.mlzone.csuldw.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommonController {
	
	private static Logger logger = Logger.getLogger(CommonController.class);

    @RequestMapping(value = "/commom/viewFile.do")  
    @ResponseBody  
    public String viewFile(HttpServletRequest request, HttpServletResponse response, Model model, String filePath) {  
        // response.setContentType("image/*");  
        FileInputStream fis = null;  
        OutputStream os = null;  
        try {  
            fis = new FileInputStream(filePath);  
            os = response.getOutputStream();  
            int count = 0;  
            byte[] buffer = new byte[1024 * 8];  
            while ((count = fis.read(buffer)) != -1) {  
                os.write(buffer, 0, count);  
                os.flush();  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        try {  
            fis.close();  
            os.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return "ok";  
    }  
}
