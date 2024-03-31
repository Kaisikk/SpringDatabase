package com.kaisikk.java.springdatabase.repo;

import com.kaisikk.java.springdatabase.model.LanguageMySQL;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageMySQLRepo extends CrudRepository<LanguageMySQL, Long> {
}
