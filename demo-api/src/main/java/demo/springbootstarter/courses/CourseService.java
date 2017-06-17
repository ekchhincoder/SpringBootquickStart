package demo.springbootstarter.courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//Business service singleton
@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;

    //GET ALL TOPICS
	public List<Course> getAllCourse(String topicId) {
		List<Course> courses= new ArrayList<>();
		courseRepository.findByTopicId(topicId)
		.forEach(courses::add);//Method references
		return courses;
	}

	// GET ID
	public Course getCourse(String id) {
		// iterate over the list of topics and match the id that was passed
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return courseRepository.findOne(id);


	}

	// ADD
	public void addCourse(Course course) {
		courseRepository.save(course);

	}

	// UPDATE
	public void updateCourse( Course course) {
	//check if there is a row already exist for this  topic if exist update if not insert as necessary
		courseRepository.save(course);

	}

	// DELETE
	public void deleteCourse(String id) {
		courseRepository.delete(id);

	}

}
