package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import application.controller.application.ScheduleMatchApplicationController;
import application.exception.TrainerException;


class TestScheduleMatchController {
	
	private ScheduleMatchApplicationController scheduleMatchController = new ScheduleMatchApplicationController();

	 @Test
	 void testSaveMatch_NullDate_ThrowsException() {
		 Exception exception = assertThrows(TrainerException.class, () -> 
		 		scheduleMatchController.saveMatch("Inter", null, LocalTime.of(18, 30), "Milan", "Home")
		  );
		 assertEquals("Enter the match date (dd/MM/yyyy)", exception.getMessage());
	 }

	   @Test
	   void testSaveMatch_PastDate_ThrowsException() {
		   LocalDate yesterday = LocalDate.now().minusDays(1);
		   Exception exception = assertThrows(TrainerException.class, () -> 
		   		scheduleMatchController.saveMatch("Inter", yesterday, LocalTime.of(18, 30), "Milan", "Home")
			);
	        assertEquals("The match date and time must be in the future", exception.getMessage());
	    }
	   
	   @Test
	    void testSaveMatch_ExistingMatchOnSameDate_ReturnsOne() throws TrainerException {
	        LocalDate date = LocalDate.now().plusDays(7);
	        LocalTime time = LocalTime.of(20, 45);

	        int result = scheduleMatchController.saveMatch("Inter", date, time, "Milan", "Home");
	        assertEquals(1, result); // Update del match
	    }

	    
	    @Test
	    void testSaveMatch_SuccessfulSave_ReturnsZero() throws TrainerException {
	        LocalDate date = LocalDate.now().plusDays(20);
	        int result = scheduleMatchController.saveMatch("Inter", date, LocalTime.of(20, 45), "Milan", "Home");
	        assertEquals(0, result);
	    }
}
