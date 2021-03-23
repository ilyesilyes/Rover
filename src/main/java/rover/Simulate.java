package rover;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import rover.exceptions.JavaArgumentException;
import rover.exceptions.SettingMapDimenssionException;
import rover.exceptions.UnAuthorisedMouvemnt;
import rover.models.Map;
import rover.models.Rover;
import rover.service.FileReader;
import rover.service.Navigation;


public class Simulate {
	
	
	static FileReader reader = new FileReader();
	
	static Navigation navigation = new Navigation();
	
	public void simulate(String filePath) throws FileNotFoundException, SettingMapDimenssionException, UnAuthorisedMouvemnt {
		

	}

	public static void main(String[] args) throws JavaArgumentException, FileNotFoundException, SettingMapDimenssionException, UnAuthorisedMouvemnt {

		if(args.length != 1) {
			throw new JavaArgumentException();}
		List<Rover> rovers = reader.getMarsDiscoveryDetail(args[0]);
		for (Rover rover : rovers) {
			navigation.navigate(rover);
			System.out.println(rover.toString());
		}
	}
}
