package com.movie.controller;

import java.io.File;

import java.io.FileInputStream;

import java.io.InputStream;

import java.nio.file.Files;

import java.util.UUID;

 

import javax.annotation.Resource;

 

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.http.HttpHeaders;

import org.springframework.http.HttpStatus;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.movie.util.MimeMediaUtil;
import com.movie.util.UploadFileUtils;

@Controller
public class UploadController {

	//@Resource(name="uploadPath")
	//private String uploadPath;
	private String uploadPath = "C:\\Users\\14Z950\\Desktop\\java_programing\\uploadTest";

	private static final Logger logger= LoggerFactory.getLogger(UploadController.class);

	@RequestMapping(value="/uploadForm", method=RequestMethod.POST)
	public String uploadFormPost(MultipartFile file, Model model) throws Exception{
		
		logger.info("OriginalFilename: "+file.getOriginalFilename());
		logger.info("Size: "+file.getSize());
		logger.info("ContentType:"+file.getContentType());

		String savedName = uploadFile(file.getOriginalFilename(), file.getBytes());

		model.addAttribute("savedName",savedName);

		return "uploadResult";
	}

	private String uploadFile(String originalName, byte[] fileData) throws Exception{

		// Universally Unique Identifier : 범용 고유 식별자
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString()+"_"+originalName;

		File target = new File(uploadPath, savedName);

		FileCopyUtils.copy(fileData, target);

		return savedName;
	}

	

	@RequestMapping(value="/uploadAjax", method=RequestMethod.GET)
	public void uploadAjax() {
		logger.info("uploadFormGet:");
	}
	/*
	@ResponseBody
	@RequestMapping(value="/uploadAjax", method=RequestMethod.POST, produces="text/plain; charset=UTF-8")
	public ResponseEntity<String> uploadAjaxPost(MultipartFile file) throws Exception{
		logger.info("OriginalFilename: "+file.getOriginalFilename());
		logger.info("Size: "+file.getSize());
		logger.info("ContentType:"+file.getContentType());

		return new ResponseEntity<>(UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes()), HttpStatus.CREATED);
	}
	*/
	/*
	@ResponseBody
	@RequestMapping(value="/displayFile")
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception{
		
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;

		logger.info("fileName: "+fileName);

		try {
			String formatName = fileName.substring(fileName.lastIndexOf(".")+1); //이미지타입의 파일인지 확인
			MediaType mType = MimeMediaUtil.getMediaType(formatName);
			HttpHeaders headers = new HttpHeaders();
			in = new FileInputStream(uploadPath+fileName);

			if(mType != null) {
				headers.setContentType(mType);
			} else {
				fileName = fileName.substring(fileName.indexOf("_")+1);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition", "attachment; filename=\""+ new String(fileName.getBytes("UTF-8"),"ISO-8859-1")+"\""); 
			}

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}

		return entity;
	}
	*/

	@ResponseBody
	@RequestMapping(value="/displayFile", method=RequestMethod.GET)
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception{

		logger.info("fileName: "+fileName);
		
		File file =new File("C:\\Users\\14Z950\\Desktop\\java_programing\\workspace\\spring_workspace\\movie\\src\\main\\webapp\\resources\\upload\\"+fileName);
		logger.info("file: "+file);
		
		InputStream in = null;

		ResponseEntity<byte[]> entity = null;

		try {
			String formatName = fileName.substring(fileName.lastIndexOf(".")+1); //이미지타입의 파일인지 확인
			MediaType mType = MimeMediaUtil.getMediaType(formatName);
			HttpHeaders header = new HttpHeaders();
			in = new FileInputStream(uploadPath+fileName);
			if(mType != null) {
				header.add("Content-Type", Files.probeContentType(file.toPath()));
			} else {
				fileName = fileName.substring(fileName.indexOf("_")+1);
				header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				header.add("Content-Disposition", "attachment; filename=\""+ new String(fileName.getBytes("UTF-8"),"ISO-8859-1")+"\""); 
			}

			entity = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();

			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);

		} finally {
			in.close();
		}
		
		return entity;
	}

	@ResponseBody
	@RequestMapping(value="/deleteFile", method=RequestMethod.POST)
	public ResponseEntity<String> deleteFile(String fileName){

		logger.info("delete File: "+fileName);
		String formatName = fileName.substring(fileName.lastIndexOf(".")+1); //이미지타입의 파일인지 확인
		MediaType mType = MimeMediaUtil.getMediaType(formatName);

		if(mType != null) {
			String front = fileName.substring(0, 12);
			logger.info("fileName front = "+front);

			String end = fileName.substring(14);
			logger.info("fileName end = "+end);
			
			new File(uploadPath + (front+end).replace('/',File.separatorChar)).delete();
		}

		new File(uploadPath + fileName.replace('/',File.separatorChar)).delete();
		
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}
}
