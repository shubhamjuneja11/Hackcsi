package probeginners.hackcsi.Models;

/**
 * Created by rishabhshukla on 02/02/17.
 */

public class Items {
    String kind;
    String selfLink;
    VolumeInfo volumeInfo;
    AccessInfo accessInfo;
    SaleInfo saleInfo;

    public SaleInfo getSaleInfo() {
        return saleInfo;
    }

    public String getKind() {
        return kind;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public AccessInfo getAccessInfo() {
        return accessInfo;
    }
}
