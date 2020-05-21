package com.t2s.staying.home.T2S.utils;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.UserDefinedFileAttributeView;

public class FileUtils {

	private static final Logger log = LoggerFactory.getLogger(FileUtils.class);
	public static final String FILE_TIMESTAMPS_DEBUG_MESSAGE = "An error occurred while trying to get file creation/last modified time";
	public static final String CREATE_BUFFERED_READER_ERROR_DEBUG_MESSAGE = "An error occurred while trying to create buffered reader";
	public static final String CLOSE_BUFFERED_READER_ERROR_DEBUG_MESSAGE = "An error occurred while trying to close buffered reader";

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

	public static Boolean setFileMetadata(String filepath, String metadataName, String metadataValue) {
		if (Strings.isBlank(metadataName) || Strings.isBlank(metadataValue))
			return false;

		UserDefinedFileAttributeView view = Files.getFileAttributeView(
				Paths.get(filepath),
				UserDefinedFileAttributeView.class);

		int bytesWritten = 0;
		try {
			bytesWritten = view.write(
					String.format("user.%s", metadataName),
					Charset.defaultCharset().encode(metadataValue));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

		log.info("Attribute {" + metadataName + ":" + metadataValue + "} has been set to the file at location: " + filepath);
		return bytesWritten > 0;
	}

	/**
	 * This methods writes an user defined attribute value at a file given in the method arguments.
	 * Empty or null metadata are not accepted
	 *
	 * @param filepath     the full os filepath for the file to be retrieved
	 * @param metadataName the metadata name
	 * @return the attribute found int he file
	 * @throws IOException for example if file has not been found or the attribute has not been found
	 */
	public static String getFileMetadata(String filepath, String metadataName) {
		if (Strings.isBlank(filepath) && Strings.isBlank(metadataName))
			return null;

		log.info(String.format("Attempting to get file matadata for {%s, %s}: ", filepath, metadataName));
		UserDefinedFileAttributeView view =
				Files.getFileAttributeView(Paths.get(filepath), UserDefinedFileAttributeView.class);

		ByteBuffer buf = null;
		try {
			buf = ByteBuffer.allocate(view.size(String.format("user.%s", metadataName)));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

		try {
			view.read(String.format("user.%s", metadataName), buf);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		buf.flip();

		String metadataValue = Charset.defaultCharset().decode(buf).toString();
		log.info("Attribute {" + metadataName + ":" + metadataValue + "} has been set to the file at location: " + filepath);

		return metadataValue;
	}

	/**
	 * Create a buffered reader from a file
	 *
	 * @param filepath the full os filepath for the file to be retrieved
	 * @return the buffered reader
	 */
	public static BufferedReader getFileBufferReader(String filepath) {
		try {
			log.info("Attempting to get file buffer for: " + filepath);
			return new BufferedReader(new FileReader(filepath));
		} catch (IOException e) {
			log.debug(filepath);
			log.debug(CREATE_BUFFERED_READER_ERROR_DEBUG_MESSAGE);
			e.printStackTrace();
		}
		return null;
	}

	public static void closeBufferedReader(BufferedReader bufferedReader) {
		try {
			bufferedReader.close();
		} catch (IOException e) {
			log.debug(CLOSE_BUFFERED_READER_ERROR_DEBUG_MESSAGE);
		}
	}

	/**
	 * Create a file object from a file
	 *
	 * @param filepath the full os filepath for the file to be retrieved
	 * @return the file object
	 */
	public static File getFileReader(String filepath) {
		return new File(filepath);
	}

	public static Long getFileCreationTime(String filepath) {
		BasicFileAttributes basicFileAttributes = null;
		try {
			basicFileAttributes = Files.readAttributes(Paths.get(filepath), BasicFileAttributes.class);
			return basicFileAttributes.creationTime().toMillis();
		} catch (IOException e) {
			log.debug(filepath);
			log.debug(FILE_TIMESTAMPS_DEBUG_MESSAGE);
			e.printStackTrace();
		}
		return null;
	}

	public static Long getFileLastModifiedTime(String filepath) {
		BasicFileAttributes basicFileAttributes = null;
		try {
			basicFileAttributes = Files.readAttributes(Paths.get(filepath), BasicFileAttributes.class);
			return basicFileAttributes.lastModifiedTime().toMillis();
		} catch (IOException e) {
			log.debug(filepath);
			log.debug(FILE_TIMESTAMPS_DEBUG_MESSAGE);
			e.printStackTrace();
		}
		return null;
	}
}
