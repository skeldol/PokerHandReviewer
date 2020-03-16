package application;

import com.pokersimples.bo.Card;
import com.pokersimples.bo.Player;

import javafx.beans.property.SimpleStringProperty;

public class UIPlayer {
	  private SimpleStringProperty name = new SimpleStringProperty();
	  private SimpleStringProperty currentChipCount = new SimpleStringProperty();
	  private SimpleStringProperty action = new SimpleStringProperty();
	  private SimpleStringProperty holeCard1 = new SimpleStringProperty();
	  private SimpleStringProperty holeCard1Colour = new SimpleStringProperty();
	  private SimpleStringProperty holeCard2 = new SimpleStringProperty();
	  private SimpleStringProperty holeCard2Colour = new SimpleStringProperty();
	  
	public SimpleStringProperty  nameProperty() { return name;}
	public SimpleStringProperty  currentChipCountProperty() { return currentChipCount;}
	public SimpleStringProperty  actionProperty() { return action;}
	public SimpleStringProperty  holeCard1Property() { return holeCard1;}
	public SimpleStringProperty  holeCard1ColourProperty() { return holeCard1Colour;}
	public SimpleStringProperty  holeCard2Property() { return holeCard2;}
	public SimpleStringProperty  holeCard2ColourProperty() { return holeCard2Colour ;}
	 
	private String getCardColour(Card pCard) {
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

	}
	
	public UIPlayer() {}
	
	public UIPlayer(Player pPlayer) {
		setName(pPlayer.getPlayerName());
		setCurrentChipCount(pPlayer.getStartingChips().toString());
		setHoleCard1(pPlayer.getHoleCard1().toString());
		setHoleCard1Colour(getCardColour(pPlayer.getHoleCard1()));
		setHoleCard2(pPlayer.getHoleCard2().toString());
		setHoleCard2Colour(getCardColour(pPlayer.getHoleCard2()));
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
}
