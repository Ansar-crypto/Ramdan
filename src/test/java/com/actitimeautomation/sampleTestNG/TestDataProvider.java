package com.actitimeautomation.sampleTestNG;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
    @DataProvider
    public String [][]getSampleData(){
        String[][] obj=new String[][]{
                {" pune " , " mumbai " , " nagpur "},
                {" dehli " , " Hydrabad " , "  " }
        };
        return obj;
    }
}
