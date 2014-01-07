package com.digreamon.bot.http.drnona;

import com.digreamon.bot.http.HttpRequest;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

/**
 * DistributorRequest
 * <p>[11/29/13 2:42 PM]<p/>
 *
 * @author Dmytro Kolomiyets<d.kolomiyets@samsung.com>
 */
public class DistributorRequest extends HttpRequest {

    final String url;

    public DistributorRequest(){
        url = "http://drnona.com/distributor";
    }

    public Object request(int distributorId) throws IOException {
        return super.request(url + "/" + distributorId, null);
    }

    @Override
    public Object onHandleResult(URL url, Map<String, String> args, String result) {
        String[] chunks = url.getPath().split("/");
        return Boolean.valueOf(result.indexOf(""+chunks[chunks.length-1]+" not found.")<0);
    }
}
