package com.javaAcademy.OXGame.model.directions;

import com.javaAcademy.OXGame.model.Direction;
import com.javaAcademy.OXGame.model.Point;

public class DescendingDirection implements Direction{

	@Override
	public Point getNextPoint(int x, int y) {
		x++;
		y++;
		return new Point(x,y);
	}

}
