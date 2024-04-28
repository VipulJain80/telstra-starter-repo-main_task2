package au.com.telstra.simcardactivator.Model;

import au.com.telstra.simcardactivator.Entity.SimCardRecord;

public class SimCardModel {

	private String iccid;
	
	private String customerEmail;
	
	private boolean active;

	public SimCardModel() {}
	
	public SimCardModel(String iccid, String customerEmail, boolean active) {
		this.iccid = iccid;
		this.customerEmail = customerEmail;
		this.active=active;
	}
	
	public SimCardModel(SimCardRecord simRecord) {
		this.iccid =simRecord.getIccid();				
		this.customerEmail = simRecord.getCustomerEmail();
		this.active=simRecord.getActive();
	}
	
	
	public String getIccid() {
		return iccid;
	}

	public void setIccid(String iccid) {
		this.iccid = iccid;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}


	@Override
	public String toString() {
		return "SimCardModel [iccid=" + iccid + ", customerEmail=" + customerEmail + ", active=" +active+"]";
	}

	
}
