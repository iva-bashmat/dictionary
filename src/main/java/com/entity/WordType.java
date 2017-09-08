package com.entity;

public enum WordType {

    NOUN(WordType.NOUN_IDENTIFIER), VERB(WordType.VERB_IDENTIFIER), PHRASE(WordType.PHRASE_IDENTIFIER);

    public static final String NOUN_IDENTIFIER = "noun";
    public static final String VERB_IDENTIFIER = "verb";
    public static final String PHRASE_IDENTIFIER = "phrase";

    private final String identifier;

    private WordType(String identifier) {
        this.identifier = identifier;
    }

    public final String getIdentifier() {
        return identifier;
    }

    public static WordType getByIdentifier(String identifier) {
        for (WordType wordType : WordType.values()) {
            if (wordType.getIdentifier().equals(identifier)) {
                return wordType;
            }
        }
        return null;
    }

}
