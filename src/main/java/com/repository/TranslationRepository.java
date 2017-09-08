package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Translation;

public interface TranslationRepository  extends JpaRepository<Translation, Integer> {

	Translation findByNameIgnoreCase(String name);
	
}
