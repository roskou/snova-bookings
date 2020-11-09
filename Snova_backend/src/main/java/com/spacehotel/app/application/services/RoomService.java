package com.spacehotel.app.application.services;

import com.spacehotel.app.application.domain.DTO.ViewRoomDetailDTO;
import com.spacehotel.app.application.models.RoomModel;
import java.util.List;

public interface RoomService {
    List<RoomModel> showAllRooms();
    List<ViewRoomDetailDTO> showAllRoomsByType(long tipo);
    List<RoomModel> showRoomByGuest(int numGuest);
    RoomModel showRoomByID(long id);
}
