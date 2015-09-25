package listwithfile;

import java.util.Scanner;

/**
 *
 * @author John Phillips
 */
public class EmployeeApp {

    EmployeeList empList = new EmployeeList();
    Scanner sc = new Scanner(System.in);

    public EmployeeApp() {
        menuLoop();
    }

    private void menuLoop() {
        int id;
        String last, first;
        String choice = "1";
        while (!choice.equals("0")) {
            System.out.println("Blood Sugar App");
            System.out.println("0 = Quit");
            System.out.println("1 = blood sugar Records");
            System.out.println("2 = Create New blood sugar level");
            System.out.println("3 = Retrieve blood sugar Record");
            System.out.println("4 = Update blood sugar Record");
            System.out.println("5 = Delete blood sugar Record");
            choice = Validator.getLine(sc, "Number of choice: ", "^[0-5]$");

            switch (choice) {
                case "1":
                    System.out.println(empList.toString());
                    break;
                case "2":
                    id = Validator.getInt(sc, "New blood sugar: ");
                    last = Validator.getLine(sc, "Last name: ");
                    first = Validator.getLine(sc, "First name: ");
                    empList.createRecord(new Employee(id, last, first));
                    break;
                case "3":
                    id = Validator.getInt(sc, "Employee id to retrieve: ");
                    System.out.println(empList.retrieveRecord(id));
                    break;
                case "4":
                    id = Validator.getInt(sc, "Employee ID to update: ");
                    last = Validator.getLine(sc, "Last name: ");
                    first = Validator.getLine(sc, "First name: ");
                    empList.updateRecord(new Employee(id, last, first));
                    break;
                case "5":
                    id = Validator.getInt(sc, "Employee ID to delete: ");
                    System.out.println(empList.retrieveRecord(id));
                    String ok = Validator.getLine(sc, "Deleter this record? (y/n) ", "^[yYnN]$");
                    if (ok.equalsIgnoreCase("Y")) {
                        empList.deleteRecord(id);
                    }
                    break;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new EmployeeApp();
    }
}
