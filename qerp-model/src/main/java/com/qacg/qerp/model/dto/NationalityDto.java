package com.qacg.qerp.model.dto;

import java.io.Serializable;

public class NationalityDto implements Serializable{

   private static final long serialVersionUID = 280349071479618625L;
   private int idNationality;
   private String nameEsMx;
   private String nameEsEu;

   public final int getIdNationality() {
      return idNationality;
   }

   public final void setIdNationality(int idNationality) {
      this.idNationality = idNationality;
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