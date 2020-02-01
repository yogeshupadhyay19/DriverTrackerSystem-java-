package com.pojo;

import java.sql.Date;

public class Drive {
	int did;
	String company_name;
	String gstnumber;
	int noofresourses;
	int exp_required;
	int ctc;
	int wposition;
	int joining_criteria;
	int edu_crt;
	Date follow_up;
	float bond;

	@Override
	public String toString() {
		return "Drive [did=" + did + ", company_name=" + company_name + ", gstnumber=" + gstnumber + ", noofresourses="
				+ noofresourses + ", exp_required=" + exp_required + ", ctc=" + ctc + ", wposition=" + wposition
				+ ", joining_criteria=" + joining_criteria + ", edu_crt=" + edu_crt + ", follow_up=" + follow_up
				+ ", bond=" + bond + "]";
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
    
	
	public String getGstnumber() {
		return gstnumber;
	}

	public void setGstnumber(String gstnumber) {
		this.gstnumber = gstnumber;
	}
	public int getNoofresourses() {
		return noofresourses;
	}

	public void setNoofresourses(int noofresourses) {
		this.noofresourses = noofresourses;
	}

	public int getExp_required() {
		return exp_required;
	}

	public void setExp_required(int exp_required) {
		this.exp_required = exp_required;
	}

	public int getCtc() {
		return ctc;
	}

	public void setCtc(int ctc) {
		this.ctc = ctc;
	}

	public int getWposition() {
		return wposition;
	}

	public void setWposition(int wposition) {
		this.wposition = wposition;
	}

	public int getJoining_criteria() {
		return joining_criteria;
	}

	public void setJoining_criteria(int joining_criteria) {
		this.joining_criteria = joining_criteria;
	}

	public int getEdu_crt() {
		return edu_crt;
	}

	public void setEdu_crt(int edu_crt) {
		this.edu_crt = edu_crt;
	}

	public Date getFollow_up() {
		return follow_up;
	}

	public void setFollow_up(Date follow_up) {
		this.follow_up = follow_up;
	}

	public float getBond() {
		return bond;
	}

	public void setBond(float bond) {
		this.bond = bond;
	}

}
