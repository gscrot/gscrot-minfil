package gscrot.uploader.minfil;

import iconlib.IconUtils;

import java.awt.image.BufferedImage;

import com.redpois0n.gscrot.CaptureUploader;

public class MinfilUploader extends CaptureUploader {
	
	public MinfilUploader() {
		super("Minfil", IconUtils.getIcon("minfil", MinfilUploader.class));
	}

	@Override
	public void process(BufferedImage image) {
		try {
			System.out.println(Minfil.upload(image));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
