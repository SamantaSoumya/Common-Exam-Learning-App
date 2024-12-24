package com.CELA.CELA.Service;

import java.util.List;


import com.CELA.CELA.Model.Mcq_Msq;
import com.CELA.CELA.Model.Saq;

public interface QuestionService {
    Boolean addMcqMsqQuestion(Mcq_Msq questionMcq_Msq);
    Boolean addSaqQuestion(Saq queSaq);
    Mcq_Msq getSingleMcqMsqQuestion(Long id);
    List<Mcq_Msq> getAllMcqMsqQuestion();
    Saq getSingleSaqQuestion(Long id);
    List<Saq> getAllSaqQuestion();
    Boolean updateMcqMsqQuestion(Long id,Mcq_Msq mcq_Msq);
    Boolean updateSaqQuestion(Long id,Saq saq);
    Boolean deleteMcqMsqQuestion(Long id);
    Boolean deleteSaqQuestion(Long id);
}
