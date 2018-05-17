package ua.logos.cloudinary;

import java.io.InputStream;
import java.util.Map;

import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.Uploader;
import com.cloudinary.utils.ObjectUtils;

@Service
@PropertySource("classpath:cloudinary.properties")
public class CloudinaryServiceImpl implements CloudinaryService {

	private Cloudinary cloudinary;

	public CloudinaryServiceImpl(Environment env) {
		this.cloudinary = new Cloudinary(env.getProperty("cloudinary.env"));
	}

	@Override
	public String uploadFile(MultipartFile multipartFile, String path) {
		Uploader uploader = cloudinary.uploader();
		
		String fileName = 
				multipartFile.getOriginalFilename()
				.substring(0, multipartFile.getOriginalFilename().lastIndexOf("."));
		
		Map<?, ?> options = ObjectUtils.asMap(
					"public_id", fileName,
					"folder", path,
					"overwrite", true
				);
		
		Map<?, ?> result = null;
		
		try {
			
			InputStream inputStream = multipartFile.getInputStream();
			result = uploader.uploadLarge(inputStream, options);
			inputStream.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return (String) result.get("url");
	}

}
