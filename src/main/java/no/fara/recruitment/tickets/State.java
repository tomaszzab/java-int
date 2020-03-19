package no.fara.recruitment.tickets;

import lombok.Getter;

import java.util.Arrays;

public enum State {

    INACTIVE(0), ACTIVE(1);
    @Getter
    int stateId;

    State(int stateId) {this.stateId = stateId;}


    public static State valueOf(int stateId) {
        return Arrays.stream(values()).filter(s -> s.getStateId() == stateId).findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
