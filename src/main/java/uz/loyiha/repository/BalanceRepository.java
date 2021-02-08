package uz.loyiha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import uz.loyiha.entity.Balance;
import uz.loyiha.entity.Client;

import java.util.List;
import java.util.UUID;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, UUID> {

    List<Balance> findAllByClient(Client client);

}
