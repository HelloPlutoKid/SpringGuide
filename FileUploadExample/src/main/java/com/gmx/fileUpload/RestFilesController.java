package com.gmx.fileUpload;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;

@RestController
@RequestMapping("restfiles")
public class RestFilesController {

	@Value("${file.path}")
	private String file_Path;

	private static final Logger logger = LoggerFactory.getLogger(RestFilesController.class);
	
	// ���� ���� ���ε� 
	@PostMapping("/fileUpload")
	public String fileUpload(@RequestParam(required = false) MultipartFile file,
			@RequestParam(defaultValue = "test") String name) {
		if (file != null) {
			System.out.println("file.getSize() = "+ file.getSize());
			
			String msg = file.getOriginalFilename() + "is upload";
			
			// File.seperator �� OS�������̴�.
			// Spring���� �����ϴ� cleanPath()�� ���ؼ� ../ ���� ���鿡 ���ؼ� ����� �����Ѵ�
			Path copyOfLocation = Paths
					.get(file_Path + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
			try {
				// inputStream�� �����ͼ�
				// copyOfLocation (������ġ)�� ������ ����.
				// copy�� �ɼ��� ������ �����ϸ� REPLACE(��ü�Ѵ�), �������̵� �Ѵ�
				Files.copy(file.getInputStream(), copyOfLocation, StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "upload is complete";
	}
	
	
	// ��Ƽ ���� ���ε� 
	@PostMapping("/multiFileUpload")
	public String multiFileUpload(
			@RequestParam(required = false) MultipartFile[] files,
			@RequestParam(defaultValue = "test") String name) {
		
		HashMap<String, String> result = new HashMap<String, String>();
		Gson gson = new Gson();
		
		if (files != null) {
			for(MultipartFile file : files) {
				String msg = file.getOriginalFilename() + "is upload";
				System.out.println("name = " + name);
				System.out.println("msg = " + msg);

				// File.seperator �� OS�������̴�.
				// Spring���� �����ϴ� cleanPath()�� ���ؼ� ../ ���� ���鿡 ���ؼ� ����� �����Ѵ�
				Path copyOfLocation = Paths
						.get(file_Path + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
				try {
					// inputStream�� �����ͼ�
					// copyOfLocation (������ġ)�� ������ ����.
					// copy�� �ɼ��� ������ �����ϸ� REPLACE(��ü�Ѵ�), �������̵� �Ѵ�
					Files.copy(file.getInputStream(), copyOfLocation, StandardCopyOption.REPLACE_EXISTING);
					result.put(file.getOriginalFilename(), "completed");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return gson.toJson(result);
	}
}
