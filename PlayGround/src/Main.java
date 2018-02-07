
import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] a= new int[]{100,2,3,4};
        RandomShuffle test= new RandomShuffle(a);
        test.shuffle();
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



    public static int bs(int[] a,int t){
        int l=0,r=a.length-1;

        while(l<r){
            int mid=l+(r-l)/2;

            if(a[mid]<t){
                l=mid+1;
            }else
                r=mid;

        }
        return l;
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
