package com.sap.Conversession.repository;

import com.sap.Conversession.modal.MeetingSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingSessionRepository extends JpaRepository<MeetingSession, Long> {
    MeetingSession findBySessionId(String sessionId);
}
