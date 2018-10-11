import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) throws IOException {
		//Si richiede il numero di giocatori, minimo 2 massimo6
			Scanner Input= new Scanner(System.in);
			System.out.println("Select the number of player-------2-3-4-5-6");
			BufferedReader read=new BufferedReader(new InputStreamReader(System.in));
			int numPlayer = Integer.parseInt(read.readLine());
			System.out.println(numPlayer);
			
			//Si costruiscono un numero di oggetti player pari al numero di giocatori in questione
			Player[] playern = new Player[numPlayer];
			int full=0;
			boolean busy=false;
			while(numPlayer!=full) {
				System.out.println("Insert player's name.");
				String namePlayer = Input.nextLine();
				//controllo nome duplicato
				for (int i = 0; i <full; i++) {
					if (playern[i].getName().equals(namePlayer)) {
						busy=true;
						System.out.println("This player already exist, please insert another name.");
					}
				}
				if (busy==false) {
					System.out.println(namePlayer);
					Player player = new Player(namePlayer,full);
					playern [full]= player;
					full=full+1;
					}
				busy=false;
			}
			
			//Riepilogo dei giocatori in partita
			for(int i = 0;i < numPlayer;i++){
				System.out.println(playern[i].toString());
			}
			
			//Inizio della Partita conteggio Round
			boolean win = false;
			int round = 0;
			int roundPlayer = 0;
			
			//ciclo del gioco 
			while(win==false) {
				int cell =0;
				int startercell= cell;
				System.out.println("Round "+ round+".");
				System.out.println("The player " + playern[roundPlayer].toString()+" .");
				System.out.println(playern[roundPlayer].getName() +"  throws the dice.");
				
				//Tiro del dado
				Dice diceResult= new Dice();
				
				System.out.println("Insert the dice result or insert 0 to the automatically throw.");
				int dicevalue = Integer.parseInt(read.readLine());
				if (dicevalue==0) {
					diceResult.twoDiceThrow();
					}
					else
						diceResult.setResult(dicevalue);
				System.out.println(diceResult.toString());
				
				startercell =playern[roundPlayer].getPosition();
				cell=startercell+diceResult.getResult();
				//Svolgimento condizioni cella
				if (cell==6) {
					cell=12;
					System.out.println("The Bridge the player go to 12.");
				}
				//calcolo due volte se si possono succedere le celle TheGoose
				if (cell==5||cell==9||cell==14||cell==18||cell==23||cell==27) {
					cell=cell+diceResult.getResult();
					System.out.println("The Goose, the player perform a jump.");
				}
				if (cell==5||cell==9||cell==14||cell==18||cell==23||cell==27) {
					cell=cell+diceResult.getResult();
					System.out.println("The Goose, the player perform a multiple jump.");
				}
				if (cell>63)
					cell=63-(playern[roundPlayer].getPosition()+diceResult.getResult()-63); 
				
				//controllo cella occupata (prank)
				busy=false;
				for (int i = 0; i < playern.length; i++) {
					if (cell==playern[i].getPosition())
						busy= true;
				}
				if (busy==true) {
					System.out.println("The cell is busy, turn back to the position before you throw the dice");
					cell=startercell;
				}	
			
				if (cell==63)
					win= true;
				
				System.out.println("The player goes to the cell "+ cell+".");
				playern[roundPlayer].setPosition(cell);
				
				//avanzamento del round e dei turni
				round=round+1;
				roundPlayer=roundPlayer+1;
				if (roundPlayer==numPlayer) {
					roundPlayer=0;
				}


			
}
} 
}

