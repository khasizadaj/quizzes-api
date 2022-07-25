package com.quizzen.quizzes.quizzesapi.quizzes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizzesService {

	@Autowired
	private QuizzesRepository quizzesRepository;

	public List<Quiz> getAllQuizzes(String id) {
		List<Quiz> quizzes = new ArrayList<>();
		quizzesRepository.findByTopicId(id).forEach(quizzes::add);
		return quizzes;
	}

	public Optional<Quiz> getQuiz(String id) {
		return quizzesRepository.findById(id);
	}

	public void addQuiz(Quiz quiz) {
		quizzesRepository.save(quiz);
	}

	public void updateQuiz(Quiz quiz) {
		quizzesRepository.save(quiz);
	}

	public void deleteQuiz(String id) {
		quizzesRepository.deleteById(id);
	}
}
