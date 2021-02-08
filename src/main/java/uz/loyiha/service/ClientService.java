package uz.loyiha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.loyiha.entity.Balance;
import uz.loyiha.entity.Book;
import uz.loyiha.entity.Client;
import uz.loyiha.entity.RentBook;
import uz.loyiha.repository.BalanceRepository;
import uz.loyiha.repository.ClientRepository;
import uz.loyiha.repository.RentBookRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class ClientService {

    @Autowired
    BalanceRepository balanceRepository;

    @Autowired
    RentBookRepository rentBookRepository;

    public Double getClientBalance(Client client){
        List<Balance> balances = balanceRepository.findAllByClient(client);
        Double clientBalance=0d;
        for (Balance balance : balances) {
            clientBalance+=balance.getSumma();
        }
        List<RentBook> rentBookList = rentBookRepository.findAllByClient(client);
        Double rentSumma=0d;
        for (RentBook rentBook : rentBookList) {
            rentSumma+=rentBook.getBook().getRent_price();
        }
        return clientBalance-rentSumma;
    }
    public List<Book> getBookListbyRentBook(Client client){
        List<RentBook> allByClient = rentBookRepository.findAllByClient(client);
        List<Book> bookList=new ArrayList<>();
        for (RentBook rentBook : allByClient) {
            bookList.add(rentBook.getBook());
        }return bookList;
    }



}
