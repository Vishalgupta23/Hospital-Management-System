package HospitalManagementSystem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class Patients {
    private Connection connection;
    private Scanner scanner;

    public Patients(Connection connection, Scanner scanner){
        this.connection = connection;
        this.scanner = scanner;
    }

    public void addPatient(){
        System.out.println("Enter the patient's name: ");
        String name = scanner.nextLine();   
        System.out.println("Enter the patient's age: ");
        int age = scanner.nextInt();      
        System.out.println("Enter the patient's gender (M/F): ");  
        String gender = scanner.next();

        try{
            String query = "INSERT INTO patients(name, age, gender) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query); 
            preparedStatement.setString(parameterIndex: 1, name);
            preparedStatement.setInt(parameterIndex: 2, age);
            preparedStatement.setString(parameterIndex: 3, gender);
            int affectedRows = preparedStatement.executeUpdate();


        }catch(SQLException e){
            e.printStackTrace();
        }

    }

}
