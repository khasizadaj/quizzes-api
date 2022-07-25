package com.quizzen.quizzes.quizzesapi.quizzes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.quizzen.quizzes.quizzesapi.topics.Topic;

@RestController
public class QuizzesController {

	@Autowired
	private QuizzesService quizzesService;

	@RequestMapping("/api/topics/{id}/quizzes")
	public List<Quiz> getAllQuizzes(@PathVariable String id) {
		return quizzesService.getAllQuizzes(id);
	}

	@RequestMapping("/api/topics/{topicId}/quizzes/{quizId}")
	public Optional<Quiz> getQuiz(@PathVariable String quizId) {
		return quizzesService.getQuiz(quizId);
	}

	@RequestMapping(value = "/api/topics/{topicId}/quizzes", method = RequestMethod.POST)
	public void addQuiz(@PathVariable String topicId, @RequestBody Quiz quiz) {
		quiz.setTopic(new Topic(topicId, ""));
		quizzesService.addQuiz(quiz);
	}

	@RequestMapping(value = "/api/topics/{topicId}/quizzes/{quizId}", method = RequestMethod.PUT)
	public void updateQuiz(@PathVariable String topicId, @RequestBody Quiz quiz) {
		quiz.setTopic(new Topic(topicId, ""));
		quizzesService.updateQuiz(quiz);
	}

	@RequestMapping(value = "/api/topics/{topicId}/quizzes/{quizId}", method = RequestMethod.DELETE)
	public void deleteQuiz(@PathVariable String id) {
		quizzesService.deleteQuiz(id);
	}

}
