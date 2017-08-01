package com.qacg.qerp.model;

import org.junit.Test;

import com.qacg.qerp.model.DtoTester.BoolGetter;
import com.qacg.qerp.model.dto.CompanyDto;
import com.qacg.qerp.model.dto.CurrencyDto;
import com.qacg.qerp.model.dto.DocumentTypeDto;
import com.qacg.qerp.model.dto.EmployeeDto;
import com.qacg.qerp.model.dto.JobTitleDto;
import com.qacg.qerp.model.dto.LanguageDto;
import com.qacg.qerp.model.dto.PhysicalResourceTypeDto;
import com.qacg.qerp.model.dto.ResourceFeatureDto;
import com.qacg.qerp.model.dto.SecModuleDto;
import com.qacg.qerp.model.dto.SecPermissionDto;
import com.qacg.qerp.model.dto.SecRoleDto;
import com.qacg.qerp.model.dto.SecUserDto;

public class ModelTest {
	@Test
	public void currencyDtoTest() {
		DtoTester<CurrencyDto> tester = new DtoTester<>(CurrencyDto.class, BoolGetter.IS);
		
		tester.verify();
	}
	
	@Test
	public void documentTypeDtoTest() {
		DtoTester<DocumentTypeDto> tester = new DtoTester<>(DocumentTypeDto.class, BoolGetter.IS);
		
		tester.verify();
	}
	
	@Test
	public void employeeDtoTest() {
		DtoTester<EmployeeDto> tester = new DtoTester<>(EmployeeDto.class, BoolGetter.IS);
		
		tester.verify();
	}
	
	@Test
	public void jobTitleDtoTest() {
		DtoTester<JobTitleDto> tester = new DtoTester<>(JobTitleDto.class, BoolGetter.IS);
		
		tester.verify();
	}
	
	@Test
	public void physicalResourceTypeTest() {
		DtoTester<PhysicalResourceTypeDto> tester = new DtoTester<>(PhysicalResourceTypeDto.class, BoolGetter.IS);
		
		tester.verify();
	}
	
	@Test
     public void companyTest() {
          DtoTester<CompanyDto> tester = new DtoTester<>(CompanyDto.class, BoolGetter.IS);
          
          tester.verify();
     }
	
	@Test
     public void resourceFeatureTest() {
          DtoTester<ResourceFeatureDto> tester = new DtoTester<>(ResourceFeatureDto.class, BoolGetter.IS);
          
          tester.verify();
     }
	
	@Test
     public void secUserTest() {
          DtoTester<SecUserDto> tester = new DtoTester<>(SecUserDto.class, BoolGetter.IS);
          
          tester.verify();
     }
	
	@Test
     public void languageTest() {
          DtoTester<LanguageDto> tester = new DtoTester<>(LanguageDto.class, BoolGetter.IS);
          
          tester.verify();
     }
	
	@Test
     public void secModuleTest() {
          DtoTester<SecModuleDto> tester = new DtoTester<>(SecModuleDto.class, BoolGetter.IS);
          
          tester.verify();
     }
	
	@Test
     public void secPermissionTest() {
          DtoTester<SecPermissionDto> tester = new DtoTester<>(SecPermissionDto.class, BoolGetter.IS);
          
          tester.verify();
     }
	
	@Test
     public void secRoleTest() {
          DtoTester<SecRoleDto> tester = new DtoTester<>(SecRoleDto.class, BoolGetter.IS);
          
          tester.verify();
     }
	
	
}
