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
@Table(name = "saqs") // Maps this entity to the "Students" table in the database
public class Saq {

    @Id // Marks this field as the primary key// Auto-generates the ID
    private Long id;

    @Column(nullable = false)// marks must be unique and non-null
    private Long examId;
    
    @Column(nullable = false)// marks must be unique and non-null
    private Long orgId;

    @Column(nullable = false) // Maps the field to a column; makes it non-null
    private String question;

    @Column(nullable = false) // Maps the field to a column; makes it non-null
    private String answer;

    @Column(nullable = false) // Maps the field to a column; makes it non-null
    private int marks;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getExamId() {
		return examId;
	}

	public void setExamId(Long examId) {
		this.examId = examId;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}
    
}

