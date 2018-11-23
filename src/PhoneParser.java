import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PhoneParser {

	/*
	 * Parses a phone data string, in the following format:
	 * 
	 * model screenSize batteryCapacity
	 * 
	 * The model name is encoded with underscores instead of spaces.
	 */
	public static Phone parse(String data) {
		String[] split = data.split(" ");
		Phone newphone = new Phone(split[0].replaceAll("_", " "),
									Double.parseDouble(split[1]),
									Integer.parseInt(split[2]));
		return newphone;
	}

	/*
	 * Returns a PhoneList by parsing a text file containing the phone data.
	 */
	public static PhoneList parseFile(String phonesFile) throws IOException {
		PhoneList phoneList = new PhoneList();
		BufferedReader file = new BufferedReader(new FileReader(phonesFile));
		while (true) {
			String line = file.readLine();
			if (line == null) {
				break;
			} else {
				phoneList.addPhone(parse(line));
			}
		}
		file.close();
		return phoneList;
	}
}
