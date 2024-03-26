package lab6;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import plotter.Plotter;
import plotter.Polyline;

public class ArrayPlotting {
	private static Polyline parseOneLine(String line) {
		int width = 1;
		Scanner scnr = new Scanner(line);

		// checking for width integer
		if (scnr.hasNextInt()) {
			width = scnr.nextInt();
		}

		// grabbing color out of string
		Polyline poly = new Polyline(scnr.next(), width);
		while (scnr.hasNextInt()) {
			int x = scnr.nextInt();
			int y = scnr.nextInt();
			poly.addPoint(new Point(x, y));
		}
		scnr.close();
		return poly;
	}

	private static ArrayList<Polyline> readFile(String filename) throws FileNotFoundException {
		ArrayList<Polyline> arr = new ArrayList<Polyline>();

		File file = new File(filename);
		Scanner scnr = new Scanner(file);
		while (scnr.hasNextLine()) {
			String line = scnr.nextLine();
			if ((line.trim()).length() != 0 && line.charAt(0) != '#') {
				arr.add(parseOneLine(line));
			}
			
		}
		return arr;

	}

	public static void main(String[] args) throws FileNotFoundException
	  {
	    ArrayList<Polyline> list = readFile("hello.txt");
	    Plotter plotter = new Plotter();

	    for (Polyline p : list)
	    {
	      plotter.plot(p);
	    }
	  }
}
