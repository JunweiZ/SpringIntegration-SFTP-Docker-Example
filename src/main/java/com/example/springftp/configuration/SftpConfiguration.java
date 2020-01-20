package com.example.springftp.configuration;

import com.jcraft.jsch.ChannelSftp;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.file.remote.session.CachingSessionFactory;
import org.springframework.integration.file.remote.session.SessionFactory;
import org.springframework.integration.sftp.session.DefaultSftpSessionFactory;

@Configuration
@ConfigurationProperties(prefix = "sftp")
@Getter
@Setter
public class SftpConfiguration {

    private String host;
    private int port;
    private String user;
    private String password;

    @Bean
    public SessionFactory<ChannelSftp.LsEntry> sftpSessionFactory() {
        DefaultSftpSessionFactory factory = new DefaultSftpSessionFactory(true);
        factory.setHost(host);
        factory.setPort(port);
        factory.setUser(user);
        factory.setPassword(password);
        factory.setAllowUnknownKeys(true);
        CachingSessionFactory<ChannelSftp.LsEntry> cachingSessionFactory = new CachingSessionFactory<>(factory);
        cachingSessionFactory.setPoolSize(10);
        cachingSessionFactory.setSessionWaitTimeout(10000);
        return cachingSessionFactory;
    }

//    @Bean
//    public DefaultSftpSessionFactory sftpSessionFactory() {
//        DefaultSftpSessionFactory factory = new DefaultSftpSessionFactory();
//        factory.setHost(host);
//        factory.setPort(port);
//        factory.setUser(user);
//        factory.setPassword(password);
//        factory.setAllowUnknownKeys(true);
//        return factory;
//    }
}
