package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.pokersimples.bo.Hand;
import com.pokersimples.bo.Player;
import com.pokersimples.parser.pokerstars.PokerStarsParser;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class PokerHandReviewerController implements Initializable {
	private Hand hand = null;
	
	private int actionNumber = 0;
	
	private UIPlayer player2;
	
	public String getPlayer1Name() {return getPlayerName(1);}
	
	public String getPlayer1Chips() {return getPlayerChips(1);}
	
	public String getPlayer1Action() {return getPlayerAction(1);}
	
	public String getPlayer1HoleCard1() {return getPlayerHoleCard1(1);}	
	
	public String getPlayer1HoleCard1Colour() {return getPlayerHoleCard1Colour(1);}	
	
	public String getPlayer1HoleCard2() {return getPlayerHoleCard2(1);}	
	
	public String getPlayer1HoleCard2Colour() {return getPlayerHoleCard2Colour(1);}	
	
	
  
	
	
	public UIPlayer getPlayer2() {
		return player2;
	}
	
	
	
	
	
	
	
	
	public String getPlayer3Name() {return getPlayerName(3);}
	
	public String getPlayer3Chips() {return getPlayerChips(3);}
	
	public String getPlayer3HoleCard1() {return getPlayerHoleCard1(3);}	
	
	public String getPlayer3HoleCard1Colour() {return getPlayerHoleCard1Colour(3);}	
	
	public String getPlayer3HoleCard2() {return getPlayerHoleCard2(3);}		
	
	public String getPlayer3HoleCard2Colour() {return getPlayerHoleCard2Colour(3);}	
	
	
	public String getPlayer4Name() {return getPlayerName(4);}
	
	public String getPlayer4Chips() {return getPlayerChips(4);}
	
	public String getPlayer4HoleCard1() {return getPlayerHoleCard1(4);}	
	
	public String getPlayer4HoleCard1Colour() {return getPlayerHoleCard1Colour(4);}	
	
	public String getPlayer4HoleCard2() {return getPlayerHoleCard2(4);}		
	
	public String getPlayer4HoleCard2Colour() {return getPlayerHoleCard2Colour(4);}	
	
	
	public String getPlayer5Name() {return getPlayerName(5);}
	
	public String getPlayer5Chips() {return getPlayerChips(5);}
	
	public String getPlayer5HoleCard1() {return getPlayerHoleCard1(5);}	
	
	public String getPlayer5HoleCard1Colour() {return getPlayerHoleCard1Colour(5);}	
	
	public String getPlayer5HoleCard2() {return getPlayerHoleCard2(5);}		
	
	public String getPlayer5HoleCard2Colour() {return getPlayerHoleCard2Colour(5);}	
	
	
	public String getPlayer6Name() {return getPlayerName(6);}
	
	public String getPlayer6Chips() {return getPlayerChips(6);}
	
	public String getPlayer6HoleCard1() {return getPlayerHoleCard1(6);}	
	
	public String getPlayer6HoleCard1Colour() {return getPlayerHoleCard1Colour(6);}	

    

	private final StringProperty player6HoleCard2Property = new SimpleStringProperty(Integer.toString(actionNumber));
	
    public StringProperty player6HoleCard2Property()
    {
        return player6HoleCard2Property;
    }
	
	public String getPlayer6HoleCard2() {return player6HoleCard2Property.get();}		
	
	public String getPlayer6HoleCard2Colour() {return getPlayerHoleCard2Colour(6);}	
	
    public void setPlayer6HoleCard2(String textValue)
    {
        this.player6HoleCard2Property.set(textValue);
    }
    
   

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
		System.out.println(System.getProperty("user.dir"));
		File file = new File("C:\\Users\\Leon\\eclipse-workspace\\Poker\\PokerHandParser\\src\\SinglePokerHand.txt"); 
	  
		List<Hand> games = new ArrayList<Hand>();
		

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file)); 
			
			PokerStarsParser parser = new PokerStarsParser();
			String st; 
			
			while ((st = br.readLine()) != null) 
				hand = parser.parse(st); 
				
				if(hand != null) {
					games.add(hand);
				}
			
		
		} catch(Exception e1) {
			e1.printStackTrace();
		} finally {
			try { br.close();}
			catch(Exception e1) {e1.printStackTrace();}
		}
		
		player2 = new UIPlayer(hand.getPlayer(2));
    }

	
	
	public void next(ActionEvent event) {
		actionNumber++;
		setPlayer6HoleCard2(Integer.toString(actionNumber));
		System.out.println(actionNumber);
	}
	
	public void previous(ActionEvent event) {
		
	}
	
	
	private String getPlayerName(int pSeatNumber) {
		if(hand != null && hand.getPlayer(pSeatNumber) != null) {
			return hand.getPlayer(pSeatNumber).getPlayerName();
		} else {
			return "Empty Seat";
		}
	}
	public String getPlayerChips(int pSeatNumber) {
		if(hand != null && hand.getPlayer(pSeatNumber) != null) {
			return hand.getPlayer(pSeatNumber).getChipCountAt(actionNumber).toString();
		} else {
			return null;
		}
	}
	public String getPlayerHoleCard1(int pSeatNumber) {
		if(hand != null && hand.getPlayer(pSeatNumber) != null && hand.getPlayer(pSeatNumber).getHoleCard1() != null) {
			return hand.getPlayer(pSeatNumber).getHoleCard1().toString();
		} else {
			return "?";
		}
	}	
	public String getPlayerHoleCard2(int pSeatNumber) {
		if(getPlayer(pSeatNumber) != null && hand.getPlayer(pSeatNumber).getHoleCard2() != null) {
			return hand.getPlayer(pSeatNumber).getHoleCard2().toString();
		} else {
			return "?";
		}
	}	
	
	
	
	 Player getPlayer(int pSeatNumber) {
		if(hand != null && hand.getPlayer(pSeatNumber) != null) {
			return hand.getPlayer(pSeatNumber);
		} else {
			return null;
		}
	}
	
	private String getPlayerAction(int pSeatNumber) {
		if(getPlayer(pSeatNumber) != null) {
			
		}
		return null;
	}
	 
	public String getPlayerHoleCard1Colour(int pSeatNumber) {
		if(hand != null && hand.getPlayer(pSeatNumber) != null && hand.getPlayer(pSeatNumber).getHoleCard1() != null) {
			switch(hand.getPlayer(pSeatNumber).getHoleCard1().suit) {
				case Clubs:
					return "-fx-background-color:green";
				case Hearts:
					return "-fx-background-color:red";
				case Diamonds:
					return "-fx-background-color:aqua";				
				case Spades:
					return "-fx-background-color:lightgray";
				default:
					return "-fx-background-color:white";
			}
		} else {
			return "-fx-background-color:white";
		}
	}	
	public String getPlayerHoleCard2Colour(int pSeatNumber) {
		if(hand != null && hand.getPlayer(pSeatNumber) != null && hand.getPlayer(pSeatNumber).getHoleCard2() != null) {
			switch(hand.getPlayer(pSeatNumber).getHoleCard2().suit) {
				case Clubs:
					return "-fx-background-color:green";
				case Hearts:
					return "-fx-background-color:red";
				case Diamonds:
					return "-fx-background-color:aqua";				
				case Spades:
					return "-fx-background-color:lightgray";
				default:
					return "-fx-background-color:white";
			}
		} else {
			return "-fx-background-color:white";
		}
	}		

}
