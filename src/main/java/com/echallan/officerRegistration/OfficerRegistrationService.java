package com.echallan.officerRegistration;

import java.util.Optional;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.echallan.utils.CDAC_SMS;
import com.echallan.utils.SmsEntity;
import com.echallan.utils.SmsRepository;

@Service
public class OfficerRegistrationService {

	private static final Logger logger = LoggerFactory.getLogger(OfficerRegistrationService.class);
	
	@Autowired
	private OfficerRegistrationRepository userRegstrationRepository;
	
	@Autowired
	private SmsRepository smsRepository;
	
	@PersistenceContext
	private EntityManager entityManager; 
	
	@Autowired
	private CDAC_SMS cdacSms;
	
	public ServiceResponse getsendOTP(String mobileNo) {
		ServiceResponse resp=new ServiceResponse();
		SmsEntity smsentity=null; 
		String otp=null;
		try {
				Random random = new Random();
				otp = String.format("%04d", random.nextInt(10000));
				String smsResp=cdacSms.sendOTPSMS(mobileNo,otp);
				 if("402".equals(smsResp.split("\\,")[0]) ){   

					 smsentity=new SmsEntity();
					resp.setRespCode(1);
					resp.setRespDesc("Success");
					resp.setRespRemark(otp);
					
					smsentity.setContactNo(Long.parseLong(mobileNo));
					smsentity.setOtpNo(Integer.parseInt(otp));
					smsentity.setOtp_verify("N");
					smsentity.setSent_status("Y");
					smsentity.setSms_mode_cd(6);
					smsentity.setUnit_cd(23);
					smsRepository.save(smsentity);
					
					
				}else {
					resp.setRespCode(2);
					resp.setRespDesc("Failure");
					resp.setRespRemark("0");
				}
				
		} catch (Exception e) {
			resp.setRespCode(5);
			resp.setRespDesc("Error");
			resp.setRespRemark("0");
			e.printStackTrace();
			logger.error("[method:getsendOTP] ERROR:",e);
		}
		return resp;
	}
	
	@Transactional
	public ServiceResponse getuserRegistration(OfficerRegistrationEntity userRegstrationEntity) {
		
		ServiceResponse resp=new ServiceResponse(); 
		OfficerRegistrationEntity repositoryResp =null;  
			try { 
				System.out.println("OfficerRegistrationEntity >>> "+userRegstrationEntity.toString());
				
				Optional<OfficerRegistrationEntity> userEmpIdExist=userRegstrationRepository.findById(userRegstrationEntity.getEmp_id());
				Optional<OfficerRegistrationEntity> userLoginIDExist=userRegstrationRepository.findByLoginId(userRegstrationEntity.getLoginId());
				System.out.println("1 > "+userRegstrationEntity.getOtp_no()+" 2 > "+userRegstrationEntity.getContact_no()+" 3> "+userRegstrationEntity.getLast_login());
				if(verifyOTP(userRegstrationEntity.getOtp_no(), userRegstrationEntity.getContact_no())) {
				if (!userEmpIdExist.isPresent() && !userLoginIDExist.isPresent()) {
					repositoryResp = userRegstrationRepository.save(userRegstrationEntity);
					System.out.println("repositoryResp > "+repositoryResp);
					if(repositoryResp!=null) {
						resp.setRespCode(1);
						resp.setRespDesc("Success");
						resp.setRespRemark("Success"); 
						cdacSms.sendSingleSMS(userRegstrationEntity.getContact_no()+"", "Dear Sir.\n Your Registration is successful.\nLogin Id : "+userRegstrationEntity.getLoginId()+"\nPassword : "+userRegstrationEntity.getPwd()+".");
						logger.info("getuserRegistration --> "+repositoryResp.getEmp_name()+" is registered.");
					}else {
						resp.setRespCode(2);
						resp.setRespDesc("Insufficient Details to Register"); 
						resp.setRespRemark("Failure");
						//logger.info("getuserRegistration --> "+repositoryResp.getEmp_name()+" is Failure.");
					}
						
						 
					}else if(userEmpIdExist.isPresent()) { 
						resp.setRespCode(3);
						resp.setRespDesc("Emp ID Already Exist");
						resp.setRespRemark("Emp ID Already Exist");
						logger.info("getuserRegistration --> "+userRegstrationEntity.getEmp_id()+" is already registered."); 
					}else if(userLoginIDExist.isPresent() ) {
						resp.setRespCode(4);
						resp.setRespDesc("Login ID Already Exist");
						resp.setRespRemark("Login ID Already Exist");
						logger.info("getuserRegistration --> "+userRegstrationEntity.getLoginId()+" is already registered.");
					}
				}else {
					resp.setRespCode(5);
					resp.setRespDesc("OTP Not Verified");
				}
			} catch (Exception e) {
				resp.setRespCode(6);
				resp.setRespDesc("Error");
				resp.setRespRemark("Error");
				e.printStackTrace();
				logger.error("[method:getuserRegistration] ERROR:",e);
			}
			logger.info("getuserRegistration --> "+resp);
		 return resp;
	}

	
	private boolean verifyOTP(int otp,long mobileNo) {
		boolean verified =false;
		SmsEntity smsentity=new SmsEntity();
		try {
			
			smsentity=smsRepository.findByContactNoAndOtpNo(mobileNo,otp);
			//smsentity=smsRepository.getByNames(mobileNo,otp,smsDT);
			if(smsentity!=null) {
				verified=true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[method:verifyOTP] ERROR:",e);
		}
		return verified;
	}
	
	public ServiceResponse getforgotPswd(String emp_id) {
		OfficerRegistrationEntity repositoryResp =null;
		ServiceResponse servResp=null;
		
		try {
			Optional<OfficerRegistrationEntity> userEmpIdExist=userRegstrationRepository.findById(emp_id); 	
			System.out.println("userEmpIdExist ->"+userEmpIdExist);
			if(userEmpIdExist.isPresent()) {
				servResp=new ServiceResponse();
				servResp.setRespCode(1);
				servResp.setRespDesc("Sucess");
				servResp.setRespRemark(emp_id);
				repositoryResp=userEmpIdExist.get(); 
				System.out.println("Employee Found ...");
				cdacSms.sendSingleSMS(repositoryResp.getContact_no()+"", "Dear Sir/n Your Login ID : "+repositoryResp.getLoginId()+"\n Password : "+repositoryResp.getPwd());
			}else {
				servResp=new ServiceResponse();
				servResp.setRespCode(2);
				servResp.setRespDesc("Not Found");
				servResp.setRespRemark(emp_id);
				System.out.println("Employee not Found ...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return servResp;
	}
	
	@Autowired
	private OfficerDetailsRepository officerDetailsRepository;
	public ServiceResponse getofficerDetails(String empID,String pwd) {
		Officer_v resp=null;
		ServiceResponse serviceResp=null;
		try {
			resp = officerDetailsRepository.findByUserIDAndPwd(empID,pwd);
			
				if (resp!=null) {
					serviceResp=new ServiceResponse();
					serviceResp.setRespCode(1);
					serviceResp.setRespDesc("Success");
					serviceResp.setRespRemark(resp);
					logger.info("getofficerDetails details found");
				}else {
					serviceResp=new ServiceResponse();
					serviceResp.setRespCode(2);
					serviceResp.setRespDesc("Failed");
					serviceResp.setRespRemark(null);
					logger.info("getofficerDetails details not found");
				}
		} catch (Exception e) {
			logger.error("[method:getofficerDetails] ERROR:",e);
		}
	 return serviceResp; 
}

	@Autowired
	private MALoginIDRepository maLoginIDRepository; 
	@Transactional
	public ServiceResponse getofficerChangePswd(String empID, String oldPwd, String newPwd) {
		MALoginIDEntity resp=null;
		ServiceResponse serviceResp=new ServiceResponse();
		try {
			Optional<MALoginIDEntity> empIDExist=maLoginIDRepository.findByempID(empID);
				 if(empIDExist!=null && empIDExist.isPresent()) {
					 
								 	resp = maLoginIDRepository.findByempIDAndPwd(empID,oldPwd);	 
										if(resp!=null){ 
											System.out.println(" Found Record "+resp.getEmpID()); 
											resp.setPwd(newPwd);
											entityManager.persist(resp); 
											entityManager.flush();
											serviceResp.setRespCode(1);
											serviceResp.setRespDesc("Success");
											serviceResp.setRespRemark(resp);
											cdacSms.sendSingleSMS(""+resp.getContact_no(), "Dear Sir,\n Your Login Id : "+resp.getLogin_id()+"\n new updated Password : "+newPwd);
										}else {
											serviceResp.setRespCode(3);
											serviceResp.setRespDesc("Old Password not matched.");
											serviceResp.setRespRemark(resp);
											/*serviceResp.setRespCode(2);
											serviceResp.setRespDesc("Failed to Update");
											serviceResp.setRespRemark(resp);*/
										}
					 		
			}else {
				serviceResp.setRespCode(4);
				serviceResp.setRespDesc("Employee ID not Found");
				serviceResp.setRespRemark(resp);
			}
		}catch (Exception e) {
			e.printStackTrace();
			serviceResp.setRespCode(5);
			serviceResp.setRespDesc("Failed to Update");
			serviceResp.setRespRemark(resp);
		}
		return serviceResp;
	}
	


}
