package com.qacg.qerp.model;

import org.junit.Test;

import com.qacg.qerp.model.DtoTester.BoolGetter;
import com.qacg.qerp.model.dto.CompanyDto;
import com.qacg.qerp.model.dto.CurrencyDto;
import com.qacg.qerp.model.dto.DocumentTypeDto;
import com.qacg.qerp.model.dto.EmployeeAddressDto;
import com.qacg.qerp.model.dto.EmployeeCertificationDto;
import com.qacg.qerp.model.dto.EmployeeCourseDto;
import com.qacg.qerp.model.dto.EmployeeDto;
import com.qacg.qerp.model.dto.EmployeeEducationDto;
import com.qacg.qerp.model.dto.EmployeeLanguageDto;
import com.qacg.qerp.model.dto.EmployeeReferenceDto;
import com.qacg.qerp.model.dto.EmployeeSkillDto;
import com.qacg.qerp.model.dto.GenderDto;
import com.qacg.qerp.model.dto.JobTitleDto;
import com.qacg.qerp.model.dto.LanguageDto;
import com.qacg.qerp.model.dto.MaritalStatusDto;
import com.qacg.qerp.model.dto.NationalityDto;
import com.qacg.qerp.model.dto.PayrollIncidentTypeDto;
import com.qacg.qerp.model.dto.PhysicalResourceHasFeatureDto;
import com.qacg.qerp.model.dto.PhysicalResourceTypeDto;
import com.qacg.qerp.model.dto.ResourceFeatureDto;
import com.qacg.qerp.model.dto.SecModuleDto;
import com.qacg.qerp.model.dto.SecPermissionDto;
import com.qacg.qerp.model.dto.SecRoleDto;
import com.qacg.qerp.model.dto.SecUserDto;
import com.qacg.qerp.model.dto.SkillDTO;
import com.qacg.qerp.model.dto.SkillTypeDto;

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

   @Test
   public void skillTypeTest() {
      DtoTester<SkillTypeDto> tester = new DtoTester<>(SkillTypeDto.class, BoolGetter.IS);

      tester.verify();
   }

   @Test
   public void skillTest() {
      DtoTester<SkillDTO> tester = new DtoTester<>(SkillDTO.class, BoolGetter.IS);

      tester.verify();
   }

   @Test
   public void physicalResourceHasFeatureTest() {
      DtoTester<PhysicalResourceHasFeatureDto> tester = new DtoTester<>(PhysicalResourceHasFeatureDto.class, BoolGetter.IS);

      tester.verify();
   }

   @Test
   public void payrollIncidentTypeTest() {
      DtoTester<PayrollIncidentTypeDto> tester = new DtoTester<>(PayrollIncidentTypeDto.class, BoolGetter.IS);

      tester.verify();
   }

   @Test
   public void employeeAdressTest() {
      DtoTester<EmployeeAddressDto> tester = new DtoTester<>(EmployeeAddressDto.class, BoolGetter.IS);

      tester.verify();
   }
   
   @Test
   public void employeeCertificationTest() {
      DtoTester<EmployeeCertificationDto> tester = new DtoTester<>(EmployeeCertificationDto.class, BoolGetter.IS);

      tester.verify();
   }
   
   @Test
   public void employeeCourseTest() {
      DtoTester<EmployeeCourseDto> tester = new DtoTester<>(EmployeeCourseDto.class, BoolGetter.IS);

      tester.verify();
   }

   @Test
   public void employeeEducationTest() {
      DtoTester<EmployeeEducationDto> tester = new DtoTester<>(EmployeeEducationDto.class, BoolGetter.IS);

      tester.verify();
   }
   
   @Test
   public void employeeLanguageTest() {
      DtoTester<EmployeeLanguageDto> tester = new DtoTester<>(EmployeeLanguageDto.class, BoolGetter.IS);

      tester.verify();
   }
   
   @Test
   public void employeeSkillTest() {
      DtoTester<EmployeeSkillDto> tester = new DtoTester<>(EmployeeSkillDto.class, BoolGetter.IS);

      tester.verify();
   }
   
   @Test
   public void genderTest() {
      DtoTester<GenderDto> tester = new DtoTester<>(GenderDto.class, BoolGetter.IS);

      tester.verify();
   }
   
   @Test
   public void maritalStatusTest() {
      DtoTester<MaritalStatusDto> tester = new DtoTester<>(MaritalStatusDto.class, BoolGetter.IS);

      tester.verify();
   }
   
   @Test
   public void nationalityTest() {
      DtoTester<NationalityDto> tester = new DtoTester<>(NationalityDto.class, BoolGetter.IS);

      tester.verify();
   }
   @Test
   public void employeeRefenceTest() {
      DtoTester<EmployeeReferenceDto> tester = new DtoTester<>(EmployeeReferenceDto.class, BoolGetter.IS);

      tester.verify();
   }

}
