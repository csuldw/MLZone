package com.mlzone.csuldw.entity;

import java.util.List;

/**
 * 
 * Date: 2017年10月14日 下午11:01:03 
 * 
 * @author liudiwei 
 * @version  
 * @since JDK 1.7
 */
public class CommentEntity {
    private Integer id;

    private String content;

    private Integer fromUserId;

    private Integer toUserId;

    private Integer articleId;

    private Integer parentCommentId;

    private String sendDate;
    
    private UserEntity userEntityFrom;
    
    private UserEntity userEntityTo;
    
    private List<CommentEntity> subCommentEntity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Integer fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Integer getToUserId() {
        return toUserId;
    }

    public void setToUserId(Integer toUserId) {
        this.toUserId = toUserId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(Integer parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate == null ? null : sendDate.trim();
    }

	public UserEntity getUserEntityFrom() {
		return userEntityFrom;
	}

	public void setUserEntityFrom(UserEntity userEntityFrom) {
		this.userEntityFrom = userEntityFrom;
	}

	public UserEntity getUserEntityTo() {
		return userEntityTo;
	}

	public void setUserEntityTo(UserEntity userEntityTo) {
		this.userEntityTo = userEntityTo;
	}

	public List<CommentEntity> getSubCommentEntity() {
		return subCommentEntity;
	}

	public void setSubCommentEntity(List<CommentEntity> subCommentEntity) {
		this.subCommentEntity = subCommentEntity;
	}
}