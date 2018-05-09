package com.niit.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
	@Entity
public class Supplier implements Serializable {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int Sid;
		private String name;
		private long phoneno;
		public Supplier()
		{}
		public int getSid() {
			return Sid;
		}
		public void setSid(int sid) {
			Sid = sid;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public long getPhoneno() {
			return phoneno;
		}
		public void setPhoneno(long phoneno) {
			this.phoneno = phoneno;
		}
}
