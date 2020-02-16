package fileupload.controller;

import fileupload.service.LocalStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class UploadController {

    private LocalStorageService localStorageService;

    @Autowired
    public UploadController(LocalStorageService localStorageService) {
        this.localStorageService = localStorageService;
    }

    @GetMapping("/")
    public String index() {
        return "upload";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        String file = this.localStorageService.storeFile(multipartFile);

        System.out.println(file);

        return "redirect:/?message=Successful!";
    }
}
