package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "verb")
@PrimaryKeyJoinColumn(name = "id", foreignKey = @ForeignKey(name = "fk_verb_id"))
public class Verb extends Word {

	@Column(name = "is_regular", nullable = false)
	private Boolean isRegular;

	public Verb() {
	}

	public Boolean getIsRegular() {
		return isRegular;
	}

	public void setIsRegular(Boolean isRegular) {
		this.isRegular = isRegular;
	}

}
