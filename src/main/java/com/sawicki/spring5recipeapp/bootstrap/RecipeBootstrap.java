package com.sawicki.spring5recipeapp.bootstrap;

import com.sawicki.spring5recipeapp.domain.*;
import com.sawicki.spring5recipeapp.repositories.CategoryRepository;
import com.sawicki.spring5recipeapp.repositories.RecipeRepository;
import com.sawicki.spring5recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes(){
        List<Recipe> recipes = new ArrayList<>(2);

        Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");

        if(!eachUomOptional.isPresent()){
            throw new RuntimeException("Expeted UOM Not Found");
        }

        Optional<UnitOfMeasure> tableSpoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");

        if(!tableSpoonUomOptional.isPresent()){
            throw new RuntimeException("Expeted UOM Not Found");
        }

        Optional<UnitOfMeasure> teaSpoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        if(!teaSpoonUomOptional.isPresent()){
            throw new RuntimeException("Expeted UOM Not Found");
        }

        Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");

        if(!dashUomOptional.isPresent()){
            throw new RuntimeException("Expeted UOM Not Found");
        }

        Optional<UnitOfMeasure> pintUomOptional = unitOfMeasureRepository.findByDescription("Pint");

        if(!pintUomOptional.isPresent()){
            throw new RuntimeException("Expeted UOM Not Found");
        }

        Optional<UnitOfMeasure> cupsUomOptional = unitOfMeasureRepository.findByDescription("Cup");

        if(!cupsUomOptional.isPresent()){
            throw new RuntimeException("Expeted UOM Not Found");
        }

        UnitOfMeasure eachUom = eachUomOptional.get();
        UnitOfMeasure tableSpoonUom = tableSpoonUomOptional.get();
        UnitOfMeasure teaSpoonUom = tableSpoonUomOptional.get();
        UnitOfMeasure dashUom = dashUomOptional.get();
        UnitOfMeasure pintUom = pintUomOptional.get();
        UnitOfMeasure cupUom = cupsUomOptional.get();

        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");

        if(!americanCategoryOptional.isPresent()){
            throw new RuntimeException("Expeted Category Not Found");
        }

        Optional<Category> polishCategoryOptional = categoryRepository.findByDescription("Polish");

        if(!polishCategoryOptional.isPresent()){
            throw new RuntimeException("Expeted Category Not Found");
        }

        Category americanCategory = americanCategoryOptional.get();
        Category polishCategory = polishCategoryOptional.get();

        Recipe pierogiRecipe = new Recipe();
        pierogiRecipe.setDescription("Perfect Polish Pierogi");
        pierogiRecipe.setPrepTime(60);
        pierogiRecipe.setCookTime(10);
        pierogiRecipe.setDifficulty(Difficulty.MODERATE);
        pierogiRecipe.setDirections("1. In a large mixing bowl making the dough by combining flour, eggs, sour cream and water. Slowly beat in the eggs until dough is well combined. Turn the dough out onto a clean, lightly floured surface. Knead 3 to 5 minutes. Wrap in plastic wrap and rest 30 minutes.\n" +
                "2. In another large mixing bowl, stir together mashed potatoes, garlic powder, onion powder, salt, pepper, and cheese.\n" +
                "3. Bring a large pot of salted water to a boil. Meanwhile, pinch of tablespoon sized pieces of dough and roll into about three dozen balls. Roll each ball out on a lightly floured surface into a 3 1/2 to 5 inch circle. Cover with a damp towel or paper towel to prevent them from drying out.\n" +
                "4. Place a heaping tablespoon of potato filling into the center of each circle. Fold in half, pinching the sides shut with your fingers, or gently with a fork to seal. Working in small batches, boil in salted water 2 to 3 minutes, until they float. Remove and transfer to a paper towel lined plate to drain.\n" +
                "5. Melt 1/2 cup butter in a large skillet and saute pierogi until lightly browned. Serve hot topped with sour cream and garnish with chives");
        Notes pierogiNotes = new Notes();
        pierogiNotes.setRecipeNotes("The key to homemade pierogi is to be sure to seal it shut so that none of the stuffing comes out during cooking. Don’t let any of the filling get in between the dough edges or you won’t be able to get a good seal. Pinch the dough shut with your fingers and then press with the tongs of a fork to further seal and give a decorative edge.");

        pierogiRecipe.setNotes(pierogiNotes);

        pierogiRecipe.addIngredient(new Ingredient("all-purpose flour plus more for dusting", new BigDecimal(3), cupUom));
        pierogiRecipe.addIngredient(new Ingredient("large eggs", new BigDecimal(3), eachUom));
        pierogiRecipe.addIngredient(new Ingredient("sour cream", new BigDecimal(2), tableSpoonUom));
        pierogiRecipe.addIngredient(new Ingredient("water", new BigDecimal(0.75), cupUom));

        pierogiRecipe.getCategories().add(polishCategory);

        recipes.add(pierogiRecipe);

        Recipe burgerRecipe = new Recipe();
        burgerRecipe.setDescription("Double Cheeseburger");
        burgerRecipe.setPrepTime(30);
        burgerRecipe.setCookTime(40);
        burgerRecipe.setDifficulty(Difficulty.EASY);
        burgerRecipe.setDirections("1 In a small bowl, mix the mayonnaise with the sesame seeds.\n" +
                "2 Heat a large nonstick griddle or 2 nonstick skillets over moderate heat. Butter the cut sides of the hamburger buns and toast them on the griddle until golden, 4 to 5 minutes. Transfer to a platter.\n" +
                "3 Season the patties with salt and pepper. Brush the griddle with the olive oil, add the patties and cook over high heat for 2 minutes. Flip the patties and cook for 2 minutes longer, then top each one with a slice of cheddar cheese. Cook just until the cheese is melted, about 1 minute.\n" +
                "4 Stack 2 burgers on each bun. Top with the lettuce, shiso leaves, tomato and onion. Spread the top halves of the buns with the sesame mayo, close the burgers and serve.");

        Notes burgerNotes = new Notes();
        burgerNotes.setRecipeNotes("Roy Choi’s burgers look like the American classic, but get an Asian twist with toasted sesame seeds in the mayo and fresh shiso leaves on top of the lettuce.");

        burgerRecipe.setNotes(burgerNotes);

        burgerRecipe.addIngredient(new Ingredient("mayonnaise", new BigDecimal(0.3), cupUom));
        burgerRecipe.addIngredient(new Ingredient("toasted sesame seeds", new BigDecimal(1), tableSpoonUom));
        burgerRecipe.addIngredient(new Ingredient("unsalted butter, at room temperature", new BigDecimal(4), tableSpoonUom));
        burgerRecipe.addIngredient(new Ingredient("hamburger buns", new BigDecimal(4), eachUom));
        burgerRecipe.addIngredient(new Ingredient("ground chuck", new BigDecimal(2), dashUom));
        burgerRecipe.addIngredient(new Ingredient("olive oil", new BigDecimal(2), tableSpoonUom));
        burgerRecipe.addIngredient(new Ingredient("tomato", new BigDecimal(1), eachUom));

        burgerRecipe.getCategories().add(americanCategory);

        recipes.add(burgerRecipe);




        return recipes;
    }

}
