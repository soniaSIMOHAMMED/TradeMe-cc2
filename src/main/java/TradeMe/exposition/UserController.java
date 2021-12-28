package TradeMe.exposition;

import TradeMe.domain.Id;
import TradeMe.domain.User;
import TradeMe.services.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@SuppressWarnings("unused")
@RestController
//@Api(tags = "User management")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/users")
    @ResponseBody
    @ApiOperation(value = "Get all users")
    public List<User> getAllUsers(){
        return this.userService.all();
    }

    @PostMapping(path="/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Add a user")
    public void addUser(@RequestBody @Valid User user) {
        user.setId(Id.of(1));
        this.userService.create(user);
    }

    @GetMapping(value="/users/{id}", produces =  MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value="Get user by ID")
    public User getUserById(@PathVariable("id") String userId){
        int id = Integer.valueOf(userId);
        Id userID = Id.of(id);
        return this.userService.getUserById(userID);
    }

    @DeleteMapping(value = "/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value="Delete user by ID")
    public void deleteById(@PathVariable("id") String userId){
        int id = Integer.valueOf(userId);
        Id userID = Id.of(id);
        this.userService.removeUser(userID);
    }




}
