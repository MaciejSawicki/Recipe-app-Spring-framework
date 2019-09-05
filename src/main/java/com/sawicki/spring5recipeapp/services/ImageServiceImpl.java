package com.sawicki.spring5recipeapp.services;

import com.sawicki.spring5recipeapp.domain.Recipe;
import com.sawicki.spring5recipeapp.repositories.RecipeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;

@Service
public class ImageServiceImpl implements ImageService {

    private final RecipeRepository recipeRepository;

    public ImageServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    @Transactional
    public void saveImageFile(Long recipeId, MultipartFile file) {
        try {
            Recipe recipe = recipeRepository.findById(recipeId).get();

            Byte[] byteObject = new Byte[file.getBytes().length];

            int i = 0;

            for(byte b : file.getBytes()){
                byteObject[i++] = b;
            }

            recipe.setImage(byteObject);
            recipeRepository.save(recipe);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
