package com.CELA.CELA.Model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

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
    private Long orgId;

    public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	@Column(nullable = false) // Maps the field to a column; makes it non-null
    private int totalMarks;

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public Long getExamId() {
		return examId;
	}

	public void setExamId(Long examId) {
		this.examId = examId;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;


	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
    
}

