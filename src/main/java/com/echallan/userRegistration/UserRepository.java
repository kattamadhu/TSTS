package com.echallan.userRegistration;

import java.util.List;
import java.util.Optional;
import java.util.Random;

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
	public class UserRepository  implements JpaRepository<UserEntity, String> {
		  private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);
		
		@PersistenceContext
		private EntityManager entityManager;
		
		@Autowired
		CDAC_SMS cdacSms;

		public UserEntity selectUserById(long userId) {
			return entityManager.find(UserEntity.class, userId);
		}

		public UserEntity insertUser(UserEntity user) {
			
			logger.debug("user name:"+user.getUserName());
			logger.debug("user email:"+user.getUserEmail());
			logger.debug("user phone:"+user.getUserPhoneNo());
			
			logger.debug("Debugging log");
	        logger.info("Info log");
	        logger.warn("Warning log");
	        logger.error("Error log");
	        
			
			//generate otp 
			Random rand = new Random(); int otp;
			otp = rand.nextInt (9000) + 100; 
			
			String message="Dear "+user.getUserName()+",Your Citizen eChallan Application Registration OTP is "+otp;
			// 1 sens otp to mobile
			
			cdacSms.sendOTPSMS(""+user.getUserPhoneNo(),message);
			
			//set same otp to user class
			
			user.setUserOTP(otp);
			entityManager.persist(user);
			entityManager.flush();
			
			//send otp 
			
			return user;
			
		}

		public UserEntity registerUser(UserEntity user) {
			// hibernate sql
			UserEntity userMain=null;
			
			try {
				System.out.println("****************UserRegister ID:"+user.getUserId() );
				System.out.println("****************UserRegister OTP:"+user.getUserOTP());
				System.out.println("****************UserRegister phone:"+user.getUserPhoneNo());

			    Query q = entityManager.createQuery(
						"SELECT e FROM  UserEntity e WHERE e.userId = :userId and e.userPhoneNo = :mobile and e.userOTP = :otp ");
				q.setParameter("userId", user.getUserId());
				q.setParameter("mobile", user.getUserPhoneNo());
				q.setParameter("otp", user.getUserOTP());
				
				
				UserEntity usr= (UserEntity)q.getSingleResult();
				
				logger.info("List<User> size:"+usr);
				
					if(usr!=null) {
						userMain=usr;
						logger.info("************************ User registration success with User Name:"+usr.getUserName());
						System.out.println("************************ User registration success with User Name:"+usr.getUserName());
						String message="Dear "+usr.getUserName()+", your Citizen eChallan Application Registration is Successfull";
						// 2 sens otp to mobile
						cdacSms.sendOTPSMS(""+user.getUserPhoneNo(),message);
						
					}
				
			} catch (Exception e) {
				logger.error("[method:registerUser]", e);
			}
			return userMain;
		}

		public Page<UserEntity> findAll(Pageable pageable) {
			// TODO Auto-generated method stub
			return null;
		}

		public <S extends UserEntity> S save(S entity) {
			// TODO Auto-generated method stub
			return null;
		}

		public Optional<UserEntity> findById(String id) {
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

		public void delete(UserEntity entity) {
			// TODO Auto-generated method stub
			
		}

		public void deleteAll(Iterable<? extends UserEntity> entities) {
			// TODO Auto-generated method stub
			
		}

		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}

		public <S extends UserEntity> Optional<S> findOne(Example<S> example) {
			// TODO Auto-generated method stub
			return null;
		}

		public <S extends UserEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
			// TODO Auto-generated method stub
			return null;
		}

		public <S extends UserEntity> long count(Example<S> example) {
			// TODO Auto-generated method stub
			return 0;
		}

		public <S extends UserEntity> boolean exists(Example<S> example) {
			// TODO Auto-generated method stub
			return false;
		}

		public void deleteAllInBatch() {
			// TODO Auto-generated method stub
			
		}

		public void deleteInBatch(Iterable<UserEntity> arg0) {
			// TODO Auto-generated method stub
			
		}

		public List<UserEntity> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

		public List<UserEntity> findAll(Sort arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		public <S extends UserEntity> List<S> findAll(Example<S> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		public <S extends UserEntity> List<S> findAll(Example<S> arg0, Sort arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		public List<UserEntity> findAllById(Iterable<String> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		public void flush() {
			// TODO Auto-generated method stub
			
		}

		public UserEntity getOne(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		public <S extends UserEntity> List<S> saveAll(Iterable<S> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		public <S extends UserEntity> S saveAndFlush(S arg0) {
			// TODO Auto-generated method stub
			return null;
		}

	
}
