package org.stc.clinicservice.dto;

import org.stc.clinicservice.model.entity.Appointments;

import java.util.List;

public class Response {
    private List<Appointments> data;
    private long count;
    public Response(List<Appointments> data ,  long count){
        this.data = data;
        this.count = count;
    }

    public List<Appointments> getData() {
        return data;
    }

    public void setData(List<Appointments> data) {
        this.data = data;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
