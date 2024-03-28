package org.apiActions;

import okhttp3.OkHttpClient;

import java.util.logging.Logger;


public class GlobalSettings {

    String baseUrl = "https://qauto.forstudy.space/api";
    OkHttpClient client = new OkHttpClient.Builder().build();
    public static Logger logger;

}
