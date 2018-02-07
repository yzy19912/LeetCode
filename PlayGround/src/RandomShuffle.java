import java.util.*;

public class RandomShuffle {
    private int[] list;
    public RandomShuffle( int[] a){
        this.list=a;
    }

    public void shuffle(){
        int[] new_list= list.clone();
        int sum=0;
        for(int i:new_list) {
            sum += i;
        }
        int k=0;
        List<Integer> res= new ArrayList<>();
        Random rand= new Random();
        while(res.size()!=new_list.length) {
         int random=  rand.nextInt(sum);
            for (int i=0 ;i<list.length;i++) {
               if(random-new_list[i]<0){
                   res.add(new_list[i]);
                   sum-=new_list[i];
                   new_list[i]=0;
                   k++;
                   break;
               }else {
                   random -= new_list[i];
               }
            }
        }


        for(int i: res)
        System.out.print(i);
    }





}
