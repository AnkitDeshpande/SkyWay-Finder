package com.fbs.Utility;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EMUtils {
	static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("FBS");
	}
	
	public static EntityManager connect() {
		return emf.createEntityManager();
	}
}
