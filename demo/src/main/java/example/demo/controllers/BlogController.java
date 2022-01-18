package example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import java.util.ArrayList;
//import java.util.Optional;

import example.demo.models.Post;
import example.demo.repositories.PostRepository;



@Controller
public class BlogController {

    @Autowired
    private PostRepository postRepository; 


    @GetMapping("/blog")
    public String blogmain(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "blog-main";
    }

    @GetMapping("/blog/add")
    public String blogAdd(Model model) {
        return "blog-add";
    }

    @PostMapping("/blog/add")
    public String blogPostAdd(@RequestParam String title, @RequestParam String text, @RequestParam String link, Model model) {

        if(!(title.isEmpty()) && !(text.isEmpty()) && !(link.isEmpty())) {
        Post post = new Post(title, text, link);
        postRepository.save(post);
        return "redirect:/blog";
    } else {
        return "redirect:/blog/add";
    }

    /*@GetMapping("/blog/{id}")
    public String blogView(@PathVariable(value = "id") long id, Model model) {
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res :: add);
        model.addAttribute("post", post);
        return "blog-view";
    } */



 
}

}  




    

