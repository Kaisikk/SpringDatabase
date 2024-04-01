package com.kaisikk.java.springdatabase.config;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@ControllerAdvice
public class FileUploadExceptionAdvice {

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public String handleMaxSizeException(Model model) {
        model.addAttribute("message", "File too large for us! (Maximum 5 MB)");
        return "image";
    }

}
