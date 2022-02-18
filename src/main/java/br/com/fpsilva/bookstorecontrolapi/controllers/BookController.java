package br.com.fpsilva.bookstorecontrolapi.controllers;

import br.com.fpsilva.bookstorecontrolapi.dtos.BookDto;
import br.com.fpsilva.bookstorecontrolapi.models.BookModel;
import br.com.fpsilva.bookstorecontrolapi.services.BookService;
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
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Object> saveBook(@RequestBody @Valid BookDto bookDto){
        var bookModel = new BookModel();
        BeanUtils.copyProperties(bookDto,bookModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.save(bookModel));
    }

    @GetMapping
    public ResponseEntity<List<BookModel>> getAllBooks(){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookModel> getBookId(@PathVariable(value = "id") UUID id){
        Optional<BookModel> bookModelOptional = bookService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(bookModelOptional.get());

    }
}
