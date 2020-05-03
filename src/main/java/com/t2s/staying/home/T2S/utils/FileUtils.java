package com.t2s.staying.home.T2S.utils;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.UserDefinedFileAttributeView;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtils {

	private static final Logger log = LoggerFactory.getLogger(FileUtils.class);

	/**
	 * This methods writes an user defined attribute value at a file given in the method arguments.
	 * Empty or null metadata are not accepted
	 *
	 * @param filepath      the full os filepath for the file to be retrieved
	 * @param metadataName  the metadata name
	 * @param metadataValue the metadata value
	 * @return the operation result
	 * @throws IOException for example if file has not been found
	 */
	public static boolean setFileMetadata(String filepath, String metadataName, String metadataValue) throws IOException {
		if (Strings.isBlank(metadataName) || Strings.isBlank(metadataValue))
			return false;

		UserDefinedFileAttributeView view = Files.getFileAttributeView(
				Paths.get(filepath),
				UserDefinedFileAttributeView.class);

		int bytesWritten = view.write(
				String.format("user.%s", metadataName),
				Charset.defaultCharset().encode(metadataValue));

		log.info("Attribute {" + metadataName + ":" + metadataValue + "} has been set to the file at location: " + filepath);
		return bytesWritten > 0;
	}


	/**
	 * This methods writes an user defined attribute value at a file given in the method arguments.
	 * Empty or null metadata are not accepted
	 *
	 * @param filepath      the full os filepath for the file to be retrieved
	 * @param metadataName  the metadata name
	 * @return the attribute found int he file
	 * @throws IOException for example if file has not been found or the attribute has not been found
	 */
	public static String getFileMetadata(String filepath, String metadataName) throws IOException {
		UserDefinedFileAttributeView view =
				Files.getFileAttributeView(Paths.get(filepath), UserDefinedFileAttributeView.class);

		ByteBuffer buf = ByteBuffer.allocate(view.size(String.format("user.%s", metadataName)));
		view.read(String.format("user.%s", metadataName), buf);
		buf.flip();

		String metadataValue = Charset.defaultCharset().decode(buf).toString();
		log.info("Attribute {" + metadataName + ":" + metadataValue + "} has been set to the file at location: " + filepath);

		return metadataValue;
	}
}
