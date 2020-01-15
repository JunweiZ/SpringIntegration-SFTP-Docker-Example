package com.example.springftp.fileuploaddownload;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
//@RequiredArgsConstructor
@Service
public class UploadMultipleFiles {

//    private final DefaultSftpSessionFactory sessionFactory;
//
//    public static final String DONE_FOLDER = "incoming/upload/done_batch/";
//    private static final String INPROGRESS_FOLDER = "incoming/upload/beinguploaded/";
//
//    public void uploadMultipleFiles(){
//        SftpSession session = sessionFactory.getSession();
//        for (int i = 0; i < 100; i++) {
//            String content = String.format("This is a test! Trlalala. Test no: %s", i);
//            String filename = String.format("fileno%s",i);
//            upload(content, filename, session);
//        }
//        session.close();
//    }
//
//    private void upload(String content, String originalFilename, SftpSession session){
//
//        String filename = String.format("%s_%s.txt", originalFilename,  LocalDateTime.now());
//        String destination = String.format("%s%s", INPROGRESS_FOLDER, filename);
//        String donedestination = String.format("%s%s",DONE_FOLDER, filename);
//
//        try {
//            log.info("Write file to: " + destination);
//            ByteArrayInputStream byteInputStream = new ByteArrayInputStream(content.getBytes());
//            session.write(byteInputStream, destination);
//
//            log.info("Rename file to: " + donedestination);
//            session.rename(destination, donedestination);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
