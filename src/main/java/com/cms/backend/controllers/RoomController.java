package com.cms.backend.controllers;


import com.cms.backend.data.RoomRepository;
import com.cms.backend.models.ResponseRoom;
import com.cms.backend.models.ResponseUser;
import com.cms.backend.models.Result;
import com.cms.backend.models.Room;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class RoomController {

    @Autowired
    RoomRepository roomRepository;

    @PostMapping("/api/v1/rooms")
    public Result createRoom(@RequestBody Room room) throws JsonProcessingException {
        roomRepository.save(room);
        return new Result(true, "Room saved");
    }

    @GetMapping("/api/v1/rooms")
    public ResponseRoom getRooms() throws JsonProcessingException {
        return new ResponseRoom(true, roomRepository.findAll());
    }

    @DeleteMapping("/api/v1/rooms/{id}")
    public Result deleteRoom(@PathVariable  Integer id) throws JsonProcessingException {
        Result result = new Result(true, "Room deleted with id " + id );
        Optional<Room> room =  roomRepository.findById(id);

        if(room.isPresent()) {
            roomRepository.deleteById(id);
        }
        return result;
    }
}
