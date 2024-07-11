package pro.vasudevan.testdataframework.util;

import java.io.*;
import java.lang.reflect.Method;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.DataProvider;
import pro.vasudevan.testdataframework.interfaces.TestData;

/*
Created By: Vasudevan Sampath

CSVTestDataProvider.java is a utility class for supporting CSV test data.
It assumes that the test suite test data files are located under src/test/resources/testData folder
Syntax on calling:
In any of the suite test methods (if test data support is needed),
@Test(dataProvider = "TestDataProvider", dataProviderClass = CSVTestDataProvider.class)
@TestData(file="your test data file.csv",  rowDataDelimiter = ";", firstRowColumnNames = false)
rowDataDelimiter is optional and if not set, defaults to ","
firstRowColumnNames is optional and defaults to true.
This framework supports test data with and without column names in the first row of the CSV.
If column names are not provided, the Map keys are set to 0...n
Note that the test data framework assumes the column delimiter as ","
 */
public class CSVTestDataProvider {

    @DataProvider(name = "TestDataProvider")
    public static Iterator<Object[]> getTestData(Method method) throws Exception {
        List<Map<Object, Object>> listOfMap = new ArrayList<>();
        Map<Object, Object> map;

        String testDataFile = method.getAnnotation(TestData.class).file();
        String rowDelimiter = method.getAnnotation(TestData.class).rowDataDelimiter();
        boolean firstRowColumnNames = method.getAnnotation(TestData.class).firstRowColumnNames();
        String[] columnNames = null;
        String filename = FileUtils.getFile("src", "test", "resources", "testData", testDataFile).getAbsolutePath();

        try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
            if (firstRowColumnNames) columnNames = in.readLine().split(",");

            String line;
            while ((line = in.readLine()) != null) {
                String[] eachRow = line.split(rowDelimiter);
                map = new HashMap<>();
                for (int i = 0; i < eachRow.length; i++) {
                    var result = firstRowColumnNames ? map.put(columnNames[i].trim(), eachRow[i].trim()) : map.put(i, eachRow[i].trim());
                }
                listOfMap.add(map);
            }
        }
        List<Object[]> dataProvider = new ArrayList<>();
        for (Map<Object, Object> finalMap: listOfMap){
            dataProvider.add(new Object[] {finalMap} );
        }
        return dataProvider.iterator();
    }
}
