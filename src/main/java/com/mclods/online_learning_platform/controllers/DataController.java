package com.mclods.online_learning_platform.controllers;

import com.mclods.online_learning_platform.exceptions.EntityDoesNotExistException;
import com.mclods.online_learning_platform.services.DataService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class DataController {
    private final DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @PutMapping("/create-dummy")
    @ResponseStatus(HttpStatus.OK)
    public void createDummyData() throws EntityDoesNotExistException {
        dataService.createDummyData();
    }
}
