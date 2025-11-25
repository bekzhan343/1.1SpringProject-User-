package com.example1._SpringProjects.utils;

import com.example1._SpringProjects.constants.ApiConst;

public class ApiUtils {

    public static final String getMethodName(){
        try {
            return Thread.currentThread().getStackTrace()[2].getMethodName();
        }catch (Exception cause){
            return ApiConst.UNDEFINED;
        }
    }
}
