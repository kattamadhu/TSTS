package com.echallan.challanGeneration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.echallan.masters.ChallanTypeEntity_MA;
import com.echallan.masters.ChallanTypeRepository;
import com.echallan.officerRegistration.OfficerDetailsRepository;
import com.echallan.officerRegistration.Officer_v;
import com.echallan.proceedures.ChallanNumberSequence;
import com.echallan.response.CommonResponse;
import com.echallan.rta.DLEntity;
import com.echallan.rta.DLRepository;
import com.echallan.rta.RCEntity;
import com.echallan.rta.RTARepository;
import com.echallan.utils.Utils;
import com.fasterxml.jackson.databind.ObjectMapper;

/*****
 * 
 * 
 * @author Madhusudhan
 *
 */

@Service
public class EchallanGenerationService {
	
	private static final Logger logger = LoggerFactory.getLogger(EchallanGenerationService.class);
	private static final String headDirectory="Evidences";
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private RTARepository rtaRepository;
	
	@Autowired
	private DLRepository dLRepository; 
	
	@Autowired
	private ChallanTypeRepository challanTypeRepository;
	
	
	@Autowired
	private OfficerDetailsRepository officerDetailsRepository;
	
	@Autowired
	Utils utils;
	
	@Transactional
	public CommonResponse generateEchallan(
			MultipartFile file,
			String unit_cd, 
			String dept_cd,
			String ps_juris_cd,
			String  responsible_ps_cd,
			String  point_cd,
			String regn_no,
			String offence_dt,
			String pid_cd,
			String challan_type,
			String d_of_pay,
			String paid_amt,
			String remark_cd,
			String imageStatus,
			String challan_base_cd,
			String violations,
			String dt_item_cd,
			String dt_status,
			String id_proof_cd,
			String id_det,
			String dob,
			String age,
			String gender,
			String name,
			String parent_name,
			String address,
			String contact_no,
			String occupation_cd,
			String education_cd,
			String penalty_points,
			String gps_lat,
			String  gps_long,
			String enforcementType,
			String paymentStatus,
			String gatewayCode,
			String stateCode,
			String unitName,
			String unitShortForm,
			String chargeSheetStatus,
			String baclevel
) {
		
		CommonResponse resp=new CommonResponse();
		SimpleDateFormat parse=new SimpleDateFormat("yyyy-MM-dd");
		ChallanTypeEntity_MA challanTypeEntity=null;
		StringBuffer violationBuffer=new StringBuffer();
		StringBuffer detainedItemsBuffer=new StringBuffer();
	try {
		
		Officer_v officerDetails =officerDetailsRepository.findByUserID(pid_cd);
		
		String drivingLicenceNo="NA";
		Optional<ChallanTypeEntity_MA> challanTypeEnty =challanTypeRepository.findById(challan_type!=null?Integer.parseInt(challan_type):null);
		
		if(challanTypeEnty.isPresent()) {
			challanTypeEntity=challanTypeEnty.get();
		}
		
		java.util.Date driverDob=null;
			//************** eticket insertion
		EticketEntity eticket = new EticketEntity();
		
		eticket.setRegn_no(regn_no);
		eticket.setUnit_cd(unit_cd!=null?Integer.parseInt(unit_cd):0);
		eticket.setState_cd(stateCode!=null?Integer.parseInt(stateCode):0);
		
		eticket.setBooked_ps_cd(officerDetails.getPs_cd());
		int ticketSequence=0;
		int currentYear =2018;
		try {
			currentYear = Calendar.getInstance().get(Calendar.YEAR);
			StoredProcedureQuery addBookNamedStoredProcedure = entityManager.createNamedStoredProcedureQuery("findByChallanTypeProcedure");
			addBookNamedStoredProcedure.setParameter("challan_type", Integer.parseInt(challan_type));
			addBookNamedStoredProcedure.execute();
			
			   Query q = entityManager.createQuery(
						"SELECT e FROM  ChallanNumberSequence e WHERE e.challan_type=:challan_type ");
				q.setParameter("challan_type", Integer.parseInt(challan_type));
				
				ChallanNumberSequence challanSeq= (ChallanNumberSequence)q.getSingleResult();
				
				if(challanSeq!=null) {
					ticketSequence=challanSeq.getSeq_no();
						logger.info("ChallanNumberSequence *****:"+ticketSequence);
				}else {
					logger.info("NO sequence generated for ChallanNumberSequence ");
				}
			
		} catch (Exception e) {
			logger.error("", e);
		}
		
		eticket.setEticket_no(ticketSequence);
		
		eticket.setChallan_no(unitShortForm+String.valueOf(eticket.getBooked_ps_cd()).substring(2,4) +currentYear+eticket.getEticket_no());
		logger.info("Challan  number :"+eticket.getChallan_no());
		if(offence_dt!=null)
		eticket.setOffence_dt(parse.parse(offence_dt));
		
		/// PRE
		
		
		eticket.setGtwy_cd(Integer.parseInt(gatewayCode));
		
		eticket.setCadre_cd(officerDetails.getCadre_cd());
		
		eticket.setChallan_base(challan_base_cd!=null?Integer.parseInt(challan_base_cd):0);
		eticket.setChallan_type(challan_type!=null?Integer.parseInt(challan_type):0);
		eticket.setDept_cd(dept_cd!=null?Integer.parseInt(dept_cd):0);
		eticket.setImage(imageStatus!=null?Integer.parseInt(imageStatus):0);
		eticket.setLogin_ID(pid_cd);
		eticket.setPoint_cd(Integer.parseInt(point_cd));
		eticket.setPs_juris_cd(ps_juris_cd!=null?Integer.parseInt(ps_juris_cd):0);
		eticket.setResponsible_ps_cd(responsible_ps_cd!=null?Integer.parseInt(responsible_ps_cd):0);
		
		
		if(dob!=null)
		driverDob=(java.util.Date)parse.parse(dob);
			
		
		
		//************** violations insertion
        int totalFineAmt=0,row=1;
		if(violations!=null ) {
			
			List<ViolationsEntity> violationsList=new ArrayList<ViolationsEntity>(); 
			String offenceCodesArray[]=violations.split("\\@");
			if(offenceCodesArray!=null && offenceCodesArray.length>0)
			for(String IndvOffence:offenceCodesArray) {
				logger.info("individual ofence:"+IndvOffence);
				String offenceDetailArray[]=IndvOffence.split("\\:");
				if(offenceDetailArray!=null && offenceDetailArray.length>0 ) {
						ViolationsEntity vioEnty=new ViolationsEntity();
						vioEnty.setEticket_no(eticket.getEticket_no());
						vioEnty.setOffence_cd(offenceDetailArray[0]!=null?Integer.parseInt(offenceDetailArray[0]):0);
						vioEnty.setAFine_Amt(offenceDetailArray[2]!=null?Integer.parseInt(offenceDetailArray[2]):0);
						violationsList.add(vioEnty);
						totalFineAmt+=vioEnty.getAFine_Amt();
						violationBuffer.append(row+". "+offenceDetailArray[1]+ " "+offenceDetailArray[2]+" \n");
					}
				row++;
		    }
			
			if(violationsList!=null && violationsList.size()>0)
				eticket.setViolations(violationsList);
		}
		
			
		
		
		if(enforcementType!=null)
			if("CONTACT".equalsIgnoreCase(enforcementType)) {
				/*eticket.setGps_lat(Long.parseLong("1312.2234"));//gps_lat!=null?new BigDecimal(gps_lat.trim()):null);
				eticket.setGps_long(Long.parseLong("2342.3454"));//gps_long!=null?new BigDecimal(gps_long.trim()):null);
				*/
				eticket.setUCh_Amt(0);
				
				if("1".equals(chargeSheetStatus)) {
					//eticket_no,cs_issue_dt,cs_status,bac_level
					eticket.setFine_Amt(0);
					eticket.setTFine_Amt(0);
					
					List<ChargeSheetDetailsEntity> chargeSheetList=new ArrayList<ChargeSheetDetailsEntity>(); 
					ChargeSheetDetailsEntity chargeSheetEnty=new ChargeSheetDetailsEntity();
					chargeSheetEnty.setEticket_no(eticket.getEticket_no());
					chargeSheetEnty.setCs_issue_dt(parse.parse(offence_dt));
					chargeSheetEnty.setCs_status(1);
					
					
					if("TD".equals(challanTypeEntity.getChallan_sf().trim())) {
						chargeSheetEnty.setBac_level(baclevel!=null?Integer.parseInt(baclevel):null);
					}
					chargeSheetList.add(chargeSheetEnty);
					
					if(chargeSheetList!=null && chargeSheetList.size()>0)
					eticket.setChargeSheetDetailsEntity(chargeSheetList);
					
				}else {
					eticket.setFine_Amt(totalFineAmt);
					eticket.setTFine_Amt(totalFineAmt+eticket.getUCh_Amt());
				}
				int detCnt=1;
				//*********************************** detained items insertion
				if("1".equalsIgnoreCase(dt_status)) {
					String detItems[]=dt_item_cd.split("\\@");
					
					if(detItems!=null && detItems.length>0) {
						
						List<DetainReleaseEntity> detainItemsEntityList=new ArrayList<DetainReleaseEntity>(); 
						for(String detItem:detItems) {
							String detItm[]=detItem.split("\\:");
							
							DetainReleaseEntity detainedEnty=new DetainReleaseEntity();
							detainedEnty.setDt_Item_CD(detItm[0]!=null?Integer.parseInt(detItm[0]):0);
							detainedEnty.setEticket_no(""+eticket.getEticket_no());
							detainedEnty.setDt_By_Login_ID(""+eticket.getLogin_ID());
							detainedEnty.setDt_Status(dt_status!=null?Integer.parseInt(dt_status):0);
							detainedEnty.setRegn_no(regn_no);
							detainItemsEntityList.add(detainedEnty);
							
							detainedItemsBuffer.append(detCnt +". "+detItm[1]+"\n");
							detCnt++;
						}
						if(detainItemsEntityList!=null && detainItemsEntityList.size()>0) {
							eticket.setDetainEntity(detainItemsEntityList);
							eticket.setDetain_no_of_items(detItems.length);
						}
					}
				}
				
				//check payment condition
				if("1".equals(paymentStatus)) {
				
					eticket.setPayment_status("P");
					
					if(d_of_pay!=null)
						eticket.setDate_of_pay(parse.parse(d_of_pay));
					
					eticket.setPaid_amt(paid_amt!=null?Integer.parseInt(paid_amt):0);
					
					// generate TXN id dynamically or use db sequence
				
					eticket.setTransaction_id(eticket.getEticket_no());
					
					eticket.setAmt_collect_by_login_id(pid_cd);
				}else {
					eticket.setPayment_status("U");
				}
				
			}else if("NONCONTACT".equalsIgnoreCase(enforcementType)) {
				eticket.setPayment_status("U");
				eticket.setUCh_Amt(35);
				
				eticket.setFine_Amt(totalFineAmt);
				eticket.setTFine_Amt(totalFineAmt+eticket.getUCh_Amt());
			}
		
		
		//add logic to insert multiple id's
		
		if(id_proof_cd!=null && id_det!=null) {
			
			List<DriverDetailsEntity> driverDetailsentityList=new ArrayList<DriverDetailsEntity>();
			String idCdArray[]=id_proof_cd.split("\\,");
			String idDetArray[]=id_det.split("\\,");
			if(idCdArray!=null && idCdArray.length>0 && idDetArray!=null && idDetArray.length>0) {
				/*for(String idCd:idCdArray) {*/
					for(int i=0;i<idCdArray.length;i++) {
					DriverDetailsEntity driverDetailsEntity=new DriverDetailsEntity();
					if("2".equals(idCdArray[i])) {
						drivingLicenceNo=idDetArray[i];
					}
					
					driverDetailsEntity.setId_det(idDetArray[i]);
					driverDetailsEntity.setId_proof_cd(idCdArray[i]!=null?Integer.parseInt(idCdArray[i]):0);
					
					driverDetailsEntity.setName(name);
					driverDetailsEntity.setOccupation_cd(occupation_cd!=null?Integer.parseInt(occupation_cd):0);
					driverDetailsEntity.setParent_name(parent_name);
					driverDetailsEntity.setPenalty_points(penalty_points!=null?Integer.parseInt(penalty_points):0);
					driverDetailsEntity.setAddress(address);
					driverDetailsEntity.setAge(age!=null?Integer.parseInt(age):0);
					driverDetailsEntity.setContact_no(contact_no!=null?Long.parseLong(contact_no.trim()):0);
					driverDetailsEntity.setDob(driverDob);
					driverDetailsEntity.setEducation_cd(education_cd!=null?Integer.parseInt(education_cd):0);
					driverDetailsEntity.setEticket_no(""+eticket.getEticket_no());
					driverDetailsEntity.setGender(gender!=null?Integer.parseInt(gender):0);
					
					driverDetailsentityList.add(driverDetailsEntity);
					
				}
			}
			if(driverDetailsentityList!=null && driverDetailsentityList.size()>0)
				eticket.setDriverDetailsEntity(driverDetailsentityList);
			
		}
		
		try {
			
			if("NONCONTACT".equalsIgnoreCase(enforcementType)) {
				
				boolean b=utils.fileUpload(file, eticket.getChallan_no(), headDirectory, unit_cd, offence_dt);
				if(b){
					
					entityManager.persist(eticket);
					entityManager.flush();
					
					resp.setRespCode(1);
					resp.setRespDesc("SUCCESS");
					resp.setRespRemark("Challan generation success");
					
				}else {
					resp.setRespCode(0);
					resp.setRespDesc("FAILED");
					resp.setRespRemark("Challan generation failure");
				}
			}else {//CONTACT ENFORCEMENT
				
				if(remark_cd!=null && remark_cd.trim().length()>0) {
					
					t_hotlist hotlistEntity=new t_hotlist();
					hotlistEntity.setLogin_id(pid_cd);
					
					t_hotlistId listId=new t_hotlistId(Integer.parseInt(remark_cd),regn_no,1);
					
					hotlistEntity.setId(listId);
					entityManager.persist(hotlistEntity);
				}
				
				try {
					
					entityManager.persist(eticket);
					entityManager.flush();
					
					String sb=getPrintBuffer(unitName ,eticket,
							challanTypeEntity.getChallan_desc(),paymentStatus,
							drivingLicenceNo,driverDob,violationBuffer.toString(),
							detainedItemsBuffer.toString(),officerDetails);
					
					resp.setRespCode(1);
					resp.setRespDesc("SUCCESS");
					resp.setRespRemark(sb);
					
				} catch (Exception e) {
					e.printStackTrace();
					
					resp.setRespCode(0);
					resp.setRespDesc("FAILED");
					resp.setRespRemark("Challan generation failure");
				}
				
			}
			
		} catch (PersistenceException e) {
			logger.error("Challan Generation failed . Please try again!", e);
			resp.setRespCode(0);
			resp.setRespDesc("FAILED");
			resp.setRespRemark("Challan generation failure");
		}

		} catch (Exception e) {
			logger.error("Challan Generation failed . Please try again!", e);
			resp.setRespCode(0);
			resp.setRespDesc("FAILED");
			resp.setRespRemark("Challan generation failure");
		}
		
		return resp;
		}

	private String getPrintBuffer(String unitName,EticketEntity eticket, String ChallanDesc, 
			String paymentStatus, String drivingLicenceNo, Date driverDob, String violationBuffer,
			String detainedItemsBuffer, Officer_v officerDetails) {
		StringBuffer sb=new StringBuffer();
		try {
			logger.info("[method:getPrintBuffer] [regnNO:"+eticket.getRegn_no()+"]");
			RCEntity rc=null;
			Optional<RCEntity> rcentity =rtaRepository.findById(eticket.getRegn_no());
			
			if(rcentity.isPresent()) {
				 rc=rcentity.get();
			}
			
			
			
			DLEntity dlEntity=dLRepository.findByLdcDlNOAndLdcDob(drivingLicenceNo, driverDob);
			
			sb.append("TELANGANA STATE POLICE \n ");  
			sb.append(" "+unitName.toUpperCase()+" TRAFFIC POLICE  \n ");
			sb.append(" SPOT CHALLAN SYSTEM        \n ");
			sb.append(" CHALLANS&RECEIPT FOR COMPOUNDING OFFENCE  \n ");
			sb.append(" UNDER THE COURT OF LAW,MOTOR VEHICLE ACT  \n ");
			sb.append("  	 /RULES(TRAFFIC VIOLATIONS)           \n ");
			sb.append("	 "+ChallanDesc.trim().toUpperCase()+" CHALLAN RECEIPT           \n ");
			sb.append(" ----------------------------------------  \n ");
			sb.append(" OFFENCE DATE          :"+eticket.getOffence_dt()+" \n");
			
			//sb.append("BREATH ANALYSER ID    :  \n ");
			//sb.append(" CHECK SERIAL NO       : \n ");
			//sb.append(" ALCOHOL READING       : \n ");
		
			sb.append(" E-TICKET NO           :"+eticket.getChallan_no()+" \n");
			//sb.append(" PETTY CASE NO         : \n ");
			sb.append(" REGN_NO               :"+eticket.getRegn_no()+" \n");
			sb.append(" CHALLAN TYPE          :"+ChallanDesc+" \n");
			sb.append(" PS NAME               :"+eticket.getBooked_ps_cd()+" \n");
			sb.append(" LOCATION NAME         :"+eticket.getPoint_cd()+" \n");
			sb.append(" ----------------------------------------  \n ");
			
			sb.append(" ----------------------------------------  \n ");
			
			//rta rc entity 
			sb.append("			 VEHICLE DETAILS                  \n ");
			sb.append("       \n ");
			sb.append("Vehicle Number:"+eticket.getRegn_no()+" \n");
			if(rc!=null) {
				sb.append("Owner Name    :"+rc.getO_name()+" \n");
				sb.append("Address       :"+rc.getAddress()+" \n");
				sb.append("City          :"+rc.getCity()+" \n");
				sb.append("Maker Name    :"+rc.getMkr_name()+" \n");
				sb.append("Maker Class   :"+rc.getMkr_clas()+" \n");
				sb.append("Color:"+rc.getColour()+" \n");
				sb.append("Contact No    :"+rc.getContact_no()+" \n");
				sb.append("Vehicle Type  :"+rc.getVeh_type()+" \n");
			}
			sb.append("----------------------------------------   \n ");
			sb.append("			 DRIVER DETAILS \n ");
			List<DriverDetailsEntity> drvEntity= eticket.getDriverDetailsEntity();
			
			String drvName="";
			String drvfName="";
			String drvAge="";
			String drvContactNo="";
			
			for (DriverDetailsEntity driverDetailsEntity : drvEntity) {
				drvName=driverDetailsEntity.getName();
				drvfName=driverDetailsEntity.getParent_name();
				drvAge=driverDetailsEntity.getAge()!=0?driverDetailsEntity.getAge()+"":"";
				drvContactNo=driverDetailsEntity.getContact_no()!=0?driverDetailsEntity.getContact_no()+"":"";
			}
			
			sb.append("DRIVER NAME   :"+drvName+" \n");
			sb.append("DRIVER F NAME :"+drvfName+" \n");
			sb.append("DRIVER AGE    :"+drvAge+" \n");
			sb.append("CONTACT NO    :"+drvContactNo+" \n");
			
			
			//driving license entity 
			sb.append("----------------------------------------   \n ");
			
			if(dlEntity!=null) {
				sb.append("		 DRIVER LICENCE INFORMATION           \n ");
				sb.append(" ----------------------------------------  \n ");
				sb.append(" Driving License No:"+dlEntity.getLdcDlNO()+" \n");
				sb.append(" Driver Name    :"+dlEntity.getLdc_F_NM()+dlEntity.getLdc_L_NM()+" \n");
				sb.append(" Driver Address :"+dlEntity.getLdc_PADDR1()+dlEntity.getLdc_PADDR2()+dlEntity.getLdc_PADDR3()+" \n");
				sb.append(" Driver City	   :"+dlEntity.getLdc_PCITY()+" \n");
				sb.append(" Driver Contact No:"+dlEntity.getLdc_PPHNO()+" \n");
				sb.append(" ----------------------------------------     \n ");
			}
			sb.append(" I'M ACCEPTING THE ABOVE VIOLATION UNDER      \n ");
			sb.append("   THE FOLLOWING OFFENCES   \n ");
			sb.append(" S 185 , S 130/177          \n ");
			sb.append(" VIOLATIONS             AMOUNT                \n ");
			sb.append(violationBuffer);
			sb.append("          \n ");
			
			
			if("1".equals(paymentStatus)) {
				sb.append(" IS IT SPOT PAYMENT     :YES \n ");
			}else {
				sb.append(" IS IT SPOT PAYMENT     :NO \n ");
			}
			
			sb.append(" PAYMENT CAN BE MADE AT GIVEN COURT           \n ");
			
			sb.append(" ----------------------------------------     \n ");
			sb.append(" 			 DETAINED ITEMS                  \n ");
			sb.append("          \n ");
			
			sb.append(detainedItemsBuffer);
			sb.append("  ---------------------------------------     \n ");
			sb.append("          \n ");
			
			// officer entity
			
			sb.append(" DRIVER SIGN			OFFICER'S SIGN           \n ");
			sb.append("					"+officerDetails.getEmp_name()+ " \n ");
			sb.append("					"+officerDetails.getCadre_sf()+"         \n ");
			sb.append("					"+officerDetails.getUnit_name()+" \n ");
			sb.append("					"+officerDetails.getContact_no()+" \n ");
			sb.append(" ----------------------------------------     \n ");
		
			sb.append(" 	 PENDING CHALLANS ON "+eticket.getRegn_no()+" \n ");
			sb.append("          \n ");
			
			//pending challans entity,gatewaynamesentity, tti councelling entity withtime
			sb.append(" NO OF PENDING ECHALLANS :2 \n ");
			sb.append(" TOTAL PENDING AMOUNT    :270                 \n ");
			
			 
			sb.append(" PAYMENT CAN BE MADE AT ANY CENTER            \n ");
			sb.append(" APONLINE/ESEVA/COMPOUNDING BOOTH/            \n ");
			sb.append(" ANDROID APP/NETBANKING(WWW.ECHALLAN.ORG)     \n ");
			sb.append(" HELPLINE NO :040 27853416                    \n ");
			sb.append("                                              \n ");
			sb.append(" Please attend the counselling at TTI         \n ");
			sb.append(" center LB NAGAR TTI with your's              \n ");
			sb.append(" and your Parent's/Gaurdian's/Spouse's        \n ");
			sb.append(" AADHAAR card copy on This Friday/Saturday    \n ");
			sb.append(" between 10AM to 3PM.                         \n ");
			sb.append(" ----------------------------------------     \n ");

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	
	@Transactional
	public CommonResponse generateEchallan(MultipartFile file, String json) {
		
		CommonResponse response=new CommonResponse();
		SimpleDateFormat parse=new SimpleDateFormat("yyyy-MM-dd");
		ChallanTypeEntity_MA challanTypeEntity=null;
		StringBuffer violationBuffer=new StringBuffer();
		StringBuffer detainedItemsBuffer=new StringBuffer();
	try {
		ObjectMapper mapper = new ObjectMapper();
		RequestParams reqObj = mapper.readValue(json, RequestParams.class);
	
		Officer_v officerDetails =officerDetailsRepository.findByUserID(reqObj.getPid_cd());
		
		String drivingLicenceNo="NA";
		Optional<ChallanTypeEntity_MA> challanTypeEnty =challanTypeRepository.findById(reqObj.getChallan_type()!=null?Integer.parseInt(reqObj.getChallan_type()):null);
		
		if(challanTypeEnty.isPresent()) {
			challanTypeEntity=challanTypeEnty.get();
		}
		
		java.util.Date driverDob=null;
		
		//************* LOGIC TO GENERATE T_ETICKET ENTITY ******************
		EticketEntity eticket = new EticketEntity();
		eticket.setRegn_no(reqObj.getRegn_no());
		eticket.setUnit_cd(reqObj.getUnit_cd()!=null?Integer.parseInt(reqObj.getUnit_cd()):0);
		eticket.setState_cd(reqObj.getStateCode()!=null?Integer.parseInt(reqObj.getStateCode()):0);
		eticket.setBooked_ps_cd(officerDetails.getPs_cd());
		eticket.setCadre_cd(officerDetails.getCadre_cd());
		eticket.setChallan_base(reqObj.getChallan_base_cd()!=null?Integer.parseInt(reqObj.getChallan_base_cd()):0);
		eticket.setChallan_type(reqObj.getChallan_type() !=null?Integer.parseInt(reqObj.getChallan_type()):0);
		eticket.setDept_cd(reqObj.getDept_cd()!=null?Integer.parseInt(reqObj.getDept_cd()):0);
		eticket.setImage(reqObj.getImageStatus()!=null?Integer.parseInt(reqObj.getImageStatus()):0);
		eticket.setLogin_ID(reqObj.getPid_cd());
		eticket.setPoint_cd(Integer.parseInt(reqObj.getPoint_cd()));
		eticket.setPs_juris_cd(reqObj.getPs_juris_cd()!=null?Integer.parseInt(reqObj.getPs_juris_cd()):0);
		eticket.setResponsible_ps_cd(reqObj.getResponsible_ps_cd()!=null?Integer.parseInt(reqObj.getResponsible_ps_cd()):0);
		if(reqObj.getOffence_dt()!=null) {
			eticket.setOffence_dt(parse.parse(reqObj.getOffence_dt()));
		}
		//**** LOGIC TO GENERATE CHALLAN NUMBER SEQUENCE
		int ticketSequence=0;
		int currentYear =2018;
		try {
			currentYear = Calendar.getInstance().get(Calendar.YEAR);
			StoredProcedureQuery addBookNamedStoredProcedure = entityManager.createNamedStoredProcedureQuery("findByChallanTypeProcedure");
			addBookNamedStoredProcedure.setParameter("challan_type", Integer.parseInt(reqObj.getChallan_type()));
			addBookNamedStoredProcedure.execute();
			
			   Query q = entityManager.createQuery(
						"SELECT e FROM  ChallanNumberSequence e WHERE e.challan_type=:challan_type ");
				q.setParameter("challan_type", Integer.parseInt(reqObj.getChallan_type()));
				
				ChallanNumberSequence challanSeq= (ChallanNumberSequence)q.getSingleResult();
				
				if(challanSeq!=null) {
					ticketSequence=challanSeq.getSeq_no();
						logger.info("ChallanNumberSequence *****:"+ticketSequence);
				}else {
					logger.info("NO sequence generated for ChallanNumberSequence ");
				}
			
		} catch (Exception e) {
			logger.error("", e);
		}
		//**** END OF LOGIC TO GENERATE CHALLAN NUMBER 
		
		eticket.setEticket_no(ticketSequence);
		eticket.setChallan_no(reqObj.getUnitShortForm()+String.valueOf(eticket.getBooked_ps_cd()).substring(2,4) +currentYear+eticket.getEticket_no());
		
		if(reqObj.getDob()!=null) {
			driverDob=(java.util.Date)parse.parse(reqObj.getDob());
		}
		
		int totalActualFineAmt=0;
		if(reqObj.getViolations()!=null ) {
			for(ViolationsBean IndvOffence:reqObj.getViolations()) {
				if(IndvOffence!=null ) {
					totalActualFineAmt+=Integer.parseInt(IndvOffence.getFineAmount());
				}
		}}
		
		//************** T_VIOLATIONS TABLE insertion START****************
				List<ViolationsEntity> violationsList=insertViolations(eticket,violationBuffer,reqObj,response);
				if(violationsList!=null && violationsList.size()>0) {
					eticket.setViolations(violationsList);
				}
				
		//**************T_VIOLATIONS TABLE insertion  END ****************	
				
				
		if(reqObj.getEnforcementType()!=null)
			if("CONTACT".equalsIgnoreCase(reqObj.getEnforcementType())) {
				/*eticket.setGps_lat(Long.parseLong("1312.2234"));//gps_lat!=null?new BigDecimal(gps_lat.trim()):null);
				eticket.setGps_long(Long.parseLong("2342.3454"));//gps_long!=null?new BigDecimal(gps_long.trim()):null);
				*/
				eticket.setUCh_Amt(0);
				
				if("1".equals(reqObj.getChargeSheetStatus())) {
					//eticket_no,cs_issue_dt,cs_status,bac_level
					try {
						eticket.setFine_Amt(0);
						eticket.setTFine_Amt(0);
						
						List<ChargeSheetDetailsEntity> chargeSheetList=new ArrayList<ChargeSheetDetailsEntity>(); 
						ChargeSheetDetailsEntity chargeSheetEnty=new ChargeSheetDetailsEntity();
						chargeSheetEnty.setEticket_no(eticket.getEticket_no());
						chargeSheetEnty.setCs_issue_dt(parse.parse(reqObj.getOffence_dt()));
						chargeSheetEnty.setCs_status(1);
						
						
						if("TD".equals(challanTypeEntity.getChallan_sf().trim())) {
							chargeSheetEnty.setBac_level(reqObj.getBaclevel()!=null?Integer.parseInt(reqObj.getBaclevel()):null);
						}
						chargeSheetList.add(chargeSheetEnty);
						
						if(chargeSheetList!=null && chargeSheetList.size()>0)
							eticket.setChargeSheetDetailsEntity(chargeSheetList);
						
					} catch (Exception e) {
							logger.info("[LOGIC:Chargesheet insertion] error",e);
							response.setRespCode(0);
							response.setRespDesc("FAILED");
							response.setRespRemark("Challan Generation failure due to invalid data found at Chargesheet info");
					}
					
					
				}else {
					eticket.setFine_Amt(totalActualFineAmt);
					eticket.setTFine_Amt(totalActualFineAmt+eticket.getUCh_Amt());
				}
				
				if(reqObj.getId_proof()!=null && reqObj.getId_proof().size()>0) {
					for(IDProofBean iddetails:reqObj.getId_proof()) {
							if("2".equals(iddetails.getIdProofCd())) {
								drivingLicenceNo=iddetails.getIdProofDetails();
							}
				}}
				//*** LOGIC TO INSERT T_ID_PROOF_DETAILS START*************
				List<DriverDetailsEntity> driverDetailsentityList=insertIDDetails(reqObj,driverDob,""+eticket.getEticket_no(),response);
				
				if(driverDetailsentityList!=null && driverDetailsentityList.size()>0) {
					eticket.setDriverDetailsEntity(driverDetailsentityList);
				}
				//*** LOGIC TO INSERT T_ID_PROOF_DETAILS END ***************
		
				
				//*** LOGIC TO INSERT T_DETAINED_RELEASED END ***************
				List<DetainReleaseEntity> detainItemsEntityList=insertDetainItems(reqObj,detainedItemsBuffer,""+eticket.getEticket_no(),response);
				
				if(detainItemsEntityList!=null && detainItemsEntityList.size()>0) {
					eticket.setDetainEntity(detainItemsEntityList);
					eticket.setDetain_no_of_items(detainItemsEntityList.size());
				}
				//*** LOGIC TO INSERT T_DETAINED_RELEASED END ***************
				
				//check payment condition
				if("1".equals(reqObj.getPaymentStatus())) {
					eticket.setGtwy_cd(Integer.parseInt(reqObj.getGatewayCode()));
					eticket.setPayment_status("P");
					
					if(reqObj.getD_of_pay()!=null)
						eticket.setDate_of_pay(parse.parse(reqObj.getD_of_pay()));
					
					eticket.setPaid_amt(totalActualFineAmt);
					
					// generate TXN id dynamically or use db sequence
				
					eticket.setTransaction_id(eticket.getEticket_no());
					
					eticket.setAmt_collect_by_login_id(reqObj.getPid_cd());
				}else {
					eticket.setPayment_status("U");
				}
				
			}else if("NONCONTACT".equalsIgnoreCase(reqObj.getEnforcementType())) {
				eticket.setPayment_status("U");
				eticket.setUCh_Amt(35);
				eticket.setFine_Amt(totalActualFineAmt);
				eticket.setTFine_Amt(totalActualFineAmt+eticket.getUCh_Amt());
			}
		
		try {
			// ***  NONCONTACT ENFORCEMENT COMMIT START **********
			if("NONCONTACT".equalsIgnoreCase(reqObj.getEnforcementType())) {
				
				boolean b=utils.fileUpload(file, eticket.getChallan_no(), headDirectory,reqObj.getUnit_cd(), reqObj.getOffence_dt());
				
				if(b){
						// ******************* LOGIC TO SAVE T_HOTLIST ENTITY ************
						if(reqObj.getRemark_cd()!=null && reqObj.getRemark_cd().trim().length()>0) {
							
							t_hotlist hotlistEntity=new t_hotlist();
							hotlistEntity.setLogin_id(reqObj.getPid_cd());
							
							t_hotlistId listId=new t_hotlistId(Integer.parseInt(reqObj.getRemark_cd()),reqObj.getRegn_no(),1);
							
							hotlistEntity.setId(listId);
							entityManager.persist(hotlistEntity);
						}
						
						entityManager.persist(eticket);
						entityManager.flush();
						
						response.setRespCode(1);
						response.setRespDesc("SUCCESS");
						response.setRespRemark("Challan Generation success");
						
					
						
					
				}else {
					response.setRespCode(0);
					response.setRespDesc("FAILED");
					response.setRespRemark("Challan Generation failure due file upload issue");
				}
			}else {// ***  CONTACT ENFORCEMENT COMMIT START **********
				
				
					try {
						entityManager.persist(eticket);
						entityManager.flush();
						
						String sb=getPrintBuffer(reqObj.getUnitName() ,eticket,
								challanTypeEntity.getChallan_desc(),reqObj.getPaymentStatus(),
								drivingLicenceNo,driverDob,violationBuffer.toString(),
								detainedItemsBuffer.toString(),officerDetails);
						
						response.setRespCode(1);
						response.setRespDesc("SUCCESS");
						response.setRespRemark(sb);
					} catch (Exception e) {
						response.setRespCode(0);
						response.setRespDesc("FAILED");
						response.setRespRemark("Challan Generation failure due to "+e);
						logger.info("[Error:PersistenceException]", e);
					}
					
					
				
				
			}// *** END OF CONTACT ENFORCEMENT **********
			
		} catch (PersistenceException e) {
			logger.error("Challan Generation failed . reason", e);
			response.setRespCode(0);
			response.setRespDesc("FAILED");
			response.setRespRemark("Challan Generation failure due to "+e);
		}

		} catch (Exception e) {
			logger.error("Challan Generation failed . reason", e);
			response.setRespCode(0);
			response.setRespDesc("FAILED");
			response.setRespRemark("Challan Generation failure due to "+e);
		}
		
		logger.info("challan generation response code::"+response.getRespCode()+ " desc:"+response.getRespDesc()+" remarks:"+response.getRespRemark());
		return response;
		
		
	}

	private List<ViolationsEntity> insertViolations(EticketEntity eticket, StringBuffer violationBuffer,
			RequestParams reqObj, CommonResponse response) {
		List<ViolationsEntity> violationsList=new ArrayList<ViolationsEntity>(); 
		try {
			int row=1;
			if(reqObj.getViolations()!=null ) {
				for(ViolationsBean IndvOffence:reqObj.getViolations()) {
					if(IndvOffence!=null ) {
							ViolationsEntity vioEnty=new ViolationsEntity();
							vioEnty.setEticket_no(eticket.getEticket_no());
							vioEnty.setOffence_cd(IndvOffence.getOffenceCode()!=null?Integer.parseInt(IndvOffence.getOffenceCode()):0);
							vioEnty.setAFine_Amt(IndvOffence.getFineAmount()!=null?Integer.parseInt(IndvOffence.getFineAmount()):0);
							
							violationsList.add(vioEnty);
							
							violationBuffer.append(row+". "+IndvOffence.getOffenceDesc()+"("+IndvOffence.getSection()+")"+ IndvOffence.getFineAmount()+" \n");
						}
					row++;
			    }
				
			}
		} catch (Exception e) {
			logger.info("", e);
			response.setRespCode(0);
			response.setRespDesc("FAILED");
			response.setRespRemark("Challan Generation failure due to invalid data found at Violations info");
		}
		return violationsList;
	}

	private List<DetainReleaseEntity> insertDetainItems(RequestParams reqObj, StringBuffer detainedItemsBuffer,String eticketNo,CommonResponse response) {
		List<DetainReleaseEntity> detainItemsEntityList=new ArrayList<DetainReleaseEntity>(); 
		try {
			int detCnt=1;
			List<DetainedItemsBean> detainedList =reqObj.getDt_items();
			
			if(detainedList!=null && detainedList.size()>0) {
			for(DetainedItemsBean detainedObj:detainedList) {
			
				if("1".equalsIgnoreCase(detainedObj.getDetainedStatus())) {
				
						DetainReleaseEntity detainedEnty=new DetainReleaseEntity();
						detainedEnty.setDt_Item_CD(detainedObj.getDetainedItemCode()!=null?Integer.parseInt(detainedObj.getDetainedItemCode()):0);
						detainedEnty.setEticket_no(eticketNo);
						detainedEnty.setDt_By_Login_ID(reqObj.getPid_cd());
						detainedEnty.setDt_Status(detainedObj.getDetainedStatus() !=null?Integer.parseInt(detainedObj.getDetainedStatus()):0);
						detainedEnty.setRegn_no(reqObj.getRegn_no());
					
						detainItemsEntityList.add(detainedEnty);
						
						detainedItemsBuffer.append(detCnt +". "+detainedObj.getDetainedItemName()+"\n");
						detCnt++;
					
				}
			}}
			
		} catch (Exception e) {
			logger.info("[method:insertdetainedItems] error", e);
			response.setRespCode(0);
			response.setRespDesc("FAILED");
			response.setRespRemark("Challan Generation failure due to invalid data found at Detained Items info");
		}
		return detainItemsEntityList;
	}

	private List<DriverDetailsEntity> insertIDDetails(RequestParams reqObj, Date driverDob, String eticketNo,CommonResponse response) {
		List<DriverDetailsEntity> driverDetailsentityList=new ArrayList<DriverDetailsEntity>();
		try {
			if(reqObj.getId_proof()!=null && reqObj.getId_proof().size()>0) {
				for(IDProofBean iddetails:reqObj.getId_proof()) {
						DriverDetailsEntity driverDetailsEntity=new DriverDetailsEntity();
						
						driverDetailsEntity.setId_det(iddetails.getIdProofDetails().trim().toUpperCase());
						driverDetailsEntity.setId_proof_cd(iddetails.getIdProofCd()!=null?Integer.parseInt(iddetails.getIdProofCd()):0);
						driverDetailsEntity.setName(reqObj.getName().trim().toUpperCase());
						driverDetailsEntity.setOccupation_cd(reqObj.getOccupation_cd()!=null?Integer.parseInt(reqObj.getOccupation_cd()):11);//11 indicates others
						driverDetailsEntity.setParent_name(reqObj.getParent_name().trim().toUpperCase());
						driverDetailsEntity.setPenalty_points(reqObj.getPenalty_points()!=null?Integer.parseInt(reqObj.getPenalty_points()):0);
						driverDetailsEntity.setAddress(reqObj.getAddress().trim().toUpperCase());
						driverDetailsEntity.setAge(reqObj.getAge()!=null?Integer.parseInt(reqObj.getAge()):0);
						driverDetailsEntity.setContact_no(reqObj.getContact_no()!=null?Long.parseLong(reqObj.getContact_no().trim()):0);
						driverDetailsEntity.setDob(driverDob);
						driverDetailsEntity.setEducation_cd(reqObj.getEducation_cd()!=null?Integer.parseInt(reqObj.getEducation_cd()):10);// indicates others
						driverDetailsEntity.setEticket_no(eticketNo);
						driverDetailsEntity.setGender(reqObj.getGender()!=null?Integer.parseInt(reqObj.getGender()):0);
						
						driverDetailsentityList.add(driverDetailsEntity);
						
					}
				
				
			}
		} catch (Exception e) {
			logger.info("[method:insertIDDetails] error",e);
			response.setRespCode(0);
			response.setRespDesc("FAILED");
			response.setRespRemark("Challan Generation failure due to invalid data found at ID Details info");
			
		}
		
		return driverDetailsentityList;
	}

	

	
}
