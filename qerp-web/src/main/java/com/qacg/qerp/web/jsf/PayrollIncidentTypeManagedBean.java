package com.qacg.qerp.web.jsf;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.PayrollIncidentTypeDto;
import com.qacg.qerp.service.PayrollIncidentTypeService;
import com.qacg.qerp.web.util.MessageUtils;

@ManagedBean(name = "payrollMB")
@ViewScoped
public class PayrollIncidentTypeManagedBean {
   
   private List<PayrollIncidentTypeDto> incidents;
   private PayrollIncidentTypeDto payrollDto;
   private Long idPayroll;
   public static final String SUCCESS = "success.detail";
   
   @ManagedProperty("#{payrollService}")
   private PayrollIncidentTypeService payrollService;
   
   @PostConstruct
   public void init() {
     incidents = payrollService.findAll();

   }

   
   
   
   public PayrollIncidentTypeService getPayrollService() {
      return payrollService;
   }




   public void setPayrollService(PayrollIncidentTypeService payrollService) {
      this.payrollService = payrollService;
   }




   public List<PayrollIncidentTypeDto> getIncidents() {
      return incidents;
   }

   public void setIncidents(List<PayrollIncidentTypeDto> incidents) {
      this.incidents = incidents;
   }
   
   
   
   public PayrollIncidentTypeDto getPayrollDto() {
      return payrollDto;
   }




   public void setPayrollDto(PayrollIncidentTypeDto payrollDto) {
      this.payrollDto = payrollDto;
   }




   public Long getIdPayroll() {
      return idPayroll;
   }




   public void setIdPayroll(Long idPayroll) {
      this.idPayroll = idPayroll;
   }




   public void create (){
      payrollDto = new PayrollIncidentTypeDto(); 
   }
   
   public void save() {

      FacesContext ctx = FacesContext.getCurrentInstance();
      try {
         payrollService.save(payrollDto);
         incidents = payrollService.findAll();
         ctx.addMessage(null, MessageUtils.success(ctx, SUCCESS));
      } catch (ServiceException se) {
         ctx.addMessage(null, MessageUtils.error(ctx, se.getMessage()));
      }

   }
   
   public void delete(Long idPayroll){
      FacesContext ctx = FacesContext.getCurrentInstance();
      try{
           payrollService.delete(idPayroll);
           incidents = payrollService.findAll();
           ctx.addMessage(null, MessageUtils.success(ctx, "success.detail"));
      }catch(ServiceException se){
           ctx.addMessage(null, MessageUtils.error(ctx, se.getMessage()));
      }
 }

}
