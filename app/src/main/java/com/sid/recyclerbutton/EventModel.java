package com.sid.recyclerbutton;

/**
 * Created by Jethva Sagar (Piml Sid) on 11/8/16.
 * Email : Jethvasagar2@gmail.com
 */

public class EventModel {

    private String name;
    private String active;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private int status;

    public EventModel(String name,String active,int status){
        this.name = name;
        this.active = active;
        this.status = status;

    }

    public String isActiove() {
        return active;
    }

    public void setActiove(String actiove) {
        this.active = actiove;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
