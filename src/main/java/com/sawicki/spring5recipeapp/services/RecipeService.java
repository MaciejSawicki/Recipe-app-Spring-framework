package com.sawicki.spring5recipeapp.services;

import com.sawicki.spring5recipeapp.commands.RecipeCommand;
import com.sawicki.spring5recipeapp.domain.Recipe;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
