package com.ui.utility;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JSONUtility {

    public static Environment readJSON(Env env) {

        Gson gson=new Gson();//to read json in to java variable we are using 3rd party library Gson
        File jsonFile = new File(System.getProperty("user.dir") + "/config/config.json");
        FileReader fileReader= null;
        try {
            fileReader = new FileReader(jsonFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Config config=gson.fromJson(fileReader,Config.class);//fromJson is a overloaded method, it can load data from multiple sources
        //Here your entire json file will be mapped to a config object and this stmt returns the object of a config class, so we need to create a ref variable to store the object i.e.'config'
        Environment environment=config.getEnvironments().get("QA");
        return environment;

    }
}
