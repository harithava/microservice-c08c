package com.maersk.multiplication.challenge.controller;

import com.maersk.multiplication.challenge.domain.ChallengeAttemptDTO;
import com.maersk.multiplication.challenge.service.ChallengeService;
import com.maersk.multiplication.challenge.domain.ChallengeAttempt;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class provides a REST API to POST the attempts from users.
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/attempts")
public class ChallengeAttemptController {
    private final ChallengeService challengeService;

    @PostMapping
    ResponseEntity<ChallengeAttempt> postResult(@RequestBody @Valid ChallengeAttemptDTO challengeAttemptDTO) {
        log.info("Received new attempt from {}", challengeAttemptDTO.userAlias());
        return ResponseEntity.ok(challengeService.verifyAttempt(challengeAttemptDTO));
    }

    @GetMapping
    ResponseEntity<List<ChallengeAttempt>> getStatistics(@RequestParam("alias") String alias) {
        return ResponseEntity.ok(challengeService.getStatsForUser(alias));
    }
}
