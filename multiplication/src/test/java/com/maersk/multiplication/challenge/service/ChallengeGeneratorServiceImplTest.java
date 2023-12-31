package com.maersk.multiplication.challenge.service;

import com.maersk.multiplication.challenge.domain.Challenge;
import com.maersk.multiplication.challenge.service.ChallengeGeneratorService;
import com.maersk.multiplication.challenge.service.ChallengeGeneratorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;
import java.util.random.RandomGenerator;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class ChallengeGeneratorServiceImplTest {

    private ChallengeGeneratorService challengeGeneratorService;

    @Mock
    private RandomGenerator random;

    @BeforeEach
    public void setUp() {
        challengeGeneratorService = new ChallengeGeneratorServiceImpl(random);
    }

    @Test
    void randomChallenge() {
        // 89 is max - min range
        given(random.nextInt(89)).willReturn(20, 30);

        // when we generate a challenge
        Challenge challenge = challengeGeneratorService.randomChallenge();

        // then the challenge contains factors as expected
        then(challenge).isEqualTo(new Challenge(31, 41));
    }
}