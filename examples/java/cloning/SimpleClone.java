public class SimpleClone {
  public static void main(String[] args) {
    Employee emp1 = new Employee("M", "A");
    emp1.setSalary(40000.0);
    Employee emp2 = (Employee)emp1.clone();
    emp1.setLastName("Smith");
    emp1.setSalary(70000.0);
    System.out.println("Employee 1 "+emp1);
    System.out.println("EMployee 2 "+emp2);
  }
}

class Employee {
  private String lastName;

  private String firstName;

  private Double salary;

  public Employee(String lastName, String firstName) {
    this.lastName = lastName;
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {

    this.lastName = lastName;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Double getSalary() {
    return this.salary;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }

/**
* If clone is not overriden, there is a compile time error:
* Clone has protected access in Object on line 5.
*/
  public Object clone() {
    Employee emp;
    emp = new Employee(this.lastName, this.firstName);
    emp.setSalary(this.salary);
    return emp;
  }

  public String toString() {
    return this.getClass().getName() + "[" + this.firstName + " " + this.lastName + ", "
        + this.salary + "]";
  }
}