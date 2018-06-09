package com.reservation.service.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageService {

	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	private final Path rootLocation = Paths.get("upload-dir");
	private final Path rootLocationCh = Paths.get("upload-dir-Ch");

	private final Path rootLocationEtab = Paths.get("image_etab");

	private   ResourceLoader resourceLoader;


	public String store(MultipartFile file) {
		try {
			
			
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(Calendar.getInstance().getTime());
			
			Files.copy(file.getInputStream(), this.rootLocation.resolve(timeStamp.concat(getFileExtension(file.getOriginalFilename()))));
			return timeStamp.concat(getFileExtension(file.getOriginalFilename()));

		} catch (Exception e) {
			throw new RuntimeException("FAIL!");
		}
		
	}

	public String storeCh(MultipartFile file) {
		try {
			
			
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(Calendar.getInstance().getTime());
			
			Files.copy(file.getInputStream(), this.rootLocationCh.resolve(timeStamp.concat(getFileExtension(file.getOriginalFilename()))));
			return timeStamp.concat(getFileExtension(file.getOriginalFilename()));

		} catch (Exception e) {
			throw new RuntimeException("FAIL!");
		}
		
	}
	public Resource loadFile(String filename) {
		try {
			Path file = rootLocationEtab.resolve(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("FAIL!");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("FAIL!");
		}
	}
	
	public Resource loadFileEtab(String filename,String rootLocation2) {
		return resourceLoader.getResource("file:"+rootLocation2+"/"+filename);
		
		
	}
	


	public void deleteAll() {
		FileSystemUtils.deleteRecursively(rootLocation.toFile());
		FileSystemUtils.deleteRecursively(rootLocationCh.toFile());

	}

	public void init() {
		try {
			Files.createDirectory(rootLocation);
			Files.createDirectory(rootLocationCh);
			
		} catch (IOException e) {
			throw new RuntimeException("Could not initialize storage!");
		}
	}
	 private static String getFileExtension(String fileName) {
	        
	        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
	        return "."+fileName.substring(fileName.lastIndexOf(".")+1);
	        else return "";
	    }
}
