package nz.co.nzpost.parcel.api.usage;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

/**
 *
 {
 "tracking_reference":"00393311680005810444",
 "event_edifact_code":"13",
 "source":"CME",
 "seqref":"2631897613",
 "status_description":"Acceptance",
 "event_description":"Your item was picked up by our courier based at Penrose.",
 "event_datetime":"2015-06-24T10:05:13",
 "signed_by":{
 "name":"",
 "signature":""
 }
 }
 */

public class TrackingEvent {
    private static DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd hh:mm:ss");

    @JsonProperty("tracking_reference")
    private String trackingReference;

    @JsonProperty("event_edifact_code")
    private int eventEdifactCode;

    @JsonProperty("source")
    private String source;

    @JsonProperty("seqref")
    private String seqRef;

    @JsonProperty("status_description")
    private String statusDescription;

    @JsonProperty("event_description")
    private String eventDescription;

    @JsonProperty("event_datetime")
    private Date eventDateTime;

    @JsonProperty("event_datetime_str")
    private String eventDateTimeString;

    @JsonProperty("signed_by")
    private SignedBy signedBy;

    public TrackingEvent() {}

    public TrackingEvent(String trackingReference, int eventEdifactCode, String seqRef, String source,
                         String statusDescription, String eventDescription, Date eventDateTime, SignedBy signedBy) {
        this.trackingReference = trackingReference;
        this.eventEdifactCode = eventEdifactCode;
        this.seqRef = seqRef;
        this.source = source;
        this.statusDescription = statusDescription;
        this.eventDescription = eventDescription;

        this.eventDateTime = eventDateTime;

        // TODO: Refactor
        DateTime dateTime = new DateTime(eventDateTime.getTime());
        this.eventDateTimeString = fmt.print(dateTime);

        this.signedBy = signedBy;
    }

    public String getTrackingReference() {
        return trackingReference;
    }

    public int getEventEdifactCode() {
        return eventEdifactCode;
    }

    public String getSource() {
        return source;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public Date getEventDateTime() {
        return eventDateTime;
    }

    public SignedBy getSignedBy() {
        return signedBy;
    }

    public String getSeqRef() {
        return seqRef;
    }

    public String getEventDateTimeString() {
        return eventDateTimeString;
    }
}
