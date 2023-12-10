package de.hbrs.team22.parkhaus_projekt.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfigCommandTest {

    @Test
    void execute() {
        assertEquals("", new ConfigCommand().execute());
    }
}