package com.ur.impl.ekstra;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;

import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

import com.ur.style.URColorPalette;
import com.ur.impl.builder.objects.BuilderLibrary;

public class RectangleTabbedPaneLayout extends BasicTabbedPaneUI {
	private URColorPalette urColorPalette = new URColorPalette();

	private static final int ADJ2 = 3;
	private Color selectedColor = urColorPalette.UR_BLUE;
	private Color unselectedColor = urColorPalette.WHITE;
	private Color borderColor = urColorPalette.BLACK;

	@Override
	public int  calculateTabHeight(int arg0, int arg1, int arg2) {
		return 40;//urBorder.HEIGHT_MEDIUM;		
	}
	
	@Override
	public int  calculateTabWidth(int arg0, int arg1, FontMetrics arg2) {
		
		return 165;//urBorder.HEIGHT_MEDIUM;		
	}

	
	@Override
	protected void paintTabArea(Graphics g, int tabPlacement, int selectedIndex) {
		int tabCount = tabPane.getTabCount();
		Rectangle iconRect = new Rectangle(), textRect = new Rectangle();
		Rectangle clipRect = g.getClipBounds();
		//this.calculateTabWidth(arg0, arg1, arg2)
		for (int i = runCount - 1; i >= 0; i--) {
			int start = tabRuns[i];
			int next = tabRuns[(i == runCount - 1) ? 0 : i + 1];
			int end = next != 0 ? next - 1 : tabCount - 1; // NOPMD
			for (int j = end; j >= start; j--) {
				if (j != selectedIndex && rects[j].intersects(clipRect)) {
					paintTab(g, tabPlacement, rects, j, iconRect, textRect);
				}
			}
		}
		if (selectedIndex >= 0 && rects[selectedIndex].intersects(clipRect)) {
			paintTab(g, tabPlacement, rects, selectedIndex, iconRect, textRect);
		}

	}

	@Override
	protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h,
			boolean isSelected) {
		// Do nothing
	}

	@Override
	protected void paintFocusIndicator(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex,
			Rectangle iconRect, Rectangle textRect, boolean isSelected) {
		// Do nothing
	}

	@Override
	protected void paintContentBorderTopEdge(Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w,
			int h) {
		super.paintContentBorderTopEdge(g, tabPlacement, selectedIndex, x, y, w, h);
		Rectangle selRect = getTabBounds(selectedIndex, calcRect);
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setColor(urColorPalette.BLACK);
//		g2.drawLine(selRect.x - ADJ2 + 1, y, selRect.x + selRect.width + ADJ2 - 1, y);
//		g2.drawLine(selRect.x, selRect.y, selRect.width, selRect.height);
		g2.drawLine(x, y, x+w, y);
		g2.dispose();
	}

	@Override
	protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h,
			boolean isSelected) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int textShiftOffset = isSelected ? 0 : 1;

		Rectangle clipRect = g2.getClipBounds();
		clipRect.grow(ADJ2 + 1, 0);
		g2.setClip(clipRect);

		GeneralPath rectangle = new GeneralPath();
		rectangle.moveTo(x, y);
		rectangle.lineTo(x, y + h);
		rectangle.lineTo(x + w, y + h);
		rectangle.lineTo(x + w, y);
		rectangle.closePath();

		g2.setColor(isSelected ? selectedColor : unselectedColor);
		g2.fill(rectangle);

		g2.setColor(urColorPalette.WHITE);
		
		g2.draw(rectangle);

		g2.dispose();
	}

}
