package com.CELA.CELA.Service.Imp;

import com.CELA.CELA.Model.Result;
import com.CELA.CELA.Repository.ResultRepository;
import com.CELA.CELA.Service.ResultService;
import com.CELA.CELA.Exception.ResourceNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultServiceImp implements ResultService {

    private static final Logger logger = LogManager.getLogger(ResultServiceImp.class);

    @Autowired
    private ResultRepository resultRepository;

    @Override
    public Boolean addResult(Result result) {
        try {
            resultRepository.save(result);
            logger.info("Result added successfully: {}", result);
            return true;
        } catch (Exception ex) {
            logger.error("Error adding result: {}", ex.getMessage());
            throw new RuntimeException("Failed to add result", ex);
        }
    }

    @Override
    public Result getSingleUserResult(Long id) {
        logger.info("Fetching result for ID: {}", id);
        return resultRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Result not found with ID: {}", id);
                    return new ResourceNotFoundException("Result not found with ID: " + id);
                });
    }

    @Override
    public List<Result> getAllUserResult() {
        try {
            List<Result> results = resultRepository.findAll();
            logger.info("Fetched all results successfully.");
            return results;
        } catch (Exception ex) {
            logger.error("Error fetching all results: {}", ex.getMessage());
            throw new RuntimeException("Failed to fetch all results", ex);
        }
    }

    @Override
    public Boolean updateResult(Long id, Result result) {
        try {
            Result existingResult = resultRepository.findById(id)
                    .orElseThrow(() -> {
                        logger.error("Result not found for update with ID: {}", id);
                        return new ResourceNotFoundException("Result not found with ID: " + id);
                    });

            // Update fields
           existingResult.setStudentId(result.getStudentId());
           existingResult.setExamId(result.getExamId());
           existingResult.setTotalMarks(result.getTotalMarks());
            resultRepository.save(existingResult);

            logger.info("Result updated successfully: {}", existingResult);
            return true;
        } catch (Exception ex) {
            logger.error("Error updating result with ID {}: {}", id, ex.getMessage());
            throw new RuntimeException("Failed to update result", ex);
        }
    }

    @Override
    public Boolean deleteResult(Long id) {
        try {
            Result existingResult = resultRepository.findById(id)
                    .orElseThrow(() -> {
                        logger.error("Result not found for deletion with ID: {}", id);
                        return new ResourceNotFoundException("Result not found with ID: " + id);
                    });

            resultRepository.delete(existingResult);
            logger.info("Result deleted successfully with ID: {}", id);
            return true;
        } catch (Exception ex) {
            logger.error("Error deleting result with ID {}: {}", id, ex.getMessage());
            throw new RuntimeException("Failed to delete result", ex);
        }
    }
}
