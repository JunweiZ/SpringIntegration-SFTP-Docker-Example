package com.example.springftp.fileuploaddownload;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@RequiredArgsConstructor
public class DownloadMultipleFiles {

//    private final DefaultSftpSessionFactory sessionFactory;
//
//    private void saveFileToDisk(String originalFileName, SftpSession session ) throws IOException {
//        String fileLocation = String.format("%s%s", UploadMultipleFiles.DONE_FOLDER, originalFileName);
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        session.read(fileLocation, outputStream);
//        String data = new String(outputStream.toByteArray());
//        File download = new File(String.format("download/%s", originalFileName));
//        FileUtils.write(download, data, Charset.forName("UTF-8"));
//    }
//
//    public void downloadMultipleFiles(){
//        SftpSession session = sessionFactory.getSession();
//
//        try {
//            ChannelSftp.LsEntry[] list = session.list(UploadMultipleFiles.DONE_FOLDER);
//            for (ChannelSftp.LsEntry lsEntry : list){
//                if (lsEntry.getFilename().endsWith(".txt") == false)
//                    continue;
//                log.info(String.format("We found the file: %s - %s", lsEntry.getFilename(), lsEntry.getLongname()));
////                log.info(String.format("Attributes: %s", lsEntry.getAttrs()));
//                saveFileToDisk(lsEntry.getFilename(), session);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }


}
