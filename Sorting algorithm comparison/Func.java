public class Func {
    public static int count = 0;
    /**
     * Method Quicksort,sends the array to sort,if m =true for quicksort1(the normal quicksort),if m=false for quicksort2(the new algoritem of quicksort).
     * and return the number of comparisons of the quicksort.

     *
     * @param A  the array you want to sort 
     * @param p  start of array
     * @param r  end of array 
     * @param m  true for quicksort1(the normal quicksort),false for quicksort2(the new algoritem of quicksort).
     * @return  return the number of comparisons of the quicksort.
     */
    public static int  Quicksort(int[] A,int p,int r,boolean m)
    {
        int[]B= new int[A.length];
        CopyArr(A,B);

        if(m==true)
        {
            count=0;
            return Quicksort1(B,0,B.length-1);
        }
        else 
        {
            count=0;
            return Quicksort2(B,0,B.length-1);
        }
    }

    /**
     * Method Quicksort1 the normal quicksort
     *
     * @param A A the array you want to sort 
     * @param p  start of array
     * @param r  end of array 
     * @return  return the number of comparisons of the quicksort.
     */
    public static int  Quicksort1(int[] A,int p,int r)
    {

        if(p<r)
        {
            int q=Partition1(A,p,r);
            Quicksort1(A,p,q-1);
            Quicksort1(A,q+1,r);
        }
        return count;
    }

    /**
     * Method Partition1 the normal partition
     *
     * @param A  the array you want to sort 
     * @param p start of array
     * @param r end of array
     * @return sort the array by A[r] and returns the number of comparisons it is required to make to sort.
     */
    public static int Partition1(int[] A,int p,int r)
    {
        int x = A[r];
        int i=p-1;
        for (int j=p;j<=r-1;j++)
        {
            count++;
            if(A[j]<=x)
            {
                i=i+1;
                Swap(A,i,j);
            }

        }
        Swap(A,i+1,r);
        return i+1;
    }

    /**
     * Method Quicksort2,like quicksort1
     *
     * @param A  the array you want to sort 
     * @param p  start of array
     * @param r  end of array 
     * @return  return the number of comparisons of the quicksort.
     */
    public static int Quicksort2(int[] A,int p,int r)
    {
        if(p<r)
        {
            int q=Partition2(A,p,r);
            Quicksort2(A,p,q-1);
            Quicksort2(A,q+1,r);
        }
        return count;
    }

    /**
     * Method Partition2,like partition 1 but chooses the axis term as the independent number the last three terms 
     * if the array is smaller than three then do like partition1 
     *
     * @param A  the array you want to sort 
     * @param p start of array
     * @param r end of array
     * @return sort the array by A[r] and returns the number of comparisons it is required to make to sort.
     */
    public static int Partition2(int[] A,int p,int r)
    {
        int x=A[r];//if the array is less then three 
        if(r-p>=3)
        {
            x=MiddleOfThree(A[r],A[r-1],A[r-2]);
        }
        int i=p-1;
        for (int j=p;j<=r-1;j++)
        {
            count++;
            if(A[j]<=x)
            {
                i=i+1;
                Swap(A,i,j);
            }
        }
        Swap(A,i+1,r);
        return i+1;
    }
    
    /**
     * Method GenerateNextPermutation produces the next parmutation
     *
     * @param A A the array you want to produce the next permutation 
     * @param n the size of the array 
     */
    public static void GenerateNextPermutation(int[] A,int n ) {
        int i = n - 1;
        while (i >= 1 && A[i] > A[i + 1])
            i--;
        int c = i + 1;
        for (int j = i + 2; j <= n; j++) 
        {
            if (A[i] < A[j] && A[j] < A[c])
                c = j;
        }
        Swap(A, i, c);
        Reverse(A, i + 1, n);
    }

    /**
     * Method Swap between A[i] and A[j]
     *
     * @param A A array
     * @param i position i in the array
     * @param j position j in the array 
     */
    public static void Swap(int[] A,int i,int j)
    {
        int k=A[i];
        A[i]=A[j];
        A[j]=k;
    }

    /**
     * Method Reverse,reverses the sub-array meaning the first element becomes the last and so on.
     *
     * @param A A array
     * @param i A start the reverse 
     * @param j A end the reverse
     */
    public static void Reverse(int[]  A,int i,int j)
    {
        while(!(i>j))
        {
            Swap(A,i,j);
            i++;
            j--;
        }
    }

    /**
     * Method Factorial,makes the number the factorial operation 
     *
     * @param i number 
     * @return the factorial of i 
     */
    public static double Factorial(int i)
    {
        if (i == 0)
            return 1;
        else
            return i * Factorial(i-1);
    }

    /**
     * Method PrintArr,saves all the numbers in the array in order within string 
     *
     * @param arr array
     * @return string of the numbers within the array
     */
    public static String PrintArr(int[] arr)
    {
        String s="";
        for(int i=0;i<arr.length;i++)
            s=s + " " +arr[i];
        return s;
    }

    /**
     * Method CopyArr,copy the vallues ofan array A to array B
     *
     * @param A array A
     * @param B array B
     */
    public static void CopyArr(int[] A,int[]B)
    {
        for(int i=0;i<A.length;i++)
        {
            B[i]=A[i];
        }
    }

    /**
     * Method MiddleOfThree,returns the middle value from three values.
     *
     * @param one value one.
     * @param two value two.
     * @param three value three.
     * @return returns the middle value from three values.
     */
    public static int MiddleOfThree(int one,int two,int three)
    {
        int min=Math.min(one,Math.min(two,three));
        int max=Math.max(one,Math.max(two,three));
        if(one!=min && one!=max)return one;
        if(two!=min && two!=max)return two;
        if(three!=min && three!=max)return three;
        return -1;
    }
    
    /**
     * Method WorstCase checks if the value in the last place in the array is equal to the size of the array 
     * and also the penultimate place is equal to the size of the array minus 1,if so return true,otherwise return false.
     *
     * @param A A array
     * @param i the value in the penultimate position of the array A
     * @param j the value in the last place is the array A
     * @return if the value in the last place in the array is equal to the size of the array 
    and also the penultimate place is equal to the size of the array minus 1,if so return true,otherwise return false.
     */
    public static boolean WorstCase(int[]A,int i,int j)
    {
        if(i==A.length-1 && j==A.length)
            return true;
        else 
            return false;
    }
    
    /**
     * Method BestCase checks if the value in the last place in the array is equal to the size of the array divided by 2 
     * and also the penultimate place is equal to the size of the array minus 1 divided by 2,if so return true,otherwise return false 
     *
     * @param A A array
     * @param i the value in the penultimate position of the array A
     * @param j the value in the last place is the array A
     * @return if the value in the last place in the array is equal to the size of the array divided by 2 
     * and also the penultimate place is equal to the size of the array minus 1 divided by 2,if so return true,otherwise return false.
     */
    public static boolean BestCase(int[]A,int i,int j)
    {
        if(A.length%2==0)
        {
            if(i==((A.length-1)/2) && j==((A.length)/2))
                return true;
            else 
                return false;
        }
        else
        {
            if(i==((A.length)/2) && j==((A.length+1)/2))
                return true;
            else 
                return false;
        }
    }
}
