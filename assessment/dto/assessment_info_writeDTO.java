package lmsTeamPro.assessment.dto;

import java.sql.Date;

public class assessment_info_writeDTO {
private String course_code;

private String test_choice_code;
private String test_choice_type;

private String test_type_code;
private String test_type;


private String test_cate_code;
private String test_cate;

private String test_info_code;
private int test_info_score;
private Date test_info_date;
private Date test_info_time;
private String test_info_unit;
private int test_info_numofq;

public String getCourse_code() {
	return course_code;
}
public void setCourse_code(String course_code) {
	this.course_code = course_code;
}
public String getTest_choice_code() {
	return test_choice_code;
}
public void setTest_choice_code(String test_choice_code) {
	this.test_choice_code = test_choice_code;
}
public String getTest_choice_type() {
	return test_choice_type;
}
public void setTest_choice_type(String test_choice_type) {
	this.test_choice_type = test_choice_type;
}
public String getTest_type_code() {
	return test_type_code;
}
public void setTest_type_code(String test_type_code) {
	this.test_type_code = test_type_code;
}
public String getTest_type() {
	return test_type;
}
public void setTest_type(String test_type) {
	this.test_type = test_type;
}
public String getTest_cate_code() {
	return test_cate_code;
}
public void setTest_cate_code(String test_cate_code) {
	this.test_cate_code = test_cate_code;
}
public String getTest_cate() {
	return test_cate;
}
public void setTest_cate(String test_cate) {
	this.test_cate = test_cate;
}
public String getTest_info_code() {
	return test_info_code;
}
public void setTest_info_code(String test_info_code) {
	this.test_info_code = test_info_code;
}
public int getTest_info_score() {
	return test_info_score;
}
public void setTest_info_score(int test_info_score) {
	this.test_info_score = test_info_score;
}
public Date getTest_info_date() {
	return test_info_date;
}
public void setTest_info_date(Date test_info_date) {
	this.test_info_date = test_info_date;
}
public Date getTest_info_time() {
	return test_info_time;
}
public void setTest_info_time(Date test_info_time) {
	this.test_info_time = test_info_time;
}
public String getTest_info_unit() {
	return test_info_unit;
}
public void setTest_info_unit(String test_info_unit) {
	this.test_info_unit = test_info_unit;
}
public int getTest_info_numofq() {
	return test_info_numofq;
}
public void setTest_info_numofq(int test_info_numofq) {
	this.test_info_numofq = test_info_numofq;
}


}
