package com.application.songr;

import com.application.songr.model.Album;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SongrApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testingContstructor() {
		Album album = new Album("al1", "adham", 10, 30, "https://i.ytimg.com/vi/RIuhSeGefxk/maxresdefault.jpg" );
		assertEquals("Album{title='al1', songCount=10, length=30, imageUrl='https://i.ytimg.com/vi/RIuhSeGefxk/maxresdefault.jpg', artist='adham'}",album.toString());
	}
	@Test
	public void testingSetters(){
		Album album = new Album("al1", "adham", 10, 30, "https://i.ytimg.com/vi/RIuhSeGefxk/maxresdefault.jpg" );
		album.setTitle("al2");
		album.setArtist("fairuz");
		album.setSongCount(11);
		album.setLength(40);
		album.setImageUrl("https://i.ytimg.com/vi/iV1FYH4_wIM/maxresdefault.jpg");
		assertEquals("Album{title='al2', songCount=11, length=40, imageUrl='https://i.ytimg.com/vi/iV1FYH4_wIM/maxresdefault.jpg', artist='fairuz'}",album.toString());
	}
	@Test
	public void testingGetters(){
		Album album = new Album("al1", "adham", 10, 30, "https://i.ytimg.com/vi/RIuhSeGefxk/maxresdefault.jpg" );
		assertEquals("adham",album.getArtist());
		assertEquals(30,album.getLength());
		assertEquals(10,album.getSongCount());
		assertEquals("al1",album.getTitle());
		assertEquals("https://i.ytimg.com/vi/RIuhSeGefxk/maxresdefault.jpg",album.getImageUrl());
	}

}
