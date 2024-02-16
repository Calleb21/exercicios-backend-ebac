package br.com.calleb.vendas.online.usercase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * Description of ProdutoServiceAlunosApplication
 * Created by calle on 16/02/2024.
 */
@SpringBootApplication
@RefreshScope
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class ProdutoServiceAlunosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProdutoServiceAlunosApplication.class, args);
    }
}
