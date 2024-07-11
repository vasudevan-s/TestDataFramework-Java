This is a utility test data framework supporting CSV files.

It assumes that the test suite test data files are located under src/test/resources/testData folder

Syntax on calling:
In any of the suite test methods (if test data support is needed),

@Test(dataProvider = "TestDataProvider", dataProviderClass = CSVTestDataProvider.class)
@TestData(file="your test data file.csv",  rowDataDelimiter = ";")

rowDataDelimiter is optional and if not set, defaults to ",".

Also, firstRowColumnNames is optional and defaults to true.
@TestData(file="HomePageVerticalLinks.csv", firstRowColumnNames = false)
This framework supports test data with and without column names in the first row of the CSV.
If column names are not provided, the Map keys are set to 0...n

Both the annotation params can be combined as well like below:
@TestData(file="HomePageVerticalLinks.csv", firstRowColumnNames = false, rowDataDelimiter = ";")

Note that the test data framework assumes that the column delimiter is set to ","
