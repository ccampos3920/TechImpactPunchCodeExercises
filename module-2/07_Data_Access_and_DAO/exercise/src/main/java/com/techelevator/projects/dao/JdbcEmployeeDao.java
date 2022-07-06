package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.techelevator.projects.model.Department;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Employee;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcEmployeeDao implements EmployeeDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcEmployeeDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Employee> getAllEmployees() {
	List<Employee> employees = new ArrayList<>();
	String sql = "SELECT employee_id, department_id, first_name, last_name, birth_date, hire_date "+
			"FROM employee";
	SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
	while(results.next()){
		employees.add(mapRowToEmployee(results));
	}
	return employees;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		List<Employee> employee = new ArrayList<>();
		String sql = "SELECT employee_id, department_id, first_name, last_name, birth_date, hire_date "+
				"FROM employee "+
				"WHERE first_name ILIKE ? AND last_name ILIKE ?;";
		firstNameSearch = "%" + firstNameSearch + "%";
		lastNameSearch = "%" + lastNameSearch + "%";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, firstNameSearch, lastNameSearch);
		while(results.next()){
			employee.add(mapRowToEmployee(results));
		}
		return employee;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(int projectId) {
		List<Employee> employees1 = new ArrayList<>();
		String sql = "SELECT employee.employee_id, department_id, first_name, last_name, birth_date, hire_date, project_employee.project_id "+
				"FROM employee "+
				"JOIN project_employee ON project_employee.employee_id = employee.employee_id "+
				"WHERE project_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);
		while(results.next()){
			employees1.add(mapRowToEmployee(results));
		}
		return employees1;

	}

	@Override
	public void addEmployeeToProject(int projectId, int employeeId) {
		String sql = "INSERT INTO project_employee(project_id, employee_id) "+
				"VALUES(?,?)";
			int updateEmployee = jdbcTemplate.update(sql ,projectId, employeeId);
	}

	@Override
	public void removeEmployeeFromProject(int projectId, int employeeId) {
		String sql = "DELETE FROM project_employee "+ "WHERE project_id = ? AND employee_id = ?";
		jdbcTemplate.update(sql, projectId, employeeId);
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		ArrayList<Employee> employeeNoProjects = new ArrayList<>();
		String sql = "SELECT * FROM employee " +
				"LEFT JOIN project_employee on project_employee.employee_id = employee.employee_id " +
				"WHERE project_employee.project_id is null;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()) {
			employeeNoProjects.add(mapRowToEmployee(results));
		}
		return employeeNoProjects;
	}

	private Employee mapRowToEmployee(SqlRowSet rowSet) {
		Employee employee = new Employee();
		employee.setId(rowSet.getInt("employee_id"));
		employee.setDepartmentId(rowSet.getInt("department_id"));
		employee.setFirstName(rowSet.getString("first_name"));
		employee.setLastName(rowSet.getString("last_name"));
		employee.setBirthDate(rowSet.getDate("birth_date").toLocalDate());
		employee.setHireDate(rowSet.getDate("hire_date").toLocalDate());
		return employee;
	}


}
