package me.justindevb.anticheatreplay;


public enum AntiCheat {
	
	VULCAN("Vulcan"), SPARTAN("Spartan"), MATRIX("Matrix"), GODSEYE("GodsEye"), KAURI("Kauri"), KARHU("Karhu"),
	THEMIS("Themis"), SOAROMA("Soaroma"), FLAPPY("FlappyAC"), NONE("None");
	public final String name;

	private AntiCheat(String name) {
		this.name = name;
	}

}
