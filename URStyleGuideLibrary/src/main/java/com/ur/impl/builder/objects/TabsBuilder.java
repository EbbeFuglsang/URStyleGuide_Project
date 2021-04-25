package com.ur.impl.builder.objects;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.border.Border;

import com.ur.impl.builder.ITabsBuilder;
import com.ur.impl.ekstra.RectangleTabbedPaneLayout;

public class TabsBuilder extends BuilderLibrary implements ITabsBuilder {
	private JTabbedPane tabbedPane;
	private int width;

	public void buildComponent() {
		
		setFont();
		setBorder();
		setDimension();
		setColor();
	}

	private void setDimension() {
		Dimension dimension = new Dimension(width, urBorder.HEIGHT_MEDIUM);
		tabbedPane.setPreferredSize(dimension);
		tabbedPane.setMaximumSize(tabbedPane.getMaximumSize());

	}

	private void setFont() {
		Font font = new Font(urTypegraphy.FontFamilie_DejaVu, urTypegraphy.Bold, urTypegraphy.FONT_VERY_LARGE);
		tabbedPane.setFont(font);
	}

	private void setBorder() {
//		Border border = BorderFactory.createMatteBorder(0, 0, urBorder.BORDER_THIN, 0, urColorPalette.BLACK);
//		tabbedPane.setBorder(border);
		tabbedPane.setUI(new RectangleTabbedPaneLayout());

	}

	private void setColor() {
//		tabbedPane.setBackground(urColorPalette.WHITE);
//		tabbedPane.setForeground(urColorPalette.BLACK);
	}

	@Override
	public void build() {
		this.tabbedPane = new JTabbedPane();
		this.buildComponent();
	}

	@Override
	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public JTabbedPane getComponent() {
		return tabbedPane;
	}

}
