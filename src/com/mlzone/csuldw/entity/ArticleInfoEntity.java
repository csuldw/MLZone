package com.mlzone.csuldw.entity;

/**
 * 
 * Date: 2017年10月14日 下午11:00:59 
 * 
 * @author liudiwei 
 * @version  
 * @since JDK 1.7
 */
public class ArticleInfoEntity {
    private Integer id;

    private String title;

    private String filePath;
    
    private String imagePath;

    private Integer userId;
    
    private String author;

    private String keywords;

    private String tags;

    private Integer postType;

    private Integer categoryId;
    
    private String publicDate;
    
    private Integer isPublish;
    
    private UserEntity userEntity;
    
    private ArticleCategoryEntity articleCategoryEntity;
    
    private Integer commentCount;
    
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

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    public Integer getPostType() {
        return postType;
    }

    public void setPostType(Integer postType) {
        this.postType = postType;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(String publicDate) {
        this.publicDate = publicDate == null ? null : publicDate.trim();
    }

	public Integer getIsPublish() {
		return isPublish;
	}

	public void setIsPublish(Integer isPublish) {
		this.isPublish = isPublish;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public ArticleCategoryEntity getArticleCategoryEntity() {
		return articleCategoryEntity;
	}

	public void setArticleCategoryEntity(ArticleCategoryEntity articleCategoryEntity) {
		this.articleCategoryEntity = articleCategoryEntity;
	}

	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	@Override
	public String toString() {
		return "ArticleInfoEntity [id=" + id + ", title=" + title
				+ ", filePath=" + filePath + ", userId=" + userId + ", author="
				+ author + ", keywords=" + keywords + ", tags=" + tags
				+ ", postType=" + postType + ", categoryId=" + categoryId
				+ ", publicDate=" + publicDate + ", isPublish=" + isPublish
				+ ", userEntity=" + userEntity + ", articleCategoryEntity="
				+ articleCategoryEntity + "]";
	}
}