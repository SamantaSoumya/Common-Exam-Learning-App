package com.CELA.CELA.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data // Generates getters, setters, toString, equals, and hashCode
@Getter
@Setter
@NoArgsConstructor // Generates a no-argument constructor
@AllArgsConstructor // Generates an all-arguments constructor
@Builder // Provides a builder pattern implementation
@Entity // Marks this as a JPA entity
@Table(name = "users") // Maps this entity to the "Users" table in the database
public class User {

    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the ID
    private Long userId;

    @Column(nullable = false) // Maps the field to a column; makes it non-null
    private String firstName;

    @Column(nullable = false) // Maps the field to a column; makes it non-null
    private String lastName;

    @Column(unique = true, nullable = false) // mobileNo must be unique and non-null
    private String mobileNo;

    @Column(unique = true, nullable = false) // Email must be unique and non-null
    private String email;

    @Column(nullable = false) // Maps the field to a column; makes it non-null
    private String role; // Role (e.g., Student, Organisation)

    @Column(nullable = false) // Maps the field to a column; makes it non-null
    private String password;

    @Builder.Default
    @Column(nullable = false) //  must be non-null
    private boolean isApproved;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getIsApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
    
}

