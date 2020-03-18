package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.pokersimples.bo.Action;
import com.pokersimples.bo.DealerAction;
import com.pokersimples.bo.Flop;
import com.pokersimples.bo.Hand;
import com.pokersimples.bo.Player;
import com.pokersimples.bo.PlayerAction;
import com.pokersimples.bo.River;
import com.pokersimples.bo.Turn;
import com.pokersimples.parser.pokerstars.PokerStarsParser;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class PokerHandReviewerController implements Initializable {
	private Hand hand = null;
	
	private int actionSeq = 0;
	
	private UIPlayer  player1;
	private UIPlayer  player2;
	private UIPlayer  player3;
	private UIPlayer  player4;
	private UIPlayer  player5;
	private UIPlayer  player6;

	private UICard	boardCard1 = new UICard();
	private UICard	boardCard2 = new UICard();
	private UICard	boardCard3 = new UICard();
	private UICard	boardCard4 = new UICard();
	private UICard	boardCard5 = new UICard();
	
	public final UIPlayer getPlayer1() { return player1; }
	public final UIPlayer getPlayer2() { return player2; }
	public final UIPlayer getPlayer3() { return player3; }
	public final UIPlayer getPlayer4() { return player4; }
	public final UIPlayer getPlayer5() { return player5; }
	public final UIPlayer getPlayer6() { return player6; }
	
	public final UICard getBoardCard1() { return boardCard1; }
	public final UICard getBoardCard2() { return boardCard2; }
	public final UICard getBoardCard3() { return boardCard3; }
	public final UICard getBoardCard4() { return boardCard4; }
	public final UICard getBoardCard5() { return boardCard5; }
    
    
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

		player1 = new UIPlayer(hand.getPlayer(1));
		player2 = new UIPlayer(hand.getPlayer(2));
		player3 = new UIPlayer(hand.getPlayer(3));
		player4 = new UIPlayer(hand.getPlayer(4));
		player5 = new UIPlayer(hand.getPlayer(5));
		player6 = new UIPlayer(hand.getPlayer(6));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }

	
	
	public void next(ActionEvent event) {
		Action action = hand.getAction(actionSeq++);
		if(action instanceof PlayerAction) {
			PlayerAction playerAction = (PlayerAction) action;
			if(playerAction.getPlayer().getSeatNumber() == getPlayer1().getSeatNumber()) {
				getPlayer1().update(playerAction);
				
			} else if(playerAction.getPlayer().getSeatNumber() == getPlayer2().getSeatNumber()) {
				getPlayer2().update(playerAction);
				
			} else if(playerAction.getPlayer().getSeatNumber() == getPlayer3().getSeatNumber()) {
				getPlayer3().update(playerAction);
				
			} else if(playerAction.getPlayer().getSeatNumber() == getPlayer4().getSeatNumber()) {
				getPlayer4().update(playerAction);
				
			} else if(playerAction.getPlayer().getSeatNumber() == getPlayer5().getSeatNumber()) {
				getPlayer5().update(playerAction);
				
			} else if(playerAction.getPlayer().getSeatNumber() == getPlayer6().getSeatNumber()) {
				getPlayer6().update(playerAction);
			}
		} else if(action instanceof DealerAction) {
			DealerAction dealerAction = (DealerAction) action;
			if(dealerAction instanceof Flop) {
				boardCard1.setCard(dealerAction.getBoardCard(0).toString());
				boardCard2.setCard(dealerAction.getBoardCard(1).toString());
				boardCard3.setCard(dealerAction.getBoardCard(2).toString());
				
			} else if(dealerAction instanceof Turn) {
				boardCard4.setCard(dealerAction.getBoardCard(0).toString());
				
			} else if(dealerAction instanceof River) {
				boardCard5.setCard(dealerAction.getBoardCard(0).toString());
			}
		}
		
		System.out.println(actionSeq);
	}
	
	public void previous(ActionEvent event) {
		Action action = hand.getAction(--actionSeq);
		if(action instanceof PlayerAction) {
			PlayerAction playerAction = (PlayerAction) action;
			if(playerAction.getPlayer().getSeatNumber() == getPlayer1().getSeatNumber()) {
				getPlayer1().undo();
				
			} else if(playerAction.getPlayer().getSeatNumber() == getPlayer2().getSeatNumber()) {
				getPlayer2().undo();
				
			} else if(playerAction.getPlayer().getSeatNumber() == getPlayer3().getSeatNumber()) {
				getPlayer3().undo();
				
			} else if(playerAction.getPlayer().getSeatNumber() == getPlayer4().getSeatNumber()) {
				getPlayer4().undo();
				
			} else if(playerAction.getPlayer().getSeatNumber() == getPlayer5().getSeatNumber()) {
				getPlayer5().undo();
				
			} else if(playerAction.getPlayer().getSeatNumber() == getPlayer6().getSeatNumber()) {
				getPlayer6().undo();
			}
		} else if(action instanceof DealerAction) {
			DealerAction dealerAction = (DealerAction) action;
			if(dealerAction instanceof Flop) {
				boardCard1.setCard(dealerAction.getBoardCard(0).toString());
				boardCard2.setCard(dealerAction.getBoardCard(1).toString());
				boardCard3.setCard(dealerAction.getBoardCard(2).toString());
				
			} else if(dealerAction instanceof Turn) {
				boardCard4.setCard(dealerAction.getBoardCard(0).toString());
				
			} else if(dealerAction instanceof River) {
				boardCard5.setCard(dealerAction.getBoardCard(0).toString());
			}
		}
		
		System.out.println(actionSeq);
	}
	
	

}
