import java.util.*;
class Solution {
    public int solution(String dirs) {
       List<Line> lines = new ArrayList<>();
		Coordinate from = new Coordinate(0, 0);

		for (char c : dirs.toCharArray()) {
			Coordinate to = new Coordinate(from.x, from.y);
			switch(c) {
				case 'U':
					to.move(0, 1);
					break;
				case 'D':
					to.move(0, -1);
					break;
				case 'R':
					to.move(1, 0);
					break;
				case 'L':
					to.move(-1, 0);
					break;
				default:
			}

			if(to.x > 5 || to.x < -5 || to.y >5 || to.y < -5) {
				continue;
			}

			addLine(lines, new Line(from, to));
			from = new Coordinate(to.x, to.y);

		}


		return lines.size();
    }
    
    public void addLine(List<Line> lines, Line line) {


		for(Line l: lines) {
			if(l.equals(line)) {
				return;
			}
		}

		lines.add(line);


	}
}

class Coordinate {
	int x;
	int y;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Coordinate)) {
			return false;
		}

		Coordinate target = (Coordinate)obj;

		return this.x == target.x && this.y == target.y;
	}

	public void move(int amountX, int amountY) {
		this.x += amountX;
		this.y += amountY;
	}
}

class Line {
	Coordinate a;
	Coordinate b;

	public Line(Coordinate a, Coordinate b) {
		this.a = a;
		this.b = b;
	}

	public Line(int ax, int ay, int bx, int by) {
		this.a = new Coordinate(ax, ay);
		this.b = new Coordinate(bx, by);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Line)) {
			return false;
		}

		Line target = (Line)obj;
		return target.a.equals(this.a) && target.b.equals(this.b)
			|| target.b.equals(this.a) && target.a.equals(this.b);
	}
}
