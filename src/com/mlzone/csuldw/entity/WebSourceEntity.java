package com.mlzone.csuldw.entity;

/**
 * 
 * Date: 2018年1月4日 上午12:41:41 
 * 
 * @author liudiwei 
 * @version  
 * @since JDK 1.7
 */
public class WebSourceEntity {
    private Integer id;

    private String name;

    private String url;

    private String sourceType;

    private String author;

    private String desc;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}