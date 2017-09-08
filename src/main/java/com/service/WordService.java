package com.service;

import com.controller.wrapper.WordRequest;
import com.entity.Word;

public interface WordService {

	Word addWord(WordRequest wordRequest);
}
