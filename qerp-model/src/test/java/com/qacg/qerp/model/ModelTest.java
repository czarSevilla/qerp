package com.qacg.qerp.model;

import org.junit.Test;

import com.qacg.qerp.model.DtoTester.BoolGetter;
import com.qacg.qerp.model.dto.CurrencyDto;
import com.qacg.qerp.model.dto.DocumentTypeDto;
import com.qacg.qerp.model.dto.EmployeeDto;
import com.qacg.qerp.model.dto.JobTitleDto;
import com.qacg.qerp.model.dto.PhysicalResourceTypeDto;

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
}
