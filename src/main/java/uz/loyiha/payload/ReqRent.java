package uz.loyiha.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.soap.SAAJResult;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReqRent {

    private UUID bookId;

    private String username;

    private String password;


}
