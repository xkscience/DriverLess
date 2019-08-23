package com.xkscience.driverless;

public interface Car {
	void move();

	int getPositionX();

	void setPositionX(int x);

	int getPositionY();

	void setPositionY(int y);

	Orientation getOrientation();

	void setOrientation(Orientation ori);

	void turnClockwise();
}
