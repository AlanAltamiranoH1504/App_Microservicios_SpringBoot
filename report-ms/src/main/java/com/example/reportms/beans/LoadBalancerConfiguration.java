package com.example.reportms.beans;

import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

//@Configuration
public class LoadBalancerConfiguration {

    @Bean
    public ServiceInstanceListSupplier serviceInstanceListSupplier(ConfigurableApplicationContext configurableApplicationContext) {
        String serviceId = configurableApplicationContext.getEnvironment().getProperty(LoadBalancerClientFactory.PROPERTY_NAME);

        return ServiceInstanceListSupplier
                .builder()
                .withBlockingDiscoveryClient()
                .withSameInstancePreference()
                .build(configurableApplicationContext);
    }
}
