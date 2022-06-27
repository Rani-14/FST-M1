package activities;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Activity13_1 {

    public static void main(String[] args) throws IOException, CsvException {

        //Load CSV file
        FileReader file = new FileReader("src/resources/Activity13_Data.csv");
        CSVReader reader = new CSVReader(file);

        List data = reader.readAll();
        System.out.println("Number of rows : " + data.size());
        //setup iterator
        Iterator<String[]> iterate = data.iterator();
        System.out.println("Data in the file : ");
        //iterate through all the rows
        while (iterate.hasNext()) {

            String[] row = iterate.next();
            for (String r : row) {
                System.out.print(r.trim() + " ");
            }
            //new line
            System.out.println();

        }
        reader.close();
        file.close();
    }

}
