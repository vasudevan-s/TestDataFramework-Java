package pro.vasudevan.testdataframework.interfaces;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * Created By: Vasudevan Sampath
 * 
 * TestData.java - custom annotation interface
 * Requires a valid CSV file (virtual path)
 * rowDataDelimiter parameter is optional and if not set, defaults to ","
 * columnDelimiter is assumed to be ","
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface TestData {

    String file() default "";
    String rowDataDelimiter() default ",";
}
