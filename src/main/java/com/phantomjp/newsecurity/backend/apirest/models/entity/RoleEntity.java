package com.phantomjp.newsecurity.backend.apirest.models.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "roles")
public class RoleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@ManyToMany()
	@JsonBackReference
	@JoinTable(name="roles_users",joinColumns=@JoinColumn(name="roles", referencedColumnName="id"),
	inverseJoinColumns=@JoinColumn(name="users", referencedColumnName="id"))
	private List<UserEntity> Users;

	public RoleEntity() {
		
	}
	
	public RoleEntity(int id, String name, List<UserEntity> users) {
		this.id = id;
		this.name = name;
		Users = users;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserEntity> getUsers() {
		return Users;
	}

	public void setUsers(List<UserEntity> users) {
		Users = users;
	}
	
	
	
}
