import java.util.*;

public class Vaccination_V2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalAge = 0;
		int numVaccinated = 0;
        int numChilds = 0;

		while (true) {
            System.out.print("Name: ");
            if (!sc.hasNext()) break;

            numChilds++;
			String name = sc.nextLine();

			System.out.println("Name is \"" + name + "\"");

			System.out.print("Age: ");
			int age = sc.nextInt();
			totalAge += age;
            sc.nextLine(); 
            
			System.out.println("Age is "+ age);

			System.out.print("Vaccinated for chickenpox? ");
			boolean vaccinated = sc.nextBoolean();
			numVaccinated += vaccinated ? 1: 0;
			sc.nextLine(); 

			System.out.println(vaccinated ? "Vaccinated for chickenpox" : "Not vaccinated for chickenpox");

		}

		double averageAge = (double) totalAge / (double) numChilds;
		double percentageVaccinated = (double) numVaccinated / (double) numChilds * 100;

		System.out.printf("Average age is %.2f%n", averageAge);
		System.out.printf("Percentage of children vaccinated is %.2f%%%n", percentageVaccinated);
	}
}