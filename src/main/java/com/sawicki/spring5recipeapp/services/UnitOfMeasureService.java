package com.sawicki.spring5recipeapp.services;

import com.sawicki.spring5recipeapp.commands.UnitOfMeasureCommand;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listAllUoms();

}
