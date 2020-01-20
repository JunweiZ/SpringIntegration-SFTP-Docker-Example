package com.example.springftp.services;

import com.example.springftp.domain.FileNotFoundException;
import com.example.springftp.domain.FileResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static java.lang.String.format;
import static java.time.format.DateTimeFormatter.ofPattern;
import static java.util.Collections.reverseOrder;

@Service
@RequiredArgsConstructor
@Slf4j
public class FileService {

    private final SFTPServerGateway sftpServerGateway;

    private final String UPLOAD_PATH = "/opt/upload/";
    private final String FILENAME_PREFIX = "sftpservice_testfile_";
    private final String FILENAME_POSTFIX = ".txt";

    @SneakyThrows
    public FileResponse uploadFile() {
        String datetime = LocalDateTime.now().format(ofPattern("yyyy-MM-dd_HH:mm:ss"));
        String fullFilename = UPLOAD_PATH + FILENAME_PREFIX + datetime + FILENAME_POSTFIX;

        File file = new File(fullFilename);
        FileUtils.writeStringToFile(file, format("Test record asdasdas; timestamp is [%s]", datetime), "utf-8");

        sftpServerGateway.upload(file);
        cleanupUploadFolder();

        return new FileResponse(FILENAME_PREFIX + datetime + FILENAME_POSTFIX, "File uploaded.", datetime);
    }

    @SneakyThrows
    public FileResponse downloadFile(String filename) {
        String datetime = LocalDateTime.now().format(ofPattern("yyyy-MM-dd_HH:mm:ss"));
        File targetFile = new File(UPLOAD_PATH + filename);

        FileUtils.copyInputStreamToFile(sftpServerGateway.download(filename), targetFile);
        String fileContent = FileUtils.readFileToString(targetFile, "UTF-8");
        cleanupUploadFolder();

        return new FileResponse(filename, fileContent, datetime);
    }

    public FileResponse downloadLast() {
        return downloadFile(getLastUploadedFileName());
    }

    public List<String> getFileList() {
        return sftpServerGateway.filelist("");
    }

    private String getLastUploadedFileName() {
        List<String> fileList = Optional.ofNullable(getFileList())
                .orElseThrow(() -> new FileNotFoundException("No files found!"));

        String lastUploadDateTime = fileList.stream()
                .filter(value -> value.endsWith(FILENAME_POSTFIX))
                .map(value -> value.split(FILENAME_POSTFIX)[0])
                .map(value -> value.split(FILENAME_PREFIX)[1])
                .map(value -> LocalDateTime.parse(value, ofPattern("yyyy-MM-dd_HH:mm:ss")))
                .sorted(reverseOrder())
                .map(value -> value.format(ofPattern("yyyy-MM-dd_HH:mm:ss")))
                .findFirst().get();

        return fileList.stream().filter(value -> value.contains(lastUploadDateTime)).findFirst().get();
    }

    @SneakyThrows
    private void cleanupUploadFolder() {
        FileUtils.cleanDirectory(new File(UPLOAD_PATH));
    }
}
