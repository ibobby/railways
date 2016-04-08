package ru.intellex.model;


import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;


/**
 * The persistent class for the STATIONS database table.
 */
@Entity
@Table(name = "STATION")
@NamedQueries({
        @NamedQuery(name = "Station.ALL_SORTED", query = "SELECT s FROM Station s ORDER BY s.stName asc"),
        @NamedQuery(name = "Station.ALL_SORTED_WITH_RAILWAYS", query = "SELECT DISTINCT s FROM Station s LEFT JOIN FETCH s.railway ORDER BY s.stName asc")
})
public class Station implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String ALL_SORTED = "Station.ALL_SORTED";
    public static final String ALL_SORTED_WITH_RAILWAYS = "Station.ALL_SORTED_WITH_RAILWAYS";

    @Id
    @SequenceGenerator(name = "SEQ_STATION", sequenceName = "SEQ_STATION")
    @GeneratedValue(generator = "SEQ_STATION")
    @Column(name = "ST_ID")
    private Long stId;

    @Column(name = "ST_CODE")
    private String stCode = "";

    @Column(name = "ST_NAME")
    private String stName = "";

    @Column(name = "ST_ACTIVE")
    private int stActive = 1;

    @Column(name = "ST_CODERW")
    private String stCodeRw = "";

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="st_rwid")
    @JsonBackReference
    /*@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ST_RWID")*/
    private Railway railway;


    public Station() {
    }

    public Long getStId() {
        return stId;
    }

    public void setStId(Long stId) {
        this.stId = stId;
    }

    public String getStCode() {
        return stCode;
    }

    public void setStCode(String stCode) {
        this.stCode = stCode;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public int getStActive() {
        return stActive;
    }

    public void setStActive(int stActive) {
        this.stActive = stActive;
    }

    public String getStCodeRw() {
        return stCodeRw;
    }

    public void setStCodeRw(String stCodeRw) {
        this.stCodeRw = stCodeRw;
    }

    public Railway getRailway() {
        return railway;
    }

    public void setRailway(Railway railway) {
        this.railway = railway;
    }

    @Override
    public String toString() {
        return "Station [" + (stId != null ? "stId=" + stId + ", " : "")
                + (stCode != null ? "stCode=" + stCode + ", " : "")
                + (stName != null ? "stName=" + stName + ", " : "")
                + "stActive=" + stActive + ", "
                + (stCodeRw != null ? "stCodeRw=" + stCodeRw + ", " : "")
                + (railway != null ? "railway=" + railway.getRwId() : "") + "]";
    }


}