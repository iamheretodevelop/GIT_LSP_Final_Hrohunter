package org.howard.edu.lsp.oopfinal.question1;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Set;

public class SongsDatabaseTest {

    @Test
    public void testAddSong() {
        SongsDatabase db = new SongsDatabase();
        db.addSong("Rap", "No Role Modelz");
        assertTrue(db.getSongs("Rap").contains("No Role Modelz"));
        assertFalse(db.getSongs("Rap").contains("Work Out"));
    }

    @Test
    public void testGetGenreOfSong() {
        SongsDatabase db = new SongsDatabase();
        db.addSong("Rap", "No Role Modelz");
        assertEquals("Rap", db.getGenreOfSong("No Role Modelz"));
        assertNotEquals("Jazz", db.getGenreOfSong("No Role Modelz"));
    }

    @Test
    public void testGetSongs() {
        SongsDatabase db = new SongsDatabase();
        db.addSong("Rock", "Here Comes The Sun");
        db.addSong("Rock", "November Rain");
        db.addSong("Rap", "No Role Modelz");
        db.addSong("Rap", "Mockingbird");
        
        Set<String> rockSongs = db.getSongs("Rock");
        assertTrue(rockSongs.contains("Here Comes The Sun"));
        assertTrue(rockSongs.contains("November Rain"));
        assertFalse(rockSongs.contains("No Role Modelz"));
        assertEquals(2, rockSongs.size());
        
        Set<String> rapSongs = db.getSongs("Rap");
        assertTrue(rapSongs.contains("No Role Modelz"));
        assertTrue(rapSongs.contains("Mockingbird"));
        assertFalse(rapSongs.contains("November Rain"));
        assertEquals(2, rapSongs.size());
    }
}