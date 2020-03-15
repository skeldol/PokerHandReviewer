package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.pokersimples.bo.Hand;
import com.pokersimples.bo.Player;
import com.pokersimples.parser.pokerstars.PokerStarsParser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class PokerHandReviewerController {
	private Hand hand = null;
	
	
	@FXML
	public String getPlayer1Name() {return getPlayerName(1);}
	@FXML
	public String getPlayer1Chips() {return getPlayerChips(1);}
	@FXML
	public String getPlayer1Action() {return getPlayerAction(1);}
	@FXML
	public String getPlayer1HoleCard1() {return getPlayerHoleCard1(1);}	
	@FXML
	public String getPlayer1HoleCard1Colour() {return getPlayerHoleCard1Colour(1);}	
	@FXML
	public String getPlayer1HoleCard2() {return getPlayerHoleCard2(1);}	
	@FXML
	public String getPlayer1HoleCard2Colour() {return getPlayerHoleCard2Colour(1);}	
	
	@FXML
	public String getPlayer2Name() {return getPlayerName(2);}
	@FXML
	public String getPlayer2Chips() {return getPlayerChips(2);}
	@FXML
	public String getPlayer2HoleCard1() {return getPlayerHoleCard1(2);}	
	@FXML
	public String getPlayer2HoleCard1Colour() {return getPlayerHoleCard1Colour(2);}	
	@FXML
	public String getPlayer2HoleCard2() {return getPlayerHoleCard2(2);}		
	@FXML
	public String getPlayer2HoleCard2Colour() {return getPlayerHoleCard2Colour(2);}	
	
	@FXML
	public String getPlayer3Name() {return getPlayerName(3);}
	@FXML
	public String getPlayer3Chips() {return getPlayerChips(3);}
	@FXML
	public String getPlayer3HoleCard1() {return getPlayerHoleCard1(3);}	
	@FXML
	public String getPlayer3HoleCard1Colour() {return getPlayerHoleCard1Colour(3);}	
	@FXML
	public String getPlayer3HoleCard2() {return getPlayerHoleCard2(3);}		
	@FXML
	public String getPlayer3HoleCard2Colour() {return getPlayerHoleCard2Colour(3);}	
	
	@FXML
	public String getPlayer4Name() {return getPlayerName(4);}
	@FXML
	public String getPlayer4Chips() {return getPlayerChips(4);}
	@FXML
	public String getPlayer4HoleCard1() {return getPlayerHoleCard1(4);}	
	@FXML
	public String getPlayer4HoleCard1Colour() {return getPlayerHoleCard1Colour(4);}	
	@FXML
	public String getPlayer4HoleCard2() {return getPlayerHoleCard2(4);}		
	@FXML
	public String getPlayer4HoleCard2Colour() {return getPlayerHoleCard2Colour(4);}	
	
	@FXML
	public String getPlayer5Name() {return getPlayerName(5);}
	@FXML
	public String getPlayer5Chips() {return getPlayerChips(5);}
	@FXML
	public String getPlayer5HoleCard1() {return getPlayerHoleCard1(5);}	
	@FXML
	public String getPlayer5HoleCard1Colour() {return getPlayerHoleCard1Colour(5);}	
	@FXML
	public String getPlayer5HoleCard2() {return getPlayerHoleCard2(5);}		
	@FXML
	public String getPlayer5HoleCard2Colour() {return getPlayerHoleCard2Colour(5);}	
	
	@FXML
	public String getPlayer6Name() {return getPlayerName(6);}
	@FXML
	public String getPlayer6Chips() {return getPlayerChips(6);}
	@FXML
	public String getPlayer6HoleCard1() {return getPlayerHoleCard1(6);}	
	@FXML
	public String getPlayer6HoleCard1Colour() {return getPlayerHoleCard1Colour(6);}	
	@FXML
	public String getPlayer6HoleCard2() {return getPlayerHoleCard2(6);}		
	@FXML
	public String getPlayer6HoleCard2Colour() {return getPlayerHoleCard2Colour(6);}	
	
	public PokerHandReviewerController() {
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
		
		
	}


	
	
	public void next(ActionEvent event) {
		
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
			return hand.getPlayer(pSeatNumber).getStartingChips().toString();
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
