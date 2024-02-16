package br.com.calleb.vendas.online.ConfigServerAlunos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigServerAlunosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerAlunosApplication.class, args);
	}
}
