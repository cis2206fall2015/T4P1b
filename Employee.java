package listwithfile;

/**
 *
 * @author John Phillips
 */
public class Employee {
    private int empId;
    private String lastName;
    private String firstName;

    public Employee() {
        empId = 0;
        lastName = "";
        firstName = "";
    }

    public Employee(int empId, String lastName, String firstName) {
        this.empId = empId;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Employee{" + "empId=" + empId + ", lastName=" + lastName + ", firstName=" + firstName + '}';
    }

}
