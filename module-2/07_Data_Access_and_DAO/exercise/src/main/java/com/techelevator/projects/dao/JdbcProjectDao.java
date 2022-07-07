package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.techelevator.projects.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;

public class JdbcProjectDao implements ProjectDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcProjectDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Project getProject(int projectId) {
		Project project = null;
		String sql = "SELECT * FROM project WHERE project_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);
	while(results.next()){
		project = mapRowToProject(results);
	}
	return project;
	}

	@Override
	public List<Project> getAllProjects() {
		List<Project> project = new ArrayList<>();
		String sql = "SELECT * FROM project;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()){
			project.add(mapRowToProject(results));
		}
		return project;
	}

	@Override
	public Project createProject(Project newProject) {

		String sql = "INSERT INTO project(project_id, name, from_date, to_date) "+
				"VALUES(?,?,?,?)";

	jdbcTemplate.update(sql, newProject.getId(), newProject.getName(),
			newProject.getFromDate(), newProject.getToDate());
	return newProject;
	}


	@Override
	public void deleteProject(int projectId) {
		String sql = "DELETE FROM project_employee WHERE project_id = ?; DELETE FROM project WHERE project_id = ?";
		jdbcTemplate.update(sql, projectId, projectId);

	}

	private Project mapRowToProject(SqlRowSet rowSet) {
		Project project = new Project();
		project.setId(rowSet.getInt("project_id"));
		project.setName(rowSet.getString("name"));

		if (rowSet.getDate("from_date") != null) {
			project.setFromDate(rowSet.getDate("from_date").toLocalDate());
		}
		if (rowSet.getDate("to_date") != null) {
			project.setToDate(rowSet.getDate("to_date").toLocalDate());
		}
		return project;
	}
	

}
