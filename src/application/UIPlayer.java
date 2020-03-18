package application;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.pokersimples.bo.Card;
import com.pokersimples.bo.Player;
import com.pokersimples.bo.PlayerAction;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;

public class UIPlayer {
	
	private String startingChips;
	
	private int seatNumber;
	public int getSeatNumber() { return seatNumber;}
	public void setSeatNumber(int seatNumber) { this.seatNumber = seatNumber;}

	// The last played action for the player
	private PlayerAction playedAction = null;

	private final StringProperty name = new SimpleStringProperty("Empty");
	private final StringProperty currentChipCount = new SimpleStringProperty("chips");
    private final StringProperty action = new SimpleStringProperty("action");
	private final StringProperty holeCard1 = new SimpleStringProperty();
	private final StringProperty holeCard1Colour = new SimpleStringProperty();
	private final StringProperty holeCard2 = new SimpleStringProperty();
	private final StringProperty holeCard2Colour = new SimpleStringProperty();
	  
	public StringProperty  nameProperty() { return name;}
	public StringProperty  currentChipCountProperty() { return currentChipCount;}
	public StringProperty  actionProperty() { return action;}
	public StringProperty  holeCard1Property() { return holeCard1;}
	public StringProperty  holeCard1ColourProperty() { return holeCard1Colour;}
	public StringProperty  holeCard2Property() { return holeCard2;}
	public StringProperty  holeCard2ColourProperty() { return holeCard2Colour ;}
	 
	private String getCardColour(Card pCard) {
		if(pCard != null) {
			switch(pCard.suit) {
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
	
	
	public UIPlayer(Player pPlayer) {
		if(pPlayer != null) {
			startingChips = pPlayer.getStartingChips().toString();
			setSeatNumber(pPlayer.getSeatNumber());
			setName(pPlayer.getPlayerName());
			setCurrentChipCount(pPlayer.getStartingChips().toString());
			if(pPlayer.getHoleCard1() != null) {
				setHoleCard1(pPlayer.getHoleCard1().toString()); 			
			} else {
				setHoleCard1("?");
			}
			setHoleCard1Colour(getCardColour(pPlayer.getHoleCard1()));
			if(pPlayer.getHoleCard2() != null) {
				setHoleCard2(pPlayer.getHoleCard2().toString()); 			
			} else {
				setHoleCard2("?");
			}
			setHoleCard2Colour(getCardColour(pPlayer.getHoleCard2()));
		}

	}
	
	public String getName() {
		return name.get();
	}
	public void setName(String name) {
		this.name.set(name);
	}
	public String getCurrentChipCount() {
		return currentChipCount.get();
	}
	public void setCurrentChipCount(String currentChipCount) {
		System.out.println("chip count " + currentChipCount);
		this.currentChipCount.set(currentChipCount);
	}
	public String getAction() {
		return action.get();
	}
	public void setAction(String action) {
		this.action.set(action);
	}
	public String getHoleCard1() {
		return holeCard1.get();
	}
	public void setHoleCard1(String holeCard1) {
		this.holeCard1.set(holeCard1);
	}
	public String getHoleCard1Colour() {
		return holeCard1Colour.get();
	}
	public void setHoleCard1Colour(String holeCard1Colour) {
		this.holeCard1Colour.set(holeCard1Colour);
	}
	public String getHoleCard2() {
		return holeCard2.get();
	}
	public void setHoleCard2(String holeCard2) {
		this.holeCard2.set(holeCard2);
	}
	public String getHoleCard2Colour() {
		return holeCard2Colour.get();
	}
	public void setHoleCard2Colour(String holeCard2Colour) {
		this.holeCard2Colour.set(holeCard2Colour);
	}
	
	
	public void update(PlayerAction action) {
		setCurrentChipCount(action.getChipCount().toString());
		setAction(action.getActionName());
		playedAction = action;
	}
	
	// Rollback the previous action
	public void undo() {
		if(playedAction != null && playedAction.lastPlayerAction() != null) {
			update(playedAction.lastPlayerAction()) ;			
		} else  {
			setCurrentChipCount(playedAction.getPlayer().getStartingChips().toString());
			setAction("Initial");
		}
	}
}
