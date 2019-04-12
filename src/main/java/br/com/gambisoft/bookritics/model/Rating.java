package br.com.gambisoft.bookritics.model;

public class Rating {

	private Float evaluation;
	private String bookId;
	
	public Float getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(Float evaluation) {
		this.evaluation = evaluation;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
}
