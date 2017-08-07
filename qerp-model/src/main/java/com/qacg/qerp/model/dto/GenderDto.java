package com.qacg.qerp.model.dto;

import java.io.Serializable;

public class GenderDto implements Serializable{

   private static final long serialVersionUID = -5918686088376727285L;
   private int idGender;
   private String nameEsMx;
   private String nameEsEu;

   public final int getIdGender() {
      return idGender;
   }

   public final void setIdGender(int idGender) {
      this.idGender = idGender;
   }

   public final String getNameEsMx() {
      return nameEsMx;
   }

   public final void setNameEsMx(String nameEsMx) {
      this.nameEsMx = nameEsMx;
   }

   public final String getNameEsEu() {
      return nameEsEu;
   }

   public final void setNameEsEu(String nameEsEu) {
      this.nameEsEu = nameEsEu;
   }
}