package carulla.CommentsApp.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "p_like")
@Data
public class Like {

    @Id
    long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id" ,nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE )
    Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id" ,nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE )
    User user;

}
