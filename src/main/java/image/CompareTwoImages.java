package image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.testng.annotations.Test;

import com.google.common.annotations.VisibleForTesting;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class CompareTwoImages {

	@Test
	public void compairTwoimages() throws IOException
	{
		String imagen1= System.getProperty("user.dir")+"/testData/person1.jpg";
		String imagen2= System.getProperty("user.dir")+"/testData/person2.jpg";
		
		File file1 =new File(imagen1);
		File file2 =new File(imagen2);
		
		BufferedImage expectedImage = ImageIO.read(file1);
		BufferedImage actualImage = ImageIO.read(file2);
		
		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff = imgDiff.makeDiff(expectedImage, actualImage);
		
		if(diff.hasDiff()) {
			System.out.println("Images are different");
		}
		else
		{
			System.out.println("Images are same");
		}
	}
	
}
