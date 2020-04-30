package ass3OS;

public class File {
	private  String filePath; 
	private int[] allocatedBlocks;  
	public String  name;
	private boolean deleted = false;  
	public  File () 
	{
		
	}
	public  File (String path) 
	{
		String [] s = path.split("/");
		filePath = path;
		this.name = s[s.length-1];
		 
	}
	public String getFileName(){
        return name;
    }

	  public void setAllocatedBlocks(int allocatedBlocks[]){
	        this.allocatedBlocks = new int[allocatedBlocks.length];
	        for(int i = 0 ; i < allocatedBlocks.length ; i++ ){
	            this.allocatedBlocks[i] = allocatedBlocks[i];
	        }
	    }

	    public String getFilePath(){
	        return filePath;
	    }

	    public int[] getAllocatedBlocks(){
	        return this.allocatedBlocks;
	    }
}
