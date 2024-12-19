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
@Table(name = "results") // Maps this entity to the "Results" table in the database
public class Result {

    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the ID
    private Long id;

    @Column(nullable = false) // Maps the field to a column; makes it non-null
    private Long studentId;

    @Column(nullable = false) // Maps the field to a column; makes it non-null
    private Long examId;

    @Column(nullable = false) // Maps the field to a column; makes it non-null
    private int totalMarks;
}

