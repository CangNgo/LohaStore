package com.cangngo.controller.web;

import com.cangngo.dao.impl.SanphamDAO;
import com.cangngo.model.SanPham;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serial;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Servlet implementation class ExportProduct
 */

@MultipartConfig(fileSizeThreshold = 1024 * 1024, // 1 MB
		maxFileSize = 1024 * 1024 * 10, // 10 MB
		maxRequestSize = 1024 * 1024 * 15 // 15 MB
)
@WebServlet(urlPatterns = { "/importProduct", "/listOfProduct", "/exportProduct" })
public class ExportProduct extends HttpServlet {
	@Serial
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExportProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		if (uri.contains("importProduct")) {
//			doImportStudent(request, response);
		} else if (uri.contains("listOfProduct")) {
			doListStudents(request, response);
		} else if (uri.contains("exportProduct")) {
			doExportStudent(request, response);
		}
	}

	private void doListStudents(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<SanPham> listProduct = new ArrayList<>();
		SanphamDAO studentDAO = new SanphamDAO();
		listProduct = studentDAO.findAll();
		request.setAttribute("listStudents", listProduct);

		// Create QR Image for each student with the content student ID
		for (SanPham st : listProduct) {
			String path = "studentQRFiles/" + st.getHinh() + ".png";
			String fileLocationAndName = request.getServletContext().getRealPath(path);
			File f = new File(fileLocationAndName);
			if (!f.exists()) {
				this.createStudentIDQRImage(String.valueOf(st.getId()), fileLocationAndName);
				System.out.println(fileLocationAndName);
			}
		}
		request.getRequestDispatcher("/views/web/listOfProduct.jsp").forward(request, response);
	}

	private void doExportStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getMethod();
		System.out.println("Export student to excel ******");
		if (method.equalsIgnoreCase("GET")) {
			try {
				List<SanPham> listStudents = new ArrayList<>();
				XSSFWorkbook workbook = new XSSFWorkbook();
				SanphamDAO studentDAO = new SanphamDAO();

				listStudents = studentDAO.findAll();
				XSSFSheet sheet = workbook.createSheet("Students");
				sheet.setColumnWidth(0, 6000);
				sheet.setColumnWidth(1, 4000);
				sheet.setColumnWidth(2, 8000);
				sheet.setColumnWidth(3, 5000);
				sheet.setColumnWidth(4, 8000);
				Row header = sheet.createRow(0);

				CellStyle headerStyle = workbook.createCellStyle();
				headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
				headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

				XSSFFont font = workbook.createFont();
				font.setFontName("Arial");
				font.setFontHeightInPoints((short) 16);
				font.setBold(true);
				headerStyle.setFont(font);
				// Create header row in the excel
				Cell headerCell = header.createCell(0);
				headerCell.setCellValue("No.");
				headerCell.setCellStyle(headerStyle);

				headerCell = header.createCell(1);
				headerCell.setCellValue("PRODUCT ID");
				headerCell.setCellStyle(headerStyle);

				headerCell = header.createCell(2);
				headerCell.setCellValue("PRODUCT Name");
				headerCell.setCellStyle(headerStyle);

				headerCell = header.createCell(3);
				headerCell.setCellValue("PRODUCT QUATITY");
				headerCell.setCellStyle(headerStyle);

				headerCell = header.createCell(4);
				headerCell.setCellValue("PRODUCT IAMGE");
				headerCell.setCellStyle(headerStyle);

				CellStyle style = workbook.createCellStyle();
				style.setWrapText(true);
				int rowIndex = 1;
				String pattern = "MM/dd/yyyy";
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
				for (SanPham st : listStudents) {
					Row row = sheet.createRow(rowIndex);
					Cell cell = row.createCell(0);
					cell.setCellValue(rowIndex);
					cell.setCellStyle(style);

					cell = row.createCell(1);
					cell.setCellValue(st.getId());
					cell.setCellStyle(style);

					cell = row.createCell(2);
					cell.setCellValue(st.getTenSanpham());
					cell.setCellStyle(style);

					cell = row.createCell(3);
					cell.setCellValue(st.getGia());
					cell.setCellStyle(style);

					cell = row.createCell(4);
					cell.setCellValue(simpleDateFormat.format(st.getSoluong()));
					cell.setCellStyle(style);
					rowIndex++;
					System.out.println(st);
				}

				// Write the content to listStudentTemp.xlsx
				String path = "productFiles/listProductTemp.xlsx";
				String fileLocationAndName = request.getServletContext().getRealPath(path);

				System.out.println(fileLocationAndName);
				FileOutputStream outputStream = new FileOutputStream(fileLocationAndName);
				workbook.write(outputStream);
				workbook.close();
				outputStream.close();
				request.getRequestDispatcher(path).forward(request, response);
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
				request.getRequestDispatcher("/views/web/listOfProduct.jsp").forward(request, response);
			}
		} else {
			request.getRequestDispatcher("/views/web/importProduct.jsp").forward(request, response);
		}

	}
//
//	private void doImportStudent(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String method = request.getMethod();
//		if (method.equalsIgnoreCase("POST")) {
//			if (request.getParameter("importStudent") != null) {
//				Part studentExcelFile = request.getPart("studentExcelFile");
//				String message = "Import student(s) successfully!";
//				List<SanPham> listStudents = new ArrayList<>();
//
//				if (studentExcelFile != null && studentExcelFile.getSize() > 0) {
//
//					String path = "studentFiles/" + studentExcelFile.getSubmittedFileName();
//
//					String fileName = request.getServletContext().getRealPath(path);
//
//					studentExcelFile.write(fileName);
//
//					System.out.println(fileName);
//
//					FileInputStream file = new FileInputStream(new File(fileName));
//					XSSFWorkbook workbook = new XSSFWorkbook(file);
//					XSSFSheet sheet = workbook.getSheetAt(0);
//					Iterator<Row> rowIterator = sheet.iterator();
//					System.out.println(workbook);
//					System.out.println(rowIterator);
//					String birthday = "";
//					SanphamDAO studentDAO = new SanphamDAO();
//					try {
//						// skip the first row - header row
//						if (rowIterator.hasNext()) {
//							rowIterator.next();
//						}
//						while (rowIterator.hasNext()) {
//							Row row = rowIterator.next();
//							SanPham st = new SanPham();
//							st.setId(row.getCell(0).getStringCellValue());
//							st.setLastName(row.getCell(1).getStringCellValue());
//							st.setFirstName(row.getCell(2).getStringCellValue());
//							birthday = row.getCell(3).getDateCellValue().toString();
//							System.out.println("Birthday: " + birthday);
//							st.setBirthday(row.getCell(3).getDateCellValue());
//
//							studentDAO.create(st);
//							System.out.println("Student: " + st);
//							listStudents.add(st);
//						}
//						file.close();
//					} catch (Exception e) {
//						System.out.println(e.getMessage());
//						message = "Import the list of students from the file " + studentExcelFile.getSubmittedFileName()
//								+ " Error!";
//
//					}
//				}
//				request.setAttribute("listStudents", listStudents);
//				request.setAttribute("fileName", studentExcelFile.getSubmittedFileName());
//				request.setAttribute("message", message);
//				request.getRequestDispatcher("/views/student/importStudent.jsp").forward(request, response);
//			}
//			request.getRequestDispatcher("/views/account/sign-up.jsp").forward(request, response);
//		} else {
//			request.getRequestDispatcher("/views/student/importStudent.jsp").forward(request, response);
//		}
//
//	}

	private boolean createStudentIDQRImage(String studentID, String locationAndName) {
		try {
			int size = 125;
			String fileType = "png";
			File qrFile = new File(locationAndName);
			createQRImage(qrFile, studentID, size, fileType);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	private void createQRImage(File qrFile, String qrCodeText, int size, String fileType)
			throws WriterException, IOException {
		// Create the ByteMatrix for the QR-Code that encodes the given String
		Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<>();
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix byteMatrix = qrCodeWriter.encode(qrCodeText, BarcodeFormat.QR_CODE, size, size, hintMap);
		// Make the BufferedImage that are to hold the QRCode
		int matrixWidth = byteMatrix.getWidth();
		BufferedImage image = new BufferedImage(matrixWidth, matrixWidth, BufferedImage.TYPE_INT_RGB);
		image.createGraphics();

		Graphics2D graphics = (Graphics2D) image.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, matrixWidth, matrixWidth);
		// Paint and save the image using the ByteMatrix
		graphics.setColor(Color.BLACK);

		for (int i = 0; i < matrixWidth; i++) {
			for (int j = 0; j < matrixWidth; j++) {
				if (byteMatrix.get(i, j)) {
					graphics.fillRect(i, j, 1, 1);
				}
			}
		}
		ImageIO.write(image, fileType, qrFile);
	}

}
