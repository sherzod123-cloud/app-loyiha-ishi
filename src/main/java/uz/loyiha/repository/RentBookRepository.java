package uz.loyiha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.loyiha.entity.Client;
import uz.loyiha.entity.RentBook;

import java.util.List;
import java.util.UUID;

public interface RentBookRepository  extends JpaRepository<RentBook, UUID> {

    List<RentBook> findAllByClient(Client client);

}
