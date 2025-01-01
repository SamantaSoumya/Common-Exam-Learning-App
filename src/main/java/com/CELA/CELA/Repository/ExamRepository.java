package com.CELA.CELA.Repository;
import com.CELA.CELA.Model.Exam;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExamRepository extends JpaRepository<Exam,Long> {
	@Query("SELECT e FROM Exam e WHERE e.orgId = :orgId")
	List<Exam> findExamByorgId(Long orgId);
}
