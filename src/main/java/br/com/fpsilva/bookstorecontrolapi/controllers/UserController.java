package br.com.fpsilva.bookstorecontrolapi.controllers;

import br.com.fpsilva.bookstorecontrolapi.dtos.BookDto;
import br.com.fpsilva.bookstorecontrolapi.dtos.UserDto;
import br.com.fpsilva.bookstorecontrolapi.models.BookModel;
import br.com.fpsilva.bookstorecontrolapi.models.UserModel;
import br.com.fpsilva.bookstorecontrolapi.services.BookService;
import br.com.fpsilva.bookstorecontrolapi.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Object> saveBook(@RequestBody @Valid UserDto userDto){
        var userModel = new UserModel();
        BeanUtils.copyProperties(userDto,userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
    }

    @GetMapping
    public ResponseEntity<List<UserModel>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getUserId(@PathVariable(value = "id") UUID id){
        Optional<UserModel> bookModelOptional = userService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(bookModelOptional.get());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") UUID id){
        Optional<UserModel> userModelOptional = userService.findById(id);
        // validação
        if (!userModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
        }

        userService.delete(userModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable(value = "id") UUID id, @RequestBody @Valid UserDto userDto){
        Optional<UserModel> userModelOptional = userService.findById(id);

        // validação
        if (!userModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
        }

        var userModel = new UserModel();
        BeanUtils.copyProperties(userDto, userModel);
        userModel.setId(userModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(userService.save(userModel));

    }

}
