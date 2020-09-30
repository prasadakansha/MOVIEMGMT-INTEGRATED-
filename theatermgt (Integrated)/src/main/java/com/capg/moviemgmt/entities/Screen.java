package com.capg.moviemgmt.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "screendetails")
public class Screen {

	@Id
	@GeneratedValue
	@Column(name = "screenId")
	private int screenId;
	@Column(name = "theaterId")
	private int theaterId;
	@Column(name = "screenName")
	private String screenName;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Show> showList;
	@Column(name = "rows")
	private int rows;
	@Column(name = "columns")
	private int columns;

	public Screen() {
		super();
	}

	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	public int getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public List<Show> getShowList() {
		return showList;
	}

	public void setShowList(List<Show> showList) {
		this.showList = showList;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	@Override
	public String toString() {
		return "Screen [screenId=" + screenId + ", theaterId=" + theaterId + ", screenName=" + screenName
				+ ", showList=" + showList + ", rows=" + rows + ", columns=" + columns + "]";
	}

}