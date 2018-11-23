import java.util.*;

public class PhoneList {
	private final List<Phone> allPhones = new ArrayList<>();
	private final Set<Phone> bestPhones = new HashSet<>();
	
	/*
	 * Adds a phone to the list.
	 */
	public void addPhone(Phone phone) {
		allPhones.add(phone);

		Iterator<Phone> iterator = bestPhones.iterator();
		while(iterator.hasNext()) {
			Phone other = iterator.next();
			if(phone.dominates(other)) {
				iterator.remove();
			}
		}
		
		// only add the new phone to bestPhones if it's not dominated
		if(!phoneIsDominated(phone)) {
			bestPhones.add(phone);
		}
	}
	
	/*
	 * Determines whether a phone is dominated by any other phone.
	 */
	public boolean phoneIsDominated(Phone phone) {
		for(Phone other : bestPhones) {
			if(other.dominates(phone)) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * Gets all phones. The list returned is unmodifiable.  
	 */
	public List<Phone> getAllPhones() {
		return Collections.unmodifiableList(allPhones);
	}
	
	/*
	 * Gets all phones which are not dominated by another phone. The
	 * collection returned is unmodifiable.  
	 */
	public Collection<Phone> getBestPhones() {
		return Collections.unmodifiableSet(bestPhones);
	}
}
