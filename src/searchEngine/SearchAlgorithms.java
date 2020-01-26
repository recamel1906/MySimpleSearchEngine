// Class containing search algorithms
package searchEngine;

import java.util.ArrayList;
import java.util.List;


public class SearchAlgorithms<T extends Comparable<T>> {

    // Linear search algorithm (Generic Type) - Returns list of indices from search
    public List<Integer> linearSearch(T[] array, T value) {
        List<Integer> searchIndicesList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i].compareTo(value) == 0) {
                searchIndicesList.add(i);
            }
        }
        return searchIndicesList;
    }

    // Linear search algorithm (String Type) - Returns list of indices from search
    public List<Integer> linearSearchStrings(String[] array, String value) {
        List<Integer> searchIndicesList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value) || array[i].contains(value)) {
                searchIndicesList.add(i);
            }
        }
        return searchIndicesList;
    }

    // Displays search indices of an item found in an array of items
    public void displaySearchIndicesResults(List<Integer> searchIndicesList, T searchItem) {

        if (searchIndicesList.size() != 0) {
            System.out.print("Indices Found for " + searchItem + ": ");
            for (Integer value : searchIndicesList) {
                System.out.print(value + " ");
            }
        }
        else {
            System.out.println(searchItem + " is not in list");
        }
    }



}
