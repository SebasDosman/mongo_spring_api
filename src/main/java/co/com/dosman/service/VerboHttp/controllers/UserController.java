package co.com.dosman.service.VerboHttp.controllers;

import co.com.dosman.service.VerboHttp.dto.*;
import co.com.dosman.service.VerboHttp.exceptions.UserException;
import co.com.dosman.service.VerboHttp.services.implementations.UserService;
import jakarta.validation.Valid;
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
            return new ResponseEntity(MessageDTO.builder().message(userService.deleteUser(id)).build(), HttpStatus.OK);
        } catch (UserException ex) {
            return new ResponseEntity(ErrorDTO.builder().error(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/existsUserById/{id}", method = RequestMethod.HEAD)
    public ResponseEntity existsUserById(@PathVariable String id) {
        return new ResponseEntity(userService.getUserHeaderById(id), HttpStatus.OK);
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
            return new ResponseEntity(ErrorDTO.builder().error(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/optionsUser", method = RequestMethod.OPTIONS)
    public ResponseEntity optionsUser() {
        return new ResponseEntity(userService.optionsUser(), HttpStatus.OK);
    }

    @PatchMapping(path = "/patchUser/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity patchUser(@PathVariable String id, @Valid @RequestBody UpdateUserDTO updateUserDTO) {
        try {
            return new ResponseEntity(userService.patchUser(id, updateUserDTO), HttpStatus.OK);
        } catch (UserException ex) {
            return new ResponseEntity(ErrorDTO.builder().error(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/saveUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveUser(@Valid @RequestBody CreateUserDTO createUserDTO) {
        try {
            return new ResponseEntity(userService.saveUser(createUserDTO), HttpStatus.CREATED);
        } catch (UserException ex) {
            return new ResponseEntity(ErrorDTO.builder().error(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "/updateUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateUser(@Valid @RequestBody UpdateUserDTO updateUserDTO) {
        try {
            return new ResponseEntity(userService.updateUser(updateUserDTO), HttpStatus.OK);
        } catch (UserException ex) {
            return new ResponseEntity(ErrorDTO.builder().error(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }
}
