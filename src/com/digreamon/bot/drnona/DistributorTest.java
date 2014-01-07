package com.digreamon.bot.drnona;

import com.digreamon.bot.http.drnona.DistributorRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * DistributorTest
 * <p>[11/29/13 3:09 PM]<p/>
 *
 * @author Dmytro Kolomiyets<d.kolomiyets@samsung.com>
 */
public class DistributorTest implements Runnable {

    private ArrayList<Integer> ids;

    public DistributorTest(int startId, int endId){
        ids = new ArrayList<>();
        for (int i=startId; i<=endId; i++){
            ids.add(i);
        }
    }

    @Override
    public void run() {
        DistributorRequest request = new DistributorRequest();
        for(Integer id : ids){
            try {
                Boolean result = (Boolean) request.request(id);
                System.out.println("id=" + id + " - " + (result?"SUCCESS":"FAIL"));
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
