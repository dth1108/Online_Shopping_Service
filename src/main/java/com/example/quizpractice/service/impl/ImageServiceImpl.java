package com.example.quizpractice.service.impl;

import com.example.quizpractice.domain.Image;
import com.example.quizpractice.repository.ImageRepository;
import com.example.quizpractice.service.ImageService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.RequestScope;

/**
 * Service Implementation for managing {@link Image}.
 */
@Service
@Transactional
@RequestScope
public class ImageServiceImpl implements ImageService {

    private final Logger log = LoggerFactory.getLogger(ImageServiceImpl.class);

    private final ImageRepository imageRepository;

    private final FileServiceImpl fileServiceImpl;

    public ImageServiceImpl(ImageRepository imageRepository, FileServiceImpl fileServiceImpl) {
        this.imageRepository = imageRepository;
        this.fileServiceImpl = fileServiceImpl;
    }

    @Override
    public Image save(Image image) {
//        fileServiceImpl.writeFile("aaaa","sssss");
        log.debug("Request to save Image : {}", image);
        return imageRepository.save(image);
    }

    @Override
    public Image update(Image image) {
        log.debug("Request to update Image : {}", image);
        return imageRepository.save(image);
    }

    @Override
    public Optional<Image> partialUpdate(Image image) {
        log.debug("Request to partially update Image : {}", image);

        return imageRepository
            .findById(image.getId())
            .map(existingImage -> {
                if (image.getContentBase64() != null) {
                    existingImage.setContentBase64(image.getContentBase64());
                }

                return existingImage;
            })
            .map(imageRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Image> findAll(Pageable pageable) {
        log.debug("Request to get all Images");
        return imageRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Image> findOne(String id) {
        log.debug("Request to get Image : {}", id);
        return imageRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        log.debug("Request to delete Image : {}", id);
        imageRepository.deleteById(id);
    }
}
