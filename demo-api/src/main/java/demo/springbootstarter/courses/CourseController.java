package demo.springbootstarter.courses;

import demo.springbootstarter.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id){
		return courseService.getAllCourse(id);
	}
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String id){
		return courseService.getCourse(id);
		
	}
	@RequestMapping(method=RequestMethod.POST, value= "/topics/{topicId}/course}" )
	public void addCourse(@RequestBody Course course,@PathVariable String topicId){
		course.setTopic(new Topic(topicId,"",""));

		courseService.addCourse(course);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value= "/topics/{topicId}/course/{id}" )
	public void updateCourse(@RequestBody Course course, @PathVariable String id){

		courseService.updateCourse(course);
		
	}
	@RequestMapping(method=RequestMethod.DELETE, value= "/topics/{topicId}/course/{id}" )
	public void deleteCourse( @PathVariable String id){
		courseService.deleteCourse(id);
		
	}


}
