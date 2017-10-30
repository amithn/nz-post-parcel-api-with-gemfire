package nz.co.nzpost.parcel.api.config;

import org.apache.geode.cache.client.ClientCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:client-cache-config-dev.xml")
public class CacheConfig {

    @Autowired
    public void cache(ClientCache clientCache) {
        System.out.println("Got the client cache");
    }
}
