
/*clear it is poggrame for the greeding algoritham */


import java.util.Scanner; // it is for the get input from the users


class GreedyAlgorithm{
    static int j = 0;
    public int max(int[] candidate){
        for (int i = j; i<candidate.length ; i++){
            if (candidate[j] < candidate[i]){
                int temp = candidate[j];
                candidate[j] = candidate[i];
                candidate[i] = temp;
            }
        }
        int x = candidate[j];
        j++;
        return x;
    }

    public static void main(String[] args) {
        int[] candidate;
        System.out.println("please enter the number of coin ");

        Scanner scan = new Scanner(System.in); // create a object of the Scanner class to get input

        int n = scan.nextInt();
        candidate = new int[n];
        
        // it is for the get price of the coin in candidate array
        for(int i = 0 ; i <n ; i++){
            System.out.println("enter the coin price " + (i+1));
            candidate[i] = scan.nextInt();
        }

        System.out.println("please enter the rupees");
        int sum = 0;
        int solution[];
        int count = 0;
        
        solution = new int[n];
        int rupees = scan.nextInt();
        GreedyAlgorithm m =new GreedyAlgorithm();
        for(int i = 0; i < n ; i++){
            int maximum = m.max(candidate);
            if ((sum + maximum) <= rupees){
                count++;
                sum = sum + maximum;
                solution[i]= maximum;
            }
        }
         if (sum == rupees){
             System.out.println("minimum = " + count + "coin required");
             
             for(int i =0 ; i < n; i ++){
                if(solution[i] == 0){continue;}
                System.out.println(solution[i]);
            }
         }
    }
}
