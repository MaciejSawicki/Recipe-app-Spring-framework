package com.sawicki.spring5recipeapp.converters;

import com.sawicki.spring5recipeapp.commands.CategoryCommand;
import com.sawicki.spring5recipeapp.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryToCategoryCommandTest {

    public static final Long ID_VALUE = new Long(1L);
    public static final String DESCRIPTION = "description";

    CategoryToCategoryCommand converter;

    @Before
    public void setUp() throws Exception {

        converter = new CategoryToCategoryCommand();

    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(converter.convert(new Category()));
    }

    @Test
    public void convert() {

        Category category = new Category();
        category.setId(ID_VALUE);
        category.setDescription(DESCRIPTION);

        CategoryCommand categoryCommand = converter.convert(category);

        assertEquals(ID_VALUE, categoryCommand.getId());
        assertEquals(DESCRIPTION, categoryCommand.getDescription());
    }
}