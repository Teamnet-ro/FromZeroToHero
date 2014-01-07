package ro.zerotohero.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ro.zerotohero.model.Employee;
import ro.zerotohero.model.Role;
import ro.zerotohero.service.EmployeeService;
import ro.zerotohero.service.RoleService;

@Controller
@RequestMapping("/admin")
public class AdminMainController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private RoleService roleService;

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

		List<Role> roleList = roleService.findAll();
		model.addAttribute("roleList", roleList);
		model.addAttribute("employee", new Employee());
		return "admin/new";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {

		Employee employee = new Employee();
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String employeeId = request.getParameter("employeeId");
		String roleId = request.getParameter("roleId");
		
		employee.setEmail(email);
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setPassword(password);
		if ((employeeId == "") || (employeeId == null)) {
			employee.setEmployeeId(0);
		}else{
			employee.setEmployeeId(Integer.valueOf(employeeId));
		}
		
		if ((roleId == "") || (roleId == null)) {
			roleId = employee.getRoleList().get(0).getRoleId()+"";
		}
		
		Role role = roleService.findById(Integer.valueOf(roleId));
		employee.getRoleList().add(role);
		role.getEmployeeList().add(employee);
		employeeService.save(employee);

		List<Employee> employeeList = employeeService.findAll();
		model.addAttribute("employeeList", employeeList);
		return "redirect:/admin/list";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, @PathVariable("id") int id) {

		Employee employee = employeeService.findById(id);
		List<Role> roleList = employee.getRoleList();
		model.addAttribute("roleList", roleList);
		model.addAttribute("employee", employee);
		model.addAttribute("isEdit", true);

		return "admin/new";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, @PathVariable("id") int id) {

		employeeService.delete(employeeService.findById(id));
		
		List<Employee> employeeList = employeeService.findAll();
		model.addAttribute("employeeList", employeeList);
		return "redirect:/admin/list";
	}
	

}