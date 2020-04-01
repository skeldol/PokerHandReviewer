package application;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.pokersimples.bo.Card;
import com.pokersimples.bo.Fold;
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
	private UICard holeCard1;
	private UICard holeCard2;
	
	public UICard getHoleCard1() { return holeCard1; }
	public UICard getHoleCard2() { return holeCard2; }

	
	private final StringProperty name = new SimpleStringProperty("Empty");
	private final StringProperty currentChipCount = new SimpleStringProperty("chips");
    private final StringProperty action = new SimpleStringProperty("action");

	  
	public StringProperty  nameProperty() { return name;}
	public StringProperty  currentChipCountProperty() { return currentChipCount;}
	public StringProperty  actionProperty() { return action;}

	 
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
			holeCard1 = new UICard(pPlayer.getHoleCard1());
			holeCard2 = new UICard(pPlayer.getHoleCard2());
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

	
	
	public void update(PlayerAction action) {
		setCurrentChipCount(action.getChipCount().toString());
		setAction(action.getActionName());
		if(action instanceof Fold) {
			getHoleCard1().setVisible("false");
			getHoleCard2().setVisible("false");	
		} else {
			getHoleCard1().setVisible("true");
			getHoleCard2().setVisible("true");	
		}
		playedAction = action;
	}
	
	// Rollback the previous action
	public void undo() {
		if(playedAction != null && playedAction.lastPlayerAction() != null) {
			update(playedAction.lastPlayerAction()) ;			
		} else  {
			setCurrentChipCount(playedAction.getPlayer().getStartingChips().toString());
			setAction("Initial");
			getHoleCard1().setVisible("true");
			getHoleCard2().setVisible("true");	
		}
	}
}
