package myBatis.Demo03;

import java.io.Serializable;

public class Book implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer bid ;
	private String bname ;
	private int price ;
	private int categoryid ;
	
	public Book() {
		
	}
	
	public Book(Integer bid, String bname, int price, int categoryid) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.price = price;
		this.categoryid = categoryid;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	@Override
	public String toString() {
		return ("id:"+this.bid+", 书名:"+this.bname+", 价格:"+this.price+", 类别："+this.categoryid);
	}
	
	
	
	
}
