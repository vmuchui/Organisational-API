package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class GeneralNewsTest {

    @Test
    public void getId() {
        GeneralNews generalNews = new GeneralNews("OFFICE PARTY", "next week ...");
        generalNews.setId(2);
        assertEquals(2, generalNews.getId());
    }

    @Test
    public void setId() {
        GeneralNews generalNews = new GeneralNews("OFFICE PARTY", "next week ...");
        generalNews.setId(2);
        assertEquals(2, generalNews.getId());
    }

    @Test
    public void getHeadlines() {
        GeneralNews generalNews = new GeneralNews("OFFICE PARTY", "next week ...");
        assertEquals("OFFICE PARTY", generalNews.getHeadlines());
    }

    @Test
    public void getContent() {
        GeneralNews generalNews = new GeneralNews("OFFICE PARTY", "next week ...");
        assertEquals("next week ...", generalNews.getContent());
    }
}