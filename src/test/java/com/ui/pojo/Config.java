package com.ui.pojo;

import java.util.Map;

public class Config {

   Map<String,Environment> environments; //first argument is key and is in string format

    public Map<String, Environment> getEnvironments() {
        return environments;
    }

    public void setEnviroments(Map<String, Environment> environments) {
        this.environments = environments;
    }
}
