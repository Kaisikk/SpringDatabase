package com.kaisikk.java.springdatabase.repo;

import com.kaisikk.java.springdatabase.model.LanguageMongo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageMongoRepo extends CrudRepository<LanguageMongo, String> {
}
