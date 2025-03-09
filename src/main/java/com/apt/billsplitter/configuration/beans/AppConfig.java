package com.apt.billsplitter.configuration.beans;

import com.apt.billsplitter.business.AptBillSplitter;
import com.apt.billsplitter.business.impl.AptBillSplitterImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public AptBillSplitter aptBillSplitter() {
        return new AptBillSplitterImpl();
    }
}
