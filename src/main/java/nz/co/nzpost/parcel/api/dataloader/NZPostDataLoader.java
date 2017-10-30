package nz.co.nzpost.parcel.api.dataloader;

import nz.co.nzpost.parcel.api.usage.TrackingEvent;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class NZPostDataLoader {

    public static void main(String[] args) throws IOException, ParseException {
        String locator = "localhost";

        TrackingEventParser trackingEventParser = new TrackingEventParser();
        Map<Map<String, String>, TrackingEvent> localBuffer = new HashMap<>();

        ClientCache cache = new ClientCacheFactory()
                .set("cache-xml-file", "parcel_client.xml")
                .create();

        Region<Object, TrackingEvent> parcelsRegion = cache.getRegion("parcels");

        int numEvents = 0;
        Map<String, String> compositeKey;

        File file = new File("./datagen/events.csv");
        try (BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()))) {
            String eventLine;
            while ((eventLine = br.readLine()) != null) {
                numEvents++;

                TrackingEvent event = trackingEventParser.parse(eventLine);

                compositeKey = new HashMap<>();
                compositeKey.put("tracking_reference", event.getTrackingReference());
                compositeKey.put("seqref", event.getSeqRef());


                localBuffer.put(compositeKey, event);

                if (numEvents % 1000 == 0) {
                    parcelsRegion.putAll(localBuffer);
                    localBuffer.clear();
                    System.out.println("Done [ = " + numEvents + "]");
                }
            }

            if (localBuffer.size() > 0) {
                parcelsRegion.putAll(localBuffer);
            }
        }

        System.out.println("Ingested num events  = " + numEvents);
        cache.close(true);
    }
}
