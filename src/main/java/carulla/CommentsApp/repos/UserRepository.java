package carulla.CommentsApp.repos;

import carulla.CommentsApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {



}
