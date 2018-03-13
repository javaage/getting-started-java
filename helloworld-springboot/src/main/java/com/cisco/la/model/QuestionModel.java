package com.cisco.la.model;

public class QuestionModel {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.la_question.qust_quiz_id
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	private Integer quizID;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.la_question.qust_subject
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	private String subject;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.la_question.qust_choices
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	private String choices;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.la_question.qust_answer
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	private String answer;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.la_question.qust_number
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	private Integer number;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.la_question.qust_quiz_id
	 * @return  the value of public.la_question.qust_quiz_id
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	public Integer getQuizID() {
		return quizID;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.la_question.qust_quiz_id
	 * @param quizID  the value for public.la_question.qust_quiz_id
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	public void setQuizID(Integer quizID) {
		this.quizID = quizID;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.la_question.qust_subject
	 * @return  the value of public.la_question.qust_subject
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.la_question.qust_subject
	 * @param subject  the value for public.la_question.qust_subject
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.la_question.qust_choices
	 * @return  the value of public.la_question.qust_choices
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	public String getChoices() {
		return choices;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.la_question.qust_choices
	 * @param choices  the value for public.la_question.qust_choices
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	public void setChoices(String choices) {
		this.choices = choices;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.la_question.qust_answer
	 * @return  the value of public.la_question.qust_answer
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.la_question.qust_answer
	 * @param answer  the value for public.la_question.qust_answer
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.la_question.qust_number
	 * @return  the value of public.la_question.qust_number
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.la_question.qust_number
	 * @param number  the value for public.la_question.qust_number
	 * @mbg.generated  Tue Mar 13 14:52:35 CST 2018
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}
}