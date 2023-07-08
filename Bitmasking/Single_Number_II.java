public class Single_Number_II{
    public static void main(String[] args) {
        
    }
    public static int Single(int []arr) {
        int[] bit=new int[32];
        for (int i = 0; i < arr.length; i++) {
            int num=arr[i];
            int pos=0;
            while(num>0){
                if((num&1)>0){
                    bit[pos]++;
                }
                pos++;
                num=num>>1;
            }

        }
        for (int i = 0; i < bit.length; i++) {
            bit[i]%=3;
        }
        
    }
}