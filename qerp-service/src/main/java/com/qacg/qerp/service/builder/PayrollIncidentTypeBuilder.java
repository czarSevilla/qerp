package com.qacg.qerp.service.builder;

import org.springframework.beans.BeanUtils;

import com.qacg.qerp.model.dto.PayrollIncidentTypeDto;
import com.qacg.qerp.persistence.entity.PayrollIncidentType;

public class PayrollIncidentTypeBuilder {

   public static final PayrollIncidentType build(PayrollIncidentTypeDto incidentDto) {
      PayrollIncidentType incident = new PayrollIncidentType();
      BeanUtils.copyProperties(incidentDto, incident);

      return incident;

   }

   public static final PayrollIncidentTypeDto build(PayrollIncidentType incident) {
      PayrollIncidentTypeDto incidentDto = new PayrollIncidentTypeDto();
      BeanUtils.copyProperties(incident, incidentDto);

      return incidentDto;
   }

}
