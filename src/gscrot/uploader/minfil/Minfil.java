package gscrot.uploader.minfil;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

import javax.imageio.ImageIO;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.redpois0n.gscrot.Format;

public class Minfil {
	
	public static String upload(BufferedImage image) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(image, "png", baos);
		byte[] bImage = baos.toByteArray();
		
		return upload(bImage, "png", "image/png");
	}
	
	public static String upload(byte[] b, Format format) throws Exception {
		return upload(b, format.toString(), format.getMime());
	}

	public static String upload(byte[] b, String ext, String mime) throws Exception {
		HttpClient httpclient = HttpClientBuilder.create().build();
		HttpPost httppost = new HttpPost("https://minfil.org/api/upload");
		
		MultipartEntityBuilder reqEntity = MultipartEntityBuilder.create();
		reqEntity.setMode(HttpMultipartMode.BROWSER_COMPATIBLE).addBinaryBody("minfil", b, ContentType.create(mime), "image." + ext);
		httppost.setEntity(reqEntity.build());

		HttpResponse response = httpclient.execute(httppost);

		String str = EntityUtils.toString(response.getEntity());

		return str;
	}
}
