package com.qacg.qerp.model.dto;

import java.io.Serializable;

public class SkillDTO implements Serializable{
   private static final long serialVersionUID = -1970415908961401491L;
   private int idSkill;
   private String name;
   
   public int getIdSkill() {
      return idSkill;
   }
   public void setIdSkill(int idSkill) {
      this.idSkill = idSkill;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
}
