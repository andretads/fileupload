package fileupload.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class LocalStorageService {

    public String storeFile(MultipartFile multipartFile) throws IOException {
        String fileName = String.format("%s%s", UUID.randomUUID().toString(), multipartFile.getOriginalFilename());

        multipartFile.transferTo(new File("/tmp/" + fileName));

        return fileName;
    }
}
