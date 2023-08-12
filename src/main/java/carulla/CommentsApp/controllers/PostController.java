package carulla.CommentsApp.controllers;

import carulla.CommentsApp.entities.Post;
import carulla.CommentsApp.request.PostCreateRequest;
import carulla.CommentsApp.request.PostUpdateRequest;
import carulla.CommentsApp.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/post")
public class PostController {

    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;

    }


    @GetMapping
    public List<Post> getAllPost(@RequestParam Optional<Long> userId){
        return postService.getAllPost(userId);
    }

    @PostMapping
    public Post createPost(@RequestBody PostCreateRequest newPostCreateRequest){
        return postService.createPost(newPostCreateRequest);
    }

    @GetMapping("/{postId}")
    public Post getOnePostById(@PathVariable Long postId){
        return postService.getOnePostById(postId);
    }

    @PutMapping("/{postId}")
    public Post updateOnePost(@PathVariable Long postId , @RequestBody PostUpdateRequest postUpdateRequest){
        return postService.updatePostById(postId,postUpdateRequest);
    }

    @DeleteMapping("/{postId}")
    public void deletePostById(@PathVariable Long postId){
        postService.deletePostById(postId);
    }

}
