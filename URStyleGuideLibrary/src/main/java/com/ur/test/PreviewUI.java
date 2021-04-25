package com.ur.test;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.ur.style.URColorPalette;
import com.ur.style.URIcon;
import com.ur.style.URLayout;
import com.ur.style.URSpacingSize;
import com.ur.style.URTypegraphy;
import com.ur.style.components.URButtons;
import com.ur.style.components.URDivider;
import com.ur.style.components.URDropdowns;
import com.ur.style.components.URErrorMessage;
import com.ur.style.components.URInformativeMessage;
import com.ur.style.components.URLoadingBar;
import com.ur.style.components.URSliders;
import com.ur.style.components.URSpacing;
import com.ur.style.components.URSuccessMessage;
import com.ur.style.components.URTables;
import com.ur.style.components.URTabs;
import com.ur.style.components.URTextFields;
import com.ur.style.components.URToggles;
import com.ur.style.components.URWarningMessage;

public class PreviewUI {

	private URColorPalette urColorPalette = new URColorPalette();
	private URTypegraphy urTypegraphy = new URTypegraphy();
	private URLayout urLayout = new URLayout();
	
	private URToggles toggleLib = new URToggles();
	private URButtons buttonLib = new URButtons();
	private URInformativeMessage informativeMessage = new URInformativeMessage();
	private URSuccessMessage successMessage = new URSuccessMessage();
	private URErrorMessage errorMessage = new URErrorMessage();
	private URWarningMessage warningMessage = new URWarningMessage();
	private URDivider divider = new URDivider();
	private URDropdowns dropdown = new URDropdowns();
	private URLoadingBar loadingbar = new URLoadingBar();
	private URSliders slider = new URSliders();
	private URTables tables = new URTables();
	private URTabs tabs = new URTabs();
	private URTextFields textFields = new URTextFields();
	
	private URSpacingSize urSpacingSize = new URSpacingSize();
	private URSpacing urSpacing = new URSpacing();
//	private URIcon iconLib = new URIcon();
	

	public PreviewUI() {

	}

	public static void main(String args[]) {
		
		PreviewUI previewUI = new PreviewUI();	
		//Initialize the program node panel.
		JPanel panel = previewUI.ProgramNodePanel("Example ProgramNode");
		
		
		System.out.println("main !");
		
		panel.add(previewUI.exampleTabs(previewUI));
		//adds the panel to be able to preview.
		previewUI.PreviewProgramNodeUI(panel);
		
	}
	
	
	private Box exampleTabs(PreviewUI previewUI) {
		Box box = Box.createHorizontalBox();
		box.setAlignmentX(Component.LEFT_ALIGNMENT);

		JTabbedPane tabPane = tabs.getTabbedPane(100);
		JPanel buttonPanel = previewUI.URPanel();
		JPanel dropDownPanel = previewUI.URPanel();
		JPanel slidersPanel = previewUI.URPanel();
		JPanel progressPanel = previewUI.URPanel();
		JPanel messagesPanel = previewUI.URPanel();
		JPanel tabelsPanel = previewUI.URPanel();
		
		
		
		buttonPanel.add(showButtons());
		dropDownPanel.add(this.showDropdowns());
		slidersPanel.add(this.showSlider());
		progressPanel.add(this.showLoadingBar());
		messagesPanel.add(this.showDifferentMessageType());
		tabelsPanel.add(this.showTables());

		
		tabPane.addTab("Buttons", buttonPanel);
		tabPane.addTab("DropDown", dropDownPanel);
		tabPane.addTab("Sliders", slidersPanel);
		tabPane.addTab("Progress", progressPanel);
		tabPane.addTab("Messages", messagesPanel);
		tabPane.addTab("Tabels", tabelsPanel);

		/*
		JLabel lab = new JLabel("Buttons");
		lab.setPreferredSize(new Dimension(165, 40));
		tabPane.setTabComponentAt(0, lab);		
		*/
		box.add(tabPane);

		return box;
	}	
	
	private Box showDropdowns() {
		Box box = Box.createVerticalBox();
		box.setAlignmentX(Component.LEFT_ALIGNMENT);
		String[] stringValues = {"A","B","C"};
		
		JComboBox<String> boxEnabled = dropdown.getDropDownEnabled(100);
		boxEnabled.setModel(new DefaultComboBoxModel<String>(stringValues));
		
		JComboBox<String> boxDisabled = dropdown.getDropDownDisabled(100);
		boxDisabled.setModel(new DefaultComboBoxModel<String>(stringValues));
		
		box.add(boxEnabled);
		box.add(urSpacing.createVerticalSpacing(urSpacingSize.VERTICAL_SPACING));
		box.add(boxDisabled);
		
		return box;
	}	
	
	public Box showTextFields() {
		Box box = Box.createHorizontalBox();
		box.setAlignmentX(Component.LEFT_ALIGNMENT);
		JTextField fieldEnabled = textFields.getTextFieldEnabled(100);
		JTextField fieldDisabled = textFields.getTextFieldDisabled(100);
		
		fieldDisabled.setText("300");
		fieldEnabled.setText("300");
		
		box.add(fieldEnabled);
		box.add(urSpacing.createVerticalSpacing(urSpacingSize.VERTICAL_SPACING));
		box.add(fieldDisabled);
		
		return box;
		
	}
	
	//The UI on main() does not look like the UR simulator...
	public Box showTabs() {
		Box box = Box.createHorizontalBox();
		box.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		JTabbedPane tabPane = tabs.getTabbedPane(100);
		tabPane.addTab("Command", new JPanel());
		tabPane.addTab("Graphics", new JPanel());
		tabPane.addTab("Variables", new JPanel());
		
		box.add(tabPane);
		
		return box;
	}
	
	
	public Box showTables() {
		Box box = Box.createHorizontalBox();
		box.setAlignmentX(Component.LEFT_ALIGNMENT);

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("test1");
		model.addRow(new String[] { "2018-02-06- 09:09:52.057 PolyScope        URSoftware 5.0.0" });
		model.addRow(new String[] { "2018-02-06- 09:09:52.057 PolyScope        Connected to Controller" });
		model.addRow(new String[] { "2018-02-06- 09:09:52.057 PolyScope        URSoftware 5.0.0 (26.10.2017)" });
		model.addRow(new String[] { "2018-02-06- 09:09:52.057 PolyScope        URSoftware 5.0.0 (26.10.2017)" });
		model.addRow(new String[] { "2018-02-06- 09:09:52.057 PolyScope        Safety checksum changed to: CCCC" });
		JTable table = tables.getTable();
		table.setModel(model);

		box.add(table);

		return box;
	}
	
	//The UI on main() does not look like the UR simulator...
	public Box showSlider() {
		Box box = Box.createHorizontalBox();
		box.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		JSlider valueSlider = slider.getSlider(0, 99, 200);
		
		box.add(valueSlider);
		
		return box;
	}
	
	//The border is not colored correct in the main()!
	public Box showLoadingBar(){
		Box box = Box.createVerticalBox();
		box.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		JProgressBar thinLoadingbar = loadingbar.getThinLoadingBar(300);
		thinLoadingbar.setIndeterminate(true);
		thinLoadingbar.setMaximum(100);
		thinLoadingbar.setValue(50);
		thinLoadingbar.setIndeterminate(false);
		
		JProgressBar thickLoadingbar = loadingbar.getThickLoadingBar(300);
		thickLoadingbar.setIndeterminate(true);
		thickLoadingbar.setMaximum(100);
		thickLoadingbar.setValue(50);
		thickLoadingbar.setIndeterminate(false);
		
		JProgressBar thinLoadingbarWithText = loadingbar.getThinLoadingBarWithText(300, "12.00 mA");
		//thinLoadingbarWithText.setStringPainted(true);
		thinLoadingbarWithText.setIndeterminate(true);
		thinLoadingbarWithText.setMaximum(100);
		thinLoadingbarWithText.setValue(50);
		thinLoadingbarWithText.setIndeterminate(false);
		
		box.add(thinLoadingbar);
		box.add(urSpacing.createVerticalSpacing(urSpacingSize.VERTICAL_SPACING));
		box.add(thinLoadingbarWithText);
		box.add(urSpacing.createVerticalSpacing(urSpacingSize.VERTICAL_SPACING));
		box.add(thickLoadingbar);
		
		return box;
	}
	
	// needs color correction...
	public Box showDivider() {
		Box box = Box.createVerticalBox();
		box.setAlignmentX(Component.LEFT_ALIGNMENT);
		box.add(divider.getVerticalDivider(100));
		box.add(urSpacing.createVerticalSpacing(urSpacingSize.VERTICAL_SPACING));
		box.add(divider.getHorizontalDivider(100));
		
		
		return box;
	}
	
	
	
	public Box showDifferentMessageType() {
		
		Box box = Box.createVerticalBox();
		box.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		box.add(informativeMessage.getLargeInformativeMessage("INFO MESSAGE", 600));
		box.add(urSpacing.createVerticalSpacing(urSpacingSize.VERTICAL_SPACING));
		box.add(informativeMessage.getSmallInformativeMessage("Changes do not take effect until saving the installation", 600));
		
		box.add(urSpacing.createVerticalSpacing(urSpacingSize.VERTICAL_SPACING));
		
		box.add(successMessage.getLargeSuccessMessage("SUCCESS MESSAGE", 600));
		box.add(urSpacing.createVerticalSpacing(urSpacingSize.VERTICAL_SPACING));
		box.add(successMessage.getSmallSuccessMessage("Success Message", 600));
		
		box.add(urSpacing.createVerticalSpacing(urSpacingSize.VERTICAL_SPACING));
		
		box.add(errorMessage.getLargeErrorMessage("NO CONTROLLER", 600));
		box.add(urSpacing.createVerticalSpacing(urSpacingSize.VERTICAL_SPACING));
		box.add(errorMessage.getSmallErrorMessage("Error Message", 600));
		
		box.add(urSpacing.createVerticalSpacing(urSpacingSize.VERTICAL_SPACING));
		
		box.add(warningMessage.getLargeWarningMessage("BACKDRIVE", 600));
		box.add(urSpacing.createVerticalSpacing(urSpacingSize.VERTICAL_SPACING));
		box.add(warningMessage.getSmallWarningMessage("Warning Message", 600));
		
		return box;
		
	}

	public Box showToggles() {
		
		Box box = Box.createVerticalBox();
		box.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		box.add(toggleLib.getLargeToggleEnabled("Enable", 200));
		box.add(urSpacing.createVerticalSpacing(urSpacingSize.VERTICAL_SPACING));
		box.add(toggleLib.getLargeToggleDisabled("Disable", 200));

		box.add(urSpacing.createVerticalSpacing(urSpacingSize.VERTICAL_SPACING));

		JToggleButton toggle = toggleLib.getSmallToggleSelected(50);
//		toggle.setIcon(iconLib.warning_icon_small);

		box.add(toggle);
		box.add(urSpacing.createVerticalSpacing(urSpacingSize.VERTICAL_SPACING));
		box.add(toggleLib.getSmallToggleDeselected(50));
		
		return box;
	}

	public Box showButtons() {
		
		Box box = Box.createVerticalBox();
		box.setAlignmentX(Component.LEFT_ALIGNMENT);

		box.add(buttonLib.getLargeButtonDisabled("MyLarge", 200));
		box.add(urSpacing.createVerticalSpacing(urSpacingSize.VERTICAL_SPACING));
		box.add(buttonLib.getLargeButtonEnabled("MyCTAButtonMedium", 200));

		box.add(urSpacing.createVerticalSpacing(urSpacingSize.VERTICAL_SPACING));

		box.add(buttonLib.getSmallButtonEnabled("MySmallButtonMedium", 200));
		box.add(urSpacing.createVerticalSpacing(urSpacingSize.VERTICAL_SPACING));
		box.add(buttonLib.getSmallButtonDisabled("MySmallButtonMedium", 200));

		box.add(urSpacing.createVerticalSpacing(urSpacingSize.VERTICAL_SPACING));

		box.add(buttonLib.getMediumCTAButtonDisabled("MyCTAButtonMedium", 200));
		box.add(urSpacing.createVerticalSpacing(urSpacingSize.VERTICAL_SPACING));
		box.add(buttonLib.getSmallCTAButtonEnabled("MyCTAButtonMedium", 200));
		
		
		return box;

	}
	
	
	//**______________________________________________________
	

	/**
	 * This method lets the user preview the UI without the simulator or ur robot.
	 * @param panel that contains the UI components.
	 */
	public void PreviewProgramNodeUI(JPanel panel) {
		JFrame frame = new JFrame("ProgramNode Preview");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.pack();
		
		frame.setSize(new Dimension(urLayout.programWidth, urLayout.programHeight));
		frame.setVisible(true);

	}

	/**
	 * This method is for adding components to the UI.
	 * @param programNodeTitle is the title of the program node. The name can be found in ProgramNodeService class.
	 * under the getTitle method.
	 * @return a reconfigured panel for adding the components.
	 */
	public JPanel ProgramNodePanel(String programNodeTitle) {
		JPanel panel = URPanel();

		panel.setBorder(new EmptyBorder(new Insets(0, 17, 0, 17)));
		
		JLabel label = new JLabel(programNodeTitle);
		label.setFont(panel.getFont());

		Box box = Box.createHorizontalBox();
		box.setAlignmentX(Component.LEFT_ALIGNMENT);
		box.add(label);
		box.add(Box.createRigidArea(new Dimension(0, 75)));

		panel.add(box);

		return panel;

	}
	
	public JPanel URPanel() {
		JPanel panel = new JPanel();

		Font font = new Font(urTypegraphy.FontFamilie_DejaVu, urTypegraphy.Bold, urTypegraphy.FONT_MAIN_HEADING_SIZE);
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

		panel.setBackground(urColorPalette.WHITE);
		panel.setForeground(urColorPalette.BLACK);
		panel.setFont(font);

		panel.setLayout(boxlayout);
		return panel;

	}	
	
	

}
