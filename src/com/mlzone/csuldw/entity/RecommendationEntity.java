package com.mlzone.csuldw.entity;

/**
 * 
 * Date: 2017年10月14日 下午11:01:07 
 * 
 * @author liudiwei 
 * @version  
 * @since JDK 1.7
 */
public class RecommendationEntity {
    private Integer id;

    private String title;

    private String link;

    private String source;

    private String author;

    private Integer recommendationType;

    private Integer categoryId;

    private String recommendDate;
    
    private ArticleCategoryEntity articleCategoryEntity; 

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Integer getRecommendationType() {
        return recommendationType;
    }

    public void setRecommendationType(Integer recommendationType) {
        this.recommendationType = recommendationType;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getRecommendDate() {
        return recommendDate;
    }

    public void setRecommendDate(String recommendDate) {
        this.recommendDate = recommendDate == null ? null : recommendDate.trim();
    }

	public ArticleCategoryEntity getArticleCategoryEntity() {
		return articleCategoryEntity;
	}

	public void setArticleCategoryEntity(ArticleCategoryEntity articleCategoryEntity) {
		this.articleCategoryEntity = articleCategoryEntity;
	}
}