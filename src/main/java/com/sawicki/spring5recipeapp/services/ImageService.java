package com.sawicki.spring5recipeapp.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface ImageService {
    void saveImageFile(Long recipeId, MultipartFile file);
}
