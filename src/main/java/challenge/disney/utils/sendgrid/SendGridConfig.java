package challenge.disney.utils.sendgrid;

import com.sendgrid.SendGrid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SendGridConfig {

    @Value("${app.sendgrid.key")
    private String appKey;

    @Bean
    public SendGrid getSendGrid(){
        return new SendGrid("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");
    }

}
