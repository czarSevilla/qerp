package com.qacg.qerp.persistence;

import org.junit.Test;

import com.qacg.qerp.persistence.entity.Company;
import com.qacg.qerp.persistence.entity.Currency;
import com.qacg.qerp.persistence.entity.DocumentType;
import com.qacg.qerp.persistence.entity.Employee;
import com.qacg.qerp.persistence.entity.EmployeeAddress;
import com.qacg.qerp.persistence.entity.EmployeeCertification;
import com.qacg.qerp.persistence.entity.EmployeeCourse;
import com.qacg.qerp.persistence.entity.EmployeeEducation;
import com.qacg.qerp.persistence.entity.EmployeeLanguage;
import com.qacg.qerp.persistence.entity.EmployeeReference;
import com.qacg.qerp.persistence.entity.EmployeeSkill;
import com.qacg.qerp.persistence.entity.Gender;
import com.qacg.qerp.persistence.entity.JobTitle;
import com.qacg.qerp.persistence.entity.Language;
import com.qacg.qerp.persistence.entity.MaritalStatus;
import com.qacg.qerp.persistence.entity.Nationality;
import com.qacg.qerp.persistence.entity.PayrollIncidentType;
import com.qacg.qerp.persistence.entity.PhysicalResource;
import com.qacg.qerp.persistence.entity.PhysicalResourceHasFeature;
import com.qacg.qerp.persistence.entity.PhysicalResourceType;
import com.qacg.qerp.persistence.entity.ResourceFeature;
import com.qacg.qerp.persistence.entity.SecModule;
import com.qacg.qerp.persistence.entity.SecPermission;
import com.qacg.qerp.persistence.entity.SecRole;
import com.qacg.qerp.persistence.entity.SecUser;
import com.qacg.qerp.persistence.entity.Skill;
import com.qacg.qerp.persistence.entity.SkillType;

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

   @Test
   public void companyTest() {
      EntityTester<Company> tester = new EntityTester<>(Company.class, EntityTester.IS);

      tester.verify();
   }

   @Test
   public void skillTypeTest() {
      EntityTester<SkillType> tester = new EntityTester<>(SkillType.class, EntityTester.IS);

      tester.verify();
   }

   @Test
   public void skillTest() {
      EntityTester<Skill> tester = new EntityTester<>(Skill.class, EntityTester.IS);

      tester.verify();
   }

   @Test
   public void secUserTest() {
      EntityTester<SecUser> tester = new EntityTester<>(SecUser.class, EntityTester.IS);

      tester.verify();
   }

   @Test
   public void secRoleTest() {
      EntityTester<SecRole> tester = new EntityTester<>(SecRole.class, EntityTester.IS);

      tester.verify();
   }

   @Test
   public void secPermissionTest() {
      EntityTester<SecPermission> tester = new EntityTester<>(SecPermission.class, EntityTester.IS);

      tester.verify();
   }

   @Test
   public void secModuleTest() {
      EntityTester<SecModule> tester = new EntityTester<>(SecModule.class, EntityTester.IS);

      tester.verify();
   }

   @Test
   public void nationalityTest() {
      EntityTester<Nationality> tester = new EntityTester<>(Nationality.class, EntityTester.IS);

      tester.verify();
   }

   @Test
   public void maritalStatusTest() {
      EntityTester<MaritalStatus> tester = new EntityTester<>(MaritalStatus.class, EntityTester.IS);

      tester.verify();
   }

   @Test
   public void languageTest() {
      EntityTester<Language> tester = new EntityTester<>(Language.class, EntityTester.IS);

      tester.verify();
   }
   
   @Test
   public void genderTest(){
      EntityTester<Gender> tester = new EntityTester<>(Gender.class, EntityTester.IS);
      
      tester.verify();    
   }
   
   @Test
   public void resourceFeatureTest(){
      EntityTester<ResourceFeature> tester = new EntityTester<>(ResourceFeature.class, EntityTester.IS);
      
      tester.verify();    
   }
      
   
   @Test
   public void physicalResourceHasFeatureTest(){
      EntityTester<PhysicalResourceHasFeature> tester = new EntityTester<>(PhysicalResourceHasFeature.class, EntityTester.IS);
      
      tester.verify();    
   }
   
   
   @Test
   public void physicalResourceTest(){
      EntityTester<PhysicalResource> tester = new EntityTester<>(PhysicalResource.class, EntityTester.IS);
      
      tester.verify();    
   }
   
   
   @Test
   public void employeeAddressTest(){
      EntityTester<EmployeeAddress> tester = new EntityTester<>(EmployeeAddress.class, EntityTester.IS);
      
      tester.verify();    
   }
   
   @Test
   public void employeeCertificationTest(){
      EntityTester<EmployeeCertification> tester = new EntityTester<>(EmployeeCertification.class, EntityTester.IS);
      
      tester.verify();    
   }
   
   @Test
   public void employeecourseTest(){
      EntityTester<EmployeeCourse> tester = new EntityTester<>(EmployeeCourse.class, EntityTester.IS);
      
      tester.verify();    
   }
   
   @Test
   public void employeeEducationTest(){
      EntityTester<EmployeeEducation> tester = new EntityTester<>(EmployeeEducation.class, EntityTester.IS);
      
      tester.verify();    
   }
   
   @Test
   public void employeeLanguageTest(){
      EntityTester<EmployeeLanguage> tester = new EntityTester<>(EmployeeLanguage.class, EntityTester.IS);
      
      tester.verify();    
   }
   
   @Test
   public void employeeReferenceTest(){
      EntityTester<EmployeeReference> tester = new EntityTester<>(EmployeeReference.class, EntityTester.IS);
      
      tester.verify();    
   }
   

   @Test
   public void employeeSkillTest(){
      EntityTester<EmployeeSkill> tester = new EntityTester<>(EmployeeSkill.class, EntityTester.IS);
      
      tester.verify();    
   }
   

   @Test
   public void payrollIncidentTypeTest(){
      EntityTester<PayrollIncidentType> tester = new EntityTester<>(PayrollIncidentType.class, EntityTester.IS);
      
      tester.verify();    
   }
   
   
   


      

}
