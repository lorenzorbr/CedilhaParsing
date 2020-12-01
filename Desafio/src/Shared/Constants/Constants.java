package Shared.Constants;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Constants {
    @Retention(RetentionPolicy.SOURCE)
    public @interface SCAN {
        String PATH_IN = "FileInput";
        String PATH_OUT = "FileOut";

        String ERROR_READ = "ERROR WHILE READING THE ARCHIVE: ";
        String ERROR_WRITE = "ERROR WHILE WRITING THE ARCHIVE: ";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface VALIDATE {
        String DELIMITER = "ç";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ID_TEXT {
        String SALESMAN = "001";
        String CLIENT = "002";
        String SALE = "003";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface REGEX{
        String INTEGER = "([0-9]*)";
        String DOUBLE = "([0-9]*)\\.([0-9]*)";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface PRINT{
        String CORRUPTED_LINE = "\nTotal Corrupted Lines : ";
        String SALESMAN = "\nSalesman Data: ";
        String SALES = "\nSales Data: ";
        String CLIENT = "\nClient Data: ";
        String INFO = "\n\nInfo of The File: ";
    }

}