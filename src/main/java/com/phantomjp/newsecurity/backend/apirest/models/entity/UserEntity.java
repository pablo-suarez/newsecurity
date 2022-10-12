package com.phantomjp.newsecurity.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "users")
public class UserEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String password;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	private String email;
	
	private Boolean enabled;
	
	//Relación muchos a muchos solo en sentido usuario->Roles con uniqueconstraint para que no se repita el mismo usuario con mismo rol
	@Fetch(FetchMode.JOIN)
	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinTable(name="roles_users",joinColumns=@JoinColumn(name="users"),
	inverseJoinColumns=@JoinColumn(name="roles"),
	uniqueConstraints= {@UniqueConstraint(columnNames= {"roles","users"})})
	private List<RoleEntity> Roles;

	public UserEntity() {}
	
	public UserEntity(int id, String password, String firstName, String lastName, String email, Boolean enabled,
			List<RoleEntity> roles) {
		this.id = id;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.enabled = enabled;
		Roles = roles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<RoleEntity> getRoles() {
		return Roles;
	}

	public void setRoles(List<RoleEntity> roles) {
		Roles = roles;
	}
	
	
	
}
