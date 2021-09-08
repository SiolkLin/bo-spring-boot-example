package io.bigobject.demo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="bo_example_user")
@Data
public class User {
	@Id
	private String id;
	
	@Column(name="username")
	private String username;
	
	@ManyToOne
	private Company company;
}