package com.example.springftp.services;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

import java.io.File;
import java.io.InputStream;
import java.util.List;

@MessagingGateway
public interface SFTPServerGateway {

    @Gateway(requestChannel = "toSftpChannel")
    void upload(File file);

    @Gateway(requestChannel = "fromSftpChannel")
    InputStream download(String filename);

    @Gateway(requestChannel = "lsChannel")
    List<String> filelist(String directory);
}
