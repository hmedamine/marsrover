package com.github.javadojo;

import java.util.LinkedList;
import java.util.List;

/**
 * The Mars rover is programmed to drive around Mars. Its programming is very
 * simple. The commands are the following:
 * <dl>
 * <dt>s</dt>
 * <dd>drive in a straight line</dd>
 * <dt>r</dt>
 * <dd>turn right</dd>
 * <dt>l</dt>
 * <dd>turn left</dd>
 * </dl>
 *
 * Note that the Mars rover always land at the <code>X</code> and starts by
 * facing east.
 * 
 * The Mars rover can send a 2D string representation of its path back to
 * Mission Control. The following character are used with the following
 * meanings:
 * <dl>
 * <dt>X</dt>
 * <dd>where the Mars rover landed</dd>
 * <dt>*</dt>
 * <dd>current position of the Mars rover</dd>
 * <dt>-</dt>
 * <dd>path in the west-east direction</dd>
 * <dt>|</dt>
 * <dd>path in the north-south direction</dd>
 * <dt>+</dt>
 * <dd>a place where the Mars rover turned or a crossroad</dd>
 * <dt>S</dt>
 * <dd>a place where a sample was taken</dd>
 * </dl>
 */
public class MarsRover {

	static final String LINE_SEPARATOR = System.getProperty("line.separator");
	private List<Directions> positions;
	private Directions currentDirection;
	private static String startPosition = "X";

	public MarsRover(String operations) {
		currentDirection = Directions.east;
		positions = new LinkedList<Directions>();
		for (int i = 0; i < operations.length(); i++) {
			switch (operations.charAt(i)) {
			case 's':
				positions.add(currentDirection);
				moveForward();
				break;
			case 'r':
				positions.add(currentDirection);
				turnRight();
				break;
			case 'l':
				positions.add(currentDirection);
				turnLeft();
				break;
			}
		}
	}

	public String path() {
		StringBuilder path = new StringBuilder();
		path.append(startPosition);
		if (currentDirection.isLineChanged())
			startPosition = "*";
		for (Directions position : positions) {
			path.append(position.print());
		}
		path.deleteCharAt(path.length() - 1);
		path.append("*");
		path.append(LINE_SEPARATOR);
		return path.toString();
	}

	public MarsRover turnLeft() {
		currentDirection = currentDirection.moveToLeft();
		return this;
	}

	public MarsRover turnRight() {
		currentDirection = currentDirection.moveToRight();
		return this;
	}

	public MarsRover moveForward() {
		currentDirection = currentDirection.moveForward();
		return this;
	}

	public MarsRover takeSample() {
		throw new IllegalStateException("Not implemented");
	}
}
