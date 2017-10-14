package com.mlzone.csuldw.service;

import com.mlzone.csuldw.entity.StarEntity;

public interface IStarService {
	
    int saveStar(StarEntity starEntity);

    int deleteStarById(Integer id);

    int countStarByCommentId(Integer commentId);

}
