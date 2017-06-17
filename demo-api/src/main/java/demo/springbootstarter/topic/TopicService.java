package demo.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Business service singleton
@Service
public class TopicService {
	@Autowired
	private TopicRepository topicRepository;

    //GET ALL TOPICS
	public List<Topic> getAllTopics() {
		List<Topic> topics= new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics::add);//Method references
		return topics;
	}

	// GET ID
	public Topic getTopic(String id) {
		// iterate over the list of topics and match the id that was passed
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepository.findOne(id);


	}

	// ADD
	public void addTopic(Topic topic) {
		topicRepository.save(topic);

	}

	// UPDATE
	public void updateTopic(String id, Topic topic) {
	//check if there is a row already exist for this  topic if exist update if not insert as necessary
		topicRepository.save(topic);

	}

	// DELETE
	public void deleteTopic(String id) {


		topicRepository.delete(id);

	}

}
