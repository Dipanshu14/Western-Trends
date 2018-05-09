package com.niit.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
	@Entity
public class Authority implements Serializable {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int authorityId;
		private String username;
		private String authority;
		public Authority()
		{}
		public int getAuthorityId() {
			return authorityId;
		}
		public void setAuthorityId(int authorityId) {
			this.authorityId = authorityId;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getAuthority() {
			return authority;
		}
		public void setAuthority(String authority) {
			this.authority = authority;
		}
	}		