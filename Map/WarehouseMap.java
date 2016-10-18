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
   static int STARTX = 50;
   static int STARTY = 50;
   static int h = 50;
   int edgesX;
   int edgesY;

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
         g.drawLine(STARTX, STARTY + i * h, STARTX + h * n2, STARTY + i * h);// 畫----
      }

      for (int j = 0; j <= n2; j++) {
         g.drawLine(STARTX + j * h, STARTY, STARTX + h * j, STARTY + n * h);// 畫|
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
            }
            System.out.print(map[i][j] + " ");
         }
         System.out.println();
      }
      System.out.println();
   }

   public int[][] getMap() {
      return map;
   }

   public void Click(MouseEvent e) {
      int x = e.getX();
      int y = e.getY();
      if (x >= STARTX && y >= STARTY && x <= edgesX && y <= edgesY) {
         int i = (y - STARTY) / h;
         int j = (x - STARTX) / h;
         if (map[i][j] != 1) {
            map[i][j] = 1;
         }
      }
   }
   
   public void Undo(MouseEvent e) {
      int x = e.getX();
      int y = e.getY();
      if (x >= STARTX && y >= STARTY && x <= edgesX && y <= edgesY) {
         int i = (y - STARTY) / h;
         int j = (x - STARTX) / h;
         if (map[i][j] != 0) {
            map[i][j] = 0;
         }
      }
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