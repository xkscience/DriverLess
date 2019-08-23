package com.xkscience.driverless;

import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

public class ParkingCarTest {
	CarPark cp;
	Car car;
	ParkingCar pc;

	@Before
	public void init() {
		cp = new CarPark(30, 20);
		car = new MyDreamCar();
		pc = new ParkingCar();
	}

	@Test
	public void testFaceEastAndMove() throws Exception {
		car.setPositionX(1);
		car.setPositionY(1);
		car.setOrientation(Orientation.EAST);

		pc.parking(cp, car);
		assertThat(car.getOrientation(), CoreMatchers.is(Orientation.EAST));
		assertThat(car.getPositionX(), CoreMatchers.is(2));
		assertThat(car.getPositionY(), CoreMatchers.is(1));

		car.setPositionX(1);
		pc.parkingDistance(cp, car, 13);
		assertThat(car.getOrientation(), CoreMatchers.is(Orientation.EAST));
		assertThat(car.getPositionX(), CoreMatchers.is(14));
		assertThat(car.getPositionY(), CoreMatchers.is(1));

	}

	@Test
	public void testFaceWestAndMove() {
		car.setPositionX(1);
		car.setPositionY(1);
		car.setOrientation(Orientation.WEST);

		try {
			pc.parking(cp, car);
		} catch (Exception e) {
			assertThat(e.getMessage(), CoreMatchers.is("Your car is out of boundries!"));
		}

	}

	@Test
	public void testFaceSouthAndMove() {
		car.setPositionX(1);
		car.setPositionY(1);
		car.setOrientation(Orientation.SOUTH);

		try {
			pc.parking(cp, car);
		} catch (Exception e) {
			assertThat(e.getMessage(), CoreMatchers.is("Your car is out of boundries!"));
		}

	}

	@Test
	public void testFaceNorthAndMove() throws Exception {
		car.setPositionX(1);
		car.setPositionY(1);
		car.setOrientation(Orientation.NORTH);

		pc.parking(cp, car);
		assertThat(car.getOrientation(), CoreMatchers.is(Orientation.NORTH));
		assertThat(car.getPositionX(), CoreMatchers.is(1));
		assertThat(car.getPositionY(), CoreMatchers.is(2));

		car.setPositionY(1);
		pc.parkingDistance(cp, car, 13);
		assertThat(car.getOrientation(), CoreMatchers.is(Orientation.NORTH));
		assertThat(car.getPositionX(), CoreMatchers.is(1));
		assertThat(car.getPositionY(), CoreMatchers.is(14));

	}

	@Test
	public void testOutOfBoundries() {
		try {
			car.setPositionX(1);
			car.setPositionY(1);
			car.setOrientation(Orientation.EAST);
			pc.parkingDistance(cp, car, 33);
		} catch (Exception e) {
			assertThat(e.getMessage(), CoreMatchers.is("Your car is out of boundries!"));
		}

		try {
			car.setPositionX(1);
			car.setPositionY(1);
			car.setOrientation(Orientation.NORTH);
			pc.parkingDistance(cp, car, 20);
		} catch (Exception e) {
			assertThat(e.getMessage(), CoreMatchers.is("Your car is out of boundries!"));
		}
	}

	@Test
	public void testTurnClockwise() {
		car.setPositionX(10);
		car.setPositionY(12);
		car.setOrientation(Orientation.EAST);
		pc.turnOrientation(car);
		assertThat(car.getOrientation(), CoreMatchers.is(Orientation.SOUTH));
		assertThat(car.getPositionX(), CoreMatchers.is(10));
		assertThat(car.getPositionY(), CoreMatchers.is(12));
		
		pc.turnOrientation(car);
		assertThat(car.getOrientation(), CoreMatchers.is(Orientation.WEST));
		assertThat(car.getPositionX(), CoreMatchers.is(10));
		assertThat(car.getPositionY(), CoreMatchers.is(12));
		
		pc.turnOrientation(car);
		assertThat(car.getOrientation(), CoreMatchers.is(Orientation.NORTH));
		assertThat(car.getPositionX(), CoreMatchers.is(10));
		assertThat(car.getPositionY(), CoreMatchers.is(12));
		
		pc.turnOrientation(car);
		assertThat(car.getOrientation(), CoreMatchers.is(Orientation.EAST));
		assertThat(car.getPositionX(), CoreMatchers.is(10));
		assertThat(car.getPositionY(), CoreMatchers.is(12));
	}

}
