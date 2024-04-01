package com.kaisikk.java.springdatabase.controller;

import com.kaisikk.java.springdatabase.model.Image;
import com.kaisikk.java.springdatabase.repo.ImageRepo;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("/image")
public class ImageController {


    private ImageRepo imageRepo;

    @Autowired
    public void setImageRepo(ImageRepo imageRepo) {
        this.imageRepo = imageRepo;
    }

    @GetMapping
    public String getFormToLoadImage(Model model) {

        model.addAttribute("message", "Maximum 5MB");

        return "image";
    }

    @PostMapping
    public String loadImage(@RequestParam("description") String description,
                            @RequestParam("file") MultipartFile file) throws IOException {

        Byte[] byArray = new Byte[file.getBytes().length];
        int i = 0;
        for (byte b : file.getBytes()) byArray[i++] = b;

        Image image = new Image();
        image.setDescription(description);
        image.setImage(byArray);
        imageRepo.save(image);
        return "redirect:image";
    }

    @GetMapping("/{id}")
    public void renderImage(@PathVariable("id") String id, HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg");

        Image image = imageRepo.findById(Long.valueOf(id)).get();
        byte[] byArray = new byte[image.getImage().length];

        int i = 0;
        for (byte b : image.getImage()) byArray[i++] = b;
        InputStream is = new ByteArrayInputStream(byArray);
        IOUtils.copy(is, response.getOutputStream());
    }


}
