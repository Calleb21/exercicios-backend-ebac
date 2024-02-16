package br.com.calleb.vendas.onlineconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * Description of ValidatorConfig
 * Created by calle on 09/02/2024.
 */
@Configuration
public class ValidatorConfig {

//	@Autowired
//    ResourceBundleMessageSource messageSource;

    @Bean
    public Validator validatorFactory() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
//	    bean.setValidationMessageSource(messageSource);
        return bean;
    }
}
