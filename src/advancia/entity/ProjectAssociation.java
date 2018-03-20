package advancia.entity;

import javax.persistence.*;
import advancia.entity.*;

@Entity
@Table(name = "PROJ_EMP")
@IdClass(ProjectAssociationId.class)
public class ProjectAssociation {

	@Id
	@Column(name = "EMP_ID")
	private int employeeId;
	
	@Id
	@Column(name = "PROJ_ID")
	private int projectId;
	
	@Column(name = "IS_PROJECT_LEAD")
	private boolean lead;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name = "EMP_ID", referencedColumnName = "ID")
	private Employee employee;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name = "PROJ_ID", referencedColumnName  = "ID")
	private Project project;
	
	
	public ProjectAssociation() {
		super();
	}
	
	public ProjectAssociation(int employeeId, int projectId, boolean lead) {
		this.employeeId = employeeId;
		this.projectId = projectId;
		this.lead = lead;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public boolean isLead() {
		return lead;
	}

	public void setLead(boolean lead) {
		this.lead = lead;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
}
