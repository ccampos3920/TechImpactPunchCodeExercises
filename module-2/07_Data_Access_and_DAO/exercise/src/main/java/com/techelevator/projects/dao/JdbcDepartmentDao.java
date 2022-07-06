package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;

public class JdbcDepartmentDao implements DepartmentDao {
	
	private final JdbcTemplate jdbcTemplate;

	public JdbcDepartmentDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Department getDepartment(int id) {
		Department department = null;
		String sql = "SELECT department_id, name " +
				"FROM department " +
				"WHERE department_id = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
		if(results.next()) {
			department = mapRowToDepartment(results);
		}
		return department;
	}

	@Override
	public List<Department> getAllDepartments() {
		List<Department> departments = new ArrayList<>();
		String sql = "SELECT name, department_id FROM department";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()){
			departments.add(mapRowToDepartment(results));
		}
		return departments;

	}

	@Override
	public void updateDepartment(Department updatedDepartment) {
	String sql = "UPDATE department "+
			"SET department_id = ?, name = ? "+
			"WHERE = department_id = ?;";
	jdbcTemplate.update(sql, updatedDepartment.getId(), updatedDepartment.getName(), updatedDepartment.getId());
	}

	private Department mapRowToDepartment(SqlRowSet rowSet) {
		Department departments = new Department();
		departments.setId(rowSet.getInt("department_id"));
		departments.setName(rowSet.getString("name"));

		return departments;
	}


}
