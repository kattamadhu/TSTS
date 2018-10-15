package com.echallan.userEchallanUpload;

public class UserEchallanUploadResponse {
    public UserEchallanUploadResponse(String fileName, boolean fileUploadStatus) {
		super();
		this.fileName = fileName;
		this.fileUploadStatus = fileUploadStatus;
	}
	private String fileName;
    private boolean fileUploadStatus;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public boolean getFileUploadStatus() {
		return fileUploadStatus;
	}
	public void setFileUploadStatus(boolean fileUploadStatus) {
		this.fileUploadStatus = fileUploadStatus;
	}
}