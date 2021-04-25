package com.example.demo.Labs.michael.sortsModel;

import lombok.Data;
import lombok.Getter;
import java.time.Duration;

@Getter
public abstract class _Sorts {
    private String rawData;
    private Object[] unsortedData;
    private String sortName;
    private String sortDescription;
    private Duration sortTime;

    public enum DataType {String, Int, Object}
    private DataType data;

    public _Sorts(String stringLiteral) {
        this.rawData = stringLiteral;
        this.checkDataType();
    }

    public abstract void sort();

    public void checkDataType() {
        if (rawData.charAt(0) >= '0' && rawData.charAt(0) <= '9') {
            this.data = DataType.Int;
        } else if (rawData.charAt(0) >= 'a' && rawData.charAt(0) <= 'z') {
            this.data = DataType.String;
        }
    }

    public static void main(String[] args) {
        _Sorts array = new BubbleSort("h8");
        array.checkDataType();
    }
}
