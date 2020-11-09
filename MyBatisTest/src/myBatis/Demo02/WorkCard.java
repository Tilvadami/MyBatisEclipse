package myBatis.Demo02;

public class WorkCard {
	private int cardid ;
	private String cardinfo ;
	
	public WorkCard() {
		super();
	}
	
	public WorkCard(int cardid, String cardinfo) {
		super();
		this.cardid = cardid;
		this.cardinfo = cardinfo;
	}
	
	public int getCardid() {
		return cardid;
	}
	public void setCardid(int cardid) {
		this.cardid = cardid;
	}
	public String getCardinfo() {
		return cardinfo;
	}
	public void setCardinfo(String cardinfo) {
		this.cardinfo = cardinfo;
	}
	
	
}
