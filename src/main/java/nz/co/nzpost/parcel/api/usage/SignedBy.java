package nz.co.nzpost.parcel.api.usage;


/**
 * Created by anambiar on 21/09/2017.
 */
public class SignedBy {
    private String name;
    private String signature;

    public SignedBy() {
    }

    public SignedBy(String name, String signature) {
        this.name = name;
        this.signature = signature;
    }

    public String getName() {
        return name;
    }

    public String getSignature() {
        return signature;
    }
}
