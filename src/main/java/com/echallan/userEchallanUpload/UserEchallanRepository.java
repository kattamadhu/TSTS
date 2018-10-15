package com.echallan.userEchallanUpload;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.echallan.utils.CDAC_SMS;


@Repository
public  class UserEchallanRepository implements JpaRepository<UserEchallanEntity, String> {
	 private static final Logger logger = LoggerFactory.getLogger(UserEchallanRepository.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	CDAC_SMS cdacSms;
	 
	public UserEchallanConfirmResponse updateComplaintStatus(UserEchallanEntity complaints) {
		
		UserEchallanConfirmResponse resp=null;
		
		try {
			resp=new UserEchallanConfirmResponse();
		    Query q = entityManager.createQuery("SELECT e FROM  UserEchallanEntity e WHERE e.fileName = :fileName ");
			q.setParameter("fileName", complaints.getFileName());
			
			UserEchallanEntity complaint= (UserEchallanEntity)q.getSingleResult();
			
			if(complaint!=null) {
					
					Query query = entityManager
							.createQuery("UPDATE UserEchallanEntity e SET e.actionTaken=:status  "
							+ "WHERE e.fileName= :fileName");
							query.setParameter("status", 1);
							query.setParameter("fileName",complaint.getFileName() );
							
							int updateCount = query.executeUpdate();
							if (updateCount > 0) {
								resp.setComplaintStatus("SUCCESS");
								String message="Dear Sir/Madam, eChallan has been successfully generated against your Complaint id:"+complaint.getComplaintId()+"";
								cdacSms.sendOTPSMS(""+complaint.getMobileNo(),message);
							}else {
								resp.setComplaintStatus("FAILUED");
							}
					
				}else {
					resp.setComplaintStatus("NOT_EXIST");
				}
			
		} catch (Exception e) {
			resp.setComplaintStatus("ERROR");
			logger.error("[method:registerUser]", e);
		}
		
		return resp;
	}

	public Page<UserEchallanEntity> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends UserEchallanEntity> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<UserEchallanEntity> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}

	public void delete(UserEchallanEntity entity) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAll(Iterable<? extends UserEchallanEntity> entities) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	public <S extends UserEchallanEntity> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends UserEchallanEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends UserEchallanEntity> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public <S extends UserEchallanEntity> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	public void deleteInBatch(Iterable<UserEchallanEntity> arg0) {
		// TODO Auto-generated method stub
		
	}

	public List<UserEchallanEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UserEchallanEntity> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends UserEchallanEntity> List<S> findAll(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends UserEchallanEntity> List<S> findAll(Example<S> arg0, Sort arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UserEchallanEntity> findAllById(Iterable<String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public void flush() {
		// TODO Auto-generated method stub
		
	}

	public UserEchallanEntity getOne(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends UserEchallanEntity> List<S> saveAll(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends UserEchallanEntity> S saveAndFlush(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
}