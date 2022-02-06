package com.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.dialect.identity.SybaseAnywhereIdentityColumnSupport;
import org.jboss.jandex.Main;
@Entity(name="sudent_test")
public class xyz {
	@Id
	private int id;
	private String name;

}



