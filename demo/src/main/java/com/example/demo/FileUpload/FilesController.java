package com.example.demo.FileUpload;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("Files")
public class FilesController {

    @GetMapping("/file")
    public String fileUploadForm(){
        return "/fileUpload/fileUploadForm";
    }

    @PostMapping("/file")
    public String fileUpload(@RequestParam MultipartFile file , RedirectAttributes attributes){
        // save
        String msg = file.getOriginalFilename() + "is upload";
        System.out.println("msg = " + msg );
        attributes.addFlashAttribute("msg" , msg);

        return "redirect:/Files/file";
    }
}
