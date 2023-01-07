package com.company.automation.reporter;

import org.openqa.selenium.BuildInfo;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class EnvironmentUtils {

	private Capabilities cap;

	public String getSystemIpAddress(){
		try {
			return InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getHostName(){
		try {
			return InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getSystemUser() {
		return System.getProperty("user.name").toLowerCase();
	}
	
	public String getPlatform() {
		return System.getProperty("os.name").toLowerCase();
	}
	
	public String getJavaVersion() {
		return System.getProperty("java.version").toLowerCase();
	}
	
	public String getOSArchitecture() {
		return System.getProperty("os.arch").toLowerCase();
	}
	
	
	public String getBrowserName(WebDriver driver) {
		cap = ((RemoteWebDriver) driver).getCapabilities();
		return cap.getBrowserName();
	}
	
	public String getBrowserVersion(WebDriver driver) {
		cap = ((RemoteWebDriver) driver).getCapabilities();
		return cap.getBrowserVersion();
	}
	
	public String getWebDriverBuildVersion() {
		BuildInfo buildInfo = new BuildInfo();
		return buildInfo.getReleaseLabel();
	}

	public String getBrowserDriverVersion(WebDriver driver) {
		Object browserDriverVersion =  ((RemoteWebDriver) driver).getCapabilities().getCapability(getBrowserName(driver));
		System.out.println(" -----> " + browserDriverVersion);
		String[] version = browserDriverVersion.toString().split("=");
		return version[1].split(" ")[0];
	}
}
