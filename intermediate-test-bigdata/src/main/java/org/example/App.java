package org.example;

import com.google.gson.Gson;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        HadoopManager hadoopManager = HadoopManager.getInstance();

        Gson gson = new Gson();

        int end = 0;

        while(end != -1) {
            Employee employee = new Employee();

            System.out.println("Insert your name: ");
            employee.setName(scanner.nextLine());

            System.out.println("Insert your surname: ");
            employee.setSurname(scanner.nextLine());

            System.out.println("Insert your age: ");
            employee.setAge(scanner.nextInt());

            // Buffer cleaning
            scanner.nextLine();


            Place place = new Place();
            System.out.println("Insert your living place info: ");

            System.out.println("\tInsert your city name: ");
            place.setName(scanner.nextLine());

            System.out.println("\tInsert your city province: ");
            place.setProvince(scanner.nextLine());

            employee.setPlace(place);

            List<ProgrammingSkill> programmingSkills = new ArrayList<>();

            System.out.println("Insert your list of programming skills: ");
            System.out.println("Do you have hany programming skill? (-1 no, other yes): ");
            int programmingSkillsFinished = scanner.nextInt();

            while (programmingSkillsFinished != -1) {
                // Buffer cleaning
                scanner.nextLine();

                ProgrammingSkill programmingSkill = new ProgrammingSkill();

                System.out.println("\tInsert the language name: ");
                programmingSkill.setName(scanner.nextLine());

                System.out.println("\tInsert a description: ");
                programmingSkill.setDescription(scanner.nextLine());

                System.out.println("\tInsert your confidence level (0 - 10): ");
                programmingSkill.setConfidenceLevel(scanner.nextInt());

                programmingSkills.add(programmingSkill);
                System.out.println("Do you have other programming skills? (-1 no, other number yes): ");
                programmingSkillsFinished = scanner.nextInt();
            }

            employee.setProgrammingSkills(programmingSkills);

            hadoopManager.appendRowInFile(gson.toJson(employee));

            System.out.println("Have you finished the insertion of employees? (-1 yes, other number no): ");
            end = scanner.nextInt();

            if(end != -1)
                // Buffer cleaning
                scanner.nextLine();
        }

        System.out.println("Bye!");
    }
}
