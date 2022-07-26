package com.project2.imfd.model;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

	@SuppressWarnings("serial")
	@Entity
	@NoArgsConstructor
	@Getter
	@Setter
	@ToString
	public class OrderDetail implements Serializable{
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Integer orderno;
		
		private String status = "Pending";
		private double subtotal;
		private double tax = 8.25;
		private double total = subtotal * 1.825;
		private String employee = "Not Assigned";
		@CreationTimestamp
		@Column(updatable=false)
		private LocalDateTime createdAt;
				
		}