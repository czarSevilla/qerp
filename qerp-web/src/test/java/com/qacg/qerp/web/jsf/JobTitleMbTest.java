package com.qacg.qerp.web.jsf;

import static org.junit.Assert.assertTrue;

import java.net.URL;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(Arquillian.class)
@RunAsClient
public class JobTitleMbTest {
	
	@ArquillianResource
	URL contextPath;
	
	@Drone
	private WebDriver browser;
	
	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class, "qerp.war");
	}
	
	@Test
	public void selectTest() {
		String startUrl = contextPath.toString() + "/admin/cat/jobTitles.xhtml";
		
		browser.get(startUrl);
		
		assertTrue(browser.getPageSource().contains("algo"));
	}

}
