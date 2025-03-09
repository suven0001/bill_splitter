package com.apt.billsplitter.configuration.beans;

import com.apt.billsplitter.business.AptBillSplitter;
import com.apt.billsplitter.business.impl.AptBillSplitterImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class AppConfig {

    @Bean
    public AptBillSplitter aptBillSplitter() {
        return new AptBillSplitterImpl();
    }

//    @Bean
//    public JavaMailSender javaMailSender() {
//        return new JavaMailSenderImpl();
//    }
}
