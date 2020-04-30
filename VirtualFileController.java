package ass3OS;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
public class VirtualFileController {
 public static 	Directory root = new Directory("root");
	int disksize;
   boolean f;
   
     public VirtualFileController(boolean conFlag) throws FileNotFoundException, UnsupportedEncodingException
	{
		String blocks="";
		//disksize = s;
		f = conFlag;
		Path file = Paths.get("DiskStructure.txt");
		try  {
			List<String> lines = Files.readAllLines(file);
			if (lines != null) {
				blocks= lines.get(0) ;
				System.out.println(lines.get(0));
			}
			else{
				System.out.println("this file is empty.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		memory.allocated= blocks;
	}
    
	
	/*public VirtualFileController(int s,boolean conFlag) throws FileNotFoundException, UnsupportedEncodingException 
	{
		
		disksize = s;
		f = conFlag;
		String blocks="";
		for(int i =0; i<s ;i++)
		{
			blocks+="0";
		}
		AddtoVirtualFileSystem(blocks);
		 memory.allocated= blocks;
		
	}*/
	void AddtoVirtualFileSystem(String str) throws FileNotFoundException, UnsupportedEncodingException 
	{
		PrintWriter writer = new PrintWriter("DiskStructure.txt");
		writer.println(str);
	
		writer.close();
	}
	
	
	
	String [] Parcer(String input) {
		String command[] = input.split(" ");
		return command;
	}
	
	
	
	
	void ExcuteCommands(String input) throws FileNotFoundException
	{
		String command[] = Parcer(input);
		String path ="" ;
		switch (command.length) {
		case 1:
			    switch (command[0]) {
			      case "DisplayDiskStatus" :
			    	  int numEmpty = memory.numOfEmptyBlocks();
						int numAllocated = memory.numOfAllocatedBlocks();
						System.out.println("Empty space = " + numEmpty + " KB." );
						System.out.println("Allocated space = " + numAllocated + " KB." );
						System.out.print("Empty Blocks in the Disk : "  );
						memory.printEmptyBlocks();
						System.out.println("allocated Blocks in the Disk : " );
						memory.printAllocatedBlocks();

			      break;
///////////////////////////////////////////////////////////////////////
			      case "DisplayDiskStructure":
				  root.printDirectoryStructure();
				  break;
			      default:
			      System.out.println("INcorrect Command");
				  break;
			                      }
			
			break;
///////////////////////////////////////////////////////////////////////
		case 2:
			String [] k= command[1].split("/");
		
			String folderpath= "";
			String foldername ="";
			switch (command[0]) {
			case "CreateFolder" :
			
				for(int i=0 ; i<k.length-1;i++ )
				{
					folderpath+=k[i];
					if(i != k.length-2)
					folderpath +="/";
				}
				System.out.println(folderpath);
			    foldername+=k[k.length-1];
			System.out.println(foldername);
				if(root.FolderExists(folderpath))
				{
					System.out.println("path exists"); 
				if(root.FolderExists(command[1]))
				{
					System.out.println("Folder is already exists ");
				}
				
				else
				{
					
                 if(k.length>2)
                	 {
                	
                	//System.out.println( root.getSpecificDirectory(k[k.length-2]).name);
                	 root.getSpecificDirectory(k[k.length-2]).addDirectory(new Directory(command[1]));
                	// System.out.println( root.getSpecificDirectory(k[k.length-2]).subDirectories.get(0).name);
                	System.out.println(root.getSpecificDirectory(foldername).name);
                    System.out.println(root.getSpecificDirectory(foldername).directoryPath);
  
                     
                	 
                	 }
                 else {
                	 Directory v = new Directory(command[1]);
                	
                	 root.addDirectory(v);
                	 if(root.subDirectories.size()>1) {
                	 System.out.println(root.subDirectories.get(1).name);
                	 System.out.println(root.subDirectories.get(1).directoryPath);
                    
                	 }
                 }
                  
                  
				}
				}
///////////////////////////////////////////////////////////////////////			
				break;
			case "DeleteFile":
				for(int i=0 ; i<k.length-1;i++ )
				{
					foldername+=k[i];
					if(i != k.length-2)
						foldername +="/";
				}
				System.out.println(foldername);
				if(root.FolderExists(foldername))
				{
					System.out.println("exists");
					//System.out.println(root.getSpecificDirectory(foldername).getSpicificFileindex(command[command.length-1]));
				    if(root.FileExists(command[1]))
				     {
					System.out.println("existssssssssss");
					//System.out.println(root.getSpecificDirectory(foldername).getSpicificFileindex(k[k.length-1]));
					//System.out.println(root.getSpecificDirectory(foldername).files.get(0).name);
					//System.out.println(k[k.length-1]);
					//root.deleteFile(0);
					System.out.println(root.getSpecificDirectory(k[k.length-2]).directoryPath);
					System.out.println(root.getSpecificDirectory(k[k.length-2]).getSpicificFileindex(k[k.length-1]));
					if(root.getSpecificDirectory(k[k.length-2]).getSpicificFileindex(k[k.length-1]) >=0)
						root.getSpecificDirectory(k[k.length-2]).deleteFile(root.getSpecificDirectory(k[k.length-2]).getSpicificFileindex(k[k.length-1]));
			    	}
				    else 
				    {
				    	System.out.println("file not exists");
				    }
				}
				break;
///////////////////////////////////////////////////////////////////////
			case"DeleteFolder":
				/*if(root.FolderExists(command[1]))
				{
					String [] k1= command[1].split("/");
					String foldername1= k1[k1.length-1];
					 root.getSpecificDirectory(foldername1).deleteDirectory();
					
					
				}*/
				if(root.FolderExists(command[1]))
				{
					String [] k1= command[1].split("/");
					String parent = k1[k1.length-2];
					String foldername1= k1[k1.length-1];
					root.getSpecificDirectory(parent).deleteSpecificDirectory( root.getSpecificDirectory(foldername1));
					
					
				}
			
				break;
///////////////////////////////////////////////////////////////////////
			default:
			   System.out.println("INcorrect Command");
				break;
			}
			break;
	case 3:
			
			int filesize= Integer.parseInt(command[2]);
			if(command[0].equalsIgnoreCase("CreateFile"))
			{
				String [] k1= command[1].split("/");
				String foldername1= "";
				for(int i=0 ; i<k1.length-1;i++ )
				{
					foldername1+=k1[i];
					if(i != k1.length-2)
						foldername1 +="/";
				}
				System.out.println("path  "+foldername1);
				if(root.FolderExists(foldername1))
				{
					System.out.println(" path exists");
					
					if(root.getSpecificDirectory(k1[k1.length-2]).getSpicificFileindex(k1[k1.length-1]) != -1)
				     {
					System.out.println("File is already exists ");
			      	}
			    	else {
					int blockes[] ;
					if(f == true)
					{
						System.out.println("contigous");
						blockes = memory.newAllocatedCon(filesize);
						System.out.println(blockes);
					}
					else
						blockes = memory.checkIndexAllocated(filesize);

					if (blockes == null) 
					{
						System.out.println("No space");
					} 
					else
					{
						System.out.println(" there is a space");
						File file = new File(command[1]);
						//System.out.println(root.getSpecificDirectory(k1[k1.length-2]).name);
						//System.out.println(k1[k1.length-2]);
						//System.out.println(root.getSpecificDirectory(k1[k1.length-2]).name);
						root.getSpecificDirectory(k1[k1.length-2]).addFile(file,blockes);
						
			
					}

					
				}

				}
			}

			else
			{
				System.out.println("INcorrect Command");
			}
			break;
///////////////////////////////////////////////////////////////////////		
		default:
			System.out.println("INcorrect Command");
			break;
		}
		PrintWriter writer = new PrintWriter("DiskStructure.txt");
		writer.println(memory.allocated);

		writer.close();
		
	}
	

}
