package rover.models;

public enum Orientation {
	N("North"),
	S("Sud"),
	E("Est"),
	W("West");
	
	private String value;
	Orientation(String value) {
		  this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
