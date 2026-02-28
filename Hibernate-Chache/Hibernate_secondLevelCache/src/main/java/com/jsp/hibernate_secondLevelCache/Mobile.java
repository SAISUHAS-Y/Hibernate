package com.jsp.hibernate_secondLevelCache;


import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Mobile {
	
	@Id
	private int mobileId;
	private String mobileName;
	private String mobileBrand;
	private int mobilePrice;
	public int getMobileId() {
		return mobileId;
	}
	public void setMobileId(int mobileId) {
		this.mobileId = mobileId;
	}
	public String getMobileName() {
		return mobileName;
	}
	public void setMobileName(String mobileName) {
		this.mobileName = mobileName;
	}
	public String getMobileBrand() {
		return mobileBrand;
	}
	public void setMobileBrand(String mobileBrand) {
		this.mobileBrand = mobileBrand;
	}
	public int getMobilePrice() {
		return mobilePrice;
	}
	public void setMobilePrice(int mobilePrice) {
		this.mobilePrice = mobilePrice;
	}
	
//	@Override
//	public String toString() {
//		return "Mobile [mobileId=" + mobileId + ", mobileName=" + mobileName + ", mobileBrand=" + mobileBrand
//				+ ", mobilePrice=" + mobilePrice + "]";
//	}
	
	

}

