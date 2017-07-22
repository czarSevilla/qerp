package com.qacg.qerp.persistence;

import org.junit.Test;

import com.qacg.qerp.persistence.entity.Currency;
import com.qacg.qerp.persistence.entity.DocumentType;
import com.qacg.qerp.persistence.entity.Employee;
import com.qacg.qerp.persistence.entity.JobTitle;
import com.qacg.qerp.persistence.entity.PhysicalResourceType;

public class EntitiesTest {

	@Test
	public void jobTitleTest() {
		EntityTester<JobTitle> tester = new EntityTester<>(JobTitle.class, EntityTester.IS);
		
		tester.verify();
	}
	
	@Test
	public void currencyTest() {
		EntityTester<Currency> tester = new EntityTester<>(Currency.class, EntityTester.IS);
		
		tester.verify();
	}
	
	@Test
	public void employeeTest() {
		EntityTester<Employee> tester = new EntityTester<>(Employee.class, EntityTester.IS);
		
		tester.verify();
	}
	
	@Test
	public void documentTypeTest() {
		EntityTester<DocumentType> tester = new EntityTester<>(DocumentType.class, EntityTester.IS);
		
		tester.verify();
	}
	
	@Test
	public void physicalResourceTypeTest() {
		EntityTester<PhysicalResourceType> tester = new EntityTester<>(PhysicalResourceType.class, EntityTester.IS);
		
		tester.verify();
	}
	
}
