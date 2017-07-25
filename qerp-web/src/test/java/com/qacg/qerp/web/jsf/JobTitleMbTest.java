package com.qacg.qerp.web.jsf;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.JobTitleDto;
import com.qacg.qerp.service.JobTitleService;

@RunWith(PowerMockRunner.class)
@PrepareForTest({FacesContext.class, ExternalContext.class})
public class JobTitleMbTest {
    
    private JobTitleManagedBean jobTitleMB;
    
    private FacesContext ctx;
    
    private JobTitleService service;
    
    @Before
    public void init() {
        ctx = Mockito.mock(FacesContext.class);
        
        PowerMockito.mockStatic(FacesContext.class);
        
        PowerMockito.when(FacesContext.getCurrentInstance()).thenReturn(ctx);
        
        service = Mockito.mock(JobTitleService.class);
        
        jobTitleMB = new JobTitleManagedBean();
        jobTitleMB.setJobTitleService(service);
        
        Mockito.when(service.findAll()).thenReturn(Arrays.asList(new JobTitleDto()));
        
        UIViewRoot viewRoot = Mockito.mock(UIViewRoot.class);
        Mockito.when(viewRoot.getLocale()).thenReturn(new Locale("es", "MX"));
        Mockito.when(ctx.getViewRoot()).thenReturn(viewRoot);
        
    }

    @Test 
    public void getJobTitles() {
        jobTitleMB.setActionTitle("actionTitle");
        jobTitleMB.setIdJobTitle(1L);
        jobTitleMB.setJobTitle(new JobTitleDto());
        jobTitleMB.setJobTitles(Arrays.asList(new JobTitleDto()));
        jobTitleMB.init();
        
        assertNotNull(jobTitleMB.getJobTitles());
        assertNotNull(jobTitleMB.getJobTitleService());
        assertNotNull(jobTitleMB.getJobTitle());
        assertNotNull(jobTitleMB.getActionTitle());
        assertNotNull(jobTitleMB.getIdJobTitle());
    }
    
    @Test
    public void saveTest() throws ServiceException {
        doNothing().when(service).save(any(JobTitleDto.class));
        
        jobTitleMB.save();
        
        verify(service, atLeastOnce()).save(any(JobTitleDto.class));
    }
    
    @Test
    public void failSaveTest() throws ServiceException {
        doThrow(new ServiceException("test")).when(service).save(any(JobTitleDto.class));
        
        jobTitleMB.save();
        
        verify(ctx, atLeastOnce()).addMessage(anyString(), any(FacesMessage.class));
    }
    
    @Test
    public void createTest() {
        jobTitleMB.setJobTitle(null);
        
        jobTitleMB.create();
        
        assertNotNull(jobTitleMB.getJobTitle());
    }
    
    @Test
    public void deleteTest() throws ServiceException {
        doNothing().when(service).delete(anyLong());
        Long idJobTitle = 1L;
        
        jobTitleMB.delete(idJobTitle);
        
        verify(service, atLeastOnce()).delete(idJobTitle);
    }
    
    @Test
    public void failDeleteTest() throws ServiceException {
        doThrow(new ServiceException("test")).when(service).delete(anyLong());
        Long idJobTitle = 1L;
        
        jobTitleMB.delete(idJobTitle);
        
        verify(ctx, atLeastOnce()).addMessage(anyString(), any(FacesMessage.class));
    }
}
