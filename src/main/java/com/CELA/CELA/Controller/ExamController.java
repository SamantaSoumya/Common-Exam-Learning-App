package com.CELA.CELA.Controller;

import com.CELA.CELA.Model.Exam;
import com.CELA.CELA.Service.ExamService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exams")
public class ExamController {

    private static final Logger logger = LogManager.getLogger(ExamController.class);

    @Autowired
    private ExamService examService;

    /**
     * Add a new exam
     */
    @PostMapping
    public ResponseEntity<String> addExam(@RequestBody Exam exam) {
        examService.addExamDetails(exam);
        logger.info("Exam added: {}", exam);
        return ResponseEntity.ok("Exam added successfully");
    }

    /**
     * Get exam details by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Exam> getExamById(@PathVariable Long id) {
        Exam exam = examService.getExamDetails(id);
        logger.info("Fetched exam for ID: {}", id);
        return ResponseEntity.ok(exam);
    }

    /**
     * Get all exam details
     */
    @GetMapping
    public ResponseEntity<List<Exam>> getAllExams() {
        List<Exam> exams = examService.getAllExamDetails();
        logger.info("Fetched all exams");
        return ResponseEntity.ok(exams);
    }

    /**
     * Update an exam by ID
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> updateExam(@PathVariable Long id, @RequestBody Exam exam) {
        examService.updateExamDetails(id, exam);
        logger.info("Exam updated for ID: {}", id);
        return ResponseEntity.ok("Exam updated successfully");
    }

    /**
     * Delete an exam by ID
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExam(@PathVariable Long id) {
        examService.deleteExamDetails(id);
        logger.info("Exam deleted for ID: {}", id);
        return ResponseEntity.ok("Exam deleted successfully");
    }
}
