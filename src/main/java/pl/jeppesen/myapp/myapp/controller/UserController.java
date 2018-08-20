package pl.jeppesen.myapp.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.jeppesen.myapp.myapp.model.User;
import pl.jeppesen.myapp.myapp.service.UserService;

public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User newUser) {
        return userService.addUser(newUser);
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserById(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public List<User> search(
//            @RequestParam(value = "name",defaultValue = "") String name,
//            @RequestParam(value = "lasName",defaultValue = "")String lastName){
//        return userService.search(name,lastName); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User update(
            @PathVariable Long id,
            @RequestBody User user) {
        return userService.updateuser(id, user);
    }
}
