package com.qacg.qerp.model.dto;

import java.io.Serializable;

public class JobTitleDto implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Long idJobTitle;
    private String titleEsMx;
    private String titleEnUs;
    
    public Long getIdJobTitle() {
        return idJobTitle;
    }
    public void setIdJobTitle(Long idJobTitle) {
        this.idJobTitle = idJobTitle;
    }
	public String getTitleEsMx() {
		return titleEsMx;
	}
	public void setTitleEsMx(String titleEsMx) {
		this.titleEsMx = titleEsMx;
	}
	public String getTitleEnUs() {
		return titleEnUs;
	}
	public void setTitleEnUs(String titleEnUs) {
		this.titleEnUs = titleEnUs;
	}
    
    
    
}
