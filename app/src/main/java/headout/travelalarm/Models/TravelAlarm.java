package headout.travelalarm.Models;

/**
 * Created by Lokesh on 07-02-2016.
 */
public class TravelAlarm {

    public long Id;
    public float Start;
    public float Dest;
    public int Kms;
    public int ETA;
    public int WakeUpType;

    public TravelAlarm setId(long id)
    {
        this.Id = id;
        return this;
    }

    public TravelAlarm setStart(float start)
    {
        this.Start = start;
        return this;
    }

    public TravelAlarm setDest(float dest)
    {
        this.Dest = dest;
        return this;
    }

    public TravelAlarm setKms(int kms)
    {
        this.Kms = kms;
        return this;
    }

    public TravelAlarm setETA(int eta)
    {
        this.ETA = eta;
        return this;
    }

    public TravelAlarm setWakeUpType(int wk)
    {
        this.WakeUpType = wk;
        return this;
    }
}
