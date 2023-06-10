package com.maersk.gamification.game.consumer;

import com.maersk.gamification.challenge.domain.ChallengeSolvedEvent;
import com.maersk.gamification.game.service.GameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class GameEventHandlerTest {

    private GameEventHandler eventHandler;

    @Mock
    private GameService gameService;

    @BeforeEach
    public void setUp() {
        eventHandler = new GameEventHandler(gameService);
    }

    @Test
    void handleMultiplicationSolved() {
        // given
        ChallengeSolvedEvent event = new ChallengeSolvedEvent( 1L, true,
                20, 30, 10L, "Hariharan");

        // when
        eventHandler.handleMultiplicationSolved(event);

        // then
        verify(gameService).newAttemptForUser(event);
    }
}