package com.investree.sandboxing.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.ConnectionFactory;

@Configuration
@EnableJms
public class JMSConfig {
    @Value("${activemq.broker-url}")
    private String brokerUrl;

    @Bean
    public DefaultJmsListenerContainerFactory transaksiJmsContFactory(
            DefaultJmsListenerContainerFactoryConfigurer configurer
    ) {
        DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
        containerFactory.setPubSubDomain(true);
        containerFactory.setConnectionFactory(connectionFactory());
        containerFactory.setConcurrency("1");
//        containerFactory.setSubscriptionShared(true);
        containerFactory.setMessageConverter(jacksonJmsMsgConverter());
        containerFactory.setSubscriptionDurable(true);

        return containerFactory;
    }
    @Bean
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory factory = new CachingConnectionFactory();
        ActiveMQConnectionFactory activeMQConnFactory = new ActiveMQConnectionFactory();
        activeMQConnFactory.setBrokerURL(brokerUrl);
        factory.setTargetConnectionFactory(activeMQConnFactory);
        factory.setClientId("client123");
        return factory;
    }
    @Bean
    public MessageConverter jacksonJmsMsgConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }
}
