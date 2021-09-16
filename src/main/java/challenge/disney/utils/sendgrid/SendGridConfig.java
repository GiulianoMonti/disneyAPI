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
