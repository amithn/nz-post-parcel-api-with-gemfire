package nz.co.nzpost.parcel.api.usage;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by anambiar on 26/09/2017.
 */
public class ParcelTrackingResponse {

    @JsonProperty("results")
    ParcelEvent parcelEvent;

    @JsonProperty("success")
    boolean success = true;

    @JsonProperty("message_id")
    private String messageId;

    private String service = "";
    private String carrier = "";

    public ParcelTrackingResponse(ParcelEvent parcelEvent, String messageId) {
        this.parcelEvent = parcelEvent;
        this.messageId = messageId;
    }
}
