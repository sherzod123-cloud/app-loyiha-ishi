package uz.loyiha.loader;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Value("${spring.datasource.initialization-mode}")
    private String initMode;

    @Override
    public void run(String... args) throws Exception {
     if (initMode.equals("always")){

        }
    }
}
