package com.niit.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
	@Entity
public class Catagory implements Serializable  {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int Cid;
		private String name;
		public Catagory()
		{}
		public int getCid() {
			return Cid;
		}
		public void setCid(int cid) {
			Cid = cid;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
}
