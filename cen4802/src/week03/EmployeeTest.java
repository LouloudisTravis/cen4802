package week03;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EmployeeTest
{

	@Test
	public void DefaultEmployeeTest()
	{
		Employee employee = new Employee();
		assertEquals(employee.getFirstName(), "New First");
		assertEquals(employee.getLastName(), "New Last");
	}

	@Test
	public void OverloadedEmployeeTest()
	{
		Employee overloadedEmployee = new Employee("Travis", "Smith");
		assertEquals(overloadedEmployee.getFirstName(), "Travis");
		assertEquals(overloadedEmployee.getLastName(), "Smith");
	}

	@Test
	public void paramEmployeeTest()
	{
		Employee paramEmployee = new Employee("Travis", "Smith", 100000);
		assertEquals(paramEmployee.getFirstName(), "Travis");
		assertEquals(paramEmployee.getLastName(), "Smith");
		assertEquals(paramEmployee.getSalary(), 100000, .0001);
	}

	@Test
	public void setFirstNameTest()
	{
		Employee employee = new Employee();
		employee.setFirstName("Travis");
		assertEquals(employee.getFirstName(), "Travis");
	}

	@Test
	public void setLastNameTest()
	{
		Employee employee = new Employee();
		employee.setLastName("Louloudis");
		assertEquals(employee.getLastName(), "Louloudis");
	}

	@Test
	public void setSalaryTest()
	{
		Employee employee = new Employee();
		employee.setSalary(100000);
		assertEquals(employee.getSalary(), 100000, .0001);
	}

	@Test
	public void getFirstNameTest()
	{
		Employee employee = new Employee();
		employee.setFirstName("Travis");
		String result = employee.getFirstName();
		assertEquals(result, "Travis");
	}

	@Test
	public void getLastNameTest()
	{
		Employee employee = new Employee();
		employee.setLastName("Louloudis");
		String result = employee.getLastName();
		assertEquals(result, "Louloudis");
	}

	@Test
	public void getDisplayNameTest()
	{
		Employee employee = new Employee();
		employee.setFirstName("Travis");
		employee.setLastName("Louloudis");
		String result = employee.getDisplayName();
		assertEquals(result, "Louloudis, Travis");
	}

	@Test
	public void getSalaryTest()
	{
		Employee employee = new Employee();
		employee.setSalary(100000);
		double salary = employee.getSalary();
		assertEquals(salary, 100000, .0001);
	}

	@Test
	public void getFormattedSalaryTest()
	{
		Employee employee = new Employee();
		employee.setSalary(100000);
		String result = employee.getFormattedSalary();
		assertEquals(result, "100,000.00");
	}

	@Test
	public void hashCodeTest()
	{
		Employee employee = new Employee("Travis", "Smith", 100000);
		int resultingInt = employee.hashCode();
		assertEquals(resultingInt, -329810713);
	}

	@Test
	public void equalsTest()
	{
		Employee employee1 = new Employee("Travis", "Smith", 100000);
		Employee employee2 = new Employee("Travis", "Smith", 1000000);
		Employee employee3 = new Employee("Travis", "Smith", 100000);

		assertTrue("employee 1 equals employee 3", employee1.equals(employee3));
		assertFalse("employee 1 does not equal employee 2",
				employee1.equals(employee2));
	}

	@Test
	public void toStringTest()
	{
		Employee employee1 = new Employee("Travis", "Smith", 100000);
		assertEquals(employee1.toString(), "Smith, Travis Salary: $100,000.00");
	}
}
