package reader.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

@SuppressWarnings("serial")
public class CategoryDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCategory;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		
//	}

	/**
	 * Create the dialog.
	 */
	public CategoryDialog() {
		setBounds(100, 100, 450, 150);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{89, 132, 134, 0};
		gbl_contentPanel.rowHeights = new int[]{28, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblEnterCategoryName = new JLabel("Enter Category Name");
			GridBagConstraints gbc_lblEnterCategoryName = new GridBagConstraints();
			gbc_lblEnterCategoryName.anchor = GridBagConstraints.WEST;
			gbc_lblEnterCategoryName.insets = new Insets(0, 0, 0, 5);
			gbc_lblEnterCategoryName.gridx = 1;
			gbc_lblEnterCategoryName.gridy = 3;
			contentPanel.add(lblEnterCategoryName, gbc_lblEnterCategoryName);
		}
		{
			txtCategory = new JTextField();
			GridBagConstraints gbc_txtCategory = new GridBagConstraints();
			gbc_txtCategory.anchor = GridBagConstraints.NORTHWEST;
			gbc_txtCategory.gridx = 2;
			gbc_txtCategory.gridy = 3;
			contentPanel.add(txtCategory, gbc_txtCategory);
			txtCategory.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
