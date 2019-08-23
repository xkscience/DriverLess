package com.xkscience.driverless;

public class MyDreamCar implements Car {
	private int positionX;
	private int positionY;
	private Orientation orientation;

	public MyDreamCar() {

	}

	public MyDreamCar(int positionX, int positionY, Orientation orientation) {
		this.positionX = positionX;
		this.positionY = positionY;
		this.orientation = orientation;
	}

	public int getPositionX() {
		return this.positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return this.positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public Orientation getOrientation() {
		return this.orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public void move() {
		switch (this.orientation) {
		case EAST:
			this.positionX += 1;
			break;
		case WEST:
			this.positionX -= 1;
			break;
		case SOUTH:
			this.positionY -= 1;
			break;
		case NORTH:
			this.positionY += 1;
			break;
		default:
			break;

		}
	}

	public void move(int steps) {
		if (steps < 0) {
			System.out.println("Please drive your car forward, currently the car doesn't support astern running!");
			return;
		}
		for (int i = 0; i < steps; i++) {
			move();
		}
	}

	public void move(Orientation ori, int steps) {
		this.orientation = ori;
		move(steps);
	}

	public void turnClockwise() {
		switch (this.orientation) {
		case EAST:
			this.orientation = Orientation.SOUTH;
			break;
		case SOUTH:
			this.orientation = Orientation.WEST;
			break;
		case WEST:
			this.orientation = Orientation.NORTH;
			break;
		case NORTH:
			this.orientation = Orientation.EAST;
			break;
		default:
			break;
		}
	}

	@Override
	public String toString() {
		return "MyDreamCar [positionX=" + positionX + ", positionY=" + positionY + ", orientation=" + orientation + "]";
	}

}
