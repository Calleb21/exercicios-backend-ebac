package br.com.calleb.vendas.online;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * Description of ClienteServiceAlunosApplication
 * Created by calle on 09/02/2024.
 */
@SpringBootApplication
@RefreshScope
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class ClienteServiceAlunosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClienteServiceAlunosApplication.class, args);
    }
}
