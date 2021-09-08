package io.bigobject.demo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="bo_example_company")
@Data
public class Company {
	@Id
	private String id;
	
	@Column(name="company_name")
	private String companyName;
}
