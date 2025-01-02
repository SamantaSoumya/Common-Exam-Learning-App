package com.CELA.CELA.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;

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
@Getter
@Setter
@NoArgsConstructor // Generates a no-argument constructor
@AllArgsConstructor // Generates an all-arguments constructor
@Builder // Provides a builder pattern implementation
@Entity // Marks this as a JPA entity
@Table(name = "mcq_msqs") // Maps this entity to the "Mcq_Msqs" table in the database
public class Mcq_Msq {

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

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public ArrayList<String> getAnswer() {
		return answer;
	}

	public void setAnswer(ArrayList<String> answer) {
		this.answer = answer;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Id // Marks this field as the primary key
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
	@Convert(converter = Converterr.class)
    private ArrayList<String> answer;// select (e.g. option1,option2,option3,option1 & option2,all)

    @Column(nullable = false)// marks must be unique and non-null
    private int marks;
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
}

