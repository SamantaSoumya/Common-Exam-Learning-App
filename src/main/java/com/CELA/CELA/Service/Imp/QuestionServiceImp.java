package com.CELA.CELA.Service.Imp;

import com.CELA.CELA.Model.Mcq_Msq;
import com.CELA.CELA.Model.Saq;
import com.CELA.CELA.Repository.McqMsqRepository;
import com.CELA.CELA.Repository.SaqRepository;
import com.CELA.CELA.Service.QuestionService;
import com.CELA.CELA.Exception.ResourceNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImp implements QuestionService {

    private static final Logger logger = LogManager.getLogger(QuestionServiceImp.class);

    @Autowired
    private McqMsqRepository mcqMsqRepository;

    @Autowired
    private SaqRepository saqRepository;

    @Override
    public Boolean addMcqMsqQuestion(Mcq_Msq questionMcq_Msq) {
        try {
            mcqMsqRepository.save(questionMcq_Msq);
            logger.info("MCQ/MSQ question added successfully: {}", questionMcq_Msq);
            return true;
        } catch (Exception ex) {
            logger.error("Error adding MCQ/MSQ question: {}", ex.getMessage());
            throw new RuntimeException("Failed to add MCQ/MSQ question", ex);
        }
    }

    @Override
    public Boolean addSaqQuestion(Saq queSaq) {
        try {
            saqRepository.save(queSaq);
            logger.info("SAQ question added successfully: {}", queSaq);
            return true;
        } catch (Exception ex) {
            logger.error("Error adding SAQ question: {}", ex.getMessage());
            throw new RuntimeException("Failed to add SAQ question", ex);
        }
    }

    @Override
    public Mcq_Msq getSingleMcqMsqQuestion(Long id) {
        logger.info("Fetching MCQ/MSQ question with ID: {}", id);
        return mcqMsqRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("MCQ/MSQ question not found with ID: {}", id);
                    return new ResourceNotFoundException("MCQ/MSQ question not found with ID: " + id);
                });
    }

    @Override
    public List<Mcq_Msq> getAllMcqMsqQuestion() {
        try {
            List<Mcq_Msq> questions = mcqMsqRepository.findAll();
            logger.info("Fetched all MCQ/MSQ questions successfully.");
            return questions;
        } catch (Exception ex) {
            logger.error("Error fetching all MCQ/MSQ questions: {}", ex.getMessage());
            throw new RuntimeException("Failed to fetch MCQ/MSQ questions", ex);
        }
    }

    @Override
    public Saq getSingleSaqQuestion(Long id) {
        logger.info("Fetching SAQ question with ID: {}", id);
        return saqRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("SAQ question not found with ID: {}", id);
                    return new ResourceNotFoundException("SAQ question not found with ID: " + id);
                });
    }

    @Override
    public List<Saq> getAllSaqQuestion() {
        try {
            List<Saq> questions = saqRepository.findAll();
            logger.info("Fetched all SAQ questions successfully.");
            return questions;
        } catch (Exception ex) {
            logger.error("Error fetching all SAQ questions: {}", ex.getMessage());
            throw new RuntimeException("Failed to fetch SAQ questions", ex);
        }
    }

    @Override
    public Boolean updateMcqMsqQuestion(Long id, Mcq_Msq mcq_Msq) {
        try {
            Mcq_Msq existingQuestion = mcqMsqRepository.findById(id)
                    .orElseThrow(() -> {
                        logger.error("MCQ/MSQ question not found for update with ID: {}", id);
                        return new ResourceNotFoundException("MCQ/MSQ question not found with ID: " + id);
                    });

            // Update fields
           existingQuestion.setQuestion(mcq_Msq.getQuestion());
           existingQuestion.setOption1(mcq_Msq.getOption1());
           existingQuestion.setOption2(mcq_Msq.getOption2());
           existingQuestion.setOption3(mcq_Msq.getOption3());
           existingQuestion.setOption4(mcq_Msq.getOption4());
           existingQuestion.setAnswer(mcq_Msq.getAnswer());
           existingQuestion.setExamId(mcq_Msq.getExamId());
           existingQuestion.setMarks(mcq_Msq.getMarks());
           existingQuestion.setOrgId(mcq_Msq.getOrgId());
            mcqMsqRepository.save(existingQuestion);

            logger.info("MCQ/MSQ question updated successfully: {}", existingQuestion);
            return true;
        } catch (Exception ex) {
            logger.error("Error updating MCQ/MSQ question with ID {}: {}", id, ex.getMessage());
            throw new RuntimeException("Failed to update MCQ/MSQ question", ex);
        }
    }

    @Override
    public Boolean updateSaqQuestion(Long id, Saq saq) {
        try {
            Saq existingQuestion = saqRepository.findById(id)
                    .orElseThrow(() -> {
                        logger.error("SAQ question not found for update with ID: {}", id);
                        return new ResourceNotFoundException("SAQ question not found with ID: " + id);
                    });

            // Update fields
           existingQuestion.setQuestion(saq.getQuestion());
           existingQuestion.setAnswer(saq.getAnswer());
           existingQuestion.setExamId(saq.getExamId());
           existingQuestion.setOrgId(saq.getOrgId());
           existingQuestion.setMarks(saq.getMarks());
            saqRepository.save(existingQuestion);

            logger.info("SAQ question updated successfully: {}", existingQuestion);
            return true;
        } catch (Exception ex) {
            logger.error("Error updating SAQ question with ID {}: {}", id, ex.getMessage());
            throw new RuntimeException("Failed to update SAQ question", ex);
        }
    }

    @Override
    public Boolean deleteMcqMsqQuestion(Long id) {
        try {
            Mcq_Msq existingQuestion = mcqMsqRepository.findById(id)
                    .orElseThrow(() -> {
                        logger.error("MCQ/MSQ question not found for deletion with ID: {}", id);
                        return new ResourceNotFoundException("MCQ/MSQ question not found with ID: " + id);
                    });

            mcqMsqRepository.delete(existingQuestion);
            logger.info("MCQ/MSQ question deleted successfully with ID: {}", id);
            return true;
        } catch (Exception ex) {
            logger.error("Error deleting MCQ/MSQ question with ID {}: {}", id, ex.getMessage());
            throw new RuntimeException("Failed to delete MCQ/MSQ question", ex);
        }
    }

    @Override
    public Boolean deleteSaqQuestion(Long id) {
        try {
            Saq existingQuestion = saqRepository.findById(id)
                    .orElseThrow(() -> {
                        logger.error("SAQ question not found for deletion with ID: {}", id);
                        return new ResourceNotFoundException("SAQ question not found with ID: " + id);
                    });

            saqRepository.delete(existingQuestion);
            logger.info("SAQ question deleted successfully with ID: {}", id);
            return true;
        } catch (Exception ex) {
            logger.error("Error deleting SAQ question with ID {}: {}", id, ex.getMessage());
            throw new RuntimeException("Failed to delete SAQ question", ex);
        }
    }
}
