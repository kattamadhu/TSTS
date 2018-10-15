package com.echallan.challanGeneration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.echallan.response.CommonResponse;

/**
 * 
 * @author Madhusudhan
 *
 */

@RestController
public class EchallanGenerationController {

private static final Logger logger = LoggerFactory.getLogger(EchallanGenerationController.class);

@Autowired
private EchallanGenerationService echallanGenService;

@PostMapping("/echallan/TicketGen")
public CommonResponse  generateEchallan(@RequestParam("file") MultipartFile file,@RequestParam("json") String json ) {
	CommonResponse response=null;
	
	response=echallanGenService.generateEchallan(file,json);
	
	
	logger.info("[method:generateEchallan] response :"+response);
	
	return response;
}



@PostMapping("/EchallanGeneration")
public CommonResponse generateEchallanCntrl(
		@RequestParam("file") MultipartFile file,
		@RequestParam("unit_cd") String unit_cd,
		@RequestParam("unitName") String unitName,
		@RequestParam("unitShortForm") String unitShortForm,
		@RequestParam("stateCode") String stateCode,
		@RequestParam("challan_type") String challan_type,
		@RequestParam("enforcementType") String enforcementType,
		@RequestParam("chargeSheetStatus") String chargeSheetStatus,
		@RequestParam("baclevel") String baclevel,
		@RequestParam("paymentStatus") String paymentStatus,
		@RequestParam("gatewayCode") String gatewayCode,
		@RequestParam("dept_cd") String dept_cd,
		@RequestParam("ps_juris_cd") String ps_juris_cd,
		@RequestParam("responsible_ps_cd") String  responsible_ps_cd,
		@RequestParam("point_cd") String  point_cd,
		@RequestParam("regn_no") String regn_no,
		@RequestParam("offence_dt") String offence_dt,
		@RequestParam("pid_cd") String pid_cd,
		@RequestParam("d_of_pay") String d_of_pay,
		@RequestParam("paid_amt") String paid_amt,
		@RequestParam("remark_cd") String remark_cd,
		@RequestParam("imageStatus") String imageStatus,
		@RequestParam("challan_base_cd") String challan_base_cd,
		@RequestParam("violations") String violations,
		@RequestParam("dt_items") String dt_items,
		@RequestParam("dt_status") String dt_status,
		@RequestParam("id_proof_cd")  String id_proof_cd,
		@RequestParam("id_det")  String id_det,
		@RequestParam("dob")  String dob,
		@RequestParam("age")  String age,
		@RequestParam("gender")  String gender,
		@RequestParam("name")  String name,
		@RequestParam("parent_name")  String parent_name,
		@RequestParam("address")  String address,
		@RequestParam("contact_no")  String contact_no,
		@RequestParam("occupation_cd")  String occupation_cd,
		@RequestParam("education_cd")  String education_cd,
		@RequestParam("penalty_points")  String penalty_points,
		@RequestParam("gps_lat")  String gps_lat,
		@RequestParam("gps_long")  String gps_long
) {
	
	CommonResponse response=null;
	try {
		 response = echallanGenService.generateEchallan(file, unit_cd, dept_cd, 
				ps_juris_cd, responsible_ps_cd, point_cd, regn_no, offence_dt, pid_cd, 
				 challan_type, d_of_pay, paid_amt, remark_cd, imageStatus, challan_base_cd,
				violations, dt_items, dt_status,id_proof_cd, id_det, dob, age, gender, name, parent_name,
				address, contact_no, occupation_cd,education_cd, penalty_points,gps_lat,gps_long,enforcementType,
				paymentStatus,gatewayCode,stateCode,unitName,unitShortForm,chargeSheetStatus,baclevel);
		
	} catch (Exception e) {
		response.setRespCode(0);
		response.setRespDesc("FAILED");
		response.setRespRemark("Challan generation failure");
	}
	
	
	
	return response;
}	

}