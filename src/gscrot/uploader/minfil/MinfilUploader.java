package gscrot.uploader.minfil;

import iconlib.IconUtils;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.redpois0n.gscrot.Capture;
import com.redpois0n.gscrot.CaptureUploader;
import com.redpois0n.gscrot.UploadResponse;

public class MinfilUploader extends CaptureUploader {
	
	public MinfilUploader() {
		super("Minfil", IconUtils.getIcon("minfil", MinfilUploader.class));
	}

	@Override
	public UploadResponse process(Capture capture) throws Exception {
		String response = Minfil.upload(capture.getBinary(), capture.getFormat());
		
		JSONObject jo = (JSONObject) JSONValue.parse(response);
		
		if (!jo.get("status").toString().equalsIgnoreCase("true")) {
			throw new Exception(jo.get("status").toString());
		}
		
		JSONObject file = (JSONObject) jo.get("file");
		JSONObject url = (JSONObject) file.get("url");

		Object link = url.get("full");
		
		if (link != null) {			
			UploadResponse ur = new UploadResponse(link.toString(), null);
			ur.setRaw(response);
			
			return ur;
		} else {
			throw new Exception("Error: " + response);
		}
	}

}
