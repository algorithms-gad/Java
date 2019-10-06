
package GreedySelection;
import java.util.Scanner;

import com.sun.jdi.event.Event;
public class GreedySelection
{
    public int[][] sort(int[][] event)
    {
        for(int i = 0; i <(event[0].length - 1) ; i++)
        {
            for(int j = i; j <(event[0].length - 1) ; j++){
                if(event[1][i] > event[1][j+1])
                {
                    int s = event[0][j+1];
                    event[0][j+1] = event[0][i];
                    event[0][i] = s;

                    int f = event[1][j+1];
                    event[1][j+1] = event[1][i];
                    event[1][i] = f;
                }
            }
        }
        return event;
    }
    public void display(int[][] event ,int n)
    {
        System.out.println();
        
        System.out.print("           ");
        
        for(int i = 0; i < n ; i++)
        {
            System.out.print((i+1) + "\t");
        }
        for(int i = 0; i<2;i++)
        {
            if (i ==0){
                System.out.print("\nStart  :   ");
            }
            else{
                System.out.print("\nfinish :   ");
                
            }
            for (int j = 0; j<n ; j++)
            {
                System.out.print(event[i][j] + "\t");
                
            }
            System.out.print("\n");
        }
    }
    public void greedy(int[][] event)
    {
        int [][] answer;
 
        int l =0;
        
        answer = new int[2][event[0].length];
        answer[0][0] = event[0][0];
        answer[1][0] = event[1][0];
       
            for(int j = 1; j <=(event[0].length - 1) ; j++){
                if(answer[1][l] < event[0][j])                      // Here, In condition if we take <= that means between two events has no interval first event over then second event synchronousy done.
                {
                    l ++;
                    answer[0][l] = event[0][j];
                    answer[1][l] = event[1][j];
                    // k = j;
                }
            }
      
        this.display(answer, l+1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("How many Event Arrive");
        int n = sc.nextInt();
        int f;
        int event[][];
        event = new int[2][n];

        for(int i = 0; i < n ;i ++)
        {

            System.out.println("please enter " + (i+1) + " event");
            System.out.print("Start Time = " );
            event[0][i] = sc.nextInt();
            while(true)
            {
                System.out.print("\nFinish Time = ");
                
                f = sc.nextInt();
                if(f > event[0][i] && f < 24)
                {
                    event[1][i] = f;
                    break;
                }
                else{
                    System.out.println("please enter valid finish time.  it never happen start time > finish time...");
                    continue;
                }
            }

        }
        GreedySelection m = new GreedySelection();
        m.display(event , n);
        event = m.sort(event);
        m.display(event, n);

        m.greedy(event);
    }
}