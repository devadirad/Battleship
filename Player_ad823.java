public class Player_ad823 implements Player{

	Coordinate fireCoordinate = new Coordinate(0,0);
	char[][] boardHits = new char[10][10];
	char[][] boardShips = new char[10][10];
	int x = 0;
	int y = 0;
	int hitsOnPlayer = 0;
	
	
	
public Player_ad823(){
	// CONSTRUCTOR
	for(int i=0; i<boardHits.length; i++){
		for(int j=0; j<boardHits[0].length; j++){
		boardHits[i][j]='~';
		}
	}
	
	for(int i=0; i<boardShips.length; i++){
		for(int j=0; j<boardShips[0].length; j++){
		boardShips[i][j]='~';
		}
	}
	
}



public void printBoard(){
	// PRINTS HITS BOARD WITH COORDINATE VALUES
	for(int i=0; i<boardHits.length; i++){
		System.out.print(i + "\t");
	}
	System.out.println();
	
	for (int i=0; i<boardHits.length; i++)
	{
		for (int j=0; j<boardHits[0].length; j++)
		{
			System.out.print(boardHits[i][j] + "\t");
		}
		System.out.print(i);
		System.out.println();
	}
	
}

private void printBoardShips(){
	
	for(int i=0; i<boardShips.length; i++){
		System.out.print(i + "\t");
	}
	System.out.println();
	
	for (int i=0; i<boardShips.length; i++)
	{
		for (int j=0; j<boardShips[0].length; j++)
		{
			System.out.print(boardShips[i][j] + "\t");
		}
		System.out.print(i);
		System.out.println();
	}
}

public void placeShips(){
	
	//Allows one player to place his/her ships on his/her board A. Update the board accordingly.
	
		String[] shipPrompts = {"aircraft carrier (5 units)","battleship (4 units)","submarine (3 units)","destroyer (3 units)","patrol boat (2 units)"};
		int[] shipLength = {5, 4, 3, 3, 2};
		
		
		//prints ships board
		printBoardShips();
		//--------------------
		boolean isFinalPlacement= false;
		while(isFinalPlacement == false){
		
		for(int i=0;i<5;i++){
			
			int xCoordinate=0;
			int yCoordinate=0;
			
			char shipCharacter = 'a';
			
			if(i==0){
				shipCharacter= 'A';
			}
			else if(i==1){
				shipCharacter= 'B';	
			}
			else if(i==2){
				shipCharacter= 'S';	
			}
			else if(i==3){
				shipCharacter= 'D';		
			}
			else {
				shipCharacter= 'P';	
			}

				
			//Gets starting coordinate of the ship, checks if they are valid, and asks the user if that's what he wants
			boolean areYouSure= false;
			while(areYouSure == false){
				
				boolean isValidCoordinate = false;
				while(isValidCoordinate == false){	
				
					boolean isValidPlacementup = true;
					boolean isValidPlacementdown = true;
					boolean isValidPlacementright = true;
					boolean isValidPlacementleft = true;
					
					
					System.out.println("Where would you like to place your "+shipPrompts[i]+"?");
					System.out.println();
					System.out.println("Enter the column number of the starting location of your ship, e.g. 5. You will later extend the ship up, down, left, or right");
					System.out.println();
					yCoordinate = IO.readInt();
					
					while(yCoordinate<0 || yCoordinate>9){
						System.out.println("That is not a valid coordinate, please try again");
						System.out.println();
						System.out.println("Enter the column number of the starting location of your ship, e.g. 5");
						System.out.println();
						yCoordinate = IO.readInt();
					}
					
					System.out.println("Enter the row number of the starting location of your ship, e.g. 5");
					xCoordinate = IO.readInt();
					
					while(xCoordinate<0 || xCoordinate>9){
						System.out.println("That is not a valid coordinate, please try again");
						System.out.println();
						System.out.println("Enter the row number of the starting location of your ship, e.g. 5");
						System.out.println();
						xCoordinate = IO.readInt();
					}
					
					if(boardShips[xCoordinate][yCoordinate]=='~'){
						isValidCoordinate = true;
						boardShips[xCoordinate][yCoordinate]=shipCharacter;
						printBoardShips();
					}
					else{
						System.out.println("That starting location already has a ship in it, please try again");
						System.out.println();
						isValidCoordinate= false;
					}
					

					for(int m=1; m<shipLength[i]; m++){
						if(xCoordinate-m<0 || xCoordinate-m>9){
							isValidPlacementup = false;
							break;
						}
						else if(boardShips[xCoordinate-m][yCoordinate] != '~'){
							isValidPlacementup = false;
							break;
						}
					}
					for(int m=1; m<shipLength[i]; m++){
						if(xCoordinate+m<0 || xCoordinate+m>9){
							isValidPlacementdown = false;
							break;
						}
						else if(boardShips[xCoordinate+m][yCoordinate] != '~'){
							isValidPlacementdown = false;
							break;
						}
					}
					for(int m=1; m<shipLength[i]; m++){
						if(yCoordinate+m<0 || yCoordinate+m>9){
							isValidPlacementright = false;
							break;
						}
						if(boardShips[xCoordinate][yCoordinate+m] != '~'){
							isValidPlacementright = false;
							break;
						}
					}
					

					for(int m=1; m<shipLength[i]; m++){
						if(yCoordinate-m<0 || yCoordinate-m>9){
							isValidPlacementleft = false;
							break;
						}
						if(boardShips[xCoordinate][yCoordinate-m] != '~'){
							isValidPlacementleft = false;
							break;
						}
					}
					
					if(isValidPlacementup == false && isValidPlacementdown == false && 
							isValidPlacementleft == false && isValidPlacementright == false){
						
						isValidCoordinate = false;
						boardShips[xCoordinate][yCoordinate]='~';
						System.out.println("There are no valid placements for a ship with that starting location, please try again");
						System.out.println();
					}
				}
			
				boolean isValidDirection = false;
				
				String extend = "";
				
				while(isValidDirection == false){
					
					System.out.println("Type 'up', 'down', 'left', or 'right' (without the quotes), depending on where you want to extend your ship:");
					System.out.println();
					extend = IO.readString();
					
					//checks if ship can be placed
					if(extend.equals("up")){
						for(int m=1; m<shipLength[i]; m++){
							if(xCoordinate-m<0 || xCoordinate-m>9){
								System.out.println("That direction is out of bounds, please choose a different direction");
								System.out.println();
								isValidDirection = false;
								break;
							}
							else if(boardShips[xCoordinate-m][yCoordinate] != '~'){
								System.out.println("You cannot overlap ships, please choose a different direction");
								System.out.println();
								isValidDirection = false;
								break;
							}
							else{
								isValidDirection = true;
							}
						}
						
					}
					else if(extend.equals("down")){
						for(int m=1; m<shipLength[i]; m++){
							if(xCoordinate+m<0 || xCoordinate+m>9){
								System.out.println("That direction is out of bounds, please choose a different direction");
								System.out.println();
								isValidDirection = false;
								break;
							}
							if(boardShips[xCoordinate+m][yCoordinate] != '~'){
								System.out.println("You cannot overlap ships, please choose a different direction");
								System.out.println();
								isValidDirection = false;
								break;
							}
							else{
								isValidDirection = true;
							}
						}
					}
					else if(extend.equals("right")){
						for(int m=1; m<shipLength[i]; m++){
							if(yCoordinate+m<0 || yCoordinate+m>9){
								System.out.println("That direction is out of bounds, please choose a different direction");
								System.out.println();
								isValidDirection = false;
								break;
							}
							if(boardShips[xCoordinate][yCoordinate+m] != '~'){
								System.out.println("You cannot overlap ships, please choose a different direction");
								System.out.println();
								isValidDirection = false;
								break;
							}
							else{
								isValidDirection = true;
							}
						}
						
					}
					else if(extend.equals("left")){
						for(int m=1; m<shipLength[i]; m++){
							if(yCoordinate-m<0 || yCoordinate-m>9){
								System.out.println("That direction is out of bounds, please choose a different direction");
								System.out.println();
								isValidDirection = false;
								break;
							}
							if(boardShips[xCoordinate][yCoordinate-m] != '~'){
								System.out.println("You cannot overlap ships, please choose a different direction");
								System.out.println();
								isValidDirection = false;
								break;
							}
							else{
								isValidDirection = true;
							}
						}
						
					}
					else{
						System.out.println("That is not a valid direction, please try again");
						System.out.println();
						isValidDirection = false;
						continue;
					}
					
				}
				
				System.out.println("Are you sure this is where you want to place your "+shipPrompts[i]+ "? Enter yes, or no if want to change the position");
				System.out.println();
				areYouSure = IO.readBoolean();
				System.out.println();
				
				if(areYouSure == true){
				
				if(extend.equals("up")){
					for(int m=1; m<shipLength[i]; m++){
						boardShips[xCoordinate-m][yCoordinate] = shipCharacter;
					}
				}
				else if(extend.equals("down")){
					for(int m=1; m<shipLength[i]; m++){
							boardShips[xCoordinate+m][yCoordinate] = shipCharacter;
					}
				}
				else if(extend.equals("right")){
					for(int m=1; m<shipLength[i]; m++){
						boardShips[xCoordinate][yCoordinate+m] = shipCharacter;
					}
				}
				else if(extend.equals("left")){
					for(int m=1; m<shipLength[i]; m++){
						boardShips[xCoordinate][yCoordinate-m] = shipCharacter;
					}
				}
				}
				else{
					boardShips[xCoordinate][yCoordinate] = '~';
				}

				

			}
			System.out.println();
			printBoardShips();
				
				
		}
		
		System.out.println("Is this how you would like to place your ships? Enter yes or no");
		System.out.println();
		isFinalPlacement = IO.readBoolean();
		System.out.println();
		
		if(isFinalPlacement == false){
			for(int i=0; i<boardShips.length; i++){
				for(int j=0; j<boardShips[0].length; j++){
				boardShips[i][j]='~';
				}
			}
			printBoardShips();
		}
		
		}

		for(int i=0;i<100;i++){
			System.out.println();
		}	
	}
	
public char fireUpon(Coordinate x){
	// OTHER PLAYER FIRES UPON THIS PLAYER, UPDATES BOARDS GIVEN COORDINATE
	
	if(boardShips[x.x][x.y] == '~'){
		return 'M';
	}
		else{
			this.hitsOnPlayer++;
			return boardShips[x.x][x.y];

		}
		
}

public Coordinate fire(){
	//RETURNS A COORDINATE THAT THIS PLAYER WISHES TO GUESS
	
	int x=0;
	int y=0;
	
	
	printBoard();
	
	System.out.println("Where would you like to fire?");
	System.out.println("Enter the column number of the location");
	y = IO.readInt();
	System.out.println();

	while(y<0 || y>9){
		System.out.println("That is not a valid coordinate, please try again");
		System.out.println("Enter the column number of the location");
		y= IO.readInt();
		System.out.println();
	}

	System.out.println("Enter the row number of the location");
	x = IO.readInt();

	while(x<0 || x>9){
		System.out.println("That is not a valid coordinate, please try again");
		System.out.println("Enter the row number of the location");
		x = IO.readInt();
		System.out.println();
	}
	
	fireCoordinate.x = x;
	fireCoordinate.y = y;
	return fireCoordinate;
	
}



public void fireResult(char result){		
	//NOTIFIES PLAYER OF TURN RESULT
	
	if(boardHits[fireCoordinate.x][fireCoordinate.y] != '~'){
		System.out.println("You have already fired in that location, please choose another one.");
		System.out.println();
	}	
	else if(result == 'M'){
		System.out.println("Aw, you missed! Next player's turn");
		boardHits[fireCoordinate.x][fireCoordinate.y]= 'M';
	}
	else if(result=='A'){
		System.out.println("You hit the aircraft carrier! You get to go again!");
		boardHits[fireCoordinate.x][fireCoordinate.y]= 'A';
	}
	else if(result=='B'){
		System.out.println("You hit the battleship!  You get to go again!");
		boardHits[fireCoordinate.x][fireCoordinate.y]= 'B';
	}
	else if(result=='S'){
		System.out.println("You hit the submarine!  You get to go again!");	
		boardHits[fireCoordinate.x][fireCoordinate.y]= 'S';
	}
	else if(result=='D'){
		System.out.println("You hit the destroyer!  You get to go again!");
		boardHits[fireCoordinate.x][fireCoordinate.y]= 'D';
	}
	else if(result == 'P'){
		System.out.println("You hit the patrol boat!  You get to go again!");
		boardHits[fireCoordinate.x][fireCoordinate.y]= 'P';
	}
}

/**
* Returns if this player has lost 
*
* @return true if this player has lost, false otherwise
*/
public boolean lost(){
	
	if(hitsOnPlayer == 17){

		return true;
	}
	else{
		return false;
	}
}







	
}
