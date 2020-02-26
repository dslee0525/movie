package com.movie.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.util.FileCopyUtils;

import com.movie.model.FileUploadVO;

public class UploadFileUtils {
	/*
	public static String uploadFile(String uploadPath, String originalName, byte[] fileData) throws Exception{

        UUID uid = UUID.randomUUID();

		String savedName = uid.toString()+"_"+originalName;

		String savedPath = calcPath(uploadPath); //년월일명의 폴더 생성

		File target = new File(uploadPath+savedPath, savedName);
							//upload\\년월일 폴더경로 합침 
		//FileCopyUtils.copy(in, out);
		FileCopyUtils.copy(fileData, target);

		System.out.println("uploadPath="+uploadPath);
		System.out.println("originalName="+originalName);
		System.out.println("target="+target);

		String formatName =originalName.substring(originalName.lastIndexOf(".")+1); //끝자리부터에서 .을 찾아서 +1을 하면 확장자를 찾을 수 있음
		System.out.println("formatName="+formatName);

		String uploadFileName = null;

		System.out.println("MimeMediaUtil.getMediaType(formatName)="+MimeMediaUtil.getMediaType(formatName));

		if(MimeMediaUtil.getMediaType(formatName)!=null) {
			System.out.println("aaa");
			uploadFileName= makeThumbnail(uploadPath, savedPath, savedName);

		} else {
			System.out.println("bbb");
			uploadFileName= makeIcon(uploadPath, savedPath, savedName);
		}

		return uploadFileName;
	}
	*/
	
	public static FileUploadVO uploadFile(String uploadPath, String originalName, byte[] fileData) throws Exception{

		FileUploadVO fileVO = new FileUploadVO();
		
        UUID uid = UUID.randomUUID();
        
        fileVO.setOriginalName(originalName);	
        fileVO.setFileName(uid.toString()+"_"+originalName);

        fileVO.setSavedPath(calcPath(uploadPath)); //년월일명의 폴더 생성

		File target = new File(uploadPath+fileVO.getSavedPath(), fileVO.getFileName());
							//upload\\년월일 폴더경로 합침 
		
		Path pathToFile = Paths.get(target+"");
		System.out.println(pathToFile.toAbsolutePath());
		
		//FileCopyUtils.copy(in, out);
		FileCopyUtils.copy(fileData, target);

		System.out.println("uploadPath="+uploadPath);
		System.out.println("originalName="+originalName);
		System.out.println("target="+target);

		String formatName =originalName.substring(originalName.lastIndexOf(".")+1); //끝자리부터에서 .을 찾아서 +1을 하면 확장자를 찾을 수 있음
		System.out.println("formatName="+formatName);

		String thumbnailName = null;

		System.out.println("MimeMediaUtil.getMediaType(formatName)="+MimeMediaUtil.getMediaType(formatName));

		if(MimeMediaUtil.getMediaType(formatName)!=null) {
			System.out.println("aaa");
			thumbnailName= makeThumbnail(uploadPath, fileVO.getSavedPath(), fileVO.getFileName());

		} else {
			System.out.println("bbb");
			thumbnailName= makeIcon(uploadPath, fileVO.getSavedPath(), fileVO.getFileName());
		}
		
		fileVO.setThumbnailName(thumbnailName);

		return fileVO;
	}

 

	private static String makeIcon(String uploadPath, String path, String fileName) throws Exception{
		String iconName = uploadPath + path + File.separator + fileName;
		
		return iconName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}

	private static String calcPath(String uploadPath) {
		Calendar cal = Calendar.getInstance();
		
		System.out.println("cal="+cal); // 오늘날짜
		String yearPath =File.separator+cal.get(Calendar.YEAR); // /2020(yearPath)
						// File.separator : 폴더 구분자(/)
		String monthPath =yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1); //시작이 0이므로 +1을 해준다. 
		 // /2020/01(monthPath)

		String datePath =monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE)); //매월 1일의 값은 1
		// /2020/01/07(datePath)

		makeDir(uploadPath, yearPath, monthPath, datePath);
		System.out.println("datePath = "+datePath);

		return datePath;
	}

	private static void makeDir(String uploadPath, String...paths) {
		System.out.println("makeDir의 길이 = "+paths.length);
		System.out.println("makeDir1 = "+paths[0]);
		System.out.println("makeDir2 = "+paths[1]);
		System.out.println("makeDir3 = "+paths[2]);

		if(new File(paths[paths.length-1]).exists()) {
			return;
		}

		for(String path: paths) {

			File dirPath = new File(uploadPath+path);

			if(!dirPath.exists()) {
				dirPath.mkdir();
			}

		}

	}

	private static String makeThumbnail(String uploadPath, String path, String fileName) throws Exception {

		BufferedImage sourceImg = ImageIO.read(new File(uploadPath+path, fileName));
		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT,360);
		String thumbnailName = uploadPath + path +File.separator +"s_" +fileName;
		File newFile = new File(thumbnailName);
		String formatName =fileName.substring(fileName.lastIndexOf(".")+1);
		ImageIO.write(destImg, formatName.toUpperCase(), newFile);

		return thumbnailName.substring(uploadPath.length()).replace(File.separatorChar, '/'); 
															//replace(File.separatorChar, '/') : 치환함수
	}

}