package br.com.fpsilva.bookstorecontrolapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {

    @NotBlank
    private String fullName;

    @NotBlank
    private String Contact;

    @NotBlank
    private String adress;
}
