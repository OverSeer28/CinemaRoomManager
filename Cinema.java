import java.util.Scanner;



public class Cinema {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        System.out.print(">");
        
        int horizontalSeating = input.nextInt();
      


        System.out.println("Enter the number of seats in each row:");
        System.out.print(">");
        
        int verticalSeating = input.nextInt();

        String[][] Cinema_matix = new String[horizontalSeating + 1][verticalSeating + 1];

          
        seatingArrangement(verticalSeating, horizontalSeating, Cinema_matix );
        


        
        boolean state = true;

        while (state) {
            System.out.println();
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            System.out.print(">");

            int userInput = input.nextInt();

            switch (userInput) {
                case 0:
                    state = false;
                    break;
                case 1:
                    showSeats(Cinema_matix);
                    break;
                case 2:
                    selectSeat(verticalSeating, horizontalSeating, Cinema_matix);
                    break;
                case 3:
                    Statistics(Cinema_matix, horizontalSeating, verticalSeating);
                    break;
                default:
                    break;
            }
            
        }

        

        input.close();

          
    }

    public static void showSeats(String[][] Cinema_matix){
         System.out.println("Cinema:");
         for (int i = 0; i < Cinema_matix.length; i++) {
            for (int j = 0; j < Cinema_matix[i].length; j++) {
                System.out.print(Cinema_matix[i][j] + " ");
            }
            System.out.println();
        }
         System.out.println();
    }

    public static void Statistics(String[][] Cinema_matix,int horizontalSeating,int verticalSeating ){


        System.out.println();

        //Number of Purchased Tickets
        int count = 0 ;
        for (int i = 0; i < Cinema_matix.length; i++) {
            for (int j = 0; j < Cinema_matix[i].length; j++) {
                if( Cinema_matix[i][j] == "B"){
                    count++;
                }
            }
            
        }

        System.out.println("Number of Tickets Purchased: " + count);


        //Percentage of Tickets Purchased
        int total_seat = horizontalSeating*verticalSeating;
        float division = (float)count/total_seat;
        String Percentage = String.format("%.2f", (float)(division*100));
        System.out.println("Percentage: "+ Percentage  +"%");

        

        int front_row = horizontalSeating %2 == 0 ? horizontalSeating/2 : (int)(horizontalSeating/2); 
        int all_seats = horizontalSeating * verticalSeating;
        

         
        int currentIncome = 0; 


        for (int i = 0; i < Cinema_matix.length; i++) {
            for (int j = 0; j < Cinema_matix[i].length; j++) {
                if( Cinema_matix[i][j] == "B"){
                    if (all_seats < 60){
                        currentIncome = currentIncome + 10;
                    }else{
                    if (i <= front_row){
                        currentIncome = currentIncome + 10;
                    }else{
                        currentIncome = currentIncome + 8;
                    }
                    
                }
            }
        }
    }



        System.out.println("Current Income: $" + currentIncome);


        //Calcuating total income
        int total_seats = horizontalSeating *verticalSeating;
        int seat_price;
        int total_income;

        if (total_seats < 60){
            seat_price = 10;
            total_income = seat_price * ((horizontalSeating) * (verticalSeating));
        }else{
            int back_row =  (horizontalSeating) - front_row;
            seat_price = (10*front_row)  + (8*back_row);
            total_income = ((10*front_row)  + (8*back_row))*verticalSeating;
        }
        System.out.println("Total Income: $" + total_income);



        System.out.println();


    }

   
    public static void selectSeat(int verticalSeating, int horizontalSeating, String[][] Cinema_matix ){
        
        Scanner select = new Scanner(System.in);
        boolean invalidState = true;

        
            
        while (invalidState){
        System.out.println("Enter a row number:");
        System.out.print(">");
        int row = select.nextInt();


        System.out.println("Enter a seat number in that row:");
        System.out.print(">");
        int column = select.nextInt();



                if (row > horizontalSeating || column > verticalSeating){
                        System.out.println("Wrong input!");
                }else if(Cinema_matix[row][column] == "B"){
                        System.out.println("That ticket has already been purchased!");
                    }else{
                        Cinema_matix[row][column] = "B";
                        System.out.println();
                    

                    int front_row = horizontalSeating %2 == 0 ? horizontalSeating/2 : (int)(horizontalSeating/2); 
                    int all_seats = horizontalSeating * verticalSeating;

                    if (all_seats < 60){
                        System.out.println("Ticket price: $10");
                    }else{
                        if (row <= front_row){
                            System.out.println("Ticket price: $10");
                            
                        }else{
                            System.out.println("Ticket price: $8");
                        }

                    }

                    invalidState = false;
            }
        }
        System.out.println();
    }

    public static void seatingArrangement(int verticalSeating, int horizontalSeating, String[][] Cinema_matix ){

        System.out.println("Cinema: ");

        

        for(int i = 0; i < horizontalSeating + 1; i++){
            for(int j = 0; j < verticalSeating + 1; j++){
                if(i == 0){
                    if(j == 0){
                        Cinema_matix[i][j] = " ";
                    }else{
                        Cinema_matix[i][j] = j+ "";
                    }
                }else{
                    if(j == 0){
                        Cinema_matix[i][j] = i + "";
                    }else{
                        Cinema_matix[i][j] = "S"; 
                    }
                   
                }
                
            }

          

        }

        for (int i = 0; i < Cinema_matix.length; i++) {
            for (int j = 0; j < Cinema_matix[i].length; j++) {
                System.out.print(Cinema_matix[i][j] + " ");
            }
            System.out.println();
        }
        

        
    }

   

    
}