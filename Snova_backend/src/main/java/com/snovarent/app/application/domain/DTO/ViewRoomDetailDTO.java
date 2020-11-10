package com.snovarent.app.application.domain.DTO;

import com.snovarent.app.application.models.RoomModel;

import java.sql.Date;
import java.util.List;

public class ViewRoomDetailDTO {
    RoomModel roomModel;
    List<Date> dates;

    public ViewRoomDetailDTO(RoomModel roomModel, List<Date> dates) {
        this.roomModel = roomModel;
        this.dates = dates;
    }

    public RoomModel getRoomModel() {
        return roomModel;
    }

    public void setRoomModel(RoomModel roomModel) {
        this.roomModel = roomModel;
    }

    public List<Date> getDates() {
        return dates;
    }

    public void setDates(List<Date> dates) {
        this.dates = dates;
    }
}
