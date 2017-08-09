package com.qacg.qerp.model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.qacg.qerp.model.dto.EmployeeDto;
import com.qacg.qerp.model.dto.EmployeeLanguageDto;

public class EmployeeLanguageTest {

   @Test
   public void setters(){
      
      EmployeeLanguageDto employeeLanguageDto = new EmployeeLanguageDto();
      EmployeeDto employeeDto = new EmployeeDto();
      String name = "";
      int porcSpeak = 1;
      int porWrite = 1;
      
      employeeLanguageDto.setEmpleado(employeeDto);
      employeeLanguageDto.setName(name);
      employeeLanguageDto.setPorcSpeak(porcSpeak);
      employeeLanguageDto.setPorWrite(porWrite);
      
      assertTrue(employeeLanguageDto.getEmpleado().equals(employeeDto));
      assertTrue(employeeLanguageDto.getName().equals(name));
      assertTrue(employeeLanguageDto.getPorcSpeak()==porcSpeak);
      assertTrue(employeeLanguageDto.getPorWrite()==porWrite);
      
   }
}
