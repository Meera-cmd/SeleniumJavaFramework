package com.ui.utility;

import com.ui.pojo.User;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReaderUtility {

    public static Iterator<User> readExcelFile(String fileName) {

        File xlsxfile = new File(System.getProperty("user.dir") + "/testData/"+fileName);
        ///XLS file
        XSSFWorkbook xssfWorkbook= null;
        List<User> userList=null;
        User user;
        Row row;
        Cell emailAddressCell,passwordCell;
        XSSFSheet xssfSheet;
        try {
            xssfWorkbook = new XSSFWorkbook(xlsxfile);
            userList= new ArrayList<User>();
            xssfSheet=xssfWorkbook.getSheet("LoginTestData");
            Iterator<Row> rowIterator=xssfSheet.iterator();
            rowIterator.next(); // to skip the column name

            while (rowIterator.hasNext()){
                row=rowIterator.next();
                emailAddressCell=row.getCell(0);
                passwordCell=row.getCell(1);
                user=new User(emailAddressCell.toString(),passwordCell.toString());
                userList.add(user);
                xssfWorkbook.close();

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

        return userList.iterator();
    }
}
