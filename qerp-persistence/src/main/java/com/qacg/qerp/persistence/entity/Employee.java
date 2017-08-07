package com.qacg.qerp.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long idEmployee;
	private Long idCompany;
	private String numberEmployee;
	private String name;
	private String lastName;
	private Date startDate;
	private String profilePicture;
	private JobTitle jobTitle;
	private boolean active;
	private Date birthday;
	private String place_birth;
	private Gender gender;
	private Nationality nationality;
	private String tin;
	private String curp;
	private String ssn;
	private MaritalStatus maritalStatus;
	private Integer homePhone;
	private Integer cellphone;
	private Integer emergyPhone;
	private String corporateEmail;
	private String personalEmail;
	
	@Id
	@Column(name = "id_employee")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getIdEmployee() {
		return idEmployee;
	}
	public void setIdEmployee(Long idEmployee) {
		this.idEmployee = idEmployee;
	}
	@Column(name = "id_company", nullable = false)
	public Long getIdCompany() {
		return idCompany;
	}
	public void setIdCompany(Long idCompany) {
		this.idCompany = idCompany;
	}
	@Column(name = "number_employee", nullable = false)
	public String getNumberEmployee() {
		return numberEmployee;
	}
	public void setNumberEmployee(String numberEmployee) {
		this.numberEmployee = numberEmployee;
	}
	
	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "start_date", nullable = false)
	@Temporal(TemporalType.DATE)
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	@Column(name = "profile_picture")
	public String getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_job_title")
	public JobTitle getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(JobTitle jobTitle) {
		this.jobTitle = jobTitle;
	}
	@Column(nullable = false)
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@Column(name = "birthday")
         public Date getBirthday() {
         return birthday;
      }
      public void setBirthday(Date birthday) {
         this.birthday = birthday;
      }
      @Column(name = "place_birth")
      public String getPlace_birth() {
         return place_birth;
      }
      public void setPlace_birth(String place_birth) {
         this.place_birth = place_birth;
      }
      @ManyToOne(fetch = FetchType.EAGER)
      @JoinColumn(name = "id_gender")
      public Gender getGender() {
         return gender;
      }
      public void setGender(Gender gender) {
         this.gender = gender;
      }
      @ManyToOne(fetch = FetchType.EAGER)
      @JoinColumn(name = "id_nationality")
      public Nationality getNationality() {
         return nationality;
      }
      public void setNationality(Nationality nationality) {
         this.nationality = nationality;
      }
      @Column(name = "tin")
      public String getTin() {
         return tin;
      }
      public void setTin(String tin) {
         this.tin = tin;
      }
      @Column(name = "curp")
      public String getCurp() {
         return curp;
      }
      public void setCurp(String curp) {
         this.curp = curp;
      }
      @Column(name = "ssn")
      public String getSSN() {
         return ssn;
      }
      public void setSSN(String ssn) {
         this.ssn = ssn;
      }
      @ManyToOne(fetch = FetchType.EAGER)
      @JoinColumn(name = "id_marital_status")
      public MaritalStatus getMaritalStatus() {
         return maritalStatus;
      }
      public void setMaritalStatus(MaritalStatus maritalStatus) {
         this.maritalStatus = maritalStatus;
      }
      @Column(name = "home_phone")
      public Integer getHomePhone() {
         return homePhone;
      }
      public void setHomePhone(Integer homePhone) {
         this.homePhone = homePhone;
      }
      @Column(name = "cellphone")
      public Integer getCellphone() {
         return cellphone;
      }
      public void setCellphone(Integer cellphone) {
         this.cellphone = cellphone;
      }
      @Column(name = "emergy_phone")
      public Integer getEmergyPhone() {
         return emergyPhone;
      }
      public void setEmergyPhone(Integer energyPhone) {
         this.emergyPhone = energyPhone;
      }
      @Column(name = "corporate_email")
      public String getCorporateEmail() {
         return corporateEmail;
      }
      public void setCorporateEmail(String corporateEmail) {
         this.corporateEmail = corporateEmail;
      }
      @Column(name = "personal_email")
      public String getPersonalEmail() {
         return personalEmail;
      }
      public void setPersonalEmail(String personalEmail) {
         this.personalEmail = personalEmail;
      }
}