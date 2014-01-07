package com.digreamon.bot.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * HttpRequest
 * <p>[11/29/13 10:37 AM]<p/>
 *
 * @author Dmytro Kolomiyets<d.kolomiyets@samsung.com>
 */
public abstract class HttpRequest {

    public final Object request(String urlString, Map<String, String> args) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        StringBuilder response = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        con.disconnect();
        return onHandleResult(url, args, response.toString());
    }

    public abstract Object onHandleResult(URL url, Map<String, String> args, String result);

}
