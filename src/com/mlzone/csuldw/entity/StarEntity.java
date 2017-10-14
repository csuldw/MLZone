package com.mlzone.csuldw.entity;

/**
 * 
 * Date: 2017年10月14日 下午11:01:12 
 * 
 * @author liudiwei 
 * @version  
 * @since JDK 1.7
 */
public class StarEntity {
    private Integer id;

    private Integer fromUserId;

    private Integer toUserId;

    private Integer commentId;

    private String starDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getStarDate() {
        return starDate;
    }

    public void setStarDate(String starDate) {
        this.starDate = starDate == null ? null : starDate.trim();
    }
}