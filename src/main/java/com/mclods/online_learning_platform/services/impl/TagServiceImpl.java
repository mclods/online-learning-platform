package com.mclods.online_learning_platform.services.impl;

import com.mclods.online_learning_platform.entities.Tag;
import com.mclods.online_learning_platform.repositories.TagRepository;
import com.mclods.online_learning_platform.services.TagService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public Tag createTag(@Valid Tag tag) {
        tag.setId(null);

        return tagRepository.save(tag);
    }

    @Override
    public List<Tag> createTags(List<Tag> tags) {
        return tags.stream().map(this::createTag).toList();
    }

    @Override
    public List<Tag> findAllTags() {
        List<Tag> tags = new ArrayList<>();
        tagRepository.findAll().forEach(tags::add);

        return tags;
    }
}
