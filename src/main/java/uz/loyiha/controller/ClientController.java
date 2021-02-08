package uz.loyiha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.loyiha.entity.Balance;
import uz.loyiha.entity.Book;
import uz.loyiha.entity.Client;
import uz.loyiha.entity.RentBook;
import uz.loyiha.model.Result;
import uz.loyiha.payload.ReqFillBalance;
import uz.loyiha.payload.ReqRent;
import uz.loyiha.repository.BalanceRepository;
import uz.loyiha.repository.BookRepository;
import uz.loyiha.repository.ClientRepository;
import uz.loyiha.repository.RentBookRepository;
import uz.loyiha.service.ClientService;

import java.util.Optional;

@RestController
@RequestMapping("/shop")
public class ClientController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    RentBookRepository rentBookRepository;

    @Autowired
    BalanceRepository balanceRepository;

    @Autowired
    ClientService clientService;

    @PostMapping("/rent/")
    public Result rentBook(@RequestBody ReqRent reqRent){
     if (bookRepository.existsById(reqRent.getBookId())){
         Optional<Client> byUsername = clientRepository.findByUsernameAndPassword(reqRent.getUsername(), reqRent.getPassword());
         if (byUsername.isPresent()){
             Client client = byUsername.get();
             Book book = bookRepository.getOne(reqRent.getBookId());
             if (clientService.getClientBalance(client)>= book.getRent_price()){
              rentBookRepository.save(new RentBook(book, client));
              clientService.getBookListbyRentBook(client);
               return new Result(true, "Book successfully rented!");
             }else {
                 return new Result(false, "Refill your balance");
             }
         }
         else {
             return new Result(false, "Username or password is wrong!");
         }
     }else {
         return new Result(false, "Book with id" + reqRent.getBookId() + " is not exist");
     }
    }
    @PostMapping("/fill/balance")
    public Result fillClientBalance(@RequestBody ReqFillBalance reqFillBalance){
        Optional<Client> byUsernameAndPassword = clientRepository.findByUsernameAndPassword(reqFillBalance.getUsername(), reqFillBalance.getPassword());
        if (byUsernameAndPassword.isPresent()){
            Client client = byUsernameAndPassword.get();
            balanceRepository.save(new Balance(client, reqFillBalance.getSumma()));
            return new Result(true, "Balance filled!");
        }else {
            return new Result(false, "Username or password is wrong!");
        }
    }
}
