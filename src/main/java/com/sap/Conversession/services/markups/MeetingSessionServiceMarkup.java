package com.sap.Conversession.services.markups;

import com.sap.Conversession.modal.MeetingSession;

public interface MeetingSessionServiceMarkup {
	public String createSession();
	public MeetingSession getSessionById(String sessionId);
}
