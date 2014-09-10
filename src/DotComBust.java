import java.awt.Checkbox;
import java.util.*;
public class DotComBust
{
     private GameHelper helper = new GameHelper();
     private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
     private int numOfGuesses = 0;
     
     private void setUpGame()
     {
          DotCom one = new DotCom();
          one.setName("Pets.com");
          DotCom two = new DotCom();
          two.setName("sToys.com");
          DotCom three = new DotCom();
          three.setName("Go2.com");
          dotComsList.add(one);
          dotComsList.add(two);
          dotComsList.add(three);
          
          System.out.println("你的目标是击沉这三个字母串。");
          
          for (DotCom dotComToSet : dotComsList)
        	  { ArrayList<String> newLocation = helper.placeDotCom(3);
        	  	
        	  dotComToSet.setLocationCells(newLocation);
        	  }//end loop
     }//end setUpGame method

     private void startPlaying()
	{
		while (!dotComsList.isEmpty())
		{
			String userGuess = helper.getUserInput("Enter a guess");
			checkUserGuess(userGuess);
			
		}
		finishGame();
	}//end startPlaying method
     
     private void checkUserGuess(String userGuess)
	{
		numOfGuesses++;
		String result = "miss";
		
		for (DotCom dotComToTest : dotComsList)
		{
			result = dotComToTest.checkYourself(userGuess);
			if(result.equals("hit"))
			{
				break;
			}
			if (result.equals("kill"))
			{
				dotComsList.remove(dotComToTest);
				break;
			}
		}//end for loop
		System.out.println(result);
	}//end check method
     
     private void finishGame()
	{
		System.out.println("所以目标被击沉。");
		if (numOfGuesses <= 18)
		{
			System.out.println("你只花费了："+ numOfGuesses);
			
		}
		else {
			System.out.println("你太水了！");
		}
	}//end finishGame method
     
     public static void main(String[] args)
	{
		DotComBust game  = new DotComBust();
		game.setUpGame();
		game.startPlaying();
	}
     
}

