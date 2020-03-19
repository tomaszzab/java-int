package no.fara.recruitment.tickets;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UtilityService {

    /**
     * Filters out values for which more that half of the characters are digits.
     * Result is returned sorted in alphabetical order
     * Example: For. input [aaa12, asd3456, 12345gdh, gfsd], result should be [aaa12, gfsd]
     * @param input - set of alphanumeric strings
     * @return List of elements for which at least half of the characters are letters. Result is sorted in alphabetical order
     */
    public List<String> filterAndSort(Set<String> input) {
        //TODO
        return null;
    }
}
