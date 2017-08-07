package com.qacg.qerp.model.dto;

import java.io.Serializable;

public class EmployeeSkillDto implements Serializable{
   private static final long serialVersionUID = -5249689763341697457L;
   private int idSkillEmployee;
   private EmployeeDto employee;
   private SkillDTO skill;
   private SkillTypeDto skillType;
   private int yearsExperience;
   
   public int getIdSkillEmployee() {
      return idSkillEmployee;
   }
   public void setIdSkillEmployee(int idSkillEmployee) {
      this.idSkillEmployee = idSkillEmployee;
   }
   public EmployeeDto getEmployee() {
      return employee;
   }
   public void setEmployee(EmployeeDto employee) {
      this.employee = employee;
   }
   public SkillDTO getSkill() {
      return skill;
   }
   public void setSkill(SkillDTO skill) {
      this.skill = skill;
   }
   public SkillTypeDto getSkillType() {
      return skillType;
   }
   public void setSkillType(SkillTypeDto skillType) {
      this.skillType = skillType;
   }
   public int getYearsExperience() {
      return yearsExperience;
   }
   public void setYearsExperience(int yearsExperience) {
      this.yearsExperience = yearsExperience;
   }
}