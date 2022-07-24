package com.quizzen.quizzes.quizzesapi.topics;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicsController {

	@Autowired
	private TopicsService topicsService;

	@RequestMapping("/api/topics")
	public List<Topic> getAllTopics() {
		return topicsService.getAllTopics();
	}

	@RequestMapping("/api/topics/{id}")
	public Optional<Topic> getTopic(@PathVariable String id) {
		return topicsService.getTopic(id);
	}

	@RequestMapping(value = "/api/topics", method = RequestMethod.POST)
	public void addTopic(@RequestBody Topic topic) {
		topicsService.addTopic(topic);
	}

	@RequestMapping(value = "/api/topics/{id}", method = RequestMethod.PUT)
	public void updateTopic(@PathVariable String id, @RequestBody Topic topic) {
		topicsService.updateTopic(id, topic);
	}

	@RequestMapping(value = "/api/topics/{id}", method = RequestMethod.DELETE)
	public void deleteTopic(@PathVariable String id) {
		topicsService.deleteTopic(id);
	}

}
