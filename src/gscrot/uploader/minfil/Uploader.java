package gscrot.uploader.minfil;

import iconlib.IconUtils;

import java.awt.image.BufferedImage;

import com.redpois0n.gscrot.CaptureUploader;

public class Uploader extends CaptureUploader {
	
	public Uploader() {
		super("Minfil", IconUtils.getIcon("minfil", Uploader.class));
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
