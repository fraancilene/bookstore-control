package br.com.fpsilva.bookstorecontrolapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
public class BookDto {

    @NotBlank
    private String name;
    @NotBlank
    private String genre;
    @NotBlank
    private String author;
}
