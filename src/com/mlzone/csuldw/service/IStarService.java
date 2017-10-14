package com.mlzone.csuldw.service;

import com.mlzone.csuldw.entity.StarEntity;

public interface IStarService {
	
    int deleteStar(Integer id);
    
    int saveStar(StarEntity starEntity);

    int countStarByCommentId(Integer commentId);

}
