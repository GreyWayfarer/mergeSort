package mergeSort;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MergeSort {
	
   public static BufferedReader create_reader(String file) throws FileNotFoundException {
	   FileReader fr = new FileReader(file);
       BufferedReader reader = new BufferedReader(fr);
       return reader;
   }
	
   public static String[] remove_element(String[] array, int index) { 
	   for(int i = index; i < (array.length - 1); i++) {
		   array[i] = array[i+1];
	   }
	   return array;
   }
   
   public static void close_reader(BufferedReader reader[], int n) throws IOException {
	   for (int i = 0; i < n; i++) {
		   reader[i].close();   
	   }    
   }
    
   public static FileWriter create_writer(String file) throws IOException {
	   FileWriter out = new FileWriter(file);
	   return out;
   }
   
   public static void sort(int n, String[] args, String type) throws IOException {
	   int[] f = new int[n];
	   int n0 = n;
	   String[] line = new String[n];
	   BufferedReader[] reader = new BufferedReader[n];
	   FileWriter out = create_writer(args[0]);
	   for (int j = 0; j < n; j++) {
		   reader[j] = create_reader(args[j+1]);
		   line[j] = reader[j].readLine();
		   f[j] = 1;
	   }
	   int min = 0, i, k, end_of_file = 0, temp = -2;
	   String mini = line[0]; 
	   do {
		   if (temp >= 0) {
			   remove_element(line, temp);
			   n--;
			   if (temp < min) min--;
			   temp = -2;
		   }
		   if (f[min] == 0) {
			   line[min] = reader[min].readLine();
			   f[min] = 1;
		   }
		   mini = line[min];
		   if (type.equals("-s")) {
			   for (i = 0; i < n; i++) {
				   if (line[i].equals(" ")) {
					   line[i] = reader[i].readLine();
					   continue;
				   }
				   if ((int)line[i].charAt(0) < (int)mini.charAt(0)) {
					   mini = line[i];
					   min = i;
				   } else if ((int)line[i].charAt(0) == (int)mini.charAt(0)) {
					   for (k = 1; k < mini.length()-1; k++) {
						   if ((int)line[i].charAt(k) < (int)mini.charAt(k)) {
							   mini = line[i];
							   min = i;
							   continue;
						   } else if ((int)line[i].charAt(k) > (int)mini.charAt(k)) {
							   continue;
						   }
					   }
				   }
			   }
		   } else if (type.equals("-i")) {
			   for (i = 0; i < n; i++) {
				   if (line[i].equals(" ")) {
					   line[i] = reader[i].readLine();
					   continue;
				   }
				   if (Integer.parseInt(line[i]) < Integer.parseInt(mini)) {
					   mini = line[i];
					   min = i;
				   }
			   }
		   }
		   line[min] = reader[min].readLine();
		   if (line[min] == null) {
			   temp = min;
			   f[min] = 2;
			   end_of_file++;
			   min = (min+1) % n;
		   }
		   out.write(mini+'\n');
	   } while(end_of_file != n0);
	   close_reader(reader, n);
	   out.close();
   }
}