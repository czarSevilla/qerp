package com.qacg.qerp.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gender")
public class Gender implements Serializable{
   private static final long serialVersionUID = -2258251179680567551L;
   private int idGender;
   private String nameEsMx;
   private String nameEsEu;

   @Id
   @Column(name = "id_gender")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public int getIdGender() {
      return idGender;
   }

   public void setIdGender(int idGender) {
      this.idGender = idGender;
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