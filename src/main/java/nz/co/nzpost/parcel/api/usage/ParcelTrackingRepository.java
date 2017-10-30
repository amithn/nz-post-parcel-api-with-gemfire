package nz.co.nzpost.parcel.api.usage;

import org.apache.geode.pdx.PdxInstance;
import org.springframework.data.gemfire.repository.GemfireRepository;
import org.springframework.data.gemfire.repository.Query;

import java.util.List;


public interface ParcelTrackingRepository extends GemfireRepository<Parcels, String> {

        @Query("SELECT * FROM /parcels limit 100")
        List<PdxInstance> getAll();

        @Query("SELECT * FROM /parcels where trackingReference = $1 order by eventDateTime.getTime asc")
        List<PdxInstance> findEvents(String trackingReference);

        @Query("select e.key from /parcels.entries e where e.value.seqref = $1")
        List<Object> findAllKeysMatching(Long sqlref);

}
