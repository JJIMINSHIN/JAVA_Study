package java_bsc.class1.ex;

public class MoviesReviewMain2 {
	
	public static void main(String args[]) {
		
		MoviesReview mv1 = new MoviesReview();
		mv1.title = "인셉션";
		mv1.review = "인생은 무한 루프";
		
		MoviesReview mv2 = new MoviesReview();
		mv2.title="어바웃 타임";
		mv2.review="인생 시간 영화!";

		MoviesReview[] Movies = {mv1, mv2};
		
		for(MoviesReview s : Movies) {
			System.out.println("영화 제목: "+s.title+", 리뷰: "+s.review);
		}
		
	}

}
