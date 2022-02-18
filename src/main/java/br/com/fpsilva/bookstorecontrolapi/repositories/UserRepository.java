package br.com.fpsilva.bookstorecontrolapi.repositories;

import br.com.fpsilva.bookstorecontrolapi.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
}
