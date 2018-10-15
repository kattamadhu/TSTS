package com.echallan.utils;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/***
 * Author K.Madhusudhan
 * Date : 26-09-2018
 * Version 1.0
 * */

@Service
public class Utils {
	private static final Logger logger = LoggerFactory.getLogger(Utils.class);
	private static final String ftpIP="192.168.11.9";
	private static final int ftpPort=2018;
	private static final String ftpUser="ftpuser";
	private static final String ftpPassword="Dk0r$l1qMp6";
	
	@Transactional
	 public  synchronized boolean fileUpload(MultipartFile file, String fileName,
			 String headDirectory,String unitCode,String offenceDate) {

	 		boolean stored = false;
	 		FTPClient ftpClient = new FTPClient();
	 		ByteArrayInputStream mrIs = null;
	 		ByteArrayInputStream is = null;
	 		BufferedInputStream mrBis = null;
	 		ByteArrayOutputStream os = null;
	 		String imgPath = "";
	 		long start = 0, end = 0;
	 		try {
	 			start = System.currentTimeMillis();
	 			
	 			ftpClient.connect(ftpIP,ftpPort);
	 			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
	 			ftpClient.setFileTransferMode(FTP.STREAM_TRANSFER_MODE);
	 			ftpClient.setSoTimeout(2000);// 10000
	 			ftpClient.enterLocalPassiveMode();

	 			if (ftpClient.login(ftpUser, ftpPassword)) {
	 				String offence_date[] = offenceDate.trim().split("\\-");

	 				if (offence_date!=null) {
	 					imgPath = "/"+headDirectory+"/"+offence_date[0].toString().trim()+"/"+
	 							offence_date[1].toString().trim()+"/"+
	 							offence_date[2].toString().trim()+"/"+unitCode.toString().trim();
	 				}

	 				String[] imgpaths = imgPath.split("\\/");
	 				if (file!=null) {
	 					byte[] encodedoffenceImg1 = file.getBytes();
	 					if (encodedoffenceImg1 != null) {
	 						createDirectories(ftpClient, imgpaths);
	 						mrIs = new ByteArrayInputStream(encodedoffenceImg1);
	 						mrBis = new BufferedInputStream(mrIs);
	 						BufferedImage origImage = ImageIO.read(mrBis);
	 						os = new ByteArrayOutputStream();
	 						ImageIO.write(origImage, "jpg", os);
	 						is = new ByteArrayInputStream(os.toByteArray());
	 						os.flush();
	 						stored = ftpClient.storeFile(imgPath+"/"+fileName+ ".jpg", is);
	 					}
	 				}
	 			}
	 		
	 			

	 		} catch (Exception e) {
	 			e.printStackTrace();
	 			logger.error("[Method:fileUpload][uploadStatus:"+stored
	 					+ "] Process time " + (end - start) + " ms. ",e);
	 			e.printStackTrace();
	 		} finally {
	 			try {
	 				if (ftpClient != null && ftpClient.isConnected()) {
	 					ftpClient.logout();
	 					ftpClient.disconnect();
	 				}
	 			} catch (IOException e) {
	 				e.printStackTrace();
	 				
	 			}
	 		}
	 		return stored;
	 	}

		private void createDirectories(FTPClient ftpClient, String[] paths) throws IOException {

		StringBuffer sb = new StringBuffer();
		boolean success = false;

		for (String dir : paths) {
			sb.append("/" + dir);
			ftpClient.changeWorkingDirectory(sb.toString().trim());
			success = ftpClient.makeDirectory(sb.toString().trim());
			if (success) {
				logger.info("Successfully created directory: " + dir);
			} /*
				 * else { log.info("Failed to create directory. See server's reply."); }
				 */
		}
	}
}
