package com.kaisikk.java.springdatabase.repo;

import com.kaisikk.java.springdatabase.model.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepo extends CrudRepository<Image, Long> {
}
