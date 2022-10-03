package com.example.quizpractice.service.impl;

import com.example.quizpractice.domain.Blog;
import com.example.quizpractice.domain.Image;
import com.example.quizpractice.dto.BlogDTO;
import com.example.quizpractice.dto.IBlogDTO;
import com.example.quizpractice.repository.BlogRepository;
import com.example.quizpractice.repository.ImageRepository;
import com.example.quizpractice.repository.UserRepository;
import com.example.quizpractice.service.BlogService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;
import javax.sql.rowset.serial.SerialBlob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.RequestScope;

/**
 * Service Implementation for managing {@link Blog}.
 */
@Service
@Transactional
@RequestScope
public class BlogServiceImpl implements BlogService {

    private final Logger log = LoggerFactory.getLogger(BlogServiceImpl.class);

    private final BlogRepository blogRepository;
    private final UserRepository userRepository;

    private final ImageRepository imageRepository;

    public BlogServiceImpl(BlogRepository blogRepository, UserRepository userRepository,
            ImageRepository imageRepository) {
        this.blogRepository = blogRepository;
        this.userRepository = userRepository;
        this.imageRepository = imageRepository;
    }

    @Override
    public Blog save(BlogDTO blogDTO) throws SQLException {
//        Image image = new Image();
//        UUID uuid = UUID.randomUUID();
//        System.out.println(blogDTO.getImageBase64());
//        image.id(uuid.toString());
//        image.contentBase64(uuid.toString());
//        imageRepository.save(image);
//
//        Blog blog = new Blog();
//        String authorID = userRepository.findByUsername(
//                SecurityContextHolder.getContext().getAuthentication().getName()).get().getId();
//        blog.authorID(authorID).title(blogDTO.getTitle()).contentText(blogDTO.getContentText())
//                .imageID(uuid.toString());
//        return blogRepository.save(blog);
//        File file = new File("write.txt");
//
//        try (Writer writer = new BufferedWriter(new FileWriter(file))) {
//            String contents = "The quick brown fox" +
//                    System.getProperty("line.separator") + "jumps over the lazy dog.";
//
//            writer.write(contents);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        String authorID = userRepository.findByUsername(
                SecurityContextHolder.getContext().getAuthentication().getName()).get().getId();
        Blog blog = new Blog();
        blog.title(blogDTO.getTitle()).contentText(blogDTO.getContentText()).imageID("")
                .authorID(authorID);
        return blogRepository.save(blog);
    }


    @Override
    public Blog update(Blog blog) {
        log.debug("Request to update Blog : {}", blog);
        return blogRepository.save(blog);
    }

    @Override
    public Optional<Blog> partialUpdate(Blog blog) {
        log.debug("Request to partially update Blog : {}", blog);

        return blogRepository
                .findById(blog.getId())
                .map(existingBlog -> {
                    if (blog.getTitle() != null) {
                        existingBlog.setTitle(blog.getTitle());
                    }
                    if (blog.getAuthorID() != null) {
                        existingBlog.setAuthorID(blog.getAuthorID());
                    }
                    if (blog.getContentText() != null) {
                        existingBlog.setContentText(blog.getContentText());
                    }
                    if (blog.getImageID() != null) {
                        existingBlog.setImageID(blog.getImageID());
                    }

                    return existingBlog;
                })
                .map(blogRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Blog> findAll(Pageable pageable) {
        log.debug("Request to get all Blogs");
        return blogRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Blog> findOne(String id) {
        log.debug("Request to get Blog : {}", id);
        return blogRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        log.debug("Request to delete Blog : {}", id);
        blogRepository.deleteById(id);
    }
}
