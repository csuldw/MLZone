package com.mlzone.csuldw.common;

/**
 * 返回结果类
 * @author liudiwei
 *
 */
public class ResultModel
{
	private Integer code;
	private String data;
	private String msg;
	
	private PropertyUtil pt = PropertyUtil.getInstance("result");
	
	public String getMsg()
	{
		return msg;
	}
	public void setMsg(String msg)
	{
		this.msg = msg;		
	}
	public Integer getCode()
	{
		return code;
	}
	public void setCode(Integer code)
	{
		this.code = code;
		this.setMsg(pt.getMsg(code.toString()));
	}
	public String getData()
	{
		return data;
	}
	public void setData(String data)
	{
		this.data = data;
	}
}
