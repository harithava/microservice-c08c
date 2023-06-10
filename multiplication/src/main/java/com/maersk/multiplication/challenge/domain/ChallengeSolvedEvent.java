package com.maersk.multiplication.challenge.domain;


public record ChallengeSolvedEvent(long attemptId, boolean correct, int factorA, int factorB, long userId,
                                   String userAlias) {

}
