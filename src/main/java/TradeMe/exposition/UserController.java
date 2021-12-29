package TradeMe.exposition;

import TradeMe.application.UserService;
import TradeMe.domain.Id;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
    public List<UserDTO> getAllUsers(){
        return this.userService.findAll();
    }

    @PostMapping(path="/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Add a user")
    public void addUser(@RequestBody @NotNull @Valid UserDTO user) {
        this.userService.createUser(user);
    }

    @GetMapping(value="/users/{id}", produces =  MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value="Get user by ID")
    public UserDTO getUserById(@PathVariable("id") String userId){
        return this.userService.findUserById(Id.of(Integer.valueOf(userId)));
    }

    @DeleteMapping(value = "/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value="Delete user by ID")
    public void deleteById(@PathVariable("id") String userId){
        int id = Integer.valueOf(userId);
        Id userID = Id.of(id);
        this.userService.deleteUser(userID);
    }

    @GetMapping(value="/users/{city}")
    @ResponseBody
    @ApiOperation("Get users in the same city")
    public List<UserDTO> getUserByCity(@PathVariable("city") String city){
        return this.userService.findByCity(city);
    }




}
