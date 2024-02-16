package br.com.calleb.vendas.online.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Description of MongoConfig
 * Created by calle on 16/02/2024.
 */
@Configuration
@EnableMongoRepositories(basePackages = "br.com.calleb.vendas.online.repository")
public class MongoConfig {
}
