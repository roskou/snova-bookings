package com.snovarent.app.application.services;

import com.snovarent.app.application.domain.DTO.ViewRoomDetailDTO;
import com.snovarent.app.application.models.RoomModel;
import java.util.List;

public interface RoomService {
    List<RoomModel> showAllRooms();
    List<ViewRoomDetailDTO> showAllRoomsByType(long tipo);
    List<RoomModel> showRoomByGuest(int numGuest);
    RoomModel showRoomByID(long id);
}
