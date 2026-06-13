package com.mclods.online_learning_platform.services.impl;

import com.mclods.online_learning_platform.entities.Tag;
import com.mclods.online_learning_platform.repositories.TagRepository;
import com.mclods.online_learning_platform.services.TagService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public Tag createTag(@Valid Tag tag) {
        tag.setId(null);

        Tag savedTag = tagRepository.save(tag);
        log.info("Tag created with id {}", savedTag.getId());

        return savedTag;
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

    @Override
    public void deleteAllTags() {
        tagRepository.deleteAll();
        log.info("All tags deleted");
    }
}
