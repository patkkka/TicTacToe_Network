package com.javaAcademy.OXGame.model;

public class Direction {

	private boolean isVertical;
	private boolean isHoryzontal;
	private boolean isDescending;
	private boolean isAscensional;

	private Direction(boolean isVertical, boolean isHoryzontal, 
				boolean isDescending,boolean isAscensional) {
		this.isVertical = isVertical;
		this.isHoryzontal = isHoryzontal;
		this.isDescending = isDescending;
		this.isAscensional = isAscensional;
	}
	
	public static Direction vertical(){
		return new Direction(true, false, false, false);
	}
	
	public static Direction horyzontal(){
		return new Direction(false, true, false, false);
	}

	public static Direction descending(){
		return new Direction(false, false, true, false);
	}
	public static Direction ascensional(){
		return new Direction(false, false, false, true);
	}
	
	public boolean isVertical() {
		return isVertical;
	}

	public boolean isHoryzontal() {
		return isHoryzontal;
	}

	public boolean isDescending() {
		return isDescending;
	}

	public boolean isAscensional() {
		return isAscensional;
	}
}
