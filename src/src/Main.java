package src;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		
		PageTable ptFIFO = new PageTable(new FIFO());
		PageTable ptLRU = new PageTable(new LRU());
		PageTable ptLRUPL = new PageTable(new LRUPL());
		
		Scanner scanner = new Scanner(System.in);
		String line = null;
		
		
		StringBuilder sbFIFO = new StringBuilder("");
		int FIFOPageFails = 0;
		
		StringBuilder sbLRU = new StringBuilder("");
		int LRUPageFails = 0;
		
		StringBuilder sbLRUPL = new StringBuilder("");
		int LRUPLPageFails = 0;

		System.out.println("Please specify the list of referred pages, separated by commas (i.e. 1,2,3) and end it with EOF.");

		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			StringTokenizer st = new StringTokenizer(line, ",");
			
			while (st.hasMoreTokens()) {
				int pageID = Integer.parseInt(st.nextToken());
				
				sbFIFO.append(ptFIFO.referPage(pageID));
				sbLRU.append(ptLRU.referPage(pageID));
				sbLRUPL.append(ptLRUPL.referPage(pageID));
				
			}
		}
		FIFOPageFails = ptFIFO.getPageFails();
		LRUPageFails = ptLRU.getPageFails();
		LRUPLPageFails = ptLRUPL.getPageFails();

		String resultDescriptionFormat ="The result of the %s algorithm:";

		System.out.println(String.format(resultDescriptionFormat, "FIFO"));
		System.out.println(sbFIFO.toString());
		System.out.println(FIFOPageFails);

		System.out.println(String.format(resultDescriptionFormat, "LRU"));
		System.out.println(sbLRU.toString());
		System.out.println(LRUPageFails);

		System.out.println(String.format(resultDescriptionFormat, "LRU-PL"));
		System.out.println(sbLRUPL.toString());
		System.out.println(LRUPLPageFails);
		
		scanner.close();
	}
}
