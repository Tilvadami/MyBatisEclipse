package myBatis.Demo02;

import java.util.List;

public class Depart {
	private int did ;
	private String dname;
	
	
	//持有worker类集合的引用
	private List<Worker> workers ;
	
	public Depart() {
		super();
	}
	
	public Depart(int did, String dname) {
		super();
		this.did = did;
		this.dname = dname;
	}
	
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}

	public List<Worker> getWorkers() {
		return workers;
	}

	public void setWorkers(List<Worker> workers) {
		this.workers = workers;
	}

	@Override
	public String toString() {
		return("部门号:"+this.did+", 部门名:"+this.dname);
	}
	
	
	
}
