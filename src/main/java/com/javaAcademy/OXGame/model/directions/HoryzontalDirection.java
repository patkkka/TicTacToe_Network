package com.javaAcademy.OXGame.model.directions;

import com.javaAcademy.OXGame.model.Direction;
import com.javaAcademy.OXGame.model.Point;

public class HoryzontalDirection implements Direction{

	@Override
	public Point getNextPoint(int x, int y) {
		x++;
		return new Point(x,y);
	}

}
