package com.demo.SpringbootCassandra;

import com.datastax.oss.driver.api.core.CqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ConfigurationTests {

    @Qualifier ("customCqlSession")
    @Autowired
    CqlSession cqlSession;

    @Test
    public void test(){
        assertNotNull(cqlSession);
    }
}
