package com.sap.Conversession.services;

import com.sap.Conversession.modal.MeetingSession;
import com.sap.Conversession.repository.MeetingSessionRepository;
import com.sap.Conversession.services.markups.MeetingSessionServiceMarkup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MeetingSessionService implements MeetingSessionServiceMarkup{
	private final MeetingSessionRepository repository;

    @Value("${application.base-url}") // Define in application.properties (e.g., http://localhost:8080)
    private String baseUrl;

    public MeetingSessionService(MeetingSessionRepository repository) {
        this.repository = repository; 
    }

    public String createSession() {
        String sessionId = UUID.randomUUID().toString();
        String meetingUrl = baseUrl + "/api/meetings/join/" + sessionId;

        MeetingSession session = new MeetingSession();
        session.setSessionId(sessionId);
        session.setMeetingUrl(meetingUrl);

        repository.save(session);

        return meetingUrl;
    }

	@Override
	public MeetingSession getSessionById(String sessionId) {
		return repository.findBySessionId(sessionId);  // Querying the database
	}
}