package rover.models;

import rover.exceptions.UnAuthorisedMouvemnt;
import rover.exceptions.UnAuthorisedMouvemntToEast;
import rover.exceptions.UnAuthorisedMouvemntToNorth;
import rover.exceptions.UnAuthorisedMouvemntToSouth;
import rover.exceptions.UnAuthorisedMouvemntToWest;

public class Rover {
	private int x;
	private int y;
	private Orientation orientation;
	private String instructions;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Orientation getOrientation() {
		return orientation;
	}
	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	public void Move(String nextMove) throws UnAuthorisedMouvemnt {
		if (this.orientation == Orientation.N) {
			this.orientation = Mouvement.L.name().equals(nextMove) ? Orientation.W : this.orientation;
			this.orientation = Mouvement.R.name().equals(nextMove) ? Orientation.E : this.orientation;
			if (Mouvement.M.name().equals(nextMove)) {
				if (this.y < Map.MaxY) 
					this.y++;
				else 
					throw new UnAuthorisedMouvemntToNorth();
			} 
			return;
		}
		
		if (this.orientation == Orientation.S) {
			this.orientation = Mouvement.L.name().equals(nextMove) ? Orientation.E : this.orientation;
			this.orientation = Mouvement.R.name().equals(nextMove) ? Orientation.W : this.orientation;
			if (Mouvement.M.name().equals(nextMove)) {
				if (this.y > 0) 
					this.y--;
				else 
					throw new UnAuthorisedMouvemntToSouth();
			} 
			return;
		}
		
		if (this.orientation == Orientation.E) {
			this.orientation = Mouvement.L.name().equals(nextMove) ? Orientation.N : this.orientation;
			this.orientation = Mouvement.R.name().equals(nextMove) ? Orientation.S : this.orientation;
			if (Mouvement.M.name().equals(nextMove)) {
				if (this.x < Map.MaxX)
					this.x++;
				else
					throw new UnAuthorisedMouvemntToEast();
			} 
			return;
		}
		
		if (this.orientation == Orientation.W) {
			this.orientation = Mouvement.L.name().equals(nextMove) ? Orientation.S : this.orientation;
			this.orientation = Mouvement.R.name().equals(nextMove) ? Orientation.N : this.orientation;
			if (Mouvement.M.name().equals(nextMove)) {
				if (this.x > 0)
					this.x--;
				else
					throw new UnAuthorisedMouvemntToWest();
			} 
			return;
		}
	}
	@Override
	public String toString() {
		return this.x + " " + this.y + " " + this.orientation;
	}
	
}


enum Mouvement {
	L("Turn Left"),
	R("Turn Right"),
	M("Move");
	private String value;
	
	Mouvement(String value) {
		  this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
