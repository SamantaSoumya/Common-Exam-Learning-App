package com.CELA.CELA.Controller;

import com.CELA.CELA.Model.Mcq_Msq;
import com.CELA.CELA.Model.Saq;
import com.CELA.CELA.Service.QuestionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/questions")
public class QuestionController {

    private static final Logger logger = LogManager.getLogger(QuestionController.class);

    @Autowired
    private QuestionService questionService;

    // MCQ/MSQ Methods

    /**
     * Add an MCQ/MSQ question
     */
    @PostMapping("/mcq-msq")
    public ResponseEntity<String> addMcqMsqQuestion(@RequestBody Mcq_Msq mcqMsq) {
        questionService.addMcqMsqQuestion(mcqMsq);
        logger.info("MCQ/MSQ question added: {}", mcqMsq);
        return ResponseEntity.ok("MCQ/MSQ Question added successfully");
    }

    /**
     * Get a single MCQ/MSQ question by ID
     */
    @GetMapping("/mcq-msq/{id}")
    public ResponseEntity<Mcq_Msq> getSingleMcqMsqQuestion(@PathVariable Long id) {
        Mcq_Msq mcqMsq = questionService.getSingleMcqMsqQuestion(id);
        logger.info("Fetched MCQ/MSQ question with ID: {}", id);
        return ResponseEntity.ok(mcqMsq);
    }

    /**
     * Get all MCQ/MSQ questions
     */
    @GetMapping("/mcq-msq")
    public ResponseEntity<List<Mcq_Msq>> getAllMcqMsqQuestions() {
        List<Mcq_Msq> mcqMsqs = questionService.getAllMcqMsqQuestion();
        logger.info("Fetched all MCQ/MSQ questions");
        return ResponseEntity.ok(mcqMsqs);
    }

    /**
     * Update an MCQ/MSQ question by ID
     */
    @PutMapping("/mcq-msq/{id}")
    public ResponseEntity<String> updateMcqMsqQuestion(@PathVariable Long id, @RequestBody Mcq_Msq mcqMsq) {
        questionService.updateMcqMsqQuestion(id, mcqMsq);
        logger.info("MCQ/MSQ question updated for ID: {}", id);
        return ResponseEntity.ok("MCQ/MSQ Question updated successfully");
    }

    /**
     * Delete an MCQ/MSQ question by ID
     */
    @DeleteMapping("/mcq-msq/{id}")
    public ResponseEntity<String> deleteMcqMsqQuestion(@PathVariable Long id) {
        questionService.deleteMcqMsqQuestion(id);
        logger.info("MCQ/MSQ question deleted with ID: {}", id);
        return ResponseEntity.ok("MCQ/MSQ Question deleted successfully");
    }

    // SAQ Methods

    /**
     * Add an SAQ question
     */
    @PostMapping("/saq")
    public ResponseEntity<String> addSaqQuestion(@RequestBody Saq saq) {
        questionService.addSaqQuestion(saq);
        logger.info("SAQ question added: {}", saq);
        return ResponseEntity.ok("SAQ Question added successfully");
    }

    /**
     * Get a single SAQ question by ID
     */
    @GetMapping("/saq/{id}")
    public ResponseEntity<Saq> getSingleSaqQuestion(@PathVariable Long id) {
        Saq saq = questionService.getSingleSaqQuestion(id);
        logger.info("Fetched SAQ question with ID: {}", id);
        return ResponseEntity.ok(saq);
    }

    /**
     * Get all SAQ questions
     */
    @GetMapping("/saq")
    public ResponseEntity<List<Saq>> getAllSaqQuestions() {
        List<Saq> saqs = questionService.getAllSaqQuestion();
        logger.info("Fetched all SAQ questions");
        return ResponseEntity.ok(saqs);
    }

    /**
     * Update an SAQ question by ID
     */
    @PutMapping("/saq/{id}")
    public ResponseEntity<String> updateSaqQuestion(@PathVariable Long id, @RequestBody Saq saq) {
        questionService.updateSaqQuestion(id, saq);
        logger.info("SAQ question updated for ID: {}", id);
        return ResponseEntity.ok("SAQ Question updated successfully");
    }

    /**
     * Delete an SAQ question by ID
     */
    @DeleteMapping("/saq/{id}")
    public ResponseEntity<String> deleteSaqQuestion(@PathVariable Long id) {
        questionService.deleteSaqQuestion(id);
        logger.info("SAQ question deleted with ID: {}", id);
        return ResponseEntity.ok("SAQ Question deleted successfully");
    }
}
