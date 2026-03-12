package uz.java.spring_boot_application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import uz.java.spring_boot_application.dto.room.RoomRequest;
import uz.java.spring_boot_application.dto.room.RoomResponse;
import uz.java.spring_boot_application.entities.Room;
import uz.java.spring_boot_application.exception.GenericNotFoundException;
import uz.java.spring_boot_application.mapper.RoomMapper;
import uz.java.spring_boot_application.repository.RoomRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    public List<RoomResponse> getAll() {
        List<RoomResponse> list = roomRepository.findAll().stream().map(
                roomMapper::toResponse
        ).toList();

        return list;
    }

    public RoomResponse getOne(Long id) {
        Room room = roomRepository.findById(id).orElseThrow(
                () -> new GenericNotFoundException("room.not.found")
        );

        return  roomMapper.toResponse(room);
    }

    public Long create(RoomRequest roomRequest) {
        Room entity = roomMapper.toEntity(roomRequest);
        Room save = roomRepository.save(entity);
        return save.getId();
    }

    public Long update(RoomRequest roomRequest, Long id) {
        Room room = roomRepository.findById(id).orElseThrow(
                () -> new GenericNotFoundException("room.not.found")
        );
        roomMapper.updateFromRequest(roomRequest, room);
        return roomRepository.save(room).getId();
    }

    public Boolean delete(Long id) {
        Room room = roomRepository.findById(id).orElseThrow(
                () -> new GenericNotFoundException("room.not.found")
        );
        room.markAsDeleted();
        roomRepository.save(room);
        return true;
    }
}
