package com.jsp.Product.entity;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Persistence;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
	
//	@Bean
//	public SessionFactory getSession() {
//		return new Configuration().configure().addAnnotatedClass(User.class).buildSessionFactory();
//	}
//	
//	@Bean
//	public EntityManagerFactory getEMF() {
//		return Persistence.createEntityManagerFactory("");
//	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@NotNull
	private String userName;
	@Email(regexp = "", message = "")
	private String email;
	private String password;
	@Min(value = 6000000000l, message = "Phone number is Invalid,should be greater than 5")
	@Max(value = 9999999999l, message = "Phone number is Invalid,should be lesser than 9")
	private long phoneNumber;
	
}
