package lk.ijse.CWTech.cofig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author : Chanuka Weerakkody
 * @since : 20.1.1
 **/
@Configuration
@Import(JPAConfig.class)
public class WebRootConfig {
}
