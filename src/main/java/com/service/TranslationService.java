package com.service;

import java.util.List;

import com.entity.Translation;

public interface TranslationService {

    List<Translation> getTranslations(String name);
}
