package com.example.demo.Labs.michael.sortsModel;

import lombok.Data;
import lombok.Getter;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

@Getter
public abstract class _Sorts {
    private String rawData; // input data
    protected Object[] unsortedData; // deprecated type that was going to be used as an opaque type
    protected Integer[] unsortedDataI; // holds sorted data if the type is identified from checkDataType
    protected String[] unsortedDataS; // ""
    protected String sortName;
    protected String sortDescription;
    private Duration sortTime;

    public enum DataType {String, Int, Object}
    protected DataType data;

    public _Sorts(String stringLiteral) {
        this.rawData = stringLiteral;
        this.checkDataType();
        this.toArray();

        Instant sortStart = Instant.now();
        this.sort();
        Instant sortEnd = Instant.now();
        this.sortTime = Duration.between(sortStart, sortEnd);

    }

    public abstract void sort();

    public void toArray() {
        switch (this.data) {
            case Int:
                /* Input box gives back a string literal, but an Integer[] is needed */
                String[] arrayI = this.rawData.split(","); // automatic split into String[]
                List<String> listI = Arrays.asList(arrayI); // conversion to List because of management of a List

                Integer[] unsortedArrayI = new Integer[listI.size()];

                for (String element : listI) { // takes each element of the list and converts it to an int which is stuffed into an int[]
                    unsortedArrayI[listI.indexOf(element)] = Integer.parseInt(element);
                }

                this.unsortedDataI = unsortedArrayI; // assigns parsed array to corresponding instance variable
                break;
            case String:
                /* Input box gives back a string literal, but an String[] is needed */
                String[] arrayS = this.rawData.split(","); // automatic split into String[]
                List<String> listS = Arrays.asList(arrayS); // conversion to List because of management of a List

                String[] unsortedArrayS = new String[listS.size()];

                for (String element : listS) { // takes each element of the list and converts it to an Integer which is stuffed into an Integer[]
                    unsortedArrayS[listS.indexOf(element)] = element;
                }

                this.unsortedDataS = unsortedArrayS; // assigns parsed array to corresponding instance variable
                break;
            default:
                System.out.println("Enum not assigned");
                break;
        }
    }

    public void checkDataType() {
        if (rawData.charAt(0) >= '0' && rawData.charAt(0) <= '9') {
            this.data = DataType.Int;
        } else if (rawData.charAt(0) >= 'a' && rawData.charAt(0) <= 'z') {
            this.data = DataType.String;
        }
    }
}
