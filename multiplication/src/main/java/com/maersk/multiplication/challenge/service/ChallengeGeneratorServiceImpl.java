package com.maersk.multiplication.challenge.service;

import com.maersk.multiplication.challenge.domain.Challenge;
import com.maersk.multiplication.challenge.service.ChallengeGeneratorService;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.random.RandomGenerator;

@Service
public class ChallengeGeneratorServiceImpl implements ChallengeGeneratorService {

    private final static int MINIMUM_FACTOR = 11;
    private final static int MAXIMUM_FACTOR = 100;

    private final RandomGenerator random;

    ChallengeGeneratorServiceImpl() {
        this.random = new Random();
    }

    protected ChallengeGeneratorServiceImpl(final RandomGenerator random) {
        this.random = random;
    }

    @Override
    public Challenge randomChallenge() {
        return new Challenge(next(), next());
    }

    private int next() {
        return random.nextInt(MAXIMUM_FACTOR - MINIMUM_FACTOR) + MINIMUM_FACTOR;
    }
}
