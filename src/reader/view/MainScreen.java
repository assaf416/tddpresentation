package reader.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

@SuppressWarnings("unused")
public class MainScreen {

	private JFrame frmApplication;
	private JTable tblArticles;

	

	/**
	 * Create the application.
	 */
	public MainScreen() {
		initialize();
	}

	public JFrame getWindow(){
		return frmApplication;
	}
	
	public JTable getList(){
		return tblArticles;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {
		frmApplication = new JFrame();
		frmApplication.setTitle("RSS Reader");
		frmApplication.setResizable(true);
		frmApplication.setBounds(100, 100, 800, 600);
		frmApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		frmApplication.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JMenuBar menuBar = new JMenuBar();
		toolBar.add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewFeed = new JMenuItem("New Feed");
		mnFile.add(mntmNewFeed);
		
		JMenuItem mntmRefresh = new JMenuItem("Refresh");
		mnFile.add(mntmRefresh);
		
		JMenuItem mntmExport = new JMenuItem("Export");
		mnFile.add(mntmExport);
		
		JSeparator separator_1 = new JSeparator();
		mnFile.add(separator_1);
		
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mnFile.add(mntmQuit);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator);
		
		JSplitPane splitPane = new JSplitPane();

		frmApplication.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);
		
		JTree treeCategories = new JTree();
		treeCategories.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Categories") {
				{
					add(new DefaultMutableTreeNode("News"));
					add(new DefaultMutableTreeNode("Technology"));
					add(new DefaultMutableTreeNode("Sports"));
					add(new DefaultMutableTreeNode("Technologies"));
				}
			}
		));
		scrollPane.setViewportView(treeCategories);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(treeCategories, popupMenu);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setRightComponent(splitPane_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		splitPane_1.setLeftComponent(scrollPane_1);
		
		tblArticles = new JTable();
		scrollPane_1.setViewportView(tblArticles);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		splitPane_1.setRightComponent(scrollPane_2);
		
		JEditorPane htmlViewer = new JEditorPane();
		scrollPane_2.setViewportView(htmlViewer);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
