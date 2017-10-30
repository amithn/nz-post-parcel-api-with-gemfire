package nz.co.nzpost.parcel.api.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeFormatConverter {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public TimeFormatConverter() {}

    public String toDate(long occurredAt) {
        Date date = new Date(occurredAt);
        return simpleDateFormat.format(date);
    }

    public long toTimestamp(String date) {
        long timestamp = 0;
        try {
            timestamp = simpleDateFormat.parse(date).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timestamp;
    }

}
