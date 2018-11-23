import java.io.IOException;
import java.util.Collection;

public class FindBestPhones {
	public static String PHONES_FILE = "phone-data.txt";
	
	public static void main(String[] args) {
		try {
			Collection<Phone> bestPhones= PhoneParser.parseFile(PHONES_FILE).getBestPhones();
			for(Phone phone:bestPhones) {
				System.out.println("Model: " +phone.getModel() + " Screen:"+phone.getScreenSize()+ " Battery:"+phone.getBatteryCapacity());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.out.println("Screensize or battery capacity cannot be negative");
		}
		
		
	}
}
