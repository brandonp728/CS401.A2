package Programs;
import java.util.*;
import java.text.*;
import java.io.*;
public class Assig2 {

	public static void main(String[] args) throws IOException {
		Die d1 = new Die();
		Die d2 = new Die();
		Player p = new Player();
		Scanner inScan = new Scanner(System.in);
		System.out.println("Welcome!! Please enter your first name: ");
		String firstName=inScan.next();
		File nFile = new File(firstName + ".txt");
		NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
		
		if(nFile.exists())
		{
			String fName = firstName + ".txt";
			Scanner readPlayer = new Scanner(nFile);
			p= new Player(readPlayer.nextLine(), readPlayer.nextLine(), readPlayer.nextDouble(), readPlayer.nextInt(), readPlayer.nextInt() );
			System.out.println("Welcome back " + firstName + "!");
			nFile.delete();
		}
		else
		{
			System.out.println("What is your last name?");
			String lastName = inScan.next();
			System.out.println("How much money is on you?");
			double money = inScan.nextDouble();
			p= new Player(firstName, lastName, money);
		}
		System.out.println("Here's your current info: " + p.toString());
		System.out.println("Would you like to play a game?");
		String ans = inScan.next();
		if(p.getMoney()==0)
		{
			System.out.print("Too bad so sad! You have no money.");
			ans="n";
		}
		while(ans.equalsIgnoreCase("y") || ans.equalsIgnoreCase("yes"))
		{
			System.out.println("Will you choose under, over, or seven?");
			String choice = inScan.next();
			while(!(choice.equalsIgnoreCase("under") || choice.equalsIgnoreCase("over") || choice.equalsIgnoreCase("seven") || choice.equals("7")))
			{
				System.out.println("That is not valid, try again");
				choice = inScan.nextLine();
			}
			System.out.println("How much are you willing to bet?(Be reasonable, you only have so much)");
			double bet = inScan.nextDouble();
			while(bet>p.getMoney() || bet<0)
			{
				System.out.println("That is not valid, try again");
				bet = inScan.nextDouble();
			}
			if(bet==0)
			{
				break;
			}
			int diceRoll = d1.rollDie() + d2.rollDie();
			System.out.println("And the dice roll is..." + diceRoll);
			if(choice.equalsIgnoreCase("Over") && diceRoll > 7)
			{
				p.setMoney(p.getMoney()+bet);
				System.out.println("Congrats! You won " + formatter.format(bet));
				p.setRoundsPlayed(p.getRoundsPlayed()+1);
				p.setTimesWon(p.getTimesWon()+1);
			}
			else if((choice.equalsIgnoreCase("Seven") || choice.equals("7")) && diceRoll == 7)
			{
				p.setMoney(p.getMoney()+(4*bet));
				System.out.println("Congrats! You won " + formatter.format(bet));
				p.setRoundsPlayed(p.getRoundsPlayed()+1);
				p.setTimesWon(p.getTimesWon()+1);
			}
			else if(choice.equalsIgnoreCase("Under") && diceRoll < 7)
			{
				p.setMoney(p.getMoney()+bet);
				System.out.println("Congrats! You won " + formatter.format(bet));
				p.setRoundsPlayed(p.getRoundsPlayed()+1);
				p.setTimesWon(p.getTimesWon()+1);
			}
			else
			{
				p.setMoney(p.getMoney() - bet);
				System.out.println("Sorry! You just lost " + formatter.format(bet));
				p.setRoundsPlayed(p.getRoundsPlayed()+1);
			}
			System.out.println("Would you like to play a game?");
			ans = inScan.next();
			if(p.getMoney()==0)
			{
				System.out.print("Too bad so sad! You have no money.");
				ans="n";
			}
			
		}
		System.out.println("Thanks for coming! Here is your updated info: " + p.toString());
		save(p);
		
		
		
		
	}
	
	public static void save(Player p) throws IOException
	{
		String fName = p.getFirstName();
		fName+= ".txt"; 
		PrintWriter fileOut = new PrintWriter(fName);
		fileOut.println(p.getLastName());
		fileOut.println(p.getFirstName());
		fileOut.println(p.getMoney());
		fileOut.println(p.getRoundsPlayed());
		fileOut.println(p.getTimesWon());
		fileOut.close();
	}

}
