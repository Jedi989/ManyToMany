package advancia.entity;

import java.util.List;

import javax.persistence.*;

@Entity 
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "NOME")
	private String name;
	
	@Column(name = "COGNOME")
	private String lName;
	
	@OneToMany(mappedBy = "employee")
	private List<ProjectAssociation> projects;
	
	public Employee() {
		super();
	}
	
	public Employee(String name, String lName) {
		this.name = name;
		this.lName = lName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public List<ProjectAssociation> getProjects() {
		return projects;
	}

	public void setProjects(List<ProjectAssociation> projects) {
		this.projects = projects;
	}
	
	public int getId() {
		return id;
	}
	
	

}
