package com.CELA.CELA.Repository;
import com.CELA.CELA.Model.Exam;
import com.CELA.CELA.Model.Result;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ResultRepository extends JpaRepository<Result,Long> {
	@Query("SELECT r FROM Result r WHERE r.studentId = :studentId")
	List<Result> findExamsByStudentId(Long studentId);
	@Query("SELECT r FROM Result r WHERE r.orgId = :orgId")
	List<Result> findResultByorgId(Long orgId);
}