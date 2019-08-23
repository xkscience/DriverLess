package com.xkscience.driverless;

public class ParkingCar {
	private boolean checkOutOfBoundries(CarPark cp, Car car) throws Exception{
		if (car.getPositionX() <= 0 || car.getPositionX() >= cp.getLength() || car.getPositionY() <= 0
				|| car.getPositionY() >= cp.getWidth()) {
			throw new RuntimeException("Your car is out of boundries!");
		}
		return false;
	}

	public void parking(CarPark cp, Car car) throws Exception{
		checkOutOfBoundries(cp, car);
		car.move();
		checkOutOfBoundries(cp, car);
	}

	public void parkingDistance(CarPark cp, Car car, int distance) throws Exception {
		if (distance < 0) {
			throw new RuntimeException("Distance must be positive!");
		}
		for (int i = 0; i < distance; i++) {
			parking(cp, car);
		}
	}

	public void turnOrientation(Car car) {
		car.turnClockwise();
	}

	private void reportCarPosition(Car car) {
		System.out.println(car);
	}
	public static void main(String[] args) {
		Car car = new MyDreamCar(1, 1, Orientation.EAST);
		CarPark cp = new CarPark(40, 30);
		ParkingCar pc = new ParkingCar();
		try {
			pc.parking(cp, car);
			pc.reportCarPosition(car);
			pc.parkingDistance(cp, car, 28);
			pc.reportCarPosition(car);
			pc.turnOrientation(car);
			pc.reportCarPosition(car);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
