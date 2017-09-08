package com.service.impl;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.controller.error.ApiException;
import com.controller.wrapper.WordRequest;
import com.entity.Translation;
import com.entity.Word;
import com.repository.TranslationRepository;
import com.repository.WordRepository;
import com.service.WordService;

@Service
public class WordServiceImpl implements WordService {

    @Autowired
    private TranslationRepository translationRepository;

    @Autowired
    private WordRepository wordRepository;

    @Override
    public Word addWord(WordRequest wordRequest) {
        Word word = wordRepository.findByNameIgnoreCase(wordRequest.getWord());
        if (word != null) {
            throw new ApiException(HttpStatus.CONFLICT, WordRequest.WORD_VALUE, wordRequest.getWord(),
                    "Word already existis");
        }

        word = new Word();
        word.setType(wordRequest.getWordType());
        word.setName(wordRequest.getWord());

        word.setTranslations(wordRequest.getTranslations().stream().map(translationName -> {
            Translation translation = translationRepository.findByNameIgnoreCase(translationName);

            if (translation == null) {
                translation = new Translation();
                translation.setName(translationName);
            }
            return translation;
        }).collect(Collectors.toSet()));

        wordRepository.save(word);

        return word;
    }
}
