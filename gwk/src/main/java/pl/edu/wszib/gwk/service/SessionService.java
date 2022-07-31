package pl.edu.wszib.gwk.service;

import pl.edu.wszib.gwk.model.Session;

public interface SessionService {

    Session createSession(Integer userId);

    void deleteSession(long id);

    boolean checkSessionTime(long id);

    Integer getUserIdBySessionId(long sessionId);

}
