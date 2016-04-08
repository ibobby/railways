package ru.intellex.model;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;

@Entity
@Table(name = "RAILWAY")
@NamedQueries({
        @NamedQuery(name = "Railway.ALL_SORTED", query = "SELECT r FROM Railway r ORDER BY r.rwName asc"),
        @NamedQuery(name = "Railway.ALL_SORTED_WITH_STATIONS", query = "SELECT distinct r FROM Railway r LEFT JOIN FETCH r.stations ORDER BY r.rwId asc")
})
public class Railway implements Serializable {

    public static final String ALL_SORTED = "Railway.ALL_SORTED";
    public static final String ALL_SORTED_WITH_STATIONS = "Railway.ALL_SORTED_WITH_STATIONS";

    @Id
    @SequenceGenerator(name = "SEQ_RAILWAY", sequenceName = "SEQ_RAILWAY")
    @GeneratedValue(generator = "SEQ_RAILWAY")
    @Column(name = "RW_ID")
    private Long rwId;

    @Column(name = "RW_NAME")
    private String rwName;

    @Column(name = "RW_SHORTNAME")
    private String rwShortname;


    //@OneToMany(mappedBy = "railway")
    @OneToMany(mappedBy = "railway", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Station> stations;


    public Railway() {
        // TODO Auto-generated constructor stub
    }

    public Long getRwId() {
        return rwId;
    }

    public void setRwId(Long rwId) {
        this.rwId = rwId;
    }

    public String getRwName() {
        return rwName;
    }

    public void setRwName(String rwName) {
        this.rwName = rwName;
    }

    public String getRwShortname() {
        return rwShortname;
    }

    public void setRwShortname(String rwShortname) {
        this.rwShortname = rwShortname;
    }

    public Set<Station> getStations() {
        return this.stations;
    }

    public void setStations(Set<Station> stations) {
        this.stations = stations;
    }

    public Station addStation(Station station) {
        getStations().add(station);
        station.setRailway(this);

        return station;
    }

    public Station removeStation(Station station) {
        getStations().remove(station);
        station.setRailway(null);

        return station;
    }

    @Override
    public String toString() {
        return "Railway ["
                + (rwId != null ? "rwId=" + rwId + ", " : "")
                + (rwName != null ? "rwName=" + rwName + ", " : "")
                + (rwShortname != null ? "rwShortname=" + rwShortname : "")
                + "]";
    }


}
