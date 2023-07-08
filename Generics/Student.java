public class Student implements Comparable<Student>{
    public String Name;
    public int Age;
    public Student(){}
    public Student(String s,int i)
    {
        Name=s;
        Age=i;
        
    }
    @Override
    public String toString()
    {
        return "name: " + this.Name + " age: " + this.Age ;
    }
    @Override
    public int compareTo(Student o) {
        // TODO Auto-generated method stub
        return this.Age -o.Age;
    }
}
