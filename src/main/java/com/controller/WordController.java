package com.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.controller.wrapper.WordRequest;
import com.controller.wrapper.WordResponse;
import com.service.WordService;

@RestController
@RequestMapping(value = "/words")
public class WordController {

    @Autowired
    private WordService wordService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public WordResponse addWord(@Valid @RequestBody(required = true) WordRequest request) {
        return new WordResponse(wordService.addWord(request));
    }
}
