package com.example.gradlespring.model;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@MappedSuperclass
//acceda al atributo y no a la propiedad
@Access(AccessType.FIELD)
public class ParentEntity implements Serializable {

	private static final long serialVersionUID = -9148994175881530233L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	//name nombre de la base de datos exactamente igual
	@Column(name="id", unique=true, nullable=false)
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	

	
}
