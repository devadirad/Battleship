import java.util.Random;

public class Player_AI implements Player{

	
	Coordinate fireCoordinate = new Coordinate(0,0);
	char[][] boardHits = new char[10][10];
	char[][] boardShips = new char[10][10];
	int x = 0;
	int y = 0;
	int hitsOnPlayer = 0;
	
	
	
public Player_AI(){
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
	
		int[] shipLength = {5, 4, 3, 3, 2};
		int dir = 0;
		
		for(int i=0;i<5;i++){
			
			Random xCoordinate = new Random();
			Random yCoordinate = new Random();
			
			int yCo = 0;
			int xCo = 0;
			
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
					
					yCo = yCoordinate.nextInt(10);
					xCo = xCoordinate.nextInt(10);
				
					boolean isValidPlacementup = true;
					boolean isValidPlacementdown = true;
					boolean isValidPlacementright = true;
					boolean isValidPlacementleft = true;
					
					

					
					if(boardShips[xCo][yCo]=='~'){
						isValidCoordinate = true;
						boardShips[xCo][yCo]=shipCharacter;
					}
					else{
						isValidCoordinate= false;
					}
					

					for(int m=1; m<shipLength[i]; m++){
						if(xCo-m<0 || xCo-m>9){
							isValidPlacementup = false;
							break;
						}
						else if(boardShips[xCo-m][yCo] != '~'){
							isValidPlacementup = false;
							break;
						}
					}
					for(int m=1; m<shipLength[i]; m++){
						if(xCo+m<0 || xCo+m>9){
							isValidPlacementdown = false;
							break;
						}
						else if(boardShips[xCo+m][yCo] != '~'){
							isValidPlacementdown = false;
							break;
						}
					}
					for(int m=1; m<shipLength[i]; m++){
						if(yCo+m<0 || yCo+m>9){
							isValidPlacementright = false;
							break;
						}
						if(boardShips[xCo][yCo+m] != '~'){
							isValidPlacementright = false;
							break;
						}
					}
					

					for(int m=1; m<shipLength[i]; m++){
						if(yCo-m<0 || yCo-m>9){
							isValidPlacementleft = false;
							break;
						}
						if(boardShips[xCo][yCo-m] != '~'){
							isValidPlacementleft = false;
							break;
						}
					}
					
					if(isValidPlacementup == false && isValidPlacementdown == false && 
							isValidPlacementleft == false && isValidPlacementright == false){
						
						isValidCoordinate = false;
						boardShips[xCo][yCo]='~';
					}
				}
			
				boolean isValidDirection = false;
				
				String extend = "";
				
				while(isValidDirection == false){
					
					Random direction = new Random();
					dir = direction.nextInt(4);
					
					//checks if ship can be placed
					if(dir == 0){
						for(int m=1; m<shipLength[i]; m++){
							if(xCo-m<0 || xCo-m>9){
								isValidDirection = false;
								break;
							}
							else if(boardShips[xCo-m][yCo] != '~'){
								isValidDirection = false;
								break;
							}
							else{
								isValidDirection = true;
							}
						}
						
					}
					else if(dir == 1){
						for(int m=1; m<shipLength[i]; m++){
							if(xCo+m<0 || xCo+m>9){
								isValidDirection = false;
								break;
							}
							if(boardShips[xCo+m][yCo] != '~'){
								isValidDirection = false;
								break;
							}
							else{
								isValidDirection = true;
							}
						}
					}
					else if(dir == 2){
						for(int m=1; m<shipLength[i]; m++){
							if(yCo+m<0 || yCo+m>9){
								isValidDirection = false;
								break;
							}
							if(boardShips[xCo][yCo+m] != '~'){
								isValidDirection = false;
								break;
							}
							else{
								isValidDirection = true;
							}
						}
						
					}
					else if(dir == 3){
						for(int m=1; m<shipLength[i]; m++){
							if(yCo-m<0 || yCo-m>9){
								isValidDirection = false;
								break;
							}
							if(boardShips[xCo][yCo-m] != '~'){
								isValidDirection = false;
								break;
							}
							else{
								isValidDirection = true;
							}
						}
						
					}
					else{
						isValidDirection = false;
						continue;
					}
					
				}

				if(dir == 0){
					for(int m=1; m<shipLength[i]; m++){
						boardShips[xCo-m][yCo] = shipCharacter;
					}
				}
				else if(dir == 1){
					for(int m=1; m<shipLength[i]; m++){
							boardShips[xCo+m][yCo] = shipCharacter;
					}
				}
				else if(dir == 2){
					for(int m=1; m<shipLength[i]; m++){
						boardShips[xCo][yCo+m] = shipCharacter;
					}
				}
				else if(dir == 3){
					for(int m=1; m<shipLength[i]; m++){
						boardShips[xCo][yCo-m] = shipCharacter;
					}
				}

			}
								
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
	
	Random xFire= new Random();
	Random yFire= new Random();
	
	
	x = xFire.nextInt(10);
	y = yFire.nextInt(10);
	
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
		System.out.println("You hit the aircraft carrier!");
		boardHits[fireCoordinate.x][fireCoordinate.y]= 'A';
	}
	else if(result=='B'){
		System.out.println("You hit the battleship!");
		boardHits[fireCoordinate.x][fireCoordinate.y]= 'B';
	}
	else if(result=='S'){
		System.out.println("You hit the submarine!");	
		boardHits[fireCoordinate.x][fireCoordinate.y]= 'S';
	}
	else if(result=='D'){
		System.out.println("You hit the destroyer!");
		boardHits[fireCoordinate.x][fireCoordinate.y]= 'D';
	}
	else if(result == 'P'){
		System.out.println("You hit the patrol boat!");
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