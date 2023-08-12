package carulla.CommentsApp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Table(name = "user")
@Data
@Entity
public class User {
    @Id
    long id;
    String userName;
    String password;

}
