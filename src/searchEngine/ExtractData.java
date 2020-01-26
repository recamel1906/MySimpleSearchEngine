// Class used to extract data from a file
package searchEngine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExtractData {

    // Display items in directory
    public void displayItems(String[] array) {

        System.out.println("Directory contains: ");
        for (String s : array) {
            System.out.println(s);
        }
    }

    // Return a list of String values
    public List<String> createListFromUserInput() {

        Scanner sc = new Scanner(System.in);
        List<String> lines = new ArrayList<>();

        while (sc.hasNext()) {
            lines.add(sc.next());
        }
        return lines;
    }

    // Convert list to String[]
    public static String[] convertListToArray(List<String> list) {

        String[] array = new String[list.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    // Store data from file as String
    public String readFileAsString(String fileName) {

        try {
            return new String(Files.readAllBytes(Paths.get(fileName)));
        }
        catch (IOException e) {
            System.out.println("Cannot read file: " + e.getMessage());
        }
        return ""; // keep compiler happy
    }

    // Extract String data from file and return as List
    public List<String> extractStringDataFromFile(File file) throws FileNotFoundException {

        Scanner sc = new Scanner(file);
        List<String> data = new ArrayList<>();

        while (sc.hasNextLine()) {
            data.add(sc.nextLine());
        }

        return data;
    }

    // Create directory of items from data in a file
    public String[] createDirectoryFromFile(String fileName)
    {

        // Extract data from text file
        File file = new File(fileName);

        List<String> dataList = new ArrayList<>();
        try {
            dataList = extractStringDataFromFile(file);
        }
        catch (FileNotFoundException e) {
            System.out.println(file + " not found.");
        }
        return convertListToArray(dataList); // Convert List to array
    }

    // Create directory of items from manual user input
    public String[] createDirectoryFromUserInput() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of items for data set: ");
        int numberOfItems = sc.nextInt();

        List<String> list = new ArrayList<>();
        System.out.println("Enter all people and information: ");
        String item;
        for (int i = 0; i < numberOfItems; i++) {
            item = sc.next();
            list.add(item);
        }
        return convertListToArray(list); // convert List to array
    }

}
