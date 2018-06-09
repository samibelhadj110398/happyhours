package com.reservation.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.reservation.dao.EtablissementDao;
import com.reservation.dao.ImageDao;
import com.reservation.model.Etablissement;
import com.reservation.model.Image;
import com.reservation.service.EtablissementService;
import com.reservation.service.impl.StorageService;


@Controller
@CrossOrigin(origins = "*")

public class UploadController {

	@Autowired
	StorageService storageService;
	@Autowired
	EtablissementDao etablissementDao;
	@Autowired
	EtablissementService etablissementService;
	private Path etabLocation ;
	private final Path rootLocation = Paths.get("upload-dir");
	@Autowired
    private ImageDao imageDao;	
	List<String> files = new ArrayList<String>();
	
	List<String> ListImages = new ArrayList<String>();

	Etablissement e;

	
	
	
	@PostMapping("api/saveImage")
	public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
		String message = "";

		try {
			String nomFile = storageService.store(file);
			files.add(nomFile);

			message = "You successfully uploaded " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			message = "FAIL to upload " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}
	@PostMapping("api/saveImageCh")
	public ResponseEntity<String> handleFileUploadCh(@RequestParam("file") MultipartFile file) {
		String message = "";

		try {
			String nomFile = storageService.storeCh(file);
			files.add(nomFile);

			message = "You successfully uploaded " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			message = "FAIL to upload " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}
	@GetMapping("api/getallfiles")
	public ResponseEntity<List<String>> getListFiles(Model model) {
		List<String> fileNames = files
				.stream().map(fileName -> MvcUriComponentsBuilder
						.fromMethodName(UploadController.class, "getFile", fileName).build().toString())
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(fileNames);
	}
	
	

	@GetMapping("api/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> getFile(@PathVariable String filename) {
		Resource file = storageService.loadFile(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}
	
	
	
	
	
	
	
	@RequestMapping(value="api/saveEtapfiles/{id_etab}", method = RequestMethod.POST)
    public void saveEtapfiles(
    		@PathVariable(value = "id_etab") Long id_etab
    		){		
		List<Image> LImages = new ArrayList<Image>();
		Etablissement etab =  etablissementDao.findOne(id_etab);
		etabLocation = Paths.get("image_etab");
		Image image;
		try {
			File source = new File(rootLocation.normalize().toString());
			File dest = new File(etabLocation.normalize().toString());			
		    FileUtils.copyDirectory(source, dest);  
		    for (int i = 0; i < files.size(); i++) {
				 image = new Image();
		    	image.setTitre("images_"+etab.getId()+etab.getNom()+"/"+files.get(i));
				imageDao.save(image);
				LImages.add(image);
			}
		    files.clear();
		    storageService.deleteAll();
		    storageService.init();
		} catch (IOException e) {
		    e.printStackTrace();
		}		
		etab.setImages(LImages);			
		etablissementDao.save(etab);
	}

	
	 
	 @RequestMapping(value="api/supp", method = RequestMethod.GET)
	    public void supp(){
		 files.clear();
		 storageService.deleteAll();
			storageService.init();	
	    }
	    
	 @GetMapping("api/getallfilesEtab/{id_etab}")
	 public ResponseEntity<List<String>> getListFilesEtab(Model model,@PathVariable Long id_etab) {
			ListImages = imageDao.allImageByEtab(id_etab);
			e = etablissementDao.findOne(id_etab);
		 List<String> fileNames = ListImages
					.stream().map(fileName -> MvcUriComponentsBuilder
							.fromMethodName(UploadController.class, "filesEtab", fileName).build().toString())
					.collect(Collectors.toList());

			return ResponseEntity.ok().body(fileNames);
		}
	 
	 @GetMapping("api/filesEtab/{id_image}")
		@ResponseBody
		public ResponseEntity<Resource>  filesEtab(@PathVariable long id_image) {
		
		 
		 Image img = imageDao.findOne(id_image);		 
		 String string = img.getTitre();		 
		 System.out.println(string);
		 String[] parts = string.split("/");
		 String part1 = parts[0]; 
		 System.out.println(part1);

		 String filename = parts[1]; 
		 System.out.println(filename);
		 try {
				Path rootLocal = Paths.get(part1);
				Path file = rootLocal.resolve(filename);
				Resource resource = new UrlResource(file.toUri());
				if (resource.exists() || resource.isReadable()) {
					return ResponseEntity.ok()
							.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
							.body(resource);
				} else {
					throw new RuntimeException("FAIL!");
				}
			} catch (MalformedURLException e) {
				throw new RuntimeException("FAIL!");
			}
		}
	 
	 

	
		
	 
	 
	
	    
	
}
