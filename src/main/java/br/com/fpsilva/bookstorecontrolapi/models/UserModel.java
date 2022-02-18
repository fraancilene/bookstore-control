package br.com.fpsilva.bookstorecontrolapi.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@Setter
public class UserModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 50)
    private String fullName;

    @Column(nullable = false, length = 20)
    private String contact;

    @Column(nullable = false, length = 30)
    private String adress;
}
