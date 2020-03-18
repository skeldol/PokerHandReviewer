package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UICard {
	private final StringProperty rank = new SimpleStringProperty("?");
	private final StringProperty suit = new SimpleStringProperty("?");
	private final StringProperty card = new SimpleStringProperty("?");
	private final StringProperty colour = new SimpleStringProperty("?");
	
	public StringProperty  rankProperty() { return rank;}
	public StringProperty  suitProperty() { return suit;}
	public StringProperty  cardProperty() { return card;}
	public StringProperty  colourProperty() { return colour;}
	
	public String getRank() {
		return rank.get();
	}
	public void setRank(String rank) {
		this.rank.set(rank);
	}

	public String getSuit() {
		return suit.get();
	}
	public void setSuit(String suit) {
		this.suit.set(suit);
	}
	
	public String getCard() {
		return card.get();
	}
	public void setCard(String card) {
		this.card.set(card);
	}
	
	public String getColour() {
		return colour.get();
	}
	public void setColour(String colour) {
		this.colour.set(colour);
	}
	
	
}
