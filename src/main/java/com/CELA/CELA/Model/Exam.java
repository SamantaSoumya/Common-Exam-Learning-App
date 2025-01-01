package com.CELA.CELA.Model;

import java.util.List;

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

