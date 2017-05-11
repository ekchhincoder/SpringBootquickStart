package demo.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

//Business service singleton
@Service
public class TopicService {

	private List<Topic> topics = new ArrayList<>(
			Arrays.asList(new Topic("Spring", "Spring Framework", "Spring Framework Description"),
					new Topic("Java", "Java Framework", "Java Framework Description"),
					new Topic("JavaScript", "JavaScript Framework", "JavaScript Framework Description")));
	
    //GET ALL TOPICS
	public List<Topic> getAllTopics() {
		return topics;
	}

	// GET ID
	public Topic getTopic(String id) {
		// iterate over the list of topics and match the id that was passed
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	// ADD
	public void addTopic(Topic topic) {
		topics.add(topic);

	}

	// UPDATE
	public void updateTopic(String id, Topic topic) {
		for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if (t.getId().equals(id)) {
				topics.set(i, topic);
				return;

			}

		}

	}

	// DELETE
	public void deleteTopic(String id) {
		// Lamda Expression
		topics.removeIf(t -> t.getId().equals(id));

	}

}
