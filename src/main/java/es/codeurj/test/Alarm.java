package es.codeurj.test;

public class Alarm {
	
	private String module;
	private int errorCode;
	private String resourceId;
	private String activeDescription;
	private int severity;
	private String originatingIp;

	public Alarm(String module, int errorCode, String resourceId, String activeDescription, int severity,
			String originatingIp) {
		super();
		this.module = module;
		this.errorCode = errorCode;
		this.resourceId = resourceId;
		this.activeDescription = activeDescription;
		this.severity = severity;
		this.originatingIp = originatingIp;
	}
	
	public Alarm(Alarm givenAlarm) {
		this.module = givenAlarm.getModule();
		this.errorCode = givenAlarm.getErrorCode();
		this.resourceId = givenAlarm.getResourceId();
		this.activeDescription = givenAlarm.getActiveDescription();
		this.severity = givenAlarm.getSeverity();
		this.originatingIp = givenAlarm.getOriginatingIp();
	}
	
	public String getModule() {
		return module;
	}
	
	public void setModule(String module) {
		this.module = module;
	}
	
	public int getErrorCode() {
		return errorCode;
	}
	
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	public String getResourceId() {
		return resourceId;
	}
	
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	
	public String getActiveDescription() {
		return activeDescription;
	}
	
	public void setActiveDescription(String activeDescription) {
		this.activeDescription = activeDescription;
	}
	
	public int getSeverity() {
		return severity;
	}
	
	public void setSeverity(int severity) {
		this.severity = severity;
	}
	
	public String getOriginatingIp() {
		return originatingIp;
	}
	
	public void setOriginatingIp(String originatingIp) {
		this.originatingIp = originatingIp;
	}
	
	}
