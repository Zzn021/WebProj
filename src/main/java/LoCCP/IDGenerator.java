package LoCCP;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class IDGenerator {
    private Set<String> idSet = new HashSet<>();

    /**
     * Generate a random and unique UUID.
     * @return ID
     */
    public String newID() {
        String newIDString = UUID.randomUUID().toString();
        while (idSet.contains(newIDString)) {
            newIDString = UUID.randomUUID().toString();
        }
        idSet.add(newIDString);
        return newIDString;
    }
}
