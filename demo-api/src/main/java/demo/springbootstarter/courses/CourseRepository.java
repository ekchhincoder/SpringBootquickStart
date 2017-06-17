package demo.springbootstarter.courses;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by bpoud on 6/17/2017.
 */
public interface CourseRepository extends CrudRepository<Course,String>  {
   //different syntax for member variable findByTopicId is -->will look by Topic ID object
    public List<Course> findByTopicId(String topicId);

    //getAllTopics
    //getTopics
    //updateTopics
    //deleteTopics  CRUD operation





}
