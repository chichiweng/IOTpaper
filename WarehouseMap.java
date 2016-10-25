package Map;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class WarehouseMap implements Serializable {
   public int[][] map;
   int STARTX = 50;
   int STARTY = 50;
   static int h = 20;
   int edgesX;
   int edgesY;

   // for dragged
   int oldI;
   int oldJ;
   int temI;
   int temJ;
   boolean isDragged = false;
   
   public WarehouseMap(int startI, int startJ, int i, int j) {
      STARTX = startJ * h;
      STARTY = startI * h;
      edgesX = (j + startJ) * h;
      edgesY = (i + startI) * h;
      map = new int[i][j];
   }

   public void print(Graphics g) {
      int n = map.length;
      int n2 = map[0].length;

      for (int i = 0; i <= n; i++) {
         g.drawLine(STARTX, STARTY + i * h, STARTX + h * n2, STARTY + i * h);//畫----
      }

      for (int j = 0; j <= n2; j++) {
         g.drawLine(STARTX + j * h, STARTY, STARTX + h * j, STARTY + n * h);// 畫||||
      }

      n = map.length;
      n2 = map[0].length;
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n2; j++) {
            if (map[i][j] == 1) {
               g.setColor(Color.BLACK);
               g.fillRect(STARTX + j * h, STARTY + i * h, h, h);
               g.setColor(Color.WHITE);
               g.drawRect(STARTX + j * h, STARTY + i * h, h, h);
            } else if (map[i][j] == 2) {
               g.setColor(Color.GRAY);
               g.fillRect(STARTX + j * h, STARTY + i * h, h, h);
               g.setColor(Color.WHITE);
               g.drawRect(STARTX + j * h, STARTY + i * h, h, h);
            }
//            System.out.print(map[i][j] + " ");
         }
//         System.out.println();
      }
      if (isDragged) {
//          System.out.println("========");
          for (int i = oldI; i <= temI; i++) {
             for (int j = oldJ; j <= temJ; j++) {
                g.setColor(new Color(255, 246, 143, 100));
                g.fillRect(STARTX + j * h, STARTY + i * h, h, h);
                // System.out.println(i + "_" + j);
             }
             // System.out.println();
          }
       }
   }

   public int[][] getMap() {
      return map;
   }

   public void pressed(MouseEvent e) {
	      int x = e.getX();
	      int y = e.getY();
	      if (x >= STARTX && y >= STARTY && x < edgesX && y < edgesY) {
	         int i = (y - STARTY) / h;
	         int j = (x - STARTX) / h;
	         oldI = i;
	         oldJ = j;
//	         System.out.println(i + " " + j);
	      }
	   }

	   public void dragged(MouseEvent e) {
	      int x = e.getX();
	      int y = e.getY();
	      if (x >= STARTX && y >= STARTY && x < edgesX && y < edgesY) {
	         int i = (y - STARTY) / h;
	         int j = (x - STARTX) / h;
	         this.temI = i;
	         this.temJ = j;
	         System.out.println(i + " " + j);
	         isDragged = true;
	      }
	   }

	   public void released(MouseEvent e) {
	      int x = e.getX();
	      int y = e.getY();
	      if (x >= STARTX && y >= STARTY && x < edgesX && y < edgesY) {
	         int i = (y - STARTY) / h;
	         int j = (x - STARTX) / h;
	         System.out.println(i + " " + j);
	         for (int k1 = oldI; k1 <= i; k1++) {
	            for (int k2 = oldJ; k2 <= j; k2++) {
	               switch (e.getButton()) {
	               case MouseEvent.BUTTON1:
	                  map[k1][k2] = 1;
	                  break;
	               case MouseEvent.BUTTON2:
	                  map[k1][k2] = 2;
	                  break;
	               case MouseEvent.BUTTON3:
	                  map[k1][k2] = 0;
	                  break;
	               }
	            }
	         }
	      }
	      isDragged = false;
	   }
   
   public void output() {
      try {
         ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("Map.txt")));
         out.writeObject(this);
         out.close();
      } catch (IOException e) {
      }
   }

   public static WarehouseMap input(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
      WarehouseMap map = null;
      ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
      map = (WarehouseMap) in.readObject();
      in.close();
      return map;
   }
}