package com.controller.wrapper;

import java.util.Set;
import java.util.stream.Collectors;

import com.entity.Translation;
import com.entity.Word;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WordResponse {

    @JsonProperty(value = "id")
    private Integer id;

    @JsonProperty(value = WordRequest.WORD_VALUE)
    private String word;

    @JsonProperty(value = "translations")
    private Set<String> translations;

    @JsonProperty(value = "type")
    private String type;

    public WordResponse(Word word) {
        this.id = word.getId();
        this.word = word.getName();
        this.translations = word.getTranslations().stream().map(Translation::getName).collect(Collectors.toSet());
        this.type = word.getType().getIdentifier();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
