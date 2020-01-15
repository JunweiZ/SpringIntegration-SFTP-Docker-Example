package com.example.springftp.msghandler;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

import java.io.File;

@MessagingGateway
public interface UploadGateway {
    @Gateway(requestChannel = "toSftpChannel")
    void upload(File file);
}
