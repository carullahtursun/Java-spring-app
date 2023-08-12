package carulla.CommentsApp.request;

import lombok.Data;

@Data
public class PostCreateRequest {
    Long id;
    Long userId;
    String title;
    String text;
}
