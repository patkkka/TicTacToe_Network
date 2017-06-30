package com.javaAcademy.OXGame.model.directions;

import com.javaAcademy.OXGame.model.Direction;
import com.javaAcademy.OXGame.model.Point;

public class VerticalDirection implements Direction{

	@Override
	public Point getNextPoint(int x, int y) {
		y++;
		return new Point(x,y);
	}

}
