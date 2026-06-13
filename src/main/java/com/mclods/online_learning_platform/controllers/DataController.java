package com.mclods.online_learning_platform.controllers;

import com.mclods.online_learning_platform.exceptions.EntityDoesNotExistException;
import com.mclods.online_learning_platform.services.DataService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/data")
public class DataController {
    private final DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @PutMapping("/create-dummy")
    @ResponseStatus(HttpStatus.CREATED)
    public void createDummyData() throws EntityDoesNotExistException {
        dataService.createDummyData();
    }

    @DeleteMapping("/delete-dummy")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDummyData() {
        dataService.deleteDummyData();
    }
}
