package nz.co.nzpost.parcel.api.usage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class ParcelTrackingApi {


    private ParcelTrackingService parcelTrackingService;

    @Autowired
    public ParcelTrackingApi(ParcelTrackingService parcelTrackingService) {
        this.parcelTrackingService = parcelTrackingService;
    }

    @RequestMapping(value = "/parceltrack/3.0/parcels/{tracking_reference}", method = RequestMethod.GET)
    @ResponseBody
    public ParcelTrackingResponse track(@PathVariable("tracking_reference") String trackingReference) {
        ParcelEvent parcelEvent =  parcelTrackingService.findEvents(trackingReference);
        return new ParcelTrackingResponse(parcelEvent, UUID.randomUUID().toString());
    }
}
