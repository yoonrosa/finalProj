package com.fin.proj.board.model.vo;

import java.sql.Date;

public class Reply {
	private int replyNo;
	private int replyWriter;
	private String nickName;
	private int boardNo;
	private String boardTitle;
	private String replyContent;
	private Date replyDate;
	private char replyStatus;
	
	public Reply() {}

	public Reply(int replyNo, int replyWriter, String nickName, int boardNo, String boardTitle, String replyContent,
			Date replyDate, char replyStatus) {
		super();
		this.replyNo = replyNo;
		this.replyWriter = replyWriter;
		this.nickName = nickName;
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.replyContent = replyContent;
		this.replyDate = replyDate;
		this.replyStatus = replyStatus;
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public int getreplyWriter() {
		return replyWriter;
	}

	public void setreplyWriter(int replyWriter) {
		this.replyWriter = replyWriter;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Date getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}

	public char getReplyStatus() {
		return replyStatus;
	}

	public void setReplyStatus(char replyStatus) {
		this.replyStatus = replyStatus;
	}

	@Override
	public String toString() {
		return "Reply [replyNo=" + replyNo + ", replyWriter=" + replyWriter + ", nickName=" + nickName + ", boardNo=" + boardNo
				+ ", boardTitle=" + boardTitle + ", replyContent=" + replyContent + ", replyDate=" + replyDate
				+ ", replyStatus=" + replyStatus + "]";
	}
	
	
}