package com.example.demo;

import com.example.demo.Core.Player;
import org.junit.jupiter.api.Test;
import org.easymock.EasyMock;

import static org.easymock.EasyMock.*;

class PlayerTest {

    @Test
    void testScoreListenerWithEasyMock() {
        // Arrange: Mock erstellen
        Runnable mockListener = EasyMock.mock(Runnable.class);

        // Erwartung: run() soll genau einmal aufgerufen werden
        mockListener.run();
        expectLastCall().once();

        // Mock aktivieren
        replay(mockListener);

        // Player erstellen und Listener hinzufügen
        Player player = new Player("Test", "Job", "");
        player.addScoreListener(mockListener);

        // Act: Score erhöhen → Listener sollte aufgerufen werden
        player.addScore(5);

        // Assert: Überprüfen, ob Erwartung erfüllt wurde
        verify(mockListener);
    }
}
