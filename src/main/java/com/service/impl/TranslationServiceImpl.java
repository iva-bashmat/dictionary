package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Translation;
import com.repository.TranslationRepository;
import com.service.TranslationService;

@Service
public class TranslationServiceImpl implements TranslationService {

    @Autowired
    private TranslationRepository translationRepository;

    @Override
    public List<Translation> getTranslations(String name) {
        // TODO Auto-generated method stub
        return null;
    }

}
