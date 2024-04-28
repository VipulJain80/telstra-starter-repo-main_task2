package au.com.telstra.simcardactivator.Entity;

import au.com.telstra.simcardactivator.Model.ActuationResult;
import au.com.telstra.simcardactivator.Model.SimCardModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class SimCardRecord {

	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false)
	private String iccid;
	
	@Column(nullable=false)	
	private String customerEmail;
	
	@Column(nullable=false)
	private boolean active;
	
	public SimCardRecord() {
		
	}
	
	public SimCardRecord(SimCardModel simcard,ActuationResult actuationResult) {
		this.iccid=simcard.getIccid();
		this.customerEmail=simcard.getCustomerEmail();
		this.active=actuationResult.getSuccess();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "SimCardRecord [id=" + id + ", iccid=" + iccid + ", customerEmail=" + customerEmail + ", active="
				+ active + "]";
	}
	
	
}
