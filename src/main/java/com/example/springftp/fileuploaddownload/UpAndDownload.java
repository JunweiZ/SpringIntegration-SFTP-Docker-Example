package com.example.springftp.fileuploaddownload;

import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class UpAndDownload {

//    private final DefaultSftpSessionFactory sessionFactory;
//
//    public void upload(){
//
//        SftpSession session = sessionFactory.getSession();
//        InputStream resourceAsStream =
//                UpAndDownload.class.getClassLoader().getResourceAsStream("mytextfile.txt");
//        try {
//            session.write(resourceAsStream, "upload/mynewfile" + LocalDateTime.now() +".txt");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        session.close();
//    }
//
//
//    public String download(){
//        SftpSession session = sessionFactory.getSession();
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        try {
//            session.read("upload/downloadme.txt", outputStream);
//            return new String(outputStream.toByteArray());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//    }


}
