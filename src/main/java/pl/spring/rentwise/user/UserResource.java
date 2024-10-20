package pl.spring.rentwise.user;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserResource {
    private  UserService userService;

    UserResource(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Long id) {
        return userService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("")
    public List<UserDto> findAll(@RequestParam(required = false) String lastName){
        if(lastName != null){
            return userService.findByLastName(lastName);
        }else
         return userService.findAll();
    }

    @PostMapping("")
    public ResponseEntity<UserDto> save(@RequestBody UserDto user) {
        if(user.getId() != null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "The saved file cannot have an id that is already set up"
            );
        }
        UserDto savedUser = userService.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).body(savedUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable Long id, @RequestBody UserDto user) {
        if(!id.equals(user.getId())){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "The updated object must have an id compatible with the id in the resourse path");

        }
        UserDto updatedUser = userService.update(user);

        return ResponseEntity.ok(updatedUser);
    }

    @GetMapping("/{id}/assignments")
    public List<UserAssignmentDto> getUserAssignments(@PathVariable Long id) {
        return userService.getUserAssignments(id);
    }

}
