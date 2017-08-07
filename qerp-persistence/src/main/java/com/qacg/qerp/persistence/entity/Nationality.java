package com.qacg.qerp.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nationality")
public class Nationality implements Serializable{

   private static final long serialVersionUID = -6422780017834407358L;
   private int idNationality;
   private String nameEsMx;
   private String nameEsEu;

   @Id
   @Column(name = "id_nationality")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public int getIdNationality() {
      return idNationality;
   }

   public void setIdNationality(int idNationality) {
      this.idNationality = idNationality;
   }
   
   @Column(name = "name_es_mx", nullable = false)
   public String getNameEsMx() {
      return nameEsMx;
   }

   public void setNameEsMx(String nameEsMx) {
      this.nameEsMx = nameEsMx;
   }

   @Column(name = "name_es_eu", nullable = false)
   public String getNameEsEu() {
      return nameEsEu;
   }

   public void setNameEsEu(String nameEsEu) {
      this.nameEsEu = nameEsEu;
   }
}
