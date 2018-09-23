package src;

public class Frame {
	private char name;
	private boolean isFrozen = false;
	private int allockTime = -1;
	private int referTime = -1;
	
	public int getReferTime() {
		return referTime;
	}

	public void setReferTime(int referTime) {
		this.referTime = referTime;
	}

	public Frame(char name) {
		this.name = name;
	}
	
	public char getName() {
		return name;
	}


	public void setName(char name) {
		this.name = name;
	}


	public boolean isFrozen() {
		return isFrozen;
	}


	public void setFrozen(boolean isFrozen) {
		this.isFrozen = isFrozen;
	}


	public int getAllockTime() {
		return allockTime;
	}


	public void setAllockTime(int allockTime) {
		this.allockTime = allockTime;
	}


	
	
	
	
	
}
