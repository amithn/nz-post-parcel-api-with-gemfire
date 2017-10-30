package nz.co.nzpost.parcel.api.dataloader;

import nz.co.nzpost.parcel.api.usage.SignedBy;
import nz.co.nzpost.parcel.api.usage.TrackingEvent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TrackingEventParser {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");


    // 2017-10-19 13:02:00,1000020590,1002031479,PSG,44,event description,Delivered,,
    public TrackingEvent parse(String eventLine) throws ParseException {
        SignedBy signedBy = null;
        TrackingEvent trackingEvent = null;
        if(eventLine != null && eventLine.length() > 10) {
            String[] parts = eventLine.split(",");

            if(parts.length == 9) {
                Date date = simpleDateFormat.parse(parts[0]);
                String trackingRef = parts[1];
                String seqRef = parts[2];
                String source = parts[3];
                int edifactCode = Integer.valueOf(parts[4]);
                String statusDesc = parts[5];
                String eventDesc = parts[6];

                String name = parts[7];
                String signature = parts[8];

                signedBy = new SignedBy(name, signature);

                // create a builder here for the Tracking event
                trackingEvent =
                        new TrackingEvent(trackingRef, edifactCode, seqRef, source, statusDesc,
                                            eventDesc, date, signedBy);
            } else {
                throw new InvalidEventException("Could not parse event");
            }
        }
        return trackingEvent;
    }
}
