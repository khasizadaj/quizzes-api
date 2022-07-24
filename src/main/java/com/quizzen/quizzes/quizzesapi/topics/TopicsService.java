package com.quizzen.quizzes.quizzesapi.topics;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicsService {

	@Autowired
	private TopicsRepository topicsRepository;

	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<>();
		topicsRepository.findAll().forEach(topics::add);
		return topics;
	}

	public Optional<Topic> getTopic(String id) {
		return topicsRepository.findById(id);
	}

	public void addTopic(Topic topic) {
		topicsRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
		topicsRepository.save(topic);
	}

	public void deleteTopic(String id) {
		topicsRepository.deleteById(id);
	}
}
