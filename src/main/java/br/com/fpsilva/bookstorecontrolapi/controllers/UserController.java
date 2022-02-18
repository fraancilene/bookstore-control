package br.com.fpsilva.bookstorecontrolapi.controllers;

import br.com.fpsilva.bookstorecontrolapi.dtos.BookDto;
import br.com.fpsilva.bookstorecontrolapi.dtos.UserDto;
import br.com.fpsilva.bookstorecontrolapi.models.BookModel;
import br.com.fpsilva.bookstorecontrolapi.models.UserModel;
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
    public ResponseEntity<List<UserModel>> getAllBooks(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getBookId(@PathVariable(value = "id") UUID id){
        Optional<UserModel> bookModelOptional = userService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(bookModelOptional.get());

    }

}
