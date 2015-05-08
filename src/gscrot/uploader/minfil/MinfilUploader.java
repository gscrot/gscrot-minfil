package gscrot.uploader.minfil;

import iconlib.IconUtils;

import com.redpois0n.gscrot.Capture;
import com.redpois0n.gscrot.CaptureUploader;
import com.redpois0n.gscrot.UploadResponse;

public class MinfilUploader extends CaptureUploader {
	
	public MinfilUploader() {
		super("Minfil", IconUtils.getIcon("minfil", MinfilUploader.class));
	}

	@Override
	public UploadResponse process(Capture capture) throws Exception {
		String response = Minfil.upload(capture.getBinary(), capture.getFormat().toString());
		
		return null;
	}

}
