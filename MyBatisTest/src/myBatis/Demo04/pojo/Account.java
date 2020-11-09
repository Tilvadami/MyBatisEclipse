package myBatis.Demo04.pojo;

public class Account {
    
    private String accountid;
    private Integer banlace;
    
    public Account() {
	}
    
    public Account(String accountid, Integer banlace) {
		super();
		this.accountid = accountid;
		this.banlace = banlace;
	}

	public String getAccountid() {
        return accountid;
    }

    
    public void setAccountid(String accountid) {
        this.accountid = accountid == null ? null : accountid.trim();
    }

    
    public Integer getBanlace() {
        return banlace;
    }

    public void setBanlace(Integer banlace) {
        this.banlace = banlace;
    }
}