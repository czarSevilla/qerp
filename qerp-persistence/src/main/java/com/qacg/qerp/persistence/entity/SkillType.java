package com.qacg.qerp.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "skill_type")
public class SkillType implements Serializable{

   private static final long serialVersionUID = -2855314075683534103L;
   private int idSkill;
   private String name;
   @Id
   @Column(name = "id_skill_type")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public int getIdSkill() {
      return idSkill;
   }
   public void setIdSkill(int idSkill) {
      this.idSkill = idSkill;
   }
   @Column(name = "name", nullable = false)
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   
}
