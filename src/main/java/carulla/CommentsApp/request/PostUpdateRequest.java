package carulla.CommentsApp.request;

import lombok.Data;

@Data
public class PostUpdateRequest {
    String text;
    String title;
}
