package logic;

import javax.persistence.*;

@Entity
public class Simulation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private SwitchAlgorithm.AlgorithmType algorithmType;

    private String referredPageIDs;

    private String usedFrameNames;

    private Integer pageFails;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SwitchAlgorithm.AlgorithmType getAlgorithmType() {
        return algorithmType;
    }

    public void setAlgorithmType(SwitchAlgorithm.AlgorithmType algorithmType) {
        this.algorithmType = algorithmType;
    }

    public String getReferredPageIDs() {
        return referredPageIDs;
    }

    public void setReferredPageIDs(String referredPageIDs) {
        this.referredPageIDs = referredPageIDs;
    }

    public String getUsedFrameNames() {
        return usedFrameNames;
    }

    public void setUsedFrameNames(String usedFrameNames) {
        this.usedFrameNames = usedFrameNames;
    }

    public Integer getPageFails() {
        return pageFails;
    }

    public void setPageFails(Integer pageFails) {
        this.pageFails = pageFails;
    }
}
