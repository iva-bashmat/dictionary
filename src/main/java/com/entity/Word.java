package com.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "words", uniqueConstraints = @UniqueConstraint(name = "words_name_uk", columnNames = { "name" }))
@Inheritance(strategy = InheritanceType.JOINED)
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private WordType type;

    @ManyToMany
    @JoinTable(name = "words_categories",
            joinColumns = @JoinColumn(name = "word_id", referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk_words_categories_word_id")),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk_words_categories_category_id")))
    private Set<Category> categories;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "words_translations",
            joinColumns = @JoinColumn(name = "word_id", referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk_words_translations_word_id")),
            inverseJoinColumns = @JoinColumn(name = "translation_id", referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk_words_translations_translation_id")))
    private Set<Translation> translations;

    public Word() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WordType getType() {
        return type;
    }

    public void setType(WordType type) {
        this.type = type;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<Translation> getTranslations() {
        return translations;
    }

    public void setTranslations(Set<Translation> translations) {
        this.translations = translations;
    }

}
