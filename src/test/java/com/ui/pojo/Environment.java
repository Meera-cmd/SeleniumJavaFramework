package com.ui.pojo;

public class Environment {
    private String url;  // url is a instance variable and its created on heap m/m, so it should be marked as private
    private int MAX_NUMBER_OF_ATTEMPTS;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getMAX_NUMBER_OF_ATTEMPTS() {
        return MAX_NUMBER_OF_ATTEMPTS;
    }

    public void setMAX_NUMBER_OF_ATTEMPTS(int MAX_NUMBER_OF_ATTEMPTS) {
        this.MAX_NUMBER_OF_ATTEMPTS = MAX_NUMBER_OF_ATTEMPTS;
    }
}
