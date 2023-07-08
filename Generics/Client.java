import java.util.Comparator;

public class Client {
    public static void main(String[] args) {
        Student[] arr=new Student[5];
        System.out.println(arr[0]);
        arr[0]=new Student("pappu",12);
        arr[1]=new Student("pappu",1);
        arr[2]=new Student("A",15);
        arr[3]=new Student("B",2);
        arr[4]=new Student("ppu",19);
        print(arr);
        bubble(arr,new cc());
        print(arr);
    }
    public static void print(Object[] arr) {
        for (Object s : arr) {
            System.out.println(s);
            
        }
        
    }
//     public static void bubble(Student[] arr) {
//         for(int count=1;count<arr.length-1;count++)
//         {
//             for (int i = 0; i < arr.length-1; i++) {
//                 if(arr[i].Age > arr[i+1].Age)
//                 {Student temp=arr[i];
//                     arr[i]=arr[i+1];
//                     arr[i+1]=temp;
//                 }
//             }
//         }
        
//     }
// }
    
    // public static <T extends Comparable<T>> void bubble(T[] arr) {
    //     for(int count=1;count<arr.length-1;count++)
    //     {
    //         for (int i = 0; i < arr.length-1; i++) {
    //             // if(arr[i].c > arr[i+1].Age)
    //             // if(arr[i]>arr[i+1] >0)   it is wrong way
    //             if(arr[i].compareTo(arr[i+1])>0)
    //             {
    //                 T temp=arr[i];
    //                 arr[i]=arr[i+1];
    //                 arr[i+1]=temp;
    //             }
    //         }
    //     }
        
    // }

        class cc implements Comparator<Student>{
            @Override
            public int compare(Student o1, Student o2) {
                // TODO Auto-generated method stub
                return o1.Age-o2.Age;
            }
            
        }
    public static <T> void bubble(T[] arr ,Comparator<T> obj) {
        for(int count=1;count<arr.length-1;count++)
        {
            for (int i = 0; i < arr.length-1; i++) {
                // if(arr[i].c > arr[i+1].Age)
                // if(arr[i]>arr[i+1] >0)   it is wrong way
                if(obj.compare(arr[i+1], arr[i])>0)
                if(arr[i].compareTo(arr[i+1])>0)
                {
                    T temp=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                }
            }
        }
        
    }
}
