package com.susmitha.quizapp.dao;


import com.susmitha.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
    List<Question> findQuestionsByCategory(String category);


    @Query(value = "SELECT * FROM question q Where q.category=:category ORDER BY RANDOM() LIMIT :numQ " ,nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category,  int numQ);
}
