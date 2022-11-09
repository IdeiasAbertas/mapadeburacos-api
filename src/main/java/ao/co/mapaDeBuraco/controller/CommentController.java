package ao.co.mapaDeBuraco.controller;

import ao.co.mapaDeBuraco.model.Comment;
import ao.co.mapaDeBuraco.model.dto.response.CommentDTO;
import ao.co.mapaDeBuraco.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Api(value = "API MAPA DE BURACOS")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping(value = "/comment/{id}")
    @ApiOperation(value = "Find comment by id")
    public ResponseEntity<CommentDTO> findById(@PathVariable Long id){
        Comment comment = commentService.findById(id);
        return ResponseEntity.ok(new CommentDTO(comment));

    }

    @GetMapping(value = "/comment")
    @ApiOperation(value = "List all comment")
    public ResponseEntity<List<CommentDTO>> findAll() {
        List<Comment> comments = commentService.findAll();
        return ResponseEntity.ok(comments.stream().map(CommentDTO::new).collect(Collectors.toList()));
    }

    @PostMapping(value = "/comment")
    @ApiOperation(value = "save comment ")
    public ResponseEntity<Comment> create(@RequestParam(value = "hole",defaultValue = "0") Long holeId,
                                           @Valid @RequestBody Comment comment){
        comment = commentService.create(holeId, comment);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(comment.getId()).toUri();
        return ResponseEntity.created(uri).body(comment);
    }

    @PutMapping(value = "/comment/{id}")
    @ApiOperation(value = "update comment ")
    public ResponseEntity<CommentDTO> update(@PathVariable Long id, @Valid @RequestBody CommentDTO commentDTO){
        Comment comment = commentService.update(id, commentDTO);
        return ResponseEntity.ok(new CommentDTO(comment));
    }
    @PutMapping(value = "/comment/approveComment/{id}")
    @ApiOperation(value = "Approve comment")
    public ResponseEntity<Comment> approveComment(@PathVariable Long id, @RequestBody CommentDTO commentDTO){
        Comment comment = commentService.approveComment(id, commentDTO);
        return ResponseEntity.ok().body(comment);
    }
    @DeleteMapping(value = "/comment/{id}")
    @ApiOperation(value = "Delete comment")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        commentService.delete(id);
        return ResponseEntity.noContent().build();

    }
}
