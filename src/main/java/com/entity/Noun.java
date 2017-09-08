package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "noun")
@PrimaryKeyJoinColumn(name = "id", foreignKey = @ForeignKey(name = "fk_noun_id"))
public class Noun extends Word {

	@Column(name = "gender")
	@Enumerated(value = EnumType.STRING)
	private NounGender gender;

	@Column(name = "has_plural", nullable = false)
	private Boolean hasPlural;

	@Column(name = "plular_form")
	private String plularForm;

	public Noun() {
	}

	public NounGender getGender() {
		return gender;
	}

	public void setGender(NounGender gender) {
		this.gender = gender;
	}

	public Boolean getHasPlural() {
		return hasPlural;
	}

	public void setHasPlural(Boolean hasPlural) {
		this.hasPlural = hasPlural;
	}

	public String getPlularForm() {
		return plularForm;
	}

	public void setPlularForm(String plularForm) {
		this.plularForm = plularForm;
	}

}
