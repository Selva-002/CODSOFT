import java.util.*;
class Main
{
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of Subjects: ");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the marks: ");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum=sum+arr[i];
        }
         System.out.println("Total Marks: ");
        System.out.println(sum);
        int avg=sum/n;
        System.out.println("Average Percentage: "+avg);
        if(avg>90)
        {
            System.out.println("O Grade");
        }
        else if(avg>80)
        {
            System.out.println("A+ Grade");
        }
        else if(avg>70)
        {
            System.out.println("A Grade");
        }
        else if(avg>60)
        {
            System.out.println("B+ Grade");
        }
        else if(avg>50)
        {
            System.out.println("B Grade");
        }
        else
        {
            System.out.println("Fail");
        }
        
    }
}