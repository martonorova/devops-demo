package logic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

@SpringBootApplication
public class Main {
	public static void main(String[] args) {

		SpringApplication.run(Main.class);

//		Scanner scanner = new Scanner(System.in);
//		String line = null;
//
//		Simulator simulator = new Simulator();
//		SimulationParameters parameters = new SimulationParameters(SwitchAlgorithm.AlgorithmType.FIFO);
//
//		System.out.println("Please specify the list of referred pages, separated by commas (i.e. 1,2,3) and end it with EOF.");
//
//		while (scanner.hasNextLine()) {
//			line = scanner.nextLine();
//			StringTokenizer st = new StringTokenizer(line, ",");
//
//
//			while (st.hasMoreTokens()) {
//				int pageID = Integer.parseInt(st.nextToken());
//				parameters.addReferredPageID(pageID);
//			}
//		}
//
//		SimulationResult result = simulator.runSimulation(parameters);
//
//		result.getUsedFrameNames().forEach(character -> {
//			System.out.print(character);
//		});
//		System.out.println("");
//
//		System.out.println(result.getPageFails());
//
//		scanner.close();


	}
}
