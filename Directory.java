package ass3OS;

import java.util.ArrayList;
import java.util.Vector;

public class Directory {
	public String directoryPath;
	public String  name;
	public Vector<File>files = new Vector<File>();
	public Vector<Directory> subDirectories = new Vector<Directory>();;
	private boolean deleted = false;
	
	public  Directory () 
	{
		directoryPath= "";
		files= new Vector<File>();
		subDirectories = new Vector<Directory>();
				
	}
	public  Directory (String path) 
	{
		String [] s = path.split("/");
		directoryPath = path;
		this.name = s[s.length-1];
		 
	}
   
    Directory getSpecificDirectory(String name)
    {     //root/folder1/folder2
    	if(this.name.equals(name))
    	{
    		return this;
    	}
    	else 
    	{
    		//System.out.println("else ");
    		//System.out.println(subDirectories.size());
    	 for(int i = 0 ; i < subDirectories.size() ; i++) 
    	 {   
    		 //System.out.println(i + subDirectories.get(i).name);
    		 if(subDirectories.get(i).name.equals(name))
 		         {
    		// System.out.println("exists  "+ subDirectories.get(i).name);
 			return subDirectories.get(i);
 	            	}
    	}
    	}
    		
    	 for(int i = 0 ; i < subDirectories.size() ; i++) 
    	 {   
    		 
    		 if(subDirectories.get(i).name.equals(name))
 		         {
    		
 			return subDirectories.get(i);
 	            	}
    	        return subDirectories.get(i).getSpecificDirectory( name); 
    	 }
    	
    	 return null;
    	
    }

	File getSpicificFile(String name)
	{ // if(this.name == "root")
	  
		for(int k =0 ;k< files.size();k++)
		{
			//System.out.println(files.get(k).name);
			if(files.get(k).name.equals(name))
			{
				return files.get(k);
			}
		}
	
	/*else
	{
		System.out.println("else  "+this.name);
		for(int j =0 ;j< subDirectories.size();j++) 
		{
			for(int i = 0 ; i <subDirectories.get(j).files.size() ; i++)
	    	 {      if(subDirectories.get(j).files.get(i).name.equals(name) )
	 		         {
	 			       return subDirectories.get(j).files.get(i);
	 	             }
	    	 }
			 return subDirectories.get(j).getSpicificFile(name);
	    	
		}
	} */
    	 return null;
	
	}
	
	
	
	int getSpicificFileindex(String name)
	{ 
		for(int i = 0 ; i<files.size(); i++)
		{
			if(files.get(i).name.equals(name))
			{
				return i;
			}
					
			
		}
		return -1;
	}
	boolean FolderExists(String fullpath ) 
	{
		
		String [] s = fullpath.split("/");
		Directory d1;
		if(directoryPath.equals(fullpath))
			return true;
		for(int k = 1 ; k<s.length; k++)
		{
			//System.out.println(s[k]);
			d1 = getSpecificDirectory(s[k]);
			if(d1 != null)
			{
				//System.out.println(" directory notnull");
			if(d1.directoryPath.equals(fullpath))
				return true;
			}
		}
		return false;
	}
	///
	boolean FileExists(String fullpath)
	{
		String [] s = fullpath.split("/");
		Directory d1;
		for(int k = 0 ; k<s.length; k++)
		{
			d1 = getSpecificDirectory(s[k]);
			if(d1 != null)
			{
				System.out.println("not null folder" +d1.name);
				System.out.println(d1.getSpicificFile(s[s.length-1]) );
				System.out.println(s[s.length-1]);
			if(d1.getSpicificFile(s[s.length-1]) != null)
			{
				System.out.println("not null file" +d1.getSpicificFile(s[s.length-1]).name);
				return true;
			}
			}
			
		}
		return false;
		
	}
	
	
	
	    public void printDirectoryStructure() {
	        if(deleted == true) return;
	        System.out.println("<"+name+">");
	    
	        for(int i = 0 ; i < files.size() ; i++)
	            System.out.println(files.get(i).getFileName());
	        for(int i = 0 ; i < subDirectories.size() ; i++)
	            subDirectories.get(i).printDirectoryStructure();
	    }

	    public void addFile(File file,int allocated[]){
	        memory.allocated(allocated);
	        file.setAllocatedBlocks(allocated);
	        files.add(file);
	    }

	    public void addDirectory(Directory subDirectory){
	        subDirectories.add(subDirectory);
	    }

	    public void deleteFile(int index){
	        int allocated[] = files.get(index).getAllocatedBlocks();
	        memory.freeAllocated(allocated);
	        files.remove(index);
	    }

	    public void deleteAllFiles(){
	        while(files.size()!=0){
	            deleteFile(0);
	        }
	    }
	    public void deleteDirectory(){
	        deleteAllFiles();
	        while(subDirectories.size() > 0){
	            subDirectories.get(0).deleteDirectory();
	            subDirectories.remove(subDirectories.get(0));
	        }
	        deleted = true;
	    }

	    public void deleteSpecificDirectory(Directory directory){
			subDirectories.get(subDirectories.indexOf(directory)).deleteDirectory();
			subDirectories.remove(subDirectories.indexOf(directory));
		}
	
}
