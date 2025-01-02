package com.CELA.CELA.Model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.CELA.CELA.Custom.Converterr;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data // Generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor // Generates a no-argument constructor
@AllArgsConstructor // Generates an all-arguments constructor
@Builder // Provides a builder pattern implementation
@Entity // Marks this as a JPA entity
@Table(name = "exams") // Maps this entity to the "exams" table in the database
public class Exam {

    @Id // Marks this field as the primary key
    private Long examId;
    
    private Long orgId;
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;
    private String examName;

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public Exam(Long examId, Long orgId, LocalDateTime createdDate, List<String> questions) {
		super();
		this.examId = examId;
		this.orgId = orgId;
		this.createdDate = createdDate;
		this.questions = questions;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	@Column(columnDefinition = "JSON", nullable = false)
    @Convert(converter = Converterr.class)
    private List<String> questions;

	public List<String> getQuestions() {
		return questions;
	}

	public Long getExamId() {
		return examId;
	}

	public void setExamId(Long examId) {
		this.examId = examId;
	}

	public void setQuestions(List<String> questions) {
		this.questions = questions;
	}
}

