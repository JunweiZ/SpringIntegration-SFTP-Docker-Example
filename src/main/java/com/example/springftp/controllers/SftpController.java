package com.example.springftp.controllers;

import com.example.springftp.services.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@Slf4j
public class SftpController {

    private final FileService fileService;

    @GetMapping("/upload")
    public ResponseEntity<?> upload() {
        return ok(fileService.uploadFile());
    }

    @GetMapping({"/download", "/download/{filename}"})
    public ResponseEntity<?> download(@PathVariable("filename") Optional<String> filename) {
        return ok(filename.isPresent()
                ? fileService.downloadFile(filename.get())
                : fileService.downloadLast());
    }

    @GetMapping("/filelist")
    public ResponseEntity<?> filelist() {
        return ok(fileService.getFileList());
    }


}
