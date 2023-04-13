package in.ashokit.service;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.ashokit.entity.CitizenPlan;
import in.ashokit.repo.CitizenRepository;
import in.ashokit.request.SearchRequest;
import in.ashokit.util.EmailUtils;
import in.ashokit.util.ExcelGenerator;
import in.ashokit.util.PdfGenerator;
@Service
public class ReportServiceImpl implements ReportService {
    
	@Autowired
	private CitizenRepository repo;
	
	@Autowired
	private ExcelGenerator excelGenerator;
	@Autowired
	private PdfGenerator PdfGenerator;
	@Autowired
	private EmailUtils emailUtils;
	
	
	@Override
	public List<String> getPlanName() {
		 return  repo.getPlanName();
	}

	@Override
	public List<String> getPlanStatus() {
		return repo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		CitizenPlan entity = new CitizenPlan();
		
		if(null!=request.getPlanName()&& !"".equals(request.getPlanName())) {
			entity.setPlanName(request.getPlanName());
		}
		
		if(null!=request.getPlanStatus() && !"".equals(request.getPlanStatus())){
			entity.setPlanStatus(request.getPlanStatus());
		}
		if(null!=request.getGender() && !"".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}
		
		if(null!=request.getPlanStartDate() && !"".equals(request.getPlanStartDate())) {
			String planStartDate = request.getPlanStartDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.parse(planStartDate,formatter);
			entity.setPlanStartDate(localDate);
		}
		
		if(null!=request.getPlanEndDate() && !"".equals(request.getPlanEndDate())) {
			String getPlanEndtDate = request.getPlanEndDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.parse(getPlanEndtDate,formatter);
			entity.setPlanStartDate(localDate);
		}
		
		
		return repo.findAll(Example.of(entity));
	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception{
		
		 File f = new File("plans.xls");
		  List<CitizenPlan> plans = repo.findAll();
          excelGenerator.generate(response, plans,f);
	       String subject="Text Mail subject";
	       String body ="<h1>Test Mail Body</h2>";
	       String to = "das35021@gmail.com";
	   
          emailUtils.sendEmail(subject, body, to, f);
          f.delete();
          
		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		 File f = new File("plans.pdf");
		List<CitizenPlan> plans = repo.findAll();
		PdfGenerator.generatePdf(response, plans,f);
		String subject="Text Mail subject";
	       String body ="<h1>Test Mail Body</h2>";
	       String to = "das35021@gmail.com";
	   
       emailUtils.sendEmail(subject, body, to, f);
       f.delete();
		
       
		
		
		
		
		return true;
	}

}
