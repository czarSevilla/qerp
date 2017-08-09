package com.qacg.qerp.persistence;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.qacg.qerp.persistence.entity.Employee;
import com.qacg.qerp.persistence.entity.MaritalStatus;

public class EmployeeTest {

   @Test
   public void setters() {
      Employee employee = new Employee();
      String snn = "";
      MaritalStatus maritalStatus = new MaritalStatus();
      Integer homePhone = 1;
      Integer cellPhone = 1;
      Integer emergencyPhone = 1;
      String corporateEmail = "";
      String personalEmail = "";
      
      employee.setSSN(snn);
      employee.setMaritalStatus(maritalStatus);
      employee.setHomePhone(homePhone);
      employee.setCellphone(cellPhone);
      employee.setEmergyPhone(emergencyPhone);
      employee.setCorporateEmail(corporateEmail);
      employee.setPersonalEmail(personalEmail);
      
      assertTrue(employee.getSSN().equals(snn));
      assertTrue(employee.getMaritalStatus().equals(maritalStatus));
      assertTrue(employee.getHomePhone().equals(homePhone));
      assertTrue(employee.getCellphone().equals(cellPhone));
      assertTrue(employee.getEmergyPhone().equals(emergencyPhone));
      assertTrue(employee.getCorporateEmail().equals(corporateEmail));
      assertTrue(employee.getPersonalEmail().equals(personalEmail));

   }
}
