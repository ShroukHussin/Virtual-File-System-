# Virtual-File-System-
### this project simulates a virtual file system with a root directory called "root" all the files and folders will be stored under it.  The disk size consists of N blocks and each block size is 1 KB.
it simulates the allocation and de-allocation of files and folders using different allocation techniques.
1- Contiguous Allocation (Using Best Fit allocation)  
2- Indexed Allocation 
#### After running the application the user will interact with it (virtual file system) through a series of commands, these commands are illustrated below,
1)"CreateFile root/file.txt 100" -->This command used to create file named “file.txt” with 100 KB size under the path “root” 
Pre-requests: 
1- The path is already exists 
2- No file with the same name is already created under this path 
3- Enough space exists 
2)"CreateFolder root/folder1"--> This command is used to create a new folder named “folder1” under the path “root” 
Pre-requests: 
1- The path is already exist 
2- No folder with the same name is already created under this path.  
3)"DeleteFile root/folder1/file.txt "--> This command used to delete file named “file.txt” form the path "root/folder1".
Pre-requests: 
1- The file is already exist under the path specified path. 
4)"DeleteFolder root/folder1"-->  This command used to delete folder named “folder1” form the path "root". All files and subdirectories of this folder will also be deleted. 
Pre-requests: 
1- The folder is already exist under the path specified 
5)"DisplayDiskStatus"--> This command used to display the status of your Driver the status  
contain the following information: 
1- Empty space 
2- Allocated space 
3- Empty Blocks in the Disk 
4- Allocated  Blocks in the Disk 
6)"DisplayDiskStructure"-->This command will display the files and folders in system file in a tree structure
