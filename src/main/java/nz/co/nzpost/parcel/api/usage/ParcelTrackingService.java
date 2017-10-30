package nz.co.nzpost.parcel.api.usage;

import org.apache.geode.pdx.PdxInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ParcelTrackingService {

    private ParcelTrackingRepository parcelTrackingRepository;

    @Autowired
    public ParcelTrackingService(ParcelTrackingRepository parcelTrackingRepository) {
        this.parcelTrackingRepository = parcelTrackingRepository;
    }

    public ParcelEvent findEvents(String trackingReference) {
        List<TrackingEvent> trackingEventList = new ArrayList<>();
        List<PdxInstance> pdxInstances = parcelTrackingRepository.findEvents(trackingReference);
        for(PdxInstance p : pdxInstances) {
            TrackingEvent event = extractEvent(p);
            trackingEventList.add(event);
        }

        return new ParcelEvent(trackingEventList);
    }

    private TrackingEvent extractEvent(PdxInstance p) {
        String trackingRef = (String) p.getField("trackingReference");
        Integer eventEdifactCode = (int) p.getField("eventEdifactCode");
        String source = (String) p.getField("source");
        String seqref = (String) p.getField("seqRef");
        String statusDescription = (String) p.getField("statusDescription");
        String eventDescription = (String) p.getField("eventDescription");
        Date eventDateTime = (Date) p.getField("eventDateTime");
        String name = (String) p.getField("signedBy.name");
        String signature = (String) p.getField("signedBy.signature");

        SignedBy signedBy = new SignedBy("Authorized", signature);
        return new TrackingEvent(trackingRef, eventEdifactCode, seqref,
                                        source,statusDescription,eventDescription,eventDateTime, signedBy);

    }
}
