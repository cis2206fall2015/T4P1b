package listwithfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Your Name Here
 */
public class EmployeeList {

    private final String FILE_NAME = "empdata.txt";
    private final Path path = Paths.get(FILE_NAME);
    final List<Employee> myList;

    public EmployeeList() {
        this.myList = new ArrayList<>();
        readList();
    }

    public void createRecord(Employee e) {
        myList.add(e);
        writeList();
    }

    public Employee retrieveRecord(int id) {
        for (Employee e : myList) {
            if (e.getEmpId() == id) {
                return e;
            }
        }
        return null;
    }

    public void updateRecord(Employee eNew) {
        for (Employee e : myList) {
            if (e.getEmpId() == eNew.getEmpId()) {
                //e.setEmpId(eNew.getEmpId());
                e.setLastName(eNew.getLastName());
                e.setFirstName(eNew.getFirstName());
                break;
            }
        }
        writeList();
    }

    public void deleteRecord(int id) {
        for (Employee e : myList) {
            if (e.getEmpId() == id) {
                myList.remove(e);
                break;
            }
        }
        writeList();
    }
    
    public void deleteRecord(Employee e) {
        myList.remove(e);
        writeList();
    }

    private void readList() {
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String last = data[1];
                String first = data[2];
                Employee employee = new Employee(id, last, first);
                myList.add(employee);
            }
        } catch (IOException e) {
            System.out.println("Error with " + e.getMessage());
        }
    }

    private void writeList() {
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (Employee employee : myList) {
                writer.write(String.format("%d,%s,%s\n",
                        employee.getEmpId(),
                        employee.getLastName(),
                        employee.getFirstName()));
            }
        } catch (IOException ex) {
            System.out.println("Error with " + ex.getMessage());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        myList.stream().forEach((employee) -> {
            sb.append(String.format("%5d : %s, %s\n", employee.getEmpId(),
                    employee.getLastName(), employee.getFirstName()));
        });

        return sb.toString();
    }

}
