package Controller.FrontEnd;

import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class FileUpload implements Action {
	//private final long serialVersionUID = 1L;
	/*sarin edit data_directory*/
	//private final String DATA_DIRECTORY = "img";
	private  String DATA_DIRECTORY = "img\\";
	private final int MAX_MEMORY_SIZE = 1024 * 1024 * 2;
	private final int MAX_REQUEST_SIZE = 1024 * 1024;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		String path = null;
		//try{
		/*
		 * path=request.getSession().getAttribute("proimag").toString();
		 * System.err.println(path); if(path.equals("profile")){
		 * DATA_DIRECTORY+="profile";
		 * 
		 * }
		 * 
		 * }catch(NullPointerException e){
		 * 
		 * }
		 */
		if(request.getSession().getAttribute("proimag")!=null){
			DATA_DIRECTORY+="profile";
		}
		
		if (!isMultipart) {
			return;
		}

		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// Sets the size threshold beyond which files are written directly to
		// disk.
		factory.setSizeThreshold(MAX_MEMORY_SIZE);

		// Sets the directory used to temporarily store files that are larger
		// than the configured size threshold. We use temporary directory for
		// java
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		// constructs the folder where uploaded file will be stored
		String uploadFolder = request.getServletContext().getRealPath("") + File.separator + DATA_DIRECTORY;
		
		/* URL resource = servletContext.getResource(path); */
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// Set overall request size constraint
		upload.setSizeMax(MAX_REQUEST_SIZE);

		System.out.println("Here it is : "+uploadFolder);
		String fileName = null;
		String filePath = null;
		try {
			// Parse the request
			List items = upload.parseRequest(request);
			Iterator iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();

				if (!item.isFormField()) {
					fileName = new File(item.getName()).getName();
					System.out.println("File Name: " + fileName);
					filePath = uploadFolder + File.separator + fileName;
					/* String filePath = uploadFolder + fileName; */
					File uploadedFile = new File(filePath);
					// saves the file to upload directory
					item.write(uploadedFile);
					// response.getWriter().write(fileName);
				}
			}
			//response.getWriter().write(fileName);
			// displays done.jsp page after upload finished
			request.getServletContext().getRequestDispatcher("/Admin/page_user_profile.jsp").forward(request, response);

		} catch (FileUploadException ex) {
			throw new ServletException(ex);
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

}
