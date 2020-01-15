package com.example.springftp;

import com.example.springftp.msghandler.UploadGateway;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final UploadGateway uploadGateway;

    @GetMapping("/test")
    public ResponseEntity<?> test() throws IOException {
        File file = new File("UPLOAD_TEST");
        FileUtils.write(file, "test value 12345", "utf-8");
        uploadGateway.upload(file);

        return ok("File uploaded.");
    }

}
