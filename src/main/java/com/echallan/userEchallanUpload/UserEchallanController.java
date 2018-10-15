package com.echallan.userEchallanUpload;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class UserEchallanController {

    private static final Logger logger = LoggerFactory.getLogger(UserEchallanController.class);

    
    @Autowired
    private UserEchallanService userEchallanService;
    
    @PostMapping("/uploadFile")
    public UserEchallanUploadResponse complaintRegister(@RequestParam("file") MultipartFile file,@RequestParam("imei") String imei,
    		@RequestParam("lattitude") String lattitude,@RequestParam("longitude") String longitude,
    		@RequestParam("location") String location,@RequestParam("mobileNo") String mobileNo) {
	  	
	  	UserEchallanUploadResponse res=userEchallanService.complaintRegister(file,imei,lattitude,longitude,location,mobileNo);
	  	
      return res;
    }
    
    
    @PostMapping("/updateChallanStatus")
    public UserEchallanConfirmResponse updateChallanStatus(@RequestParam("fileName") String fileName) {
      
      
    	UserEchallanEntity userComplaints=new UserEchallanEntity();
	  	userComplaints.setFileName(fileName);
	  	
	  	UserEchallanConfirmResponse res=userEchallanService.updateComplaintStatus(userComplaints);;
	  	
      return res;
    }

}