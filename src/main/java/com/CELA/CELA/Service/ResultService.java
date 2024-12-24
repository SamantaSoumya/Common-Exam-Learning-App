package com.CELA.CELA.Service;

import java.util.List;

import com.CELA.CELA.Model.Result;

public interface ResultService {
    Boolean addResult(Result result);
    Result getSingleUserResult(Long id);
    List<Result> getAllUserResult();
    Boolean updateResult(Long id,Result result);
    Boolean deleteResult(Long id);
}
