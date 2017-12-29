package com.mlzone.csuldw.common;

import com.github.pagehelper.StringUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

public class CorsFilter implements Filter
{
	Logger log  = Logger.getLogger(Filter.class);
	private String allowOrigin;
	private String allowMethods;
	private String allowCredentials;
	private String allowHeaders;
	private String exposeHeaders;
	private String maxAge;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
		allowOrigin = filterConfig.getInitParameter("allowOrigin");
		allowMethods = filterConfig.getInitParameter("allowMethods");
		allowCredentials = filterConfig.getInitParameter("allowCredentials");
		allowHeaders = filterConfig.getInitParameter("allowHeaders");
		exposeHeaders = filterConfig.getInitParameter("exposeHeaders");
		maxAge = filterConfig.getInitParameter("maxAge");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException
	{
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		if (StringUtil.isNotEmpty(allowOrigin))
		{
			if ("*".equals(allowOrigin.trim()))
			{
				response.setHeader("Access-Control-Allow-Origin", "*");
			} 
			else
			{
				List<String> allowOriginList = Arrays.asList(allowOrigin.split(","));
				if (null != allowOriginList && allowOriginList.size() > 0)
				{
					// 解决跨多个域名的问题
					String currentOrigin = request.getHeader("Origin");
					if (allowOriginList.contains(currentOrigin))
					{
						response.setHeader("Access-Control-Allow-Origin", currentOrigin);
					}
				}
			}
		}
		if (StringUtil.isNotEmpty(allowMethods))
		{
			response.setHeader("Access-Control-Allow-Methods", allowMethods);
		}
		if (StringUtil.isNotEmpty(allowCredentials))
		{
			response.setHeader("Access-Control-Allow-Credentials", allowCredentials);
		}
		//response.setHeader("Access-Control-Allow-Origin", "http://localhost:9009");
		if (StringUtil.isNotEmpty(allowHeaders))
		{
			response.setHeader("Access-Control-Allow-Headers", allowHeaders);
		}
		if (StringUtil.isNotEmpty(exposeHeaders))
		{
			response.setHeader("Access-Control-Expose-Headers", exposeHeaders);
		}
		if (StringUtil.isNotEmpty(maxAge))
		{
			response.setHeader("Access-Control-Max-Age", maxAge);
		}
		// chain.doFilter(req, res);
		Throwable problem = null;
		try
		{
			chain.doFilter(req, res);
		} catch (Throwable t)
		{
			problem = t;
			t.printStackTrace();
		}
		if (problem != null)
		{
			if (problem instanceof ServletException)
			{
				throw (ServletException) problem;
			}
			if (problem instanceof IOException)
			{
				throw (IOException) problem;
			}
			sendProcessingError(problem, response);
		}
	}

	private void sendProcessingError(Throwable t, ServletResponse response)
	{
		String stackTrace = getStackTrace(t);
		if (stackTrace != null && !stackTrace.equals(""))
		{
			try
			{
				response.setContentType("text/html");
				PrintStream ps = new PrintStream(response.getOutputStream());
				PrintWriter pw = new PrintWriter(ps);
				pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); // NOI18N
				pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");
				pw.print(stackTrace);
				pw.print("</pre></body>\n</html>"); // NOI18N
				pw.close();
				ps.close();
				response.getOutputStream().close();
			} catch (IOException e)
			{
			}
		}
	}

	private String getStackTrace(Throwable t)
	{
		String stackTrace = null;
		try
		{
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			t.printStackTrace(pw);
			pw.close();
			sw.close();
			stackTrace = sw.getBuffer().toString();
		} catch (Exception e)
		{

		}
		return stackTrace;
	}

	@Override
	public void destroy()
	{
	}
}
