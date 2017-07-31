package com.qacg.qerp.web.jsf;

import java.util.List;

import javax.faces.context.FacesContext;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.service.CrudService;
import com.qacg.qerp.web.util.MessageUtils;

public abstract class CrudManagedBean<T, I> {

    private List<T> list;
    private T t;
    private String actionTitle;
    private I id;
    
    public void save() {
        FacesContext ctx = FacesContext.getCurrentInstance(); 
        try {
            getService().save(t);
            list = getService().findAll();
            ctx.addMessage(null, MessageUtils.success(ctx, "success.detail"));
        } catch (ServiceException se) {
            ctx.addMessage(null, MessageUtils.error(ctx, se.getMessage()));
        }
    }
    
    public void delete() {
        FacesContext ctx = FacesContext.getCurrentInstance(); 
        try {
            getService().delete(id);
            list = getService().findAll();
            ctx.addMessage(null, MessageUtils.success(ctx, "success.detail"));
        } catch (ServiceException se) {
            ctx.addMessage(null, MessageUtils.error(ctx, "delete.error"));
        }
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public T getDto() {
        return t;
    }

    public void setDto(T t) {
        this.t = t;
    }

    public String getActionTitle() {
        return actionTitle;
    }

    public void setActionTitle(String actionTitle) {
        this.actionTitle = actionTitle;
    }

    public abstract CrudService<T, I> getService();

    public I getId() {
        return id;
    }

    public void setId(I id) {
        this.id = id;
    }
}
