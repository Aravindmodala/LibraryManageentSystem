package com.example.demo.Entity;

import java.util.List;

import jakarta.persistence.*;
@Entity
@Table(name = "Users")
public class Users {
	
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long user_id;
	    
	    private String name;
	    
	    @Column(unique = true, nullable = false)
	    private String email;
	    
	    private String password;
	    
	    private String phone_number;
	    
	    @Column(nullable = false)
	    private boolean membershipStatus; // true for active, false for inactive
	    
	    private String address;

	    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private List<Books> books; // A user can add multiple books

		public Long getUser_id() {
			return user_id;
		}

		public void setUser_id(Long user_id) {
			this.user_id = user_id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getPhone_number() {
			return phone_number;
		}

		public void setPhone_number(String phone_number) {
			this.phone_number = phone_number;
		}

		public boolean isMembershipStatus() {
			return membershipStatus;
		}

		public void setMembershipStatus(boolean membershipStatus) {
			this.membershipStatus = membershipStatus;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public List<Books> getBooks() {
			return books;
		}

		public void setBooks(List<Books> books) {
			this.books = books;
		}

}
