package com.qacg.qerp.model.dto;

import java.io.Serializable;

public class SkillTypeDto implements Serializable{
   private static final long serialVersionUID = -3746531581088115932L;
   private int idSkillType;
   private String name;
   
   public int getIdSkillType() {
      return idSkillType;
   }
   public void setIdSkillType(int idSkillType) {
      this.idSkillType = idSkillType;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
}
