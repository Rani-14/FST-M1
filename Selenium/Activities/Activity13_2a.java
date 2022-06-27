package activities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Activity13_2a {

    XSSFWorkbook workbook;
    XSSFSheet sheet;


    public void writeExcel(String path) {
        List<String[]> data = new ArrayList<String[]>();
        String[] heading = {"ID", "First Name", "Last Name", "Email", "Ph.No."};
        String[] row1 = {"1", "Satvik", "Shah", "satshah@example.com", "4537829158"};
        String[] row2 = {"2", "Avinash", "Kati", "avinashK@example.com", "4892184058"};
        String[] row3 = {"3", "Lahri", "Rath", "lahri.rath@example.com", "4528727830"};

        data.add(heading);
        data.add(row1);
        data.add(row2);
        data.add(row3);
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Sheet1");

        //Iterate over data and write to sheet
        int rownum = 0;
        for (String[] rowData : data) {
            //Creates a new row in the sheet
            Row row = sheet.createRow(rownum++);
            int cellno = 0;

            for (String cellData : rowData) {
                //Creates a cell in the next column of that row
                Cell cell = row.createCell(cellno++);
                cell.setCellValue(cellData);
            }
        }
        try {
            FileOutputStream fw = new FileOutputStream(path);
            workbook.write(fw);
            fw.close();
            workbook.close();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }

    }

    public void readExcel(String path) {
        try {
            FileInputStream fi = new FileInputStream(path);
            workbook = new XSSFWorkbook(path);
            //get the sheet1
            sheet = workbook.getSheetAt(0);

            Iterator<Row> iterator = sheet.iterator();
            while (iterator.hasNext()) {
                Row row = iterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    //Check the cell type and format accordingly
                    switch (cell.getCellType()) {
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + " \t ");
                            break;
                        case STRING:
                            System.out.print(cell.getStringCellValue() + " \t ");
                            break;
                        default:
                            System.out.println("Invalid value");
                            break;
                    }
                }
                System.out.println();


            }
            fi.close();
            workbook.close();
        } catch (IOException e) {
            System.out.println("File is not found : " + e.getMessage());

        }

    }

    public static void main(String[] args) {

        //Prepare the path of excel file
        String filePath = "src/resources/sample13_2a.xlsx";

        //Create an object of current class
        Activity13_2a obj = new Activity13_2a();

        //Write the file using file name
        obj.writeExcel(filePath);
        //read file method of the class to read data
        obj.readExcel(filePath);

    }
}
