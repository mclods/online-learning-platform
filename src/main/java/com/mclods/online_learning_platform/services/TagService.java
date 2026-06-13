package com.mclods.online_learning_platform.services;

import com.mclods.online_learning_platform.entities.Tag;

import java.util.List;

public interface TagService {
    Tag createTag(Tag tag);

    List<Tag> createTags(List<Tag> tags);

    List<Tag> findAllTags();

    void deleteAllTags();
}
