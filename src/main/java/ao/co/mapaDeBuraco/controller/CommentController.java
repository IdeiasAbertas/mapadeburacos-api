package ao.co.mapaDeBuraco.controller;

import ao.co.mapaDeBuraco.model.Comment;
import ao.co.mapaDeBuraco.model.Hole;
import ao.co.mapaDeBuraco.service.CommentService;
import ao.co.mapaDeBuraco.service.HoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Comment> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(commentService.findById(id));

    }
}
