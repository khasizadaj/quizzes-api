package com.quizzen.quizzes.quizzesapi.quizzes;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface QuizzesRepository extends CrudRepository<Quiz, String> {

	public List<Quiz> findByTopicId(String topicId);

}
