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
@Entity(name = "balance")
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    private Double summa;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdAt;

    public Balance(Client client, Double summa) {
        this.client = client;
        this.summa = summa;
    }
}
