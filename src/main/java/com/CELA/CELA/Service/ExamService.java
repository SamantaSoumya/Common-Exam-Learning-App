package com.CELA.CELA.Service;

import java.util.List;


import com.CELA.CELA.Model.Exam;

public interface ExamService {
    Exam getExamDetails(Long id);
    List<Exam> getAllExamDetails();
    Boolean updateExamDetails(Long id, Exam exam);
    Boolean addExamDetails(Exam exam);
    Boolean deleteExamDetails(Long id);
    List<Exam> getAllExamDetailsByorgId(Long orgId);
}
