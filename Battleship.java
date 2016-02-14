public class Battleship{
public static void main(String[] args){
	
	Coordinate firedCoordinate = new Coordinate(0,0);
	char result = ' ';
	
	
	// GET NAMES OF THE PLAYERS
	System.out.println();
	System.out.println();
	System.out.println("___  ____ ___ ___ _    ____ ____ _  _ _ ___"); 
	System.out.println("|__] |__|  |   |  |    |___ [__  |__| | |__]"); 
	System.out.println("|__] |  |  |   |  |___ |___ ___] |  | | |   ");
	System.out.println();
	System.out.println();
	System.out.println("Welcome to Battleship!");
	System.out.println();
	System.out.println("Enter yes to play against a computer or no to play against another player");
	boolean gameType = IO.readBoolean();
	
	if(gameType == true){
		
		System.out.println("Player, please enter your name:");
		System.out.println();
		String player1Name= IO.readString();
		String player2Name = "CPU";
		
		
		// PLACE SHIPS FOR BOTH PLAYERS
		
		System.out.println(player1Name+"'s turn:");
		System.out.println();
		Player player1 = new Player_ad823();
		player1.placeShips();
		
		System.out.println(player2Name+"'s turn:");
		System.out.println();
		Player player2 = new Player_AI();
		player2.placeShips();
		
		
		
		// GAME LOOP
		while(player1.lost() == false && player2.lost() == false){
			
			while(result != 'M'){
			System.out.println(player1Name+"'s turn:");
			System.out.println();
			result = '~';
			while(result == '~'){
			firedCoordinate = player1.fire();
			result = player2.fireUpon(firedCoordinate);
			player1.fireResult(result);
			}
			if(player2.lost() == true){
				System.out.println(player2Name + ", you have lost!!!"+ player1Name +" wins!!!");
				System.out.println();
				break;
			}
			}
			result = ' ';
			
			if(player2.lost() == true){
				break;
			}

			while(result != 'M'){
			System.out.println(player2Name+"'s turn:");
			System.out.println();
			result = '~';
			while(result == '~'){
			firedCoordinate = player2.fire();
			result = player1.fireUpon(firedCoordinate);
			player2.fireResult(result);
			}
			if(player1.lost() == true){
				System.out.println(player1Name + ", you have lost!!! "+ player2Name +" wins!!!");
				System.out.println();
				break;
			}
			}

			result = ' ';
			
			if(player1.lost() == true){
				break;
		
		
		}
		}
		
		System.out.println();
		System.out.println("___  ____ ___ ___ _    ____ ____ _  _ _ ___"); 
		System.out.println("|__] |__|  |   |  |    |___ [__  |__| | |__]"); 
		System.out.println("|__] |  |  |   |  |___ |___ ___] |  | | |   ");
		System.out.println();
		
		
	}
	
	
	if (gameType == false){
		

		System.out.println("Player 1, please enter your name:");
		System.out.println();
		String player1Name= IO.readString();
		System.out.println("Player 2, please enter your name:");
		System.out.println();
		String player2Name= IO.readString();
		
		
		
		// PLACE SHIPS FOR BOTH PLAYERS
		
		System.out.println(player1Name+"'s turn:");
		System.out.println();
		Player player1 = new Player_ad823();
		player1.placeShips();
		
		System.out.println(player2Name+"'s turn:");
		System.out.println();
		Player player2 = new Player_ad823();
		player2.placeShips();
		
		
		
		// GAME LOOP
		while(player1.lost() == false && player2.lost() == false){
			
			while(result != 'M'){
			System.out.println(player1Name+"'s turn:");
			System.out.println();
			result = '~';
			while(result == '~'){
			firedCoordinate = player1.fire();
			result = player2.fireUpon(firedCoordinate);
			player1.fireResult(result);
			}
			if(player2.lost() == true){
				System.out.println(player2Name + ", you have lost!!!"+ player1Name +" wins!!!");
				System.out.println();
				break;
			}
			}
			result = ' ';
			
			if(player2.lost() == true){
				break;
			}

			while(result != 'M'){
			System.out.println(player2Name+"'s turn:");
			System.out.println();
			result = '~';
			while(result == '~'){
			firedCoordinate = player2.fire();
			result = player1.fireUpon(firedCoordinate);
			player2.fireResult(result);
			}
			if(player1.lost() == true){
				System.out.println(player1Name + ", you have lost!!! "+ player2Name +" wins!!!");
				System.out.println();
				break;
			}
			}

			result = ' ';
			
			if(player1.lost() == true){
				break;
		
		
		}
		}
		
		System.out.println();
		System.out.println("___  ____ ___ ___ _    ____ ____ _  _ _ ___"); 
		System.out.println("|__] |__|  |   |  |    |___ [__  |__| | |__]"); 
		System.out.println("|__] |  |  |   |  |___ |___ ___] |  | | |   ");
		System.out.println();
		
		
		
		
		
	}
	
	

}
}