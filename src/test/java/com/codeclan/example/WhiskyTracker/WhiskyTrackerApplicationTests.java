package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindWhiskiesByYear() {
		List<Whisky> found = whiskyRepository.findWhiskiesByYear(1995);
		assertEquals("The Macallan Anniversary Malt", found.get(0).getName() );
	}

	@Test
	public void canFindDistilleriesByRegion() {
		List<Distillery> found = distilleryRepository.findDistilleriesByRegion("Speyside");
		assertEquals("Speyside", found.get(0).getRegion());
	}

	@Test
	public void findWhiskeysThatAreASpecificAgeFromAGivenDistillery() {
		List<Whisky> found = whiskyRepository.findWhiskyThatAreASpecificAgeFrom(1L, 12);
		assertEquals("The Glendronach Original", found.get(0).getName());
	}

	@Test
	public void canFindWhiskyFromASpecificRegion() {
		List<Whisky> found = whiskyRepository.findWhiskyFromASpecificRegion("Lowland");
		assertEquals("The Rosebank 12 - Flora and Fona", found.get(0).getName());
	}
}
