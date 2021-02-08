package uz.loyiha.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RentBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne
    private Book book;

    @ManyToOne
    private Client client;

    @CreationTimestamp
    @Column(nullable = false)
    private Timestamp createdAt;

    public RentBook(Book book, Client client) {
        this.book = book;
        this.client = client;
    }
}
