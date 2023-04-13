package in.ashokit.controller;


import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.entity.CitizenPlan;
import in.ashokit.request.SearchRequest;
import in.ashokit.service.ReportService;
@Controller
public class ReportController {
@Autowired	
private ReportService service;


@GetMapping("/pdf")
public void exportPdf(HttpServletResponse response,Model model) throws Exception {
	   response.setContentType("application/pdf");
	   response.addHeader("Content-Disposition", "attachment;filename=plans.pdf");
	   
	   boolean status = service.exportPdf(response);
	  
}

@GetMapping("/excel")
   public void excelExport(HttpServletResponse response,Model model) throws Exception {
	   response.setContentType("application/octet-stream");
	   response.addHeader("Content-Disposition", "attachment;filename=plans.xls");
	   
	   boolean status = service.exportExcel(response);
	  
   }
	
	
	@GetMapping("/")
	public String indexPage(Model model) {
		//bind the obj to UI page
		//SearchRequest serchobj = new SearchRequest();
		/*model.addAttribute("search", new SearchRequest());
		model.addAttribute("names", service.getPlanName());
		model.addAttribute("status", service.getPlanStatus());
		*/
		model.addAttribute("search", new SearchRequest());
		
		model.addAttribute("search", new SearchRequest());
		init(model);
		return "index";
	}

	private void init(Model model) {
		//model.addAttribute("search", new SearchRequest());
		model.addAttribute("names", service.getPlanName());
		model.addAttribute("status", service.getPlanStatus());
	}
	
	@PostMapping("/search")
	 public String handleSearch(@ModelAttribute("search") SearchRequest request, Model model) {
		
		 System.out.println(request);
		 
		 List<CitizenPlan> plans = service.search(request);
		 model.addAttribute("plan", plans);
		 init(model);
		 return "index";
	 }
	
	
}
