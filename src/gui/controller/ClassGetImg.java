
package gui.controller;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ClassGetImg {
	public void getImg(String fileOutPath, JLabel label) throws IOException {
		InputStream inStream = null;
		OutputStream outStream = null;
		File fileIn = new File("");
		File fileOut = new File("");

		JFileChooser jfileChooser = new JFileChooser();
		FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("Chọn file", "jpg", "png");
		jfileChooser.setFileFilter(extensionFilter);
		jfileChooser.setMultiSelectionEnabled(false);
		int x = jfileChooser.showDialog(null, "Chọn ảnh thuốc");
		if (x == JFileChooser.APPROVE_OPTION) {
			fileIn = jfileChooser.getSelectedFile();
			label.setIcon(new ImageIcon(new ImageIcon(fileIn.getAbsolutePath()).getImage()
					.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT)));
			try {
				try {
					fileOutPath = fileOutPath + ".jpg";
					fileOut = new File(fileOutPath);
					try {
						fileOut.delete();
					} catch (Exception e) {
					}
					inStream = new FileInputStream(fileIn);
					outStream = new FileOutputStream(fileOut);

					int length;
					byte[] buffer = new byte[1024];

					// copy the file content in bytes
					while ((length = inStream.read(buffer)) > 0) {
						outStream.write(buffer, 0, length);
					}
				} catch (Exception e) {
					try {
						fileOutPath = fileOutPath + ".png";
						fileOut = new File(fileOutPath);
						try {
							fileOut.delete();
						} catch (Exception e1) {
						}
						inStream = new FileInputStream(fileIn);
						outStream = new FileOutputStream(fileOut);

						int length;
						byte[] buffer = new byte[1024];

						// copy the file content in bytes
						while ((length = inStream.read(buffer)) > 0) {
							outStream.write(buffer, 0, length);
						}
					} catch (Exception e2) {
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				inStream.close();
				outStream.close();
			}
		}
	}

	public String setImg(String fileOutPath, JLabel label) throws IOException {
		File fileIn = new File("");
		JFileChooser jfileChooser = new JFileChooser();
		FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("Chọn file", "jpg", "png");
		jfileChooser.setFileFilter(extensionFilter);
		jfileChooser.setMultiSelectionEnabled(false);
		int x = jfileChooser.showDialog(null, "Chọn ảnh thuốc");
		if (x == JFileChooser.APPROVE_OPTION) {
			fileIn = jfileChooser.getSelectedFile();
			label.setIcon(new ImageIcon(new ImageIcon(fileIn.getAbsolutePath()).getImage()
					.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT)));
			return fileIn.getAbsolutePath();
		}
		return "";
	}

	public void createDropImgThuoc(String fileOutPath, String fileInPath) throws IOException {
		if (fileInPath == "")
			return;
		InputStream inStream = null;
		OutputStream outStream = null;
		File fileIn = new File(fileInPath);
		File fileOut = new File(fileOutPath);
			try {
				try {
					String fileOutPath1 = fileOutPath + ".jpg";
					fileOut = new File(fileOutPath1);
					fileOut.delete();
				} catch (Exception e) {
					e.printStackTrace();
					try {
						String fileOutPath1 = fileOutPath + ".png";
						fileOut = new File(fileOutPath1);
						fileOut.delete();
					} catch (Exception e1) {
						e1.printStackTrace();
						System.out.println("Khong co hinh de xoa");
					}
				}
				fileOut = new File(fileOutPath + ".jpg");
				System.out.println(fileOutPath + ".jpg 126 getimg");
				inStream = new FileInputStream(fileIn);
				outStream = new FileOutputStream(fileOut);

				int length;
				byte[] buffer = new byte[1024];

				// copy the file content in bytes
				while ((length = inStream.read(buffer)) > 0) {
					outStream.write(buffer, 0, length);
				}
				System.out.println("copy lan 1 thanh cong 137 getimg");
			} catch (Exception e) {
				e.printStackTrace();
			}

		finally {
			inStream.close();
			outStream.close();
		}
	}

	public String getFileExtension(String fullName) {
		if (fullName == "" || fullName == null)
			return "";
		String fileName = new File(fullName).getName();
		int dotIndex = fileName.lastIndexOf('.');
		return (dotIndex == -1) ? "" : fileName.substring(dotIndex);
	}

	public void setImgChiTiet(JLabel label, String filePath) {
		try {
			label.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(filePath + ".png")).getImage()
					.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT)));
		} catch (Exception e) {
			try {
				label.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(filePath + ".jpg")).getImage()
						.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT)));
			} catch (Exception e2) {
			}
		}
	}
}
