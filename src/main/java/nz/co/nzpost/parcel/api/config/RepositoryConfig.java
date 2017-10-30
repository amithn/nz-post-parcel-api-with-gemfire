package nz.co.nzpost.parcel.api.config;

import nz.co.nzpost.parcel.api.usage.ParcelTrackingRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;


@Configuration
@EnableGemfireRepositories(basePackageClasses = {ParcelTrackingRepository.class})
public class RepositoryConfig {
}

