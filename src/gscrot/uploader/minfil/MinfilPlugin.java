package gscrot.uploader.minfil;

import gscrot.api.Plugin;

import com.redpois0n.gscrot.CaptureUploader;

public class MinfilPlugin extends Plugin {

	public MinfilPlugin() {
		super("Minfil");
		CaptureUploader.addUploader(new MinfilUploader());
	}

}
