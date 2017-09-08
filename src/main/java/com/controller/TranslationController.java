package com.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Translation;
import com.service.TranslationService;

@RestController
@RequestMapping(value = "/translations")
public class TranslationController {

    @Autowired
    private TranslationService translationService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public List<String> getTranslations(@RequestParam(value = "name", required = true) String name) {
        return translationService.getTranslations(name).stream().map(Translation::getName).collect(Collectors.toList());
    }
}
