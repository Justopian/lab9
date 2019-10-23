// Lab 9: 5-4
// Justin Varga

import images.*;
import java.lang.Math;

public class Sepia
{
	public static void main(String[] args)
	{
		// Take input
		APImage image = new APImage("toucan.jpg");
		image.draw();
		APImage sepiaCopy = image.clone();
		
		for (Pixel p : sepiaCopy)
		{
			// Make Grayscale
			int red = p.getRed();
			int green = p.getGreen();
			int blue = p.getBlue();
			
			int average = (int)((red + green + blue) / 3.0 + 0.5);
			
			red = average;
			green = average;
			blue = average;
			
			// Make Sepia
			if (red < 63)
			{
				red = (int)(red * 1.1);
				blue = (int)(blue * 0.9);
			}
			else if (red < 192)
			{
				red = (int)(red * 1.15);
				blue = (int)(blue * 0.85);
			}
			else
			{
				red = Math.min((int)(red * 1.08), 255);
				blue = (int)(blue * 0.93);
			}
			
			p.setRed(red);
			p.setGreen(green);
			p.setBlue(blue);
		}
		
		
		// Show the sepia-ized image
		sepiaCopy.draw();
		//sepiaCopy.save();
	}
}
