import java.util.Scanner;
import java.util.Random;
    class game{
       int number;
       int userinput;
        int noofguesses = 0 ;
        public int getnoofguesses(){
            return noofguesses;
        }
        public void setnoofguesses(int noofguesses){
                this.noofguesses = noofguesses;
        }
        game(){
            
            Random rand = new Random();
        this.number =  (rand.nextInt(100));    
        }
        void takeuseinput(){
            System.out.println("guess the number");
            
            Scanner sc =  new Scanner(System.in);

userinput = sc.nextInt();
        }
    
      
        boolean irohit(){
        noofguesses++;
             
        if (userinput==number){
            System.out.println("congras you huess the right"+ number+ " wow you guessed it in  attemds " + noofguesses );
            return true;
        }  
        else if (userinput <number){
            System.out.println("to low...........");
            
        
        }
        else if (userinput >number){
            System.out.println("to high............");
      
               

        }
                return false;
    }             
    }
public class guess{
    public static void main(String[] args) {
        game g = new game();
        boolean b = false;
        while(!b){
             g.takeuseinput();
           b =   g.irohit();
            
        }

    }
    }
