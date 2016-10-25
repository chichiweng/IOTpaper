package Map;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.event.MouseInputListener;

class TestTree extends JComponent implements MouseInputListener {
	WarehouseMap map;

	public TestTree() {
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		File file = new File("Map.txt");

		if (!file.exists()) {
			map = new WarehouseMap(1, 1, 3, 3); // 前面要空多少? i,j 你要幾格 i,j
		} else {
			try {
				map = WarehouseMap.input(file);
			} catch (ClassNotFoundException | IOException e) {
				map = new WarehouseMap(1, 1, 3, 3);
			}
		}
	}

	@Override
	public void paintComponent(Graphics g) { // 印出整個地圖
		requestFocusInWindow();
		map.print(g);
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		map.pressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		map.released(e);
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		;
	}

	@Override
	public void mouseExited(MouseEvent e) {
		map.output();
		String[][] edges = TreeBuilder.BuilderTree(map);
//		PathDistance.detail(edges);
		TreeBuilder.detail(edges);
		//pd.detail();
		// for(int i=0;i<edges.length;i++ ){
		// for(int j=0;j<edges[i].length;j++ ){
		// System.out.print(edges[i][j]+" ");
		// }
		// System.out.println();
		// }
		// System.out.println();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		map.dragged(e);
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		;
	}

}