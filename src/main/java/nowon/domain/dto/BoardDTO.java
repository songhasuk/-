package nowon.domain.dto;

import java.time.LocalDateTime;

public class BoardDTO {
	
	private int no;
	private String subject;
	private String content;
	private String writer;
	private int readCount;//카멜-언더스코어
	private LocalDateTime createdDate;
	
	
	
	@Override
	public String toString() {
		return "BoardDTO [no=" + no + ", subject=" + subject + ", content=" + content + ", writer=" + writer
				+ ", readCount=" + readCount + ", createdDate=" + createdDate + "]";
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

}
