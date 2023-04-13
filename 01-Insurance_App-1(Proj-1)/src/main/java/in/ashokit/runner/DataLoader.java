package in.ashokit.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.ashokit.entity.CitizenPlan;
import in.ashokit.repo.CitizenRepository;
@Component
public class DataLoader implements ApplicationRunner{
	@Autowired
     private CitizenRepository repo;
	@Override
	public void run(ApplicationArguments args) throws Exception {
	  
		repo.deleteAll();
		//cash plan data
		
		CitizenPlan c1 = new CitizenPlan();
		c1.setCitizenName("John");
		c1.setGender("Male");
		c1.setPlanName("Cash");
		c1.setPlanStatus("Approved");
		c1.setPlanStartDate(LocalDate.now());
		c1.setPlanEndDate(LocalDate.now().plusMonths(5));
		c1.setBenifitAmt(5000.00);
		
		CitizenPlan c2 = new CitizenPlan();
		c2.setCitizenName("Smith");
		c2.setGender("Male");
		c2.setPlanName("Cash");
		c2.setPlanStatus("Denai");
		c2.setDenailReson("Rental Income");
		
		CitizenPlan c3 = new CitizenPlan();
		c3.setCitizenName("Cathy");
		c3.setGender("Fe-Male");
		c3.setPlanName("Cash");
		c3.setPlanStatus("Terminated");
		c3.setPlanStartDate(LocalDate.now().minusMonths(4));
		c3.setPlanEndDate(LocalDate.now().plusMonths(6));
		c3.setBenifitAmt(4000.00);
		c3.setTerminatedDate(LocalDate.now());
		c3.setDenailReson("Employed");
		
		
		//Food plan data
		
		CitizenPlan c4 = new CitizenPlan();
		c4.setCitizenName("Bablu");
		c4.setGender("Male");
		c4.setPlanName("Food");
		c4.setPlanStatus("Approved");
		c4.setPlanStartDate(LocalDate.now());
		c4.setPlanEndDate(LocalDate.now().plusMonths(5));
		c4.setBenifitAmt(55000.00);
		
		CitizenPlan c5 = new CitizenPlan();
		c5.setCitizenName("Rahul");
		c5.setGender("Male");
		c5.setPlanName("Food");
		c5.setPlanStatus("Denai");
		c5.setDenailReson("more property");
		
		CitizenPlan c6 = new CitizenPlan();
		c6.setCitizenName("Orline");
		c6.setGender("Fe-Male");
		c6.setPlanName("Food");
		c6.setPlanStatus("Terminated");
		c6.setPlanStartDate(LocalDate.now().minusMonths(4));
		c6.setPlanEndDate(LocalDate.now().plusMonths(6));
		c6.setBenifitAmt(1200.00);
		c6.setTerminatedDate(LocalDate.now());
		c6.setTerminationReason("Gov. Epm");
		
		
		//Medical data
		
		CitizenPlan c7 = new CitizenPlan();
		c7.setCitizenName("Virat");
		c7.setGender("Male");
		c7.setPlanName("Medical");
		c7.setPlanStatus("Approved");
		c7.setPlanStartDate(LocalDate.now());
		c7.setPlanEndDate(LocalDate.now().plusMonths(5));
		c7.setBenifitAmt(5500.00);
		
		CitizenPlan c8 = new CitizenPlan();
		c8.setCitizenName("David");
		c8.setGender("Male");
		c8.setPlanName("Medical");
		c8.setPlanStatus("Denai");
		c8.setDenailReson("High Income");
		
		CitizenPlan c9 = new CitizenPlan();
		c9.setCitizenName("Devin");
		c9.setGender("Fe-Male");
		c9.setPlanName("Medical");
		c9.setPlanStatus("Terminated");
		c9.setPlanStartDate(LocalDate.now().minusMonths(4));
		c9.setPlanEndDate(LocalDate.now().plusMonths(6));
		c9.setBenifitAmt(4400.00);
		c9.setTerminatedDate(LocalDate.now());
		c9.setTerminationReason("Some issu occured");
		
		//Employment data
		
		CitizenPlan c10 = new CitizenPlan();
		c10.setCitizenName("ABD");
		c10.setGender("Male");
		c10.setPlanName("Employment");
		c10.setPlanStatus("Approved");
		c10.setPlanStartDate(LocalDate.now());
		c10.setPlanEndDate(LocalDate.now().plusMonths(5));
		c10.setBenifitAmt(6000.00);
		
		CitizenPlan c11 = new CitizenPlan();
		c11.setCitizenName("GAYL");
		c11.setGender("Male");
		c11.setPlanName("Employment");
		c11.setPlanStatus("Denai");
		c11.setDenailReson("More Income");
		
		CitizenPlan c12 = new CitizenPlan();
		c12.setCitizenName("Gardner");
		c12.setGender("Fe-Male");
		c12.setPlanName("Employment");
		c12.setPlanStatus("Terminated");
		c12.setPlanStartDate(LocalDate.now().minusMonths(4));
		c12.setPlanEndDate(LocalDate.now().plusMonths(6));
		c12.setBenifitAmt(4500.00);
		c12.setTerminatedDate(LocalDate.now());
		c12.setTerminationReason("Due to Job");
		List<CitizenPlan> list = Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12);
		repo.saveAll(list);
		
	}
}
