package test.pojo;

import java.util.List;

import test.model.Picture;
import test.model.PictureSet;

public class PictureSetDetail {
	private PictureSet ps;
	private List<Picture> pictures;
	public PictureSet getPs() {
		return ps;
	}
	public void setPs(PictureSet ps) {
		this.ps = ps;
	}
	public List<Picture> getList() {
		return pictures;
	}
	public void setList(List<Picture> list) {
		this.pictures = list;
	}
}
