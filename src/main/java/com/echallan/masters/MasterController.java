package com.echallan.masters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.echallan.officerRegistration.Officer_v;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class MasterController {


@Autowired
private MasterService masterService;


		@GetMapping("/echallan/offenceMaster")
		public List<SectionsEntity_MA> getSectionMaster(@RequestParam String offence_cds) {
			List<SectionsEntity_MA> response= masterService.offenceMaster(offence_cds);
			return response; 
		}

		@GetMapping("/echallan/cadreMaster")
		public List<CadreEntity_MA> getcadreMaster() {
			List<CadreEntity_MA> response= masterService.getcadreMaster();
			return response; 
		}
		
		@GetMapping("/echallan/challanBaseMaster")
		public List<ChallanBaseEntity_MA> getChallanbase() {
			List<ChallanBaseEntity_MA> response= masterService.getChallanbase();
			return response;
		}
		
		@GetMapping("/echallan/challanTypeMaster")
		public List<ChallanTypeEntity_MA> getChallanType() {
			List<ChallanTypeEntity_MA> response= masterService.getChallanType();
			return response;
		}
		
		@GetMapping("/echallan/complaintsMaster")
		public List<ComplaintsEntity_MA> getcomplaintsMaster() {
			List<ComplaintsEntity_MA> response= masterService.getcomplaintsMaster();
			return response;
		}
		
		@GetMapping("/echallan/convictionMaster")
		public List<ConvictionEntity_MA> getconvictionMaster() {
			List<ConvictionEntity_MA> response= masterService.getconvictionMaster();
			return response; 
		}
		
		@GetMapping("/echallan/courtMaster")
		public List<CourtEntity_MA> getcourtMaster(@RequestParam  int unitCode) {
			List<CourtEntity_MA> response= masterService.getcourtMaster(unitCode);
			return response; 
		}
		
		@GetMapping("/echallan/deptMaster")
		public List<DeptEntity_MA> getdeptMaster() {
			List<DeptEntity_MA> response= masterService.getdeptMaster();
			return response; 
		}
		
		@GetMapping("/echallan/divisionItemsMaster")
		public List<DivisionEntity_MA> getdivisionMaster(@RequestParam  int unitCode) {
			List<DivisionEntity_MA> response= masterService.getdivisionMaster(unitCode);
			return response; 
		}
		
		@GetMapping("/echallan/dutiesMaster")
		public List<DutiesEntity_MA> getdutiesMaster() {
			List<DutiesEntity_MA> response= masterService.getdutiesMaster();
			return response;
		}
		
		@GetMapping("/echallan/educationMaster")
		public List<EducationEntity_MA> geteducationMaster() {
			List<EducationEntity_MA> response= masterService.geteducationMaster();
			return response; 
		}
		
		@GetMapping("/echallan/finesMaster")
		public List<FinesEntity_MA> getfinesMaster() {
			List<FinesEntity_MA> response= masterService.getfinesMaster();
			return response; 
		}
		
		@GetMapping("/echallan/gatewayMaster")
		public List<GatewayEntity_MA> getgatewayMaster() {
			List<GatewayEntity_MA> response= masterService.getgatewayMaster();
			return response; 
		}
		
		@GetMapping("/echallan/idproofMaster")
		public List<IdproofEntity_MA> getidproofMaster() {
			List<IdproofEntity_MA> response= masterService.getidproofMaster();
			return response; 
		}
		
		@GetMapping("/echallan/occupationMaster")
		public List<OccupationEntity_MA> getoccupationMaster() {
			List<OccupationEntity_MA> response= masterService.getoccupationMaster();
			return response; 
		}
		
		@GetMapping("/echallan/pointsMaster") 
		public List<PointsEntity_MA> getpointsMaster(@RequestParam  int psCode) {
			List<PointsEntity_MA> response= masterService.getpointsMaster(psCode);
			return response; 
		}
		
		@GetMapping("/echallan/psMaster")
		public List<PsEntity_MA> getpsMaster(@RequestParam  int zoneCode) {
			List<PsEntity_MA> response= masterService.getpsMaster(zoneCode);
			return response; 
		}
		
		@GetMapping("/echallan/psMasterbyUnit")
		public List<PsEntity_MA> getpsMasterbyUnit(@RequestParam  int unitCode) {
			List<PsEntity_MA> response= masterService.getpsMasterbyUnit(unitCode);
			return response; 
		}
		
		@GetMapping("/echallan/remarksMaster")
		public List<RemarksEntity_MA> getremarksMaster() {
			List<RemarksEntity_MA> response= masterService.getremarksMaster();
			return response; 
		}

		@GetMapping("/echallan/sectionMaster")
		public List<SectionsEntity_MA> getsectionMaster() {
			List<SectionsEntity_MA> response= masterService.getsectionMaster();
			return response;
		}
		
		@GetMapping("/echallan/stateMaster")
		public List<StateEntity_MA> getstateMaster() {
			List<StateEntity_MA> response= masterService.getstateMaster();
			return response;
		}
		
		@GetMapping("/echallan/unitMaster")
		public List<UnitEntity_MA> getunitMaster(@RequestParam  int stateCode) {
			List<UnitEntity_MA> response= masterService.getunitMaster(stateCode);
			return response; 
		} 
		
		@GetMapping("/echallan/wheelerMaster")
		public List<WheelerEntity_MA> getwheelerMaster() {
			List<WheelerEntity_MA> response= masterService.getwheelerMaster();
			return response;
		}
		
		@GetMapping("/echallan/zoneMaster")
		public List<ZoneEntity_MA> getzoneMaster(@RequestParam  int divisionCode) {
			List<ZoneEntity_MA> response= masterService.getzoneMaster(divisionCode);
			return response; 
		}

		
		
}