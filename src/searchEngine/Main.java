// Main Class for SimpleSearchEngine project
package searchEngine;

import java.util.List;
import java.util.Scanner;

public class Main {

    // Prompt user to search for an element in a directory
    public static void searchForElementsInDirectory(String[] directory) {

        Scanner sc = new Scanner(System.in);
        SearchAlgorithms<String> search = new SearchAlgorithms<>();

        System.out.println("Enter the number of search queries: ");
        int numberOfQueries = sc.nextInt();

        for (int query = 1; query <= numberOfQueries; query++) {

            System.out.println("Search Query #" + query);
            System.out.print("Enter search item: ");
            String item = sc.next();

            // Perform linear search for a particular item in directory
            List<Integer> indexList = search.linearSearchStrings(directory, item);

            // Print elements extracted from search, if any
            System.out.println();
            String itemFound;
            if (indexList.size() != 0) {
                search.displaySearchIndicesResults(indexList, item); // Display indices
                System.out.println();
                System.out.println("Found the following item(s) from search: ");
                for (Integer integer : indexList) {
                    itemFound = directory[integer];
                    System.out.println(itemFound);
                }

            }
            else {
                System.out.println(item + " is not in list");
            }
            System.out.println();
            System.out.println();
        }

    }

    // Create menu of options for search
    public static void searchEngineMenu() {

        Scanner sc = new Scanner(System.in);
        System.out.println("=== Search Engine Menu ===");
        System.out.println("1. Create Directory - Manually");
        System.out.println("2. Create Directory - From File");
        System.out.println("3. Search for Item in List Created Manually");
        System.out.println("4. Search for Item in List Created From File");
        System.out.println("5. Exit");
        System.out.println();

        System.out.print("Enter a choice (1 - 5): ");
        int choice = sc.nextInt();

        ExtractData extractData = new ExtractData();
        if (choice == 1) {
            System.out.println("User creates directory manually...");
            String[] directory = extractData.createDirectoryFromUserInput();
            extractData.displayItems(directory);
        }
        else if (choice == 2) {
            System.out.print("Enter name of file: ");
            String fileName = sc.next();
            String[] directory = extractData.createDirectoryFromFile(fileName);
            extractData.displayItems(directory);
        }
        else if (choice == 3) {
            String[] directory = extractData.createDirectoryFromUserInput();
            searchForElementsInDirectory(directory);
        }
        else if (choice == 4) {
            System.out.println();
            System.out.print("Enter name of file: ");
            String fileName = sc.next();
            String[] directory = extractData.createDirectoryFromFile(fileName);
            System.out.println();
            searchForElementsInDirectory(directory);
        }
        else if (choice == 5) {
            System.exit(0);
        }

    }


    public static void main(String[] args) {

        // Set Up search engine menu
        searchEngineMenu();

    }



}
