package com.pokersimples.handreviewer;

import com.pokersimples.bo.DealerAction;
import com.pokersimples.bo.Flop;
import com.pokersimples.bo.Fold;
import com.pokersimples.bo.PlayerAction;
import com.pokersimples.bo.River;
import com.pokersimples.bo.Turn;

public class UIBoard {
	private UICard	boardCard1 = new UICard();
	private UICard	boardCard2 = new UICard();
	private UICard	boardCard3 = new UICard();
	private UICard	boardCard4 = new UICard();
	private UICard	boardCard5 = new UICard();
	
	public final UICard getBoardCard1() { return boardCard1; }
	public final UICard getBoardCard2() { return boardCard2; }
	public final UICard getBoardCard3() { return boardCard3; }
	public final UICard getBoardCard4() { return boardCard4; }
	public final UICard getBoardCard5() { return boardCard5; }
	
	public void update(DealerAction pDealerAction) {
		if(pDealerAction instanceof Flop) {
			getBoardCard1().setCard(pDealerAction.getBoardCard(0).toString());
			getBoardCard2().setCard(pDealerAction.getBoardCard(1).toString());
			getBoardCard3().setCard(pDealerAction.getBoardCard(2).toString());			
			System.out.println("Set flop " + pDealerAction);
		} else if(pDealerAction instanceof Turn) {
			getBoardCard4().setCard(pDealerAction.getBoardCard(0).toString());
			
		} else if(pDealerAction instanceof River) {
			getBoardCard5().setCard(pDealerAction.getBoardCard(0).toString());
		}
	}
	
	// Rollback the previous action
	public void undo(DealerAction pDealerAction) {
		if(pDealerAction instanceof Flop) {
			boardCard1.setCard("");
			boardCard2.setCard("");
			boardCard3.setCard("");			
			
		} else if(pDealerAction instanceof Turn) {
			boardCard4.setCard("");
			
		} else if(pDealerAction instanceof River) {
			boardCard5.setCard("");
		}
	}
}
