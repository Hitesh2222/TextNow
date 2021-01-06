package data;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NewExcelData {
    private Workbook workbook;

    public NewExcelData() throws IOException {
        Path path = Paths.get("");// Please provide file location
        InputStream inputStream = new FileInputStream(path.toFile());
        workbook = new XSSFWorkbook(inputStream);
    }
    public List<Object[]> getDataFromSheet(String sheetName){
        Sheet sheet = workbook.getSheet(sheetName);
        Iterator<Row> rowIterator = sheet.rowIterator();
        rowIterator.next();

        List<Object[]> data = new ArrayList<>();
        while (rowIterator.hasNext()){
            Row row = rowIterator.next();
            List<Object> cellData = new ArrayList<>();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()){
                Cell cell = cellIterator.next();
                if (cell.getCellTypeEnum() == CellType.NUMERIC){
                    cellData.add(cell.getNumericCellValue());
                }
                if (cell.getCellTypeEnum() == CellType.STRING){
                    cellData.add(cell.getStringCellValue());
//                    cellIterator.next();
                }
            }
            data.add(cellData.toArray());
        }
        return data;
    }
    @DataProvider
    public Iterator<Object[]> dateProvider1(){
        return getDataFromSheet("TextNow").iterator();
    }
}
