package co.com.dosman.service.VerboHttp.controllers;

import co.com.dosman.service.VerboHttp.dto.ErrorResponse;
import co.com.dosman.service.VerboHttp.dto.MessageResponse;
import co.com.dosman.service.VerboHttp.dto.UserRequest;
import co.com.dosman.service.VerboHttp.exceptions.UserException;
import co.com.dosman.service.VerboHttp.services.implementations.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user")
@RestController
public class UserController {
    private final UserService userService;

    @DeleteMapping(path = "/deleteUser/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteUser(@PathVariable String id) {
        try {
            return new ResponseEntity(MessageResponse.builder().message(userService.deleteUser(id)).build(), HttpStatus.OK);
        } catch (UserException ex) {
            return new ResponseEntity(ErrorResponse.builder().error(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "existsUserById/{id}", method = RequestMethod.HEAD)
    public ResponseEntity existsUserById(@PathVariable String id) {
        return userService.existsUserById(id) ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/getAllUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllUsers() {
        return new ResponseEntity(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping(path = "/getUserById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUserById(@PathVariable String id) {
        try {
            return new ResponseEntity(userService.getUserById(id), HttpStatus.OK);
        } catch (UserException ex) {
            return new ResponseEntity(ErrorResponse.builder().error(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping(path = "/patchUser/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity patchUser(@PathVariable String id, @RequestBody UserRequest userRequest) {
        try {
            return new ResponseEntity(userService.patchUser(id, userRequest), HttpStatus.OK);
        } catch (UserException ex) {
            return new ResponseEntity(ErrorResponse.builder().error(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/saveUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveUser(@RequestBody UserRequest userRequest) {
        try {
            return new ResponseEntity(userService.saveUser(userRequest), HttpStatus.CREATED);
        } catch (UserException ex) {
            return new ResponseEntity(ErrorResponse.builder().error(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "/updateUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateUser(@RequestBody UserRequest userRequest) {
        try {
            return new ResponseEntity(userService.updateUser(userRequest), HttpStatus.OK);
        } catch (UserException ex) {
            return new ResponseEntity(ErrorResponse.builder().error(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }
}
