package carulla.CommentsApp.repos;

import carulla.CommentsApp.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like ,Long> {
}
