package com.usjt.beehealthy.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.usjt.beehealthy.model.Articles;

public interface ArticlesRepository extends JpaRepository<Articles, Long>{

}
