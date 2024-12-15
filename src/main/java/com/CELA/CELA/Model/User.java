package com.CELA.CELA.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data // Generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor // Generates a no-argument constructor
@AllArgsConstructor // Generates an all-arguments constructor
@Builder // Provides a builder pattern implementation
@Entity // Marks this as a JPA entity
@Table(name = "Users") // Maps this entity to the "Users" table in the database
public class User {

    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the ID
    private Long id;

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
    private boolean isApproved = false;
}

