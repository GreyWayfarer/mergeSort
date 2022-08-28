package mergeSort;

import java.io.IOException;

public class Main {
	
	public static void main(String[] args) {
		String[] arguments = new String[args.length];
		int j = 1;
		if (args.length < 3) {
			System.out.println("Not enough arguments");
			return;
		}
		if (args[0].equals("-d") || args[0].equals("-a")) { 
			j = 2;
			for (int i = 0; i < args.length-j; i++) {
				arguments[i] = args[i+j];
			}
			if (args[1].equals("-s") || args[1].equals("-i")) {
				try {
					MergeSort.sort(arguments.length-j-1, arguments, args[1]);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("Wrong argument, should be used \"-s\" or \"-i\"");
				return;
			}
			System.out.println("End of program");
		} else if (args[0].equals("-s") || args[0].equals("-i")) {
			for (int i = 0; i < args.length-j; i++) {
				arguments[i] = args[i+j];
			}
			try {
				MergeSort.sort(arguments.length-j-1, arguments, args[0]);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("End of program");
		} else {
			System.out.println("Wrong argument");
			return;
		}
	}
}
