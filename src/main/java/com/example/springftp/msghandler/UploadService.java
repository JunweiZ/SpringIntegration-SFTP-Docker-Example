package com.example.springftp.msghandler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.sftp.session.DefaultSftpSessionFactory;
import org.springframework.integration.sftp.session.SftpSession;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class UploadService {

    private final DefaultSftpSessionFactory sftpSessionFactory;

    @ServiceActivator(inputChannel = "toSftpChannel")
    public void uploadFile(File file){
        System.out.println(String.format("Uploading file... %s", file));

        SftpSession session = sftpSessionFactory.getSession();
        this.uploadFile111(file, session);

        System.out.println("File uploaded.");
    }

    private void uploadFile111(File file, SftpSession session) {

        String filename = String.format("%s_%s.txt", file.getName(),  LocalDateTime.now());
        String destination = String.format("%s%s", "incoming/upload/", filename);

        try {
            log.info("Write file to: " + destination);
            ByteArrayInputStream byteInputStream = new ByteArrayInputStream(FileUtils.readFileToByteArray(file));
            session.write(byteInputStream, destination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
