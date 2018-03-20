package advancia.entity;


import java.util.ArrayList;
import java.util.List;
import advancia.entity.ProjectAssociation;
import javax.persistence.*;

@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "NAME")
	private String cod;

	@OneToMany(mappedBy = "project")
	private List<ProjectAssociation> employees;
	
	public Project() {
		super();
	}
	
	public Project(String cod) {
		super();
		this.cod = cod;
	}

	public int getId() {
		return id;
	}
	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public List<ProjectAssociation> getEmployees() {
		return employees;
	}

	public void setEmployees(List<ProjectAssociation> employees) {
		this.employees = employees;
	}

	public void addEmployee(Employee employee, boolean teamLead) {
		ProjectAssociation association = new ProjectAssociation();
		association.setEmployee(employee);
		association.setProject(this);
		association.setEmployeeId(employee.getId());
		association.setProjectId(this.getId());
		association.setLead(teamLead);
		
		if(this.employees == null)
			this.employees = new ArrayList<>();
		this.employees.add(association);
		employee.getProjects().add(association);
	}
}
