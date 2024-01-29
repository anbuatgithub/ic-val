package com.qualcomm.chip.validation.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "directory")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Hidden
public class Directory  {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String resultsPath;
	private String project;
	private String chipType;
	private String chipRevision;
	private String testArea;
	private String testScope;
	private Long dutId;
	private Date dateOfTest;
	private Integer runOfTest;
	private Integer temperature;

}
