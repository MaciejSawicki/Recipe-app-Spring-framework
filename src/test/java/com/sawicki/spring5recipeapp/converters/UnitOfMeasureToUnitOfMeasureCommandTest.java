package com.sawicki.spring5recipeapp.converters;

import com.sawicki.spring5recipeapp.commands.UnitOfMeasureCommand;
import com.sawicki.spring5recipeapp.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitOfMeasureToUnitOfMeasureCommandTest {

    public static final Long ID_VALUE = 1L;
    public static final String DESCRIPTION = "UOM Description";

    UnitOfMeasureToUnitOfMeasureCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasureToUnitOfMeasureCommand();
    }

    @Test
    public void testNull() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testNullObject() {
        assertNotNull(converter.convert(new UnitOfMeasure()));
    }

    @Test
    public void convert() {

        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(ID_VALUE);
        unitOfMeasure.setDescription(DESCRIPTION);

        UnitOfMeasureCommand uomCommand = converter.convert(unitOfMeasure);

        assertNotNull(uomCommand);
        assertEquals(ID_VALUE, uomCommand.getId());
        assertEquals(DESCRIPTION, uomCommand.getDescription());

    }
}