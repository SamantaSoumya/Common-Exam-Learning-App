package com.CELA.CELA.Controller;

import com.CELA.CELA.Model.Result;
import com.CELA.CELA.Service.ResultService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/results")
public class ResultController {

    private static final Logger logger = LogManager.getLogger(ResultController.class);

    @Autowired
    private ResultService resultService;

    /**
     * Add a new result
     */
    @PostMapping
    public ResponseEntity<String> addResult(@RequestBody Result result) {
        resultService.addResult(result);
        logger.info("Result added: {}", result);
        return ResponseEntity.ok("Result added successfully");
    }

    /**
     * Get a single result by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Result> getSingleResult(@PathVariable Long id) {
        Result result = resultService.getSingleUserResult(id);
        logger.info("Fetched result for ID: {}", id);
        return ResponseEntity.ok(result);
    }

    /**
     * Get all results
     */
    @GetMapping
    public ResponseEntity<List<Result>> getAllResults() {
        List<Result> results = resultService.getAllUserResult();
        logger.info("Fetched all results");
        return ResponseEntity.ok(results);
    }

    /**
     * Update a result by ID
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> updateResult(@PathVariable Long id, @RequestBody Result result) {
        resultService.updateResult(id, result);
        logger.info("Updated result for ID: {}", id);
        return ResponseEntity.ok("Result updated successfully");
    }

    /**
     * Delete a result by ID
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteResult(@PathVariable Long id) {
        resultService.deleteResult(id);
        logger.info("Deleted result for ID: {}", id);
        return ResponseEntity.ok("Result deleted successfully");
    }
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Result>> findExamsByStudentId(@PathVariable Long studentId) {
        List<Result> exams = resultService.findExamsByStudentId(studentId);
        logger.info("Fetched all exams");
        return ResponseEntity.ok(exams);
    }
    @GetMapping("/organisation/{orgId}")
    public ResponseEntity<List<Result>> findResultByorgId(@PathVariable Long orgId) {
        List<Result> results = resultService.findResultByorgId(orgId);
        logger.info("Fetched all exams");
        return ResponseEntity.ok(results);
    }
}
