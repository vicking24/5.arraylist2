import java.util.ArrayList;

class sieve {

    public static void s(ArrayList<Integer> nums ) {
        nums.remove(0);
        for (int i=0; i<nums.size(); i++){
            for (int k=nums.size()-1; k>=0; k--){
                if (nums.get(k)>nums.get(i) && nums.get(k)%nums.get(i)==0){
                    nums.remove(k);
                }
            }
        }
    }

    public static ArrayList<Integer> gc(ArrayList<Integer> myList, ArrayList<Integer> nums){
        //boolean first=true;
        ArrayList <Integer> n=new ArrayList<Integer>();
        /*for (int i=nums.size()-1; i>=0; i--){
            if (first&&nums.get(i)<myList.get(0)) {
                n.add(nums.get(i));
                first=false;
            }
            if (!first&&myList.get(0)-n.get(0)==nums.get(i)) n.add(nums.get(i));
        }
        */
        
        for (int i=0; i<nums.size(); i++){
            if (nums.contains(myList.get(0)-nums.get(i))){
                n.add(nums.get(i));
                n.add(myList.get(0)-nums.get(i));
                return n;
            }
        }
        return n; 
    }

    public static void main (String[] args) {
        //question 1
        ArrayList<Integer> nums= new ArrayList<Integer>();
        for (int i=0; i<100; i++) {
            nums.add(i, i+1);
        }
        System.out.println ("before: "+nums);
        s(nums);
        System.out.println ("after: "+nums);

        //question 2
        ArrayList<Integer> list= new ArrayList<Integer>();
        list.add( (int) (Math.random()*100+2) );
        if (list.get(0)%2==1) list.set (0,list.get(0)+1);
        System.out.println ("Num: "+list+"="+gc(list, nums));
    }

}