package com.echallan.masters;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.echallan.officerRegistration.OfficerDetailsRepository;
import com.echallan.officerRegistration.Officer_v;
import com.echallan.userEchallanUpload.UserEchallanEntity;


@Service
public class MasterService {
	
	private static final Logger logger = LoggerFactory.getLogger(MasterService.class);
	
	@Autowired
	private SectionsRepository masectionsRepository;
	@Autowired
	private ChallanBaseRepository machallanBaseRepository;
	@Autowired
	private ChallanTypeRepository machallanTypeRepository;
	@Autowired
	private ComplaintsRepository macomplaintsRepository;
	@Autowired
	private CadreRepository macadreRepository;
	@Autowired
	private ConvictionRepository maconvictionRepository;
	@Autowired
	private CourtRepository macoourtRepository;
	@Autowired
	private DeptRepository madeptRepository;
	
	@Autowired
	private SectionsRepository sectionsRepository;
	
	@Autowired
	private EntityManager entityManager;
	
	@Transactional
	public List<SectionsEntity_MA> getsectionMaster() {
		
		List<SectionsEntity_MA> resp=null;
			try {
				resp = masectionsRepository.findAll();
					if (resp!=null) {
						logger.info("getsectionMaster details found");
					}else {
						logger.info("getsectionMaster details not found");
					}
			} catch (Exception e) {
				logger.error("[method:getsectionMaster] ERROR:",e);
			}
		 return resp;
	}

	
	@Transactional
	public List<ChallanBaseEntity_MA> getChallanbase() {
		
		List<ChallanBaseEntity_MA> resp=null;
			try {
				resp = machallanBaseRepository.findAll();
					if (resp!=null) {
						logger.info("getsectionMaster details found");
					}else {
						logger.info("getsectionMaster details not found");
					}
			} catch (Exception e) {
				logger.error("[method:getChallanbase] ERROR:",e);
			}
		 return resp;
	} 
	
	@Transactional
	public List<ChallanTypeEntity_MA> getChallanType() {
		
		List<ChallanTypeEntity_MA> resp=null;
			try {
				resp = machallanTypeRepository.findAll();
					if (resp!=null) {
						logger.info("getChallanType details found");
					}else {
						logger.info("getChallanType details not found");
					}
			} catch (Exception e) {
				logger.error("[method:getChallanType] ERROR:",e);
			}
		 return resp;
	}
	
	@Transactional
	public List<ComplaintsEntity_MA> getcomplaintsMaster() {
		
		List<ComplaintsEntity_MA> resp=null;
			try {
				resp = macomplaintsRepository.findAll();
					if (resp!=null) {
						logger.info("getcomplaintsMaster details found");
					}else {
						logger.info("getcomplaintsMaster details not found");
					}
			} catch (Exception e) {
				logger.error("[method:getcomplaintsMaster] ERROR:",e);
			}
		 return resp;
	}
	
	@Transactional
	public List<CadreEntity_MA> getcadreMaster() {
		
		List<CadreEntity_MA> resp=null;
			try {
				resp = macadreRepository.findAll();
					if (resp!=null) {
						logger.info("getcadreMaster details found");
					}else {
						logger.info("getcadreMaster details not found");
					}
			} catch (Exception e) {
				logger.error("[method:getcadreMaster] ERROR:",e);
			}
		 return resp;
	}


	public List<ConvictionEntity_MA> getconvictionMaster() {
		
		List<ConvictionEntity_MA> resp=null;
			try {
				resp = maconvictionRepository.findAll();
					if (resp!=null) {
						logger.info("getconvictionMaster details found");
					}else {
						logger.info("getconvictionMaster details not found");
					}
			} catch (Exception e) {
				logger.error("[method:getconvictionMaster] ERROR:",e);
			}
		 return resp;
	}


	public List<CourtEntity_MA> getcourtMaster(int unitCode) {
		
		List<CourtEntity_MA> resp=null;
			try {
				resp = macoourtRepository.findByUnitCode(unitCode);
					if (resp!=null) {
						logger.info("getcourtMaster details found");
					}else {
						logger.info("getcourtMaster details not found");
					}
			} catch (Exception e) {
				logger.error("[method:getcourtMaster] ERROR:",e);
			}
		 return resp;
	}


	public List<DeptEntity_MA> getdeptMaster() {
		
		List<DeptEntity_MA> resp=null;
			try {
				resp = madeptRepository.findAll();
					if (resp!=null) {
						logger.info("getdeptMaster details found");
					}else {
						logger.info("getdeptMaster details not found");
					}
			} catch (Exception e) {
				logger.error("[method:getdeptMaster] ERROR:",e);
			}
		 return resp;
	}

@Autowired
private DetainItemRepository madetainItemRepository;
	public List<DetainItemEntity_MA> getdetainItemsMaster() {
		
		List<DetainItemEntity_MA> resp=null;
			try {
				resp = madetainItemRepository.findAll();
					if (resp!=null) {
						logger.info("getdetainItemsMaster details found");
					}else {
						logger.info("getdetainItemsMaster details not found");
					}
			} catch (Exception e) {
				logger.error("[method:getdetainItemsMaster] ERROR:",e);
			}
		 return resp;
	}

	@Autowired
	private DivisionRepository madivisionRepository;

	public List<DivisionEntity_MA> getdivisionMaster(int unitCode) {
		
		List<DivisionEntity_MA> resp=null;
			try {
				//resp = madivisionRepository.findAll();
				resp = madivisionRepository.findByUnitCode(unitCode);
				
					if (resp!=null) {
						logger.info("getdivisionMaster details found");
					}else {
						logger.info("getdivisionMaster details not found");
					}
			} catch (Exception e) {
				logger.error("[method:getdivisionMaster] ERROR:",e);
			}
		 return resp;
	}

	@Autowired
	private DutiesRepository madutiesRepository;
	public List<DutiesEntity_MA> getdutiesMaster() {
		
		List<DutiesEntity_MA> resp=null;
			try {
				resp = madutiesRepository.findAll();
					if (resp!=null) {
						logger.info("getdutiesMaster details found");
					}else {
						logger.info("getdutiesMaster details not found");
					}
			} catch (Exception e) {
				logger.error("[method:getdutiesMaster] ERROR:",e);
			}
		 return resp;
	}


	@Autowired
	private EducationRepository maeducationRepository;
	public List<EducationEntity_MA> geteducationMaster() {
		
		List<EducationEntity_MA> resp=null;
			try {
				resp = maeducationRepository.findAll();
					if (resp!=null) {
						logger.info("geteducationMaster details found");
					}else {
						logger.info("geteducationMaster details not found");
					}
			} catch (Exception e) {
				logger.error("[method:geteducationMaster] ERROR:",e);
			}
		 return resp;
	}

	@Autowired
	private FinesRepository mafinesRepository;
	public List<FinesEntity_MA> getfinesMaster() {
		
		List<FinesEntity_MA> resp=null;
			try {
				resp = mafinesRepository.findAll();
					if (resp!=null) {
						logger.info("MAfinesEntity details found");
					}else {
						logger.info("MAfinesEntity details not found");
					}
			} catch (Exception e) {
				logger.error("[method:MAfinesEntity] ERROR:",e);
			}
		 return resp;
	}

	@Autowired
	private GatewayRepository magatewayRepository;
	public List<GatewayEntity_MA> getgatewayMaster() {
		
		List<GatewayEntity_MA> resp=null;
			try {
				resp = magatewayRepository.findAll();
					if (resp!=null) {
						logger.info("MAfinesEntity details found");
					}else {
						logger.info("MAfinesEntity details not found");
					}
			} catch (Exception e) {
				logger.error("[method:MAfinesEntity] ERROR:",e);
			}
		 return resp;
	}

	@Autowired
	private IdproofRepository maidproofRepository;
	public List<IdproofEntity_MA> getidproofMaster() {
		
		List<IdproofEntity_MA> resp=null;
			try {
				resp = maidproofRepository.findAll();
					if (resp!=null) {
						logger.info("getidproofMaster details found");
					}else {
						logger.info("getidproofMaster details not found");
					}
			} catch (Exception e) {
				logger.error("[method:getidproofMaster] ERROR:",e);
			}
		 return resp;
	}

	@Autowired
	private OccupationRepository maoccupationRepository;
	public List<OccupationEntity_MA> getoccupationMaster() {
		
		List<OccupationEntity_MA> resp=null;
			try {
				resp = maoccupationRepository.findAll();
					if (resp!=null) {
						logger.info("getoccupationMaster details found");
					}else {
						logger.info("getoccupationMaster details not found");
					}
			} catch (Exception e) {
				logger.error("[method:getoccupationMaster] ERROR:",e);
			}
		 return resp;
	}

	@Autowired
	private PointsRepository mapointsRepository;
	public List<PointsEntity_MA> getpointsMaster (int psCode) {
		
		List<PointsEntity_MA> resp=null;
			try {
				resp = mapointsRepository.findByPsCode(psCode);
					if (resp!=null) {
						logger.info("getpointsMaster details found");
					}else {
						logger.info("getpointsMaster details not found");
					}
			} catch (Exception e) {
				logger.error("[method:getpointsMaster] ERROR:",e);
			}
		 return resp;
	}

	@Autowired
	private PsRepository mapsRepository;
	public List<PsEntity_MA> getpsMaster(int zoneCode) {
		
		List<PsEntity_MA> resp=null;
			try {
				resp = mapsRepository.findByZoneCode(zoneCode);
					if (resp!=null) {
						logger.info("getpsMaster details found");
					}else {
						logger.info("getpsMaster details not found");
					}
			} catch (Exception e) {
				logger.error("[method:getpsMaster] ERROR:",e);
			}
		 return resp;  
	} 
	
	
	@Autowired
	private OfficerDetailsRepository officerDetailsRepository;
	public List<PsEntity_MA> getpsMasterbyUnit(int unitCode) {
		List<PsEntity_MA> unitpsList=null;
		PsEntity_MA psEntity=null;
		List<Officer_v> resp=null;
			try {
				resp = officerDetailsRepository.findByUnitcd(unitCode);
					if (resp!=null) {
						unitpsList=new ArrayList<PsEntity_MA>();
						System.out.println("resp :"+resp.size()+" unitCode:"+unitCode);
						
						for(Officer_v psList:resp) {
							
							logger.info(" Ps Code :"+psList.getPs_cd()+"  psName:"+psList.getPs_name());
							
							psEntity=new PsEntity_MA();
							psEntity.setPs_cd(psList.getPs_cd());
							psEntity.setPs_name(psList.getPs_name());
							unitpsList.add(psEntity);
						}
						
						logger.info("getpsMasterbyUnit details found"); 
					}else {
						logger.info("getpsMasterbyUnit details not found"); 
					}
			} catch (Exception e) {
				logger.error("[method:getpsMaster] ERROR:",e); 
			}
		 return unitpsList;
	}

	@Autowired
	private RemarksRepository maremarksRepository;
	public List<RemarksEntity_MA> getremarksMaster() {
		
		List<RemarksEntity_MA> resp=null;
			try {
				resp = maremarksRepository.findAll();
					if (resp!=null) {
						logger.info("getremarksMaster details found");
					}else {
						logger.info("getremarksMaster details not found");
					}
			} catch (Exception e) {
				logger.error("[method:getremarksMaster] ERROR:",e);
			}
		 return resp;
	}

	@Autowired
	private StateRepository mastateRepository;
	public List<StateEntity_MA> getstateMaster() {
		
		List<StateEntity_MA> resp=null;
			try {
				resp = mastateRepository.findAll();
					if (resp!=null) {
						logger.info("getstateMaster details found");
					}else {
						logger.info("getstateMaster details not found");
					}
			} catch (Exception e) {
				logger.error("[method:getstateMaster] ERROR:",e);
			}
		 return resp;
	}

	@Autowired
	private UnitRepository maunitRepository;
	public List<UnitEntity_MA> getunitMaster(int stateCode) {
		List<UnitEntity_MA> resp=null;
			try {
				resp = maunitRepository.findByStateCode(stateCode);
					if (resp!=null) {
						logger.info("getstateMaster details found");
					}else {
						logger.info("getstateMaster details not found");
					}
			} catch (Exception e) {
				logger.error("[method:getstateMaster] ERROR:",e);
			}
		 return resp;
	}

	@Autowired
	private WheelerRepository	mawheelerRepository;
	public List<WheelerEntity_MA> getwheelerMaster() {
		List<WheelerEntity_MA> resp=null;
		try {
			resp = mawheelerRepository.findAll();
				if (resp!=null) {
					logger.info("getwheelerMaster details found");
				}else {
					logger.info("getwheelerMaster details not found");
				}
		} catch (Exception e) {
			logger.error("[method:getwheelerMaster] ERROR:",e);
		}
	 return resp;
}

	@Autowired
	private ZoneRepository mazoneRepository;
	public List<ZoneEntity_MA> getzoneMaster(int divisionCode) {
		List<ZoneEntity_MA> resp=null;
		try {
			resp = mazoneRepository.findByDivisionCode(divisionCode);
				if (resp!=null) {
					logger.info("getzoneMaster details found");
				}else {
					logger.info("getzoneMaster details not found");
				}
		} catch (Exception e) {
			logger.error("[method:getzoneMaster] ERROR:",e);
		}
	 return resp;
}

	
	public Officer_v getofficerDetails(String empID,String pwd) {
		Officer_v resp=null;
		try {
			resp = officerDetailsRepository.findByUserIDAndPwd(empID,pwd);
				if (resp!=null) {
					logger.info("getofficerDetails details found");
				}else {
					logger.info("getofficerDetails details not found");
				}
		} catch (Exception e) {
			logger.error("[method:getofficerDetails] ERROR:",e);
		}
	 return resp; 
}


	public List<SectionsEntity_MA> offenceMaster(String offence_cds) {
		List<SectionsEntity_MA> complaint=null;
		try {
		    Query q = entityManager.createQuery("SELECT e FROM  SectionsEntity_MA e WHERE e.offence_cd = :offence_cd ");
				q.setParameter("offence_cd", offence_cds);
				
				complaint= q.getResultList();
				
				if(complaint!=null) {
					
				}
			
		} catch (Exception e) {
			logger.error("[offenceMaster:method] ERROR:",e);
		}
		return complaint;
	}


	


	
}
