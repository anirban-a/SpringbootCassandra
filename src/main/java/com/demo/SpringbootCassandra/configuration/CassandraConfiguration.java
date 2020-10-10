package com.demo.SpringbootCassandra.configuration;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.CqlSessionBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetSocketAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

@Configuration
public class CassandraConfiguration {
    Logger logger = Logger.getLogger(this.getClass().getName());
    @Bean
    @Qualifier("customCqlSession")
    public CqlSession getCqlSession(){
        logger.log(Level.INFO, "attempting to create CQL session");
        CqlSession cqlSession = null;
        final InetSocketAddress contactPoint = new InetSocketAddress("localhost", 9042);
        try {
            CqlSessionBuilder cqlSessionBuilder = new CqlSessionBuilder();
            // assuming we have a keyspace named "demo_ks" created.
            cqlSessionBuilder.withKeyspace("demo_ks");
            cqlSessionBuilder.addContactPoint(contactPoint);
            cqlSessionBuilder.withLocalDatacenter("datacenter1");
            cqlSession = cqlSessionBuilder.build();
        } catch (RuntimeException e) {
            logger.log(Level.SEVERE, "Some exception occurred in getting cqlSession");
        }
        return cqlSession;
    }
}
