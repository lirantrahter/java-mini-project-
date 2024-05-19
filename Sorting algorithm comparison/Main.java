/**
 * compares the two quicksort algorithms and prints who did the sort with fewer comparison operation.
 * quicksort1 this is the usual sort described in the book. 
 * quicksort2 this is the new algorithm uses an axis term that neither minimum ot maximum.
 *
 * @author (adi shemesh and liran trahter)
 * @version (23.12.2022)
 */

public class Main extends Func  
{
    public static void main(String[] args)
    {
        int[] arr = new int[]{1,2,3,4,5,6,7,8};
        double count1=0;//number of times quicksort1 miles in fewer comparisons quicksort2
        double count2=0;//number of times quicksort2 miles in fewer comparisons quicksort1
        double count3=0;// the number of times quicksort1 and quicksort2 were sorted with the same amount of comparisons
        int Quicksort1=0;//the number of comparisons made by quicksort1
        int Quicksort2=0;//the number of comparisons made by quicksort2
        double AvergeQuicksort1=0;
        double AvergeQuicksort2=0;
        double WorstCaseQuicksort1=0;
        double WorstCaseQuicksort2=0;
        double BestCaseQuicksort1=0;
        double BestCaseQuicksort2=0;
        double A=0;
        for(int i=0 ;i<Factorial(arr.length);i++)
        {
            Quicksort1=Quicksort(arr,0,arr.length-1,true);
            Quicksort2=Quicksort(arr,0,arr.length-1,false);
            if(Quicksort1<Quicksort2)
            {
                count1++;
            }
            else if(Quicksort1>Quicksort2)
            {
                count2++;
            }
            else 
            {
                count3++;
            }

            if(WorstCase(arr,arr[arr.length-2],arr[arr.length-1]))
            {
                WorstCaseQuicksort1+=Quicksort1;
                WorstCaseQuicksort2+=Quicksort2;
            }

            if(BestCase(arr,arr[arr.length-2],arr[arr.length-1]))
            {
                BestCaseQuicksort1+=Quicksort1;
                BestCaseQuicksort2+=Quicksort2;
            }
            AvergeQuicksort1+=Quicksort1;
            AvergeQuicksort2+=Quicksort2;
            GenerateNextPermutation(arr,arr.length-1);
        }
        A=(1/((double)arr.length*(arr.length-1)));
        System.out.println("for n="+arr.length+":");
        System.out.println("the number of comparisons of quicksort1 is: " +AvergeQuicksort1);
        System.out.println("the number of comparisons of quicksort2 is: "+AvergeQuicksort2);
        System.out.println("Quicksort1 wins="+count1 +" times.");
        System.out.println("Quicksort2 wins="+count2 +" times.");
        System.out.println("Draw:"+count3+" times");
        System.out.println("the averge number of quicksort1 comparisons is: "+AvergeQuicksort1/Factorial(arr.length));
        System.out.println("the averge number of quicksort1 comparisons is: "+AvergeQuicksort2/Factorial(arr.length));
        System.out.println("A="+A);
        System.out.println("the averge number of comparisons A the worst cases in quicksort1: "+WorstCaseQuicksort1/Factorial(arr.length-2));
        System.out.println("the averge number of comparisons A the worst cases in quicksort2: "+WorstCaseQuicksort2/Factorial(arr.length-2));
        System.out.println("the averge number of comparisons A the best cases in quicksort1: "+BestCaseQuicksort1/Factorial(arr.length-2));
        System.out.println("the averge number of comparisons A the best cases in quicksort2: "+BestCaseQuicksort2/Factorial(arr.length-2));

    }

}
