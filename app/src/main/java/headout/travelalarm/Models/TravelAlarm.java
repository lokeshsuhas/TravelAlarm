package headout.travelalarm.Models;

/**
 * Created by Lokesh on 07-02-2016.
 */
public class TravelAlarm {

    public long Id;
    public String Start;
    public String Dest;
    public int Kms;
    public int ETA;
    public int WakeUpType;

    public TravelAlarm setId(long id) {
        this.Id = id;
        return this;
    }

    public TravelAlarm setStart(String start) {
        this.Start = start;
        return this;
    }

    public TravelAlarm setDest(String dest) {
        this.Dest = dest;
        return this;
    }

    public TravelAlarm setKms(int kms) {
        this.Kms = kms;
        return this;
    }

    public TravelAlarm setETA(int eta) {
        this.ETA = eta;
        return this;
    }

    public TravelAlarm setWakeUpType(int wk) {
        this.WakeUpType = wk;
        return this;
    }


    public long getId() {
        return this.Id;
    }

    public String getStart() {
        return this.Start;
    }

    public String getDest() {
        return this.Dest;
    }

    public int getKms() {
        return this.Kms;
    }

    public int getETA() {
        return this.ETA;
    }

    public int getWakeUpType() {
        return this.WakeUpType;
    }
}
