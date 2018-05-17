package ua.logos.cloudinary;

import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryService {

	String uploadFile(MultipartFile multipartFile, String path);
	
}
