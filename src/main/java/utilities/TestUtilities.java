package utilities;

import java.util.Date;

public class TestUtilities {


    public static String mtimeStamp() {

        Date today = new Date();
        long dd = today.getDate();
        long mm = today.getMonth() + 1; //January is 0!
        long yyyy = today.getYear();
        int hours = today.getHours();
        int minutes = today.getMinutes();
        int seconds = today.getSeconds();
        String timeStamp = yyyy + '-' + mm + '-' + dd + 'T' + hours + ':' + minutes + ':' + seconds + "+000000";
        return timeStamp;

    }


    public static long mrequestId() {

        Date d = new Date();
        long requestId = d.getTime();
        return requestId;

    }

    public static void waitForTenTime() {

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
