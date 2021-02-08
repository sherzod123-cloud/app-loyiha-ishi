package uz.loyiha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.loyiha.entity.Client;
import uz.loyiha.projection.ClientProjection;

import java.util.Optional;
import java.util.UUID;

@RepositoryRestResource(path = "client", excerptProjection = ClientProjection.class)
public interface ClientRepository extends JpaRepository<Client, UUID> {

    Optional<Client> findByUsernameAndPassword(String username, String password);


}
