package ass3OS;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
	VirtualFileController c ;
	int DiskSize = 0;
	  Scanner in = new Scanner(System.in) ;
	  Scanner s = new Scanner(System.in) ;
    // System.out.println("Enter size of blocks in the disk");
    // DiskSize = in.nextInt();
     
     c = new VirtualFileController(true);
     
     
     while(true)
     {
 
     String Input = s.nextLine();
     c.ExcuteCommands(Input);
     }
     
     
	}
	/*
	 * CreateFolder root/folder1
	 * CreateFolder root/folder1/folder2
	 * DeleteFolder root/folder1/folder2
	 * DisplayDiskStructure 
	 * CreateFile root/folder1/file.txt 10
	DeleteFolder root/folder1/folder2
	CreateFile root/file.txt 10 
	DeleteFile root/file.txt 
	DeleteFile root/folder1/file.txt
	 */

}
