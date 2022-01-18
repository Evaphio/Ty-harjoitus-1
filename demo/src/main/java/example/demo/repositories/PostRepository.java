package example.demo.repositories;
import org.springframework.data.repository.CrudRepository;

import example.demo.models.Post;

public interface PostRepository extends CrudRepository<Post, Long>{
    
}
