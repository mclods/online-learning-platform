package com.mclods.online_learning_platform.services;

import com.mclods.online_learning_platform.exceptions.EntityDoesNotExistException;

public interface DataService {
    void createDummyData() throws EntityDoesNotExistException;
}
