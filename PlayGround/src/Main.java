
import java.util.*;

public class Main {

    public static void main(String[] args) {
        //int[] s= new int[Integer.MAX_VALUE];
        System.out.print("012345".substring(3));
        char[] carr= new char[]{'a','b','c','d'};
        int [] arrk=new int[]{3,1,0,2};
        reorder(carr,arrk);
        for(char c:carr){
            System.out.print(c+",");
        }
        System.out.println();
        count6dights();
        //test(2);
        List<Integer>[] marker= new List[5];
        for(int i=0;i<marker.length;i++){
            marker[i]= new ArrayList<>();
        }

        marker[0].add(1);

        int[] arr1= {-1,-1,5,7,-1,12,14};
        int[] arr3= {1,6,10};
        //sortTwoArr(arr1,arr3);
        //int[] arr2= new int[ (int)(1.5*arr1.length)];
        //System.arraycopy(arr1,0,arr2,0,arr1.length);
        for(int i: arr1){
            System.out.print(i+" ");
        }

        int[] res=new int[]{1,2,3,4,6,6,6,6,6,7,8};

        System.out.println( "=====================");
        System.out.println(binarySearch2(res,6));


    }


    public static int binarySearch2(int[] nums, int k){
        int i=0,j=nums.length-1;

        while(i<j){
            int mid= i+(j-i)/2;
            if(nums[mid]>k)
                j=mid-1;
            else
                i=mid;
        }
        System.out.println(i+" and "+(i+1));
        return nums[i];
    }


    public static int binarySearch(int[] nums, int k){
        int i=0,j=nums.length-1;

        while(i<j){
            int mid= i+(j-i)/2;
            if(nums[mid]<k)
                i=mid+1;
            else
                j=mid;
        }
        System.out.println(i+" and "+(i+1));
        return nums[i];
    }


    ///count all 6 digits

    public static int countNum(int num){
        int ans=0;
        while(num!=0){
            ans+=num%10;
            num/=10;
        }
        return ans;
    }

    //
    public static void reorder(char[] A, int[] B) {

        for(int i=0;i<A.length;i++){

            if(B[i]==i) continue;
            int cur=i;
            char c=A[i];
            while(B[cur]!=i){
                A[cur]=A[B[cur]];
                int temp=B[cur];
                B[cur]=cur;
                cur=temp;
            }

            A[cur]=c;
            B[cur]=cur;


        }

    }
    public static void swapChar(char[] a,int i,int j){
        char tmp=a[i];
        a[i]=a[j];
        a[j]=tmp;
    }

    public static void swapInt(int[] a,int i,int j){
        int tmp=a[i];
        a[i]=a[j];
        a[j]=tmp;
    }

    public static void count6dights(){
        int ans1=0;
        for(int i=100;i<=999;i++){
            for(int j=0;j<=999;j++){
                if(countNum(i)==countNum(j))
                    ans1++;
            }
        }



        //dp

        int[][] firstThree= new int[1][28];
        int[][] lastThree= new int[1][28];

        for(int i=0;i<=9;i++){
            if(i>0)firstThree[0][i]=1;
            lastThree[0][i]=1;
        }



        for(int i=1;i<3;i++){
            for(int j=27;j>=0;j--){
                for(int d=1;d<=9;d++) {
                    if (j - d >= 0) {
                        firstThree[0][j] += firstThree[0][j - d];
                        lastThree[0][j] += lastThree[0][j - d];
                    }


                }
            }
        }

        int ans2=0;

        for(int i=1;i<=27;i++){
            ans2 += (firstThree[0][i]*lastThree[0][i]);
        }

        System.out.print(ans1+"=="+ans2);

    }


    // min diff of two arrays
    public static int minDiff(int[] a, int[] b){
        if(a==null || b==null || a.length==0 ||b.length==0)
            throw new IllegalArgumentException();

        int alen=a.length,blen=b.length;
        int min=Math.abs(a[0]-b[0]);
        int i=0,j=0;

        while(i<alen && j<blen){

            min= Math.min(min,Math.abs(a[i]-b[j]));
            if(min==0) return 0;

            if(a[i]>b[j]){
                j++;
            }else{
                i++;
            }
        }

        while(j<blen){
            min=Math.min(min,Math.min(a[alen-1],b[j++]));
        }

        while(i<alen){
            min=Math.min(min,Math.min(b[blen-1],a[i++]));
        }


        return min;


    }


    //out of stack




    public  static int getBiCo (int n, int k){
        if(n==k) return 1;

        if(k==0) return 1;

        return getBiCo(n-1,k-1) + getBiCo(n-1,k);

    }


    public static int product(int i,int j){
        if(i==0 || j==0) return 0;
        int sign= ((i>0 && j>0)||(i<0 && j<0))?1:-1;
        int res=0;
        while(i>0){
            if((i&1)!=0){
                res+=j;
            }
            j<<=1;
            i>>=1;
        }
        return sign*res;
    }




    public static int removeDuplicates(int[] nums) {
        Set<Integer> dic =new HashSet<Integer>();
        int length =0;
        for (int i=0;i<nums.length;i++){
            if (dic.contains(nums[i])){
                continue;
            }else{
                length++;
                dic.add(nums[i]);
            }
        }
        return length;
    }


    public class Solution {

        TrieNode map= new TrieNode(-1);


        public void buildDictionary(ArrayList<String> dict) {

        }

        //public ArrayList<String> lookup(int input) {

        //}
    }

    public class TrieNode{
        int i;
        TrieNode[] children;
        List<String> res;

        public TrieNode(int i){
            this.i=i;
            children = new TrieNode[10];
            res= new ArrayList<>();
        }
    }

    // 乘法
    public static int bc(int n ,int k ){
        if(k==0 || k==n)
            return 1;

        if(k>n/2)
            return bc(n,n-k);

        double res=1;
        for(int i=k;i>=1;i--){
            res=res*n/i;
            n--;
        }

        return (int)res;
    }





}
