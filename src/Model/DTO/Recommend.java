package Model.DTO;

import java.io.Serializable;

public class Recommend implements Serializable{
 private int rec_id;
 private int news_id;
/**
 * @return the rec_id
 */
public int getRec_id() {
	return rec_id;
}
/**
 * @param rec_id the rec_id to set
 */
public void setRec_id(int rec_id) {
	this.rec_id = rec_id;
}
/**
 * @return the news_id
 */
public int getNews_id() {
	return news_id;
}
/**
 * @param news_id the news_id to set
 */
public void setNews_id(int news_id) {
	this.news_id = news_id;
}
}
