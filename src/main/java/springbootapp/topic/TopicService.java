package springbootapp.topic;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	private List<Topic> topics = new ArrayList<>( Arrays.asList(
			new Topic(1,"Searching","Learn various Searching Algorithms"),
			new Topic(2,"Sorting","Learn various Sorting Algorithms"),
			new Topic(3,"Indexing","Learn B+ Tree Index")
			));

	
	
	public List<Topic> getAllTopics(){
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}

	public Optional<Topic> getTopic(int id) {
		return topicRepository.findById(id);

	}

	public void addTopic(Topic topic) {		
		topicRepository.save(topic);
	}

	public void updateTopic(int id, Topic topic) {
		topicRepository.save(topic);
		
	}

	public void removeTopic(int id) {
		topicRepository.deleteById(id);
	}
	
	
}
