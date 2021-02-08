package uz.loyiha.projection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;
import uz.loyiha.entity.Book;
import uz.loyiha.entity.Client;

import java.util.List;
import java.util.UUID;


@Projection(types = Client.class, name = "clientProjection")
public interface ClientProjection {

    UUID getId();

   String getFull_name();

   Integer getAge();

   String getUsername();

   String getStatus();

   @Value("#{@clientService.getClientBalance(target)}")
   Double getBalance();

   @Value("#{@clientService.getBookListbyRentBook(target)}")
   List<Book> getBooks();


}
