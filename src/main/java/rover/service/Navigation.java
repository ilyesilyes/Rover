package rover.service;

import org.springframework.stereotype.Service;

import rover.exceptions.UnAuthorisedMouvemnt;
import rover.models.Rover;

@Service
public class Navigation {

	public void navigate(Rover rover) throws UnAuthorisedMouvemnt {
		String[] instructionList = rover.getInstructions().split("");
		
		for (String instruction : instructionList) {
			rover.Move(instruction);
		}
		rover.setInstructions(null);
	}
}
