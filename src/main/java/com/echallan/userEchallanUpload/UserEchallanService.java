package com.echallan.userEchallanUpload;


import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.echallan.exception.FileStorageException;
import com.echallan.utils.CDAC_SMS;


@Service
public class UserEchallanService {

	private static final Logger logger = LoggerFactory.getLogger(UserEchallanService.class);
    
    @PersistenceContext
	private EntityManager entityManager;
    
    @Autowired
    CDAC_SMS cdacSms;
    
    @Autowired
    private UserEchallanRepository userComplaintsRepository;

    @Transactional
    public UserEchallanUploadResponse complaintRegister(MultipartFile file,String imei,String lattitude,String longitude,String location,String mobileNo) {

    	UserEchallanEntity userComplaints=new UserEchallanEntity();
	  	userComplaints.setImei(imei);
	  	userComplaints.setLattitude(lattitude);
	  	userComplaints.setLongitude(longitude);
	  	userComplaints.setLocation(location);
	  	userComplaints.setMobileNo(mobileNo);
    	
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        boolean fileUploadResponse=false;
        try {
        	
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date();
            String currentDate =dateFormat.format(date);

			LocalDateTime now = LocalDateTime.now();
			int year = now.getYear();
			int month = now.getMonthValue();
			int day = now.getDayOfMonth();
			int hour = now.getHour();
			int minute = now.getMinute();
			int second = now.getSecond();
			String timeStamp=year+""+month+""+day+""+hour+""+minute+""+second;
			String storedfileName=userComplaints.getMobileNo()+"_"+timeStamp;

           fileUploadResponse= writeImageToFTP(file,storedfileName,currentDate,userComplaints);
   
            
        } catch (Exception ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }

        return new UserEchallanUploadResponse(fileName,fileUploadResponse);

    }

    
    private synchronized boolean fileUpload(String ftpIP,int ftpPort,String ftpUser,String ftpPassword,
    		MultipartFile file, String fileName,String headDirectory,String unitCode,String offenceDate) {

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
 				String offence_date[] = offenceDate.trim().split("\\/");

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
   private synchronized boolean writeImageToFTP(MultipartFile file, String storedfileName, 
		   String offenceDate,UserEchallanEntity userComplaints) {

		boolean stored = false;
		FTPClient ftpClient = new FTPClient();
		ByteArrayInputStream mrIs = null;
		ByteArrayInputStream is = null;
		BufferedInputStream mrBis = null;
		ByteArrayOutputStream os = null;
		String MRImgPath = "";
		long start = 0, end = 0;
		try {
			start = System.currentTimeMillis();
			
			ftpClient.connect("192.168.11.9",1305);
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			ftpClient.setFileTransferMode(FTP.STREAM_TRANSFER_MODE);
			ftpClient.setSoTimeout(2000);// 10000
			ftpClient.enterLocalPassiveMode();

			if (ftpClient.login("ftpuser", "Dk0r$l1qMp6")) {
				String offence_date[] = offenceDate.trim().split("\\/");

				if (offence_date!=null) {
					MRImgPath = "/CitizenUploads/"+offence_date[0].toString().trim()+"/"+offence_date[1].toString().trim()+"/"+offence_date[2].toString().trim();
				}

				String[] MRpaths = MRImgPath.split("\\/");
				if (file!=null) {
					byte[] encodedoffenceImg1 = file.getBytes();
					if (encodedoffenceImg1 != null) {
						createDirectories(ftpClient, MRpaths);
						mrIs = new ByteArrayInputStream(encodedoffenceImg1);
						mrBis = new BufferedInputStream(mrIs);
						BufferedImage origImage = ImageIO.read(mrBis);
						os = new ByteArrayOutputStream();
						ImageIO.write(origImage, "jpg", os);
						is = new ByteArrayInputStream(os.toByteArray());
						os.flush();
						stored = ftpClient.storeFile(MRImgPath+"/"+storedfileName+ ".jpg", is);
					}
				}
			}
			if(stored) {
				
				if(userComplaints!=null) {
					userComplaints.setFileName(storedfileName);
					entityManager.persist(userComplaints);
		        	entityManager.flush();
		        	
		        	String message="Dear Sir/Madam, Your Complaint registration is successfull  with your Complaint id:"+userComplaints.getComplaintId()+".";
		        	cdacSms.sendOTPSMS(""+userComplaints.getMobileNo(),message);
		            logger.info("[Method:writeImageToFTP][uploadStatus:"+stored+"]Complaint registration success  with mobile number "+userComplaints.getMobileNo()+" FileName:"+storedfileName);
				}
	            
			}else {
				end = System.currentTimeMillis();
				 logger.info("[Method:writeImageToFTP][uploadStatus:"+stored+"]Complaint registration failed  with mobile number "+userComplaints.getMobileNo()+" FileName:"+storedfileName
						+ "] Process time " + (end - start) + " ms. ");
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[Method:writeImageToFTP][uploadStatus:"+stored+"]Complaint registration error  with mobile number "+userComplaints.getMobileNo()+" FileName:"+storedfileName
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
				logger.error("[Method:writeImageToFTP][mobile no:" + userComplaints.getMobileNo()
						+ "] Error while FTP closing connection ", e);
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

	@Transactional
	public UserEchallanConfirmResponse updateComplaintStatus(UserEchallanEntity userComplaints) {
		
		UserEchallanConfirmResponse resp= userComplaintsRepository.updateComplaintStatus(userComplaints);
		return resp;
	}
}