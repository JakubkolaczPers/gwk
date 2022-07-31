package pl.edu.wszib.gwk.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.wszib.gwk.model.Session;
import pl.edu.wszib.gwk.repositories.SessionRepository;
import pl.edu.wszib.gwk.service.SessionService;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {
    private final SessionRepository sessionRepository;

    @Override
    public Session createSession(Integer userId) {
        return sessionRepository.save(Session.builder()
                        .userId(userId)
                        .creationTime(LocalDateTime.now())
                .build()
        );
    }

    @Override
    public void deleteSession(long id) {
        sessionRepository.deleteById(id);
    }

    @Override
    public boolean checkSessionTime(long id) {
        LocalDateTime minute = sessionRepository.findById(id)
                .get()
                .getCreationTime();
        LocalDateTime now = LocalDateTime.now();
        if(minute.plusMinutes(10).getMinute() >= now.getMinute()){
            deleteSession(id);
            return false;
        }
        return true;
    }

    @Override
    public Integer getUserIdBySessionId(long sessionId) {
        return sessionRepository.getById(sessionId).getUserId();
    }
}
