package rover.service;

import org.springframework.stereotype.Service;

import rover.exceptions.SettingMapDimenssionException;
import rover.models.Map;
import rover.models.Rover;
import rover.models.Orientation;

import java.io.File;  
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 

@Service
public class FileReader {

	public List<Rover> getMarsDiscoveryDetail(String filePath) throws FileNotFoundException, SettingMapDimenssionException {
		
		try {
		      File file = new File(filePath);
		      Scanner myReader = new Scanner(file);
		      String data;
		      if (myReader.hasNextLine()) {
			        data = myReader.nextLine();
			        setMapDimention(data);
		      }
		      
		      List<Rover> rovers = new ArrayList<Rover>();
		      while (myReader.hasNextLine()) {
		          data = myReader.nextLine();
		          rovers.add(getRover(data));
		          if (myReader.hasNextLine())
		        	  rovers.get(rovers.size()-1).setInstructions(myReader.nextLine());
		      }		     
		      myReader.close();
		      return rovers;
		    } catch (FileNotFoundException e) {
		    	throw new FileNotFoundException();
		    }
	}
	
	private void setMapDimention(String str) throws SettingMapDimenssionException {
		String[] dimensions = str.split(" ");
		try {
			Map.MaxX = Integer.parseInt(dimensions[0]);
			Map.MaxY = Integer.parseInt(dimensions[1]);
		} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
			throw new SettingMapDimenssionException();
		}
	}
	
	private Rover getRover(String str) throws SettingMapDimenssionException {
		String[] roverDetail = str.split(" ");
		Rover rover = new Rover();
		try {
			rover.setX(Integer.parseInt(roverDetail[0]));
			rover.setY(Integer.parseInt(roverDetail[1]));
			for (Orientation c : Orientation.values()) {
		        if (c.name().equals(roverDetail[2])) {
		            rover.setOrientation(c);
		        }
		    }
			return rover;
		} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
			throw new SettingMapDimenssionException();
		}
	}
}
