package lk.ijse.CWTech.cofig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author : Chanuka Weerakkody
 * @since : 20.1.1
 **/
@EnableWebMvc
@Configuration
@ComponentScan("lk.ijse.CWTech")
public class WebAppConfig {
}
