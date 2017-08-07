package com.qacg.qerp.persistence.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "marital_status")
public class MaritalStatus implements Serializable{
   
   private static final long serialVersionUID = -5277555786497944131L;
   private int idMaritalStatus;
   private String nameEsMx;
   private String nameEsEu;

   @Id
   @Column(name = "id_marital_status")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public int getIdMaritalStatus() {
      return idMaritalStatus;
   }

   public void setIdMaritalStatus(int idMaritalStatus) {
      this.idMaritalStatus = idMaritalStatus;
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