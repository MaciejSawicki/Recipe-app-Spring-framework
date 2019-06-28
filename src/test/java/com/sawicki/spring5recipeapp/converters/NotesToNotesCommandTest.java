package com.sawicki.spring5recipeapp.converters;

import com.sawicki.spring5recipeapp.commands.NotesCommand;
import com.sawicki.spring5recipeapp.domain.Notes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotesToNotesCommandTest {

    public static final  Long ID_VALUE = 1L;
    public static final String RECIPE_NOTES = "Notes";

    NotesToNotesCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new NotesToNotesCommand();
    }

    @Test
    public void testNull() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testNullObject(){
        assertNotNull(converter.convert(new Notes()));
    }

    @Test
    public void convert() {
        Notes notes = new Notes();
        notes.setId(ID_VALUE);
        notes.setRecipeNotes(RECIPE_NOTES);

        NotesCommand notesCommand = converter.convert(notes);

        //then
        assertNotNull(notes);
        assertEquals(ID_VALUE, notesCommand.getId());
        assertEquals(RECIPE_NOTES, notesCommand.getRecipeNotes());
    }
}