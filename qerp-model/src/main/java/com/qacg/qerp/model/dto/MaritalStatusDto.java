package com.qacg.qerp.model.dto;

import java.io.Serializable;

public class MaritalStatusDto implements Serializable{

   private static final long serialVersionUID = -9006928614541432174L;
   private int idMaritalStatus;
   private String nameEsMx;
   private String nameEsEu;

   public final int getIdMaritalStatus() {
      return idMaritalStatus;
   }

   public final void setIdMaritalStatus(int idMaritalStatus) {
      this.idMaritalStatus = idMaritalStatus;
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