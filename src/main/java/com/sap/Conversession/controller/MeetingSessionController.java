package com.sap.Conversession.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sap.Conversession.modal.MeetingSession;
import com.sap.Conversession.services.MeetingSessionService;

@RestController
@RequestMapping("/api/meetings")
public class MeetingSessionController{

    private final MeetingSessionService service;

    public MeetingSessionController(MeetingSessionService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createSession() {
        String meetingUrl = service.createSession();
        return ResponseEntity.ok(meetingUrl);
    }
    
    @GetMapping("/join/{sessionId}")
    public ResponseEntity<String> joinSession(@PathVariable String sessionId) {
        MeetingSession session = service.getSessionById(sessionId);
        if (session != null) {
            return ResponseEntity.ok("Join the meeting: " + session.getMeetingUrl());
        } else {
            return ResponseEntity.status(404).body("Session not found");
        }
    }

}
