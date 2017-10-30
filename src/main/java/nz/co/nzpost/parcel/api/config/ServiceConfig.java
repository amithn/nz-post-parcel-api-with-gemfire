package nz.co.nzpost.parcel.api.config;

import nz.co.nzpost.parcel.api.util.TimeFormatConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("nz.co.nzpost")
public class ServiceConfig {

    @Bean
    TimeFormatConverter timestampToDateConverter() {
        return new TimeFormatConverter();
    }


}