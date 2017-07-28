package com.qacg.qerp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.EmployeeDto;
import com.qacg.qerp.model.dto.JobTitleDto;
import com.qacg.qerp.persistence.entity.Employee;
import com.qacg.qerp.persistence.repository.EmployeeRepository;
import com.qacg.qerp.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public void setEmployeeRepository(EmployeeRepository empRep) {
		this.employeeRepository = empRep;
	}

    @Override
    public List<EmployeeDto> findAll() {
        
    	List<EmployeeDto> result = new ArrayList<>();
        
        List<Employee> employees = employeeRepository.findAll();
        
        for (Employee employee : employees) {
        	EmployeeDto emp = new EmployeeDto();
            emp.setActive(employee.isActive());
            emp.setIdEmployee(employee.getIdEmployee());
            JobTitleDto jobTitle = new JobTitleDto();
            jobTitle.setIdJobTitle(employee.getJobTitle().getIdJobTitle());
            jobTitle.setTitleEnUs(employee.getJobTitle().getTitleEnUs());
            jobTitle.setTitleEsMx(employee.getJobTitle().getTitleEsMx());
            emp.setJobTitle(jobTitle);
            emp.setLastName(employee.getLastName());
            emp.setName(employee.getName());
            emp.setNumberEmployee(employee.getNumberEmployee());
            emp.setProfilePicture(employee.getProfilePicture());
            emp.setStartDate(employee.getStartDate());
            result.add(emp);
        }
        
        return result;
    }

	@Override
	public void save(EmployeeDto employee) throws ServiceException {
		Employee entity = new Employee();
		
		try {
			BeanUtils.copyProperties(employee, entity);
			employeeRepository.save(entity);
		} catch (DataAccessException dae) {
			throw new ServiceException(dae.getMessage());
		}
		
	}

}
