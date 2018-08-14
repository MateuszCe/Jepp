package pl.jeppesen.myapp.myapp.service;

import org.springframework.stereotype.Service;
import pl.jeppesen.myapp.myapp.exception.NotFoundException;
import pl.jeppesen.myapp.myapp.exception.ValidationException;
import pl.jeppesen.myapp.myapp.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    private List<User> userList = new ArrayList<>();


    public User addUser(User user) {
        if (user.getId()==null){
            throw new ValidationException("Id cannot be null");
        }
        userList.add(user);
        return user;
    }

    public void deleteUser(Long id) {
        User userToBeDeleted = userList.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .get();
        if (userToBeDeleted != null){
            userList.remove(userToBeDeleted);
        }else {
            throw new NotFoundException("User dosn't exists");
        }
    }

//    public User search (String name, String lastname){
//       return userList.stream()
//               .filter(user -> user.getName().toLowerCase().contains(name.toLowerCase())
//               && user.getLastName().toLowerCase().contains(lastname.toLowerCase())
//               .collect(toList));
//    }

    public User getUser(Long id) {
        Optional<User> findUser = userList.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
        if (findUser.isPresent()){
            return findUser.get();
        }else {
            throw new NotFoundException("User was not found"); }
    }

    public User updateuser(Long id, User user) {
        Optional<User> userToBeUpdated = userList.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();

        userList.remove(userToBeUpdated.get());
        user.setId(id);
        userList.add(user);
        return user;
    }
}
