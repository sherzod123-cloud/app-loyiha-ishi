package uz.loyiha.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReqFillBalance {

    private String username;

    private String password;

    private Double summa;

}
