package com.ui.dataproviders;

import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.User;
import com.ui.utility.CSVReaderUtility;
import com.ui.utility.ExcelReaderUtility;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginDataProvider {

    @DataProvider(name="LoginTestDataProvider")
    public Iterator<Object[]> loginDataProvider() throws FileNotFoundException {
        Gson gson=new Gson();
        File jsonFile = new File(System.getProperty("user.dir") + "/testData/loginData.json");
        FileReader fileReader=new FileReader(jsonFile);
        TestData data =gson.fromJson(fileReader, TestData.class);

        List<Object[]> dataToReturn = new ArrayList<Object[]>();
        for(User user:data.getData()){
            dataToReturn.add(new Object[] {user});
        }

        return dataToReturn.iterator();

    }

    @DataProvider(name="LoginCSVTestDataProvider")
    public Iterator<User> loginCSVDataProvider(){
        return CSVReaderUtility.readCSVFile("loginData.csv");

    }

    @DataProvider(name="LoginExcelTestDataProvider")
    public Iterator<User> loginExcelDataProvider(){
        return ExcelReaderUtility.readExcelFile("loginData.xlsx");

    }
}
