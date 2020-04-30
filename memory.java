package ass3OS;

public class memory {
    public static String allocated;

    public static  void memory(String allocated){
        memory.allocated = allocated;
    }

    public  static int[] newAllocatedCon(int numOfBlocks){
        int count = 0;
        int startIndex = -1;
        int size = Integer.MAX_VALUE;
        for(int i = 0 ; i < allocated.length() ; i++){
            if (allocated.charAt(i) == '0')
                count++;
            else{
                if ( count < size && count >= numOfBlocks ){
                    startIndex = i - count;
                    size = count;
                }
                count = 0;
            }
        }
        if (count == allocated.length())
            startIndex = 0;
        else {
            if ( count < size && count >= numOfBlocks ){
                startIndex = allocated.length() - 1 - count;
                size = count;
            }
        }
        if (startIndex != -1){
            int res[] = new int[numOfBlocks];
            for(int i = 0 ; i < numOfBlocks ; i++ ){
                res[i] = startIndex + i;
            }
            return res;
        }
        return null;
    }

    public static int[] checkIndexAllocated(int numOFBlocks){
        int res[] = new int[numOFBlocks];
        for(int i = 0 , j = 0 ; i < allocated.length() ; i++){
            if (allocated.charAt(i) == '0') {
                res[j] = i;
                j++;
                if(j == numOFBlocks) return res;
            }
        }
        return null;
    }
    public static void allocated(int blocks[]){
        for(int i = 0 ; i < blocks.length ;i++){
            String tem = allocated.substring(0, blocks[i]);
            tem += '1';
            tem += allocated.substring(blocks[i] + 1);
            allocated = tem;
        }
    }

    public static void freeAllocated(int blocks[]){
        for(int i = 0 ; i < blocks.length ;i++){
                String tem = allocated.substring(0, blocks[i]);
                tem += '0';
                tem += allocated.substring(blocks[i] + 1);
                allocated = tem;
        }
    }
    public static int numOfEmptyBlocks(){
        int res = 0 ;
        for(int i = 0 ; i < allocated.length() ; i++){
            if (allocated.charAt(i) == '0')
                res++;
        }
        return res;
    }
    public static int numOfAllocatedBlocks(){
        int res = 0 ;
        for(int i = 0 ; i < allocated.length() ; i++){
            if (allocated.charAt(i) == '1')
                res++;
        }
        return res;
    }
    public static void printEmptyBlocks(){
        for(int i = 0 ; i < allocated.length() ; i++){
            if (allocated.charAt(i) == '0')
                System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void printAllocatedBlocks(){
        for(int i = 0 ; i < allocated.length() ; i++){
            if (allocated.charAt(i) == '1')
                System.out.print(i + " ");
        }
        System.out.println();
    }

}
