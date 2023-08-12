package carulla.CommentsApp.services;

import carulla.CommentsApp.entities.Post;
import carulla.CommentsApp.entities.User;
import carulla.CommentsApp.repos.PostRepository;
import carulla.CommentsApp.request.PostCreateRequest;
import carulla.CommentsApp.request.PostUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    PostRepository postRepository;
    UserService userService;

    public PostService(PostRepository postRepository,UserService userService) {
        this.postRepository = postRepository;
        this.userService=userService;
    }

    public List<Post> getAllPost(Optional<Long> userId) {
        if (userId.isPresent()){
            return postRepository.findByUserId(userId.get());
        }
        else return postRepository.findAll();

    }

    public Post createPost(PostCreateRequest newPostCreateRequest) {
     User user= userService.getOneUser(newPostCreateRequest.getUserId());
     if (user==null)
         return null;
     Post toPost =new Post();
     toPost.setId(newPostCreateRequest.getId());
     toPost.setTitle(newPostCreateRequest.getTitle());
     toPost.setText(newPostCreateRequest.getText());
     toPost.setUser(user);
        return postRepository.save(toPost);
    }


    public Post getOnePostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    public Post updatePostById(Long postId, PostUpdateRequest postUpdateRequest) {
        Optional<Post> post =postRepository.findById(postId);
        if (post.isPresent()){
            Post toUpdate =post.get();
            toUpdate.setText(postUpdateRequest.getText());
            toUpdate.setTitle(postUpdateRequest.getTitle());
            postRepository.save(toUpdate);
            return toUpdate;
        }
        return null;
    }

    public void deletePostById(Long postId) {
        postRepository.deleteById(postId);
    }
}
