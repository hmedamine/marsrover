package com.github.javadojo;

import static com.github.javadojo.MarsRover.LINE_SEPARATOR;

public enum Directions {
	east {
		@Override
		String print() {
			return "-";
		}

		@Override
		Directions moveToLeft() {
			return south;
		}

		@Override
		Directions moveToRight() {
			return north;
		}

		@Override
		Directions moveForward() {
			return east;
		}

		@Override
		boolean isLineChanged() {
			return false;
		}
	},
	west {
		@Override
		String print() {
			return "-";
		}

		@Override
		Directions moveToLeft() {
			return south;
		}

		@Override
		Directions moveToRight() {
			return north;
		}

		@Override
		Directions moveForward() {
			return west;
		}

		@Override
		boolean isLineChanged() {
			return false;
		}
	},
	south {
		@Override
		String print() {
			return "|" + LINE_SEPARATOR;
		}

		@Override
		Directions moveToLeft() {
			return east;
		}

		@Override
		Directions moveToRight() {
			return west;
		}

		@Override
		Directions moveForward() {
			return south;
		}

		@Override
		boolean isLineChanged() {
			return true;
		}
	},
	north {
		@Override
		String print() {
			return "|" + LINE_SEPARATOR;
		}

		@Override
		Directions moveToLeft() {
			return east;
		}

		@Override
		Directions moveToRight() {
			return west;
		}

		@Override
		Directions moveForward() {
			return north;
		}

		@Override
		boolean isLineChanged() {
			return true;
		}
	};

	abstract String print();

	abstract Directions moveToLeft();

	abstract Directions moveToRight();

	abstract Directions moveForward();

	abstract boolean isLineChanged();
}
