This is a utility test data framework supporting CSV files.

It assumes that the test suite test data files are located under src/test/resources/testData folder

Syntax on calling:
In any of the suite test methods (if test data support is needed),

@Test(dataProvider = "TestDataProvider", dataProviderClass = CSVTestDataProvider.class)
@TestData(file="your test data file.csv",  rowDataDelimiter = ";")

rowDataDelimiter is optional and if not set, defaults to ",".

Note that the test data framework assumes that the column delimiter is set to ","
