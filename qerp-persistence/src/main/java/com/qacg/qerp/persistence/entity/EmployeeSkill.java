package com.qacg.qerp.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.qacg.qerp.model.dto.EmployeeDto;

@Entity
@Table(name = "employee_skill")
public class EmployeeSkill implements Serializable{
   private static final long serialVersionUID = 7942595683439876439L;
   private int idSkillEmployee;
   private Employee employee;
   private Skill skill;
   private SkillType skillType;
   private int yearsExperience;
   
   @Id
   @Column(name = "id_employee_skill")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public int getIdSkillEmployee() {
      return idSkillEmployee;
   }
   public void setIdSkillEmployee(int idSkillEmployee) {
      this.idSkillEmployee = idSkillEmployee;
   }
   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "id_employee")
   public Employee getEmployee() {
      return employee;
   }
   public void setEmployee(Employee employee) {
      this.employee = employee;
   }
   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "id_skill")
   public Skill getSkill() {
      return skill;
   }
   public void setSkill(Skill skill) {
      this.skill = skill;
   }
   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "id_skill_type")
   public SkillType getSkillType() {
      return skillType;
   }
   public void setSkillType(SkillType skillType) {
      this.skillType = skillType;
   }
   @Column(name = "years_experience", nullable = false)
   public int getYearsExperience() {
      return yearsExperience;
   }
   public void setYearsExperience(int yearsExperience) {
      this.yearsExperience = yearsExperience;
   }
}