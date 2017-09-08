package com.controller.wrapper;

import java.util.Set;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.controller.validator.EnumValues;
import com.entity.WordType;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WordRequest {

    public static final String WORD_VALUE = "word";

    @NotNull
    @JsonProperty(value = WORD_VALUE)
    private String word;

    @NotEmpty
    @JsonProperty(value = "translations")
    private Set<String> translations;

    @NotNull
    @EnumValues(enumValues = { WordType.NOUN_IDENTIFIER, WordType.VERB_IDENTIFIER, WordType.PHRASE_IDENTIFIER })
    @JsonProperty(value = "type")
    private String type;

    public WordRequest() {
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Set<String> getTranslations() {
        return translations;
    }

    public void setTranslations(Set<String> translations) {
        this.translations = translations;
    }

    public WordType getWordType() {
        return WordType.getByIdentifier(type);
    }

    public void setWordType(WordType wordType) {
        type = wordType.getIdentifier();
    }
}
