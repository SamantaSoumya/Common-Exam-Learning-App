package com.CELA.CELA.Model;

import java.util.ArrayList;

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
@Table(name = "Mcq_Msqs") // Maps this entity to the "Mcq_Msqs" table in the database
public class Mcq_Msq {

    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the ID
    private Long id;
    
    @Column(nullable = false)// marks must be unique and non-null
    private Long examId;
    
    @Column(nullable = false)// marks must be unique and non-null
    private Long orgId;

    @Column(nullable = false) // Maps the field to a column; makes it non-null
    private String question;

    @Column(nullable = false) // Maps the field to a column; makes it non-null
    private String option1;

    @Column(unique = true, nullable = false) // Option2 must be unique and non-null
    private String option2;

    @Column(unique = true, nullable = false) // Option3 must be unique and non-null
    private String option3;

    @Column(nullable = false)// Option4 must be unique and non-null
    private String option4;
    
    @Column(columnDefinition = "JSON", nullable = false)// Answer must be unique and non-null
    private ArrayList<String> answer;// select (e.g. option1,option2,option3,option1 & option2,all)

    @Column(nullable = false)// marks must be unique and non-null
    private int marks;
}

