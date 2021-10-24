package com.example.songr;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SongrApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	void testConstructorOfAlbumClass() {
		Album album1 = new Album("erry-Jacks-Seasons-In-The-Sun", "abd ata",6,1440,"https://static.stereogum.com/uploads/2019/05/Terry-Jacks-Seasons-In-The-Sun-1557350323-520x520.jpg");
		String output = album1.toString();
		String expected = "Album{title='erry-Jacks-Seasons-In-The-Sun', artist='abd ata', songCount=6, length=1440, imageUrl='https://static.stereogum.com/uploads/2019/05/Terry-Jacks-Seasons-In-The-Sun-1557350323-520x520.jpg'}";
		assertEquals(expected,output);
	}

	@Test
	void testSetterAndGetterOfAlbumClass() {
		Album album1 = new Album("erry-Jacks-Seasons-In-The-Sun", "abd ata",6,1440,"https://static.stereogum.com/uploads/2019/05/Terry-Jacks-Seasons-In-The-Sun-1557350323-520x520.jpg");
		album1.setSongCount(9);
		int output = album1.getSongCount();
		int expected = 9;
		assertEquals(expected,output);
	}


}
