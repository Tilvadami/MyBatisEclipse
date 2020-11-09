package myBatis.Demo02;

public class Worker {
	private int workerid ;
	private String workername ;
	private int cardid ;
	private WorkCard card ;
	
	public Worker() {
		super();
	}
	
	public Worker(int workerid, String workername) {
		super();
		this.workerid = workerid;
		this.workername = workername;
	}

	public int getWorkerid() {
		return workerid;
	}

	public void setWorkerid(int workerid) {
		this.workerid = workerid;
	}

	public String getWorkername() {
		return workername;
	}

	public void setWorkername(String workername) {
		this.workername = workername;
	}

	public int getCardid() {
		return cardid;
	}

	public void setCardid(int cardid) {
		this.cardid = cardid;
	}

	public WorkCard getCard() {
		return card;
	}

	public void setCard(WorkCard card) {
		this.card = card;
	}

	@Override
	public String toString() {
		return ("员工id:"+this.workerid+", 员工姓名:"+this.workername
		+", 卡号："+this.cardid+", 卡信息:"+this.card.getCardinfo());
	}
	
	
}	
