package codex.afinal.smsapp;



/**
 * Created by Ali on 22-Nov-17.
 */

public class person {
    public String name;
    public String contact;

    public person(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    public String getName()
    {
        return this.name;
    }

    public String getContact()
    {
        return this.contact;
    }

    public void setName(String x)
    {
        this.name=x;
    }

    public void setContact(String x)
    {
        this.contact=x;
    }


}
