package logic;

public class Frame {
	private char name;
	private boolean isFrozen = false;
	private int allocTime = -1;
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


	public int getAllocTime() {
		return allocTime;
	}


	public void setAllocTime(int allocTime) {
		this.allocTime = allocTime;
	}


	
	
	
	
	
}
