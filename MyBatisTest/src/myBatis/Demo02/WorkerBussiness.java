package myBatis.Demo02;

/*
 * 事务扩展类，继承自Worker类
 * 作用：1.继承（使用）Worker类的属性 2.将WorkCard的代码在该业务扩展类中粘贴一遍
 *	
 */
public class WorkerBussiness extends Worker{
	private int cardid ;
	private String cardinfo ;
	
	public WorkerBussiness() {
		super();
	}
	public WorkerBussiness(int cardid, String cardinfo) {
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
	@Override
	public String toString() {
		return ("员工id:"+super.getWorkerid()+", 员工姓名:"+super.getWorkername()
				+", 卡号："+this.cardid+", 卡信息:"+this.cardinfo);
	}
	
	

}
