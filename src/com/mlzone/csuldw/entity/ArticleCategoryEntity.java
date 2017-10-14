package com.mlzone.csuldw.entity;

/**
 * 
 * Date: 2017年10月14日 下午11:00:56 
 * 
 * @author liudiwei 
 * @version  
 * @since JDK 1.7
 */
public class ArticleCategoryEntity {
    private Integer id;

    private String categoryName;

    private Integer parentId;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}