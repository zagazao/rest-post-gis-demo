package de.ls7.pg609.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Time;
import java.time.DayOfWeek;

/**
 * Created by lukas on 19.05.2017.
 */
@Entity
@Table(name = "OEFFNUNGSZEITEN")
public class Öffnungszeiten {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "OEFFNUNGSZEITEN_ID")
    private Long id;

    private DayOfWeek day;

    private Time startTime;

    private Time endTime;

    public Öffnungszeiten() {
    }

    public Öffnungszeiten(Long id, DayOfWeek day, Time startTime, Time endTime) {
        this.id = id;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Öffnungszeiten{" +
                "id=" + id +
                ", day=" + day +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    public static final class ÖffnungszeitenBuilder {
        private Long id;
        private DayOfWeek day;
        private Time startTime;
        private Time endTime;

        private ÖffnungszeitenBuilder() {
        }

        public static ÖffnungszeitenBuilder aÖffnungszeiten() {
            return new ÖffnungszeitenBuilder();
        }

        public ÖffnungszeitenBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public ÖffnungszeitenBuilder withDay(DayOfWeek day) {
            this.day = day;
            return this;
        }

        public ÖffnungszeitenBuilder withStartTime(Time startTime) {
            this.startTime = startTime;
            return this;
        }

        public ÖffnungszeitenBuilder withEndTime(Time endTime) {
            this.endTime = endTime;
            return this;
        }

        public Öffnungszeiten build() {
            Öffnungszeiten öffnungszeiten = new Öffnungszeiten(id, day, startTime, endTime);
            return öffnungszeiten;
        }
    }
}
