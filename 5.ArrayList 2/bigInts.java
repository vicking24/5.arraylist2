import java.util.ArrayList;

class bigInts {

    public static ArrayList<Integer> add(ArrayList<Integer> nums, ArrayList<Integer> num2) {
        ArrayList<Integer> sum = new ArrayList<Integer>();
        int ten=0;
        int s=Math.abs(nums.size()-num2.size()); //difference in length
        if (nums.size()>=num2.size()){ 
            for (int i=nums.size()-1; i>=0+s; i--){ //add up # in same place values
                sum.add(0, nums.get(i)+num2.get(i-s)+ten);
                ten=0;
                if (nums.get(i)+num2.get(i-s)>=10){ //if bigger than 10, then next place add 1, this place minus 10
                    sum.set(0, nums.get(i)+num2.get(i-s)-10);
                    ten=1;
                }
            }
            for (int k=s-1; k>=0; k--){ //unequal lenth, biggest place value>10
                if (ten==1) {
                    sum.add(0, nums.get(k)+1);
                    ten=0;
                }
                else sum.add(0, nums.get(k));
            }
            if (ten==1) sum.add(0, 1); //equal length biggest place value>10

        } else {
            for (int i=num2.size()-1; i>=0+s; i--){
                sum.add(0, nums.get(i-s)+num2.get(i)+ten);
                ten=0;
                if (nums.get(i-s)+num2.get(i)>=10){
                    sum.set(0, nums.get(i-s)+num2.get(i)-10);
                    ten=1;
                }
            }
            for (int k=s-1; k>=0; k--){
                if (ten==1) {
                    sum.add(0, num2.get(k)+1);
                    ten=0;
                }
                else sum.add(0, num2.get(k));
            }
            if (ten==1) sum.add(0, 1);

        }

        return sum;
    }


    public static void main (String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(2);
        nums.add(4);
        nums.add(5);
        nums.add(4);
        ArrayList<Integer> num2 = new ArrayList<Integer>();
        num2.add(9);
        num2.add(2);
        num2.add(6);
        System.out.println("Our numbers before: " + nums+", "+num2);
        System.out.println("The sum:  " + add(nums, num2));
    }

}
