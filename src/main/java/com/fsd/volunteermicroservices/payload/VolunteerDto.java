package com.fsd.volunteermicroservices.payload;

public class VolunteerDto 
{
	   private long id;
	  private String volunteername;
	  private String volunteeremail;
	  private long  volunteerphno;
	  private long projectCode;
	  private String project_name;
	  private String project_description;
	  private String projectplace;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getVolunteername() {
		return volunteername;
	}
	public void setVolunteername(String volunteername) {
		this.volunteername = volunteername;
	}
	public String getVolunteeremail() {
		return volunteeremail;
	}
	public void setVolunteeremail(String volunteeremail) {
		this.volunteeremail = volunteeremail;
	}
	public long getVolunteerphno() {
		return volunteerphno;
	}
	public void setVolunteerphno(long volunteerphno) {
		this.volunteerphno = volunteerphno;
	}
	public long getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(long projectCode) {
		this.projectCode = projectCode;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getProject_description() {
		return project_description;
	}
	public void setProject_description(String project_description) {
		this.project_description = project_description;
	}
	public String getProjectplace() {
		return projectplace;
	}
	public void setProjectplace(String projectplace) {
		this.projectplace = projectplace;
	}
	@Override
	public String toString() {
		return "VolunteerDto [id=" + id + ", volunteername=" + volunteername + ", volunteeremail=" + volunteeremail
				+ ", volunteerphno=" + volunteerphno + ", projectCode=" + projectCode + ", project_name=" + project_name
				+ ", project_description=" + project_description + ", projectplace=" + projectplace + "]";
	}
	public VolunteerDto(long id, String volunteername, String volunteeremail, long volunteerphno, long projectCode,
			String project_name, String project_description, String projectplace) {
		super();
		this.id = id;
		this.volunteername = volunteername;
		this.volunteeremail = volunteeremail;
		this.volunteerphno = volunteerphno;
		this.projectCode = projectCode;
		this.project_name = project_name;
		this.project_description = project_description;
		this.projectplace = projectplace;
	}
	public VolunteerDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
