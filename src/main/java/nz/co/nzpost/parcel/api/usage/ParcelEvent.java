package nz.co.nzpost.parcel.api.usage;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ParcelEvent {

    @JsonProperty("tracking_events")
    private List<TrackingEvent> trackingEventList;

    public ParcelEvent() {
    }

    public ParcelEvent(List<TrackingEvent> trackingEventList) {
        this.trackingEventList = trackingEventList;
    }

}