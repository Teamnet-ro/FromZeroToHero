package ro.zerotohero.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ro.zerotohero.dao.EmployeeDao;
import ro.zerotohero.model.Employee;
import ro.zerotohero.service.EmployeeService;

@Controller
@RequestMapping("/admin")
public class AdminMainController {

	@Autowired
	private EmployeeService employeeService;

	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap model) {
		model.addAttribute("message", "Admin Index");
		return "admin/index";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(ModelMap model) {
		List<Employee> employeeList = employeeService.findAll();
		model.addAttribute("employeeList", employeeList);
		return "admin/list";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newEmployee(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {

		return "admin/new";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(
			ModelMap model,
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "employeeList" , required = false) ArrayList<Employee> employeeList) {

		if (employeeList == null) {
			employeeList = new ArrayList<Employee>();
		}
		
		Employee employee = new Employee();
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		employee.setEmail(email);
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setPassword(password);

		employeeList.add(employee);

		model.addAttribute(employeeList);
		return "admin/list";
	}

}