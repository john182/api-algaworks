package com.chronos.money.api.repository;

import com.chronos.money.api.model.Categoria;
import com.chronos.money.api.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by john on 19/10/17.
 */
public interface PostRepository extends JpaRepository<Post,Long> {




}
