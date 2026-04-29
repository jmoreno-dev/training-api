package com.jmorenodev.training_api.service;

import com.jmorenodev.training_api.model.Session;
import com.jmorenodev.training_api.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public List<Session> getAllSessions(){
        return sessionRepository.findAll();
    }

    public Optional<Session> getSessionById (Long id){
        return sessionRepository.findById(id);
    }

    public Session saveOrUpdateSession(Session session){
        return sessionRepository.save(session);
    }

    public void deleteSessionById (Long id) {
        if (sessionRepository.existsById(id)) {
            sessionRepository.deleteById(id);
        }
    }
}
