package advancia.entity;

import java.io.Serializable;


public class ProjectAssociationId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9125378077737670152L;
	private int employeeId;
	private int projectId;
	
	public ProjectAssociationId() {
		super();
	}
	
	public ProjectAssociationId(int employeeId, int projectId) {
		super();
		this.employeeId = employeeId;
		this.projectId = projectId;
	}
	
	public int hashCode() {
		return (employeeId + projectId);
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof ProjectAssociationId) {
			ProjectAssociationId otherId = (ProjectAssociationId) obj;
			return(( otherId.employeeId == this.employeeId) && (otherId.projectId == this.projectId));
		}
		return(false);
	}
}
	

