package com.CELA.CELA.Service.Imp;

import com.CELA.CELA.Model.Exam;
import com.CELA.CELA.Repository.ExamRepository;
import com.CELA.CELA.Service.ExamService;
import com.CELA.CELA.Exception.ResourceNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImp implements ExamService {

    private static final Logger logger = LogManager.getLogger(ExamServiceImp.class);

    @Autowired
    private ExamRepository examRepository;

    @Override
    public Exam getExamDetails(Long id) {
        logger.info("Fetching exam details for ID: {}", id);
        return examRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Exam not found with ID: {}", id);
                    return new ResourceNotFoundException("Exam not found with ID: " + id);
                });
    }

    @Override
    public List<Exam> getAllExamDetails() {
        try {
            List<Exam> exams = examRepository.findAll();
            logger.info("Fetched all exam details successfully.");
            return exams;
        } catch (Exception ex) {
            logger.error("Error fetching all exams: {}", ex.getMessage());
            throw new RuntimeException("Failed to fetch all exam details", ex);
        }
    }

    @Override
    public Boolean updateExamDetails(Long id, Exam exam) {
        try {
            Exam existingExam = examRepository.findById(id)
                    .orElseThrow(() -> {
                        logger.error("Exam not found for update with ID: {}", id);
                        return new ResourceNotFoundException("Exam not found with ID: " + id);
                    });

            // Update fields
            existingExam.setQuestions(exam.getQuestions());
            examRepository.save(existingExam);

            logger.info("Exam updated successfully: {}", existingExam);
            return true;
        } catch (Exception ex) {
            logger.error("Error updating exam with ID {}: {}", id, ex.getMessage());
            throw new RuntimeException("Failed to update exam details", ex);
        }
    }

    @Override
    public Boolean addExamDetails(Exam exam) {
        try {
            examRepository.save(exam);
            logger.info("Exam added successfully: {}", exam);
            return true;
        } catch (Exception ex) {
            logger.error("Error adding exam: {}", ex.getMessage());
            throw new RuntimeException("Failed to add exam details", ex);
        }
    }

    @Override
    public Boolean deleteExamDetails(Long id) {
        try {
            // Check if exam exists before attempting to delete
            Exam exam = examRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Exam not found with ID: " + id));
    
            // Delete the exam by ID
            examRepository.deleteById(id);
            logger.info("Exam deleted successfully with ID: {}", exam);
            return true;
        } catch (Exception ex) {
            logger.error("Error deleting exam with ID {}: {}", id, ex.getMessage());
            throw new RuntimeException("Failed to delete exam details", ex);
        }
    }

	@Override
	public List<Exam> getAllExamDetailsByorgId(Long orgId) {
		try {
            List<Exam> exams = examRepository.findExamByorgId(orgId);
            logger.info("Fetched all exam details successfully.");
            return exams;
        } catch (Exception ex) {
            logger.error("Error fetching all exams: {}", ex.getMessage());
            throw new RuntimeException("Failed to fetch all exam details", ex);
        }
	}

    
}
