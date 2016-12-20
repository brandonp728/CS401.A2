package Programs;
import java.text.*;
import java.util.Locale;
public class Player {
	public String firstName, lastName;
	public double money;
	public int roundsPlayed, timesWon;
	NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
	public Player()
	{
		firstName="";
		lastName="";
		money=0;
		roundsPlayed=0;
		timesWon=0;
	}
	
	public Player(String fn, String ln, double m)
	{
		firstName=fn;
		lastName=ln;
		money=m;
		roundsPlayed=0;
		timesWon=0;
	}
	
	public Player(String ln, String fn, double m, int rP, int tW)
	{
		firstName=fn;
		lastName=ln;
		money=m;
		roundsPlayed=rP;
		timesWon=tW;
	}
	
	public void setFirstName(String fn)
	{
		firstName=fn;
	}
	
	public void setLastName(String ln)
	{
		lastName=ln;
	}
	
	public void setMoney(double m)
	{
		money=m;
	}
	
	public void setRoundsPlayed(int rP)
	{
		roundsPlayed=rP;
	}
	
	public void setTimesWon(int tW)
	{
		timesWon=tW;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public double getMoney()
	{
		return money;
	}
	
	public int getRoundsPlayed()
	{
		return roundsPlayed;
	}
	
	public int getTimesWon()
	{
		return timesWon;
	}
	
	
	public void subtractMoney(int m)
	{
		if(money==0)
		{
			money=0;
		}
		else{
			money-=m;
		}
	}
	
	public void addMoney(int m)
	{
		money+=m;
	}
	
	public void playedAGame()
	{
		roundsPlayed++;
	}
	
	public void wonAGAme()
	{
		timesWon++;
	}
	
	public String toString()
	{
		String str;
		str="\nName: " + firstName + " " + lastName + "\nMoney on you: " + formatter.format(money)
				+ "\nRounds played: " + roundsPlayed + "\nTimes won: " + timesWon;
		return str;
	}
	
	
	
	
}
