package com.cisco.la.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PaperModelExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table public.la_paper
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table public.la_paper
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table public.la_paper
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_paper
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	public PaperModelExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_paper
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_paper
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_paper
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_paper
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_paper
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_paper
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_paper
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_paper
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_paper
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_paper
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table public.la_paper
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull() {
			addCriterion("ppr_id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("ppr_id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("ppr_id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("ppr_id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("ppr_id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ppr_id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("ppr_id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("ppr_id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("ppr_id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("ppr_id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("ppr_id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ppr_id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andQuizIDIsNull() {
			addCriterion("ppr_quz_id is null");
			return (Criteria) this;
		}

		public Criteria andQuizIDIsNotNull() {
			addCriterion("ppr_quz_id is not null");
			return (Criteria) this;
		}

		public Criteria andQuizIDEqualTo(Integer value) {
			addCriterion("ppr_quz_id =", value, "quizID");
			return (Criteria) this;
		}

		public Criteria andQuizIDNotEqualTo(Integer value) {
			addCriterion("ppr_quz_id <>", value, "quizID");
			return (Criteria) this;
		}

		public Criteria andQuizIDGreaterThan(Integer value) {
			addCriterion("ppr_quz_id >", value, "quizID");
			return (Criteria) this;
		}

		public Criteria andQuizIDGreaterThanOrEqualTo(Integer value) {
			addCriterion("ppr_quz_id >=", value, "quizID");
			return (Criteria) this;
		}

		public Criteria andQuizIDLessThan(Integer value) {
			addCriterion("ppr_quz_id <", value, "quizID");
			return (Criteria) this;
		}

		public Criteria andQuizIDLessThanOrEqualTo(Integer value) {
			addCriterion("ppr_quz_id <=", value, "quizID");
			return (Criteria) this;
		}

		public Criteria andQuizIDIn(List<Integer> values) {
			addCriterion("ppr_quz_id in", values, "quizID");
			return (Criteria) this;
		}

		public Criteria andQuizIDNotIn(List<Integer> values) {
			addCriterion("ppr_quz_id not in", values, "quizID");
			return (Criteria) this;
		}

		public Criteria andQuizIDBetween(Integer value1, Integer value2) {
			addCriterion("ppr_quz_id between", value1, value2, "quizID");
			return (Criteria) this;
		}

		public Criteria andQuizIDNotBetween(Integer value1, Integer value2) {
			addCriterion("ppr_quz_id not between", value1, value2, "quizID");
			return (Criteria) this;
		}

		public Criteria andUserIDIsNull() {
			addCriterion("ppr_usr_id is null");
			return (Criteria) this;
		}

		public Criteria andUserIDIsNotNull() {
			addCriterion("ppr_usr_id is not null");
			return (Criteria) this;
		}

		public Criteria andUserIDEqualTo(String value) {
			addCriterion("ppr_usr_id =", value, "userID");
			return (Criteria) this;
		}

		public Criteria andUserIDNotEqualTo(String value) {
			addCriterion("ppr_usr_id <>", value, "userID");
			return (Criteria) this;
		}

		public Criteria andUserIDGreaterThan(String value) {
			addCriterion("ppr_usr_id >", value, "userID");
			return (Criteria) this;
		}

		public Criteria andUserIDGreaterThanOrEqualTo(String value) {
			addCriterion("ppr_usr_id >=", value, "userID");
			return (Criteria) this;
		}

		public Criteria andUserIDLessThan(String value) {
			addCriterion("ppr_usr_id <", value, "userID");
			return (Criteria) this;
		}

		public Criteria andUserIDLessThanOrEqualTo(String value) {
			addCriterion("ppr_usr_id <=", value, "userID");
			return (Criteria) this;
		}

		public Criteria andUserIDLike(String value) {
			addCriterion("ppr_usr_id like", value, "userID");
			return (Criteria) this;
		}

		public Criteria andUserIDNotLike(String value) {
			addCriterion("ppr_usr_id not like", value, "userID");
			return (Criteria) this;
		}

		public Criteria andUserIDIn(List<String> values) {
			addCriterion("ppr_usr_id in", values, "userID");
			return (Criteria) this;
		}

		public Criteria andUserIDNotIn(List<String> values) {
			addCriterion("ppr_usr_id not in", values, "userID");
			return (Criteria) this;
		}

		public Criteria andUserIDBetween(String value1, String value2) {
			addCriterion("ppr_usr_id between", value1, value2, "userID");
			return (Criteria) this;
		}

		public Criteria andUserIDNotBetween(String value1, String value2) {
			addCriterion("ppr_usr_id not between", value1, value2, "userID");
			return (Criteria) this;
		}

		public Criteria andContentIsNull() {
			addCriterion("ppr_content is null");
			return (Criteria) this;
		}

		public Criteria andContentIsNotNull() {
			addCriterion("ppr_content is not null");
			return (Criteria) this;
		}

		public Criteria andContentEqualTo(String value) {
			addCriterion("ppr_content =", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotEqualTo(String value) {
			addCriterion("ppr_content <>", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentGreaterThan(String value) {
			addCriterion("ppr_content >", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentGreaterThanOrEqualTo(String value) {
			addCriterion("ppr_content >=", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentLessThan(String value) {
			addCriterion("ppr_content <", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentLessThanOrEqualTo(String value) {
			addCriterion("ppr_content <=", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentLike(String value) {
			addCriterion("ppr_content like", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotLike(String value) {
			addCriterion("ppr_content not like", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentIn(List<String> values) {
			addCriterion("ppr_content in", values, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotIn(List<String> values) {
			addCriterion("ppr_content not in", values, "content");
			return (Criteria) this;
		}

		public Criteria andContentBetween(String value1, String value2) {
			addCriterion("ppr_content between", value1, value2, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotBetween(String value1, String value2) {
			addCriterion("ppr_content not between", value1, value2, "content");
			return (Criteria) this;
		}

		public Criteria andStandardIsNull() {
			addCriterion("ppr_standard is null");
			return (Criteria) this;
		}

		public Criteria andStandardIsNotNull() {
			addCriterion("ppr_standard is not null");
			return (Criteria) this;
		}

		public Criteria andStandardEqualTo(String value) {
			addCriterion("ppr_standard =", value, "standard");
			return (Criteria) this;
		}

		public Criteria andStandardNotEqualTo(String value) {
			addCriterion("ppr_standard <>", value, "standard");
			return (Criteria) this;
		}

		public Criteria andStandardGreaterThan(String value) {
			addCriterion("ppr_standard >", value, "standard");
			return (Criteria) this;
		}

		public Criteria andStandardGreaterThanOrEqualTo(String value) {
			addCriterion("ppr_standard >=", value, "standard");
			return (Criteria) this;
		}

		public Criteria andStandardLessThan(String value) {
			addCriterion("ppr_standard <", value, "standard");
			return (Criteria) this;
		}

		public Criteria andStandardLessThanOrEqualTo(String value) {
			addCriterion("ppr_standard <=", value, "standard");
			return (Criteria) this;
		}

		public Criteria andStandardLike(String value) {
			addCriterion("ppr_standard like", value, "standard");
			return (Criteria) this;
		}

		public Criteria andStandardNotLike(String value) {
			addCriterion("ppr_standard not like", value, "standard");
			return (Criteria) this;
		}

		public Criteria andStandardIn(List<String> values) {
			addCriterion("ppr_standard in", values, "standard");
			return (Criteria) this;
		}

		public Criteria andStandardNotIn(List<String> values) {
			addCriterion("ppr_standard not in", values, "standard");
			return (Criteria) this;
		}

		public Criteria andStandardBetween(String value1, String value2) {
			addCriterion("ppr_standard between", value1, value2, "standard");
			return (Criteria) this;
		}

		public Criteria andStandardNotBetween(String value1, String value2) {
			addCriterion("ppr_standard not between", value1, value2, "standard");
			return (Criteria) this;
		}

		public Criteria andAwswerIsNull() {
			addCriterion("ppr_answer is null");
			return (Criteria) this;
		}

		public Criteria andAwswerIsNotNull() {
			addCriterion("ppr_answer is not null");
			return (Criteria) this;
		}

		public Criteria andAwswerEqualTo(String value) {
			addCriterion("ppr_answer =", value, "awswer");
			return (Criteria) this;
		}

		public Criteria andAwswerNotEqualTo(String value) {
			addCriterion("ppr_answer <>", value, "awswer");
			return (Criteria) this;
		}

		public Criteria andAwswerGreaterThan(String value) {
			addCriterion("ppr_answer >", value, "awswer");
			return (Criteria) this;
		}

		public Criteria andAwswerGreaterThanOrEqualTo(String value) {
			addCriterion("ppr_answer >=", value, "awswer");
			return (Criteria) this;
		}

		public Criteria andAwswerLessThan(String value) {
			addCriterion("ppr_answer <", value, "awswer");
			return (Criteria) this;
		}

		public Criteria andAwswerLessThanOrEqualTo(String value) {
			addCriterion("ppr_answer <=", value, "awswer");
			return (Criteria) this;
		}

		public Criteria andAwswerLike(String value) {
			addCriterion("ppr_answer like", value, "awswer");
			return (Criteria) this;
		}

		public Criteria andAwswerNotLike(String value) {
			addCriterion("ppr_answer not like", value, "awswer");
			return (Criteria) this;
		}

		public Criteria andAwswerIn(List<String> values) {
			addCriterion("ppr_answer in", values, "awswer");
			return (Criteria) this;
		}

		public Criteria andAwswerNotIn(List<String> values) {
			addCriterion("ppr_answer not in", values, "awswer");
			return (Criteria) this;
		}

		public Criteria andAwswerBetween(String value1, String value2) {
			addCriterion("ppr_answer between", value1, value2, "awswer");
			return (Criteria) this;
		}

		public Criteria andAwswerNotBetween(String value1, String value2) {
			addCriterion("ppr_answer not between", value1, value2, "awswer");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIsNull() {
			addCriterion("ppr_update_time is null");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIsNotNull() {
			addCriterion("ppr_update_time is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeEqualTo(Date value) {
			addCriterion("ppr_update_time =", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotEqualTo(Date value) {
			addCriterion("ppr_update_time <>", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThan(Date value) {
			addCriterion("ppr_update_time >", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("ppr_update_time >=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThan(Date value) {
			addCriterion("ppr_update_time <", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
			addCriterion("ppr_update_time <=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIn(List<Date> values) {
			addCriterion("ppr_update_time in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotIn(List<Date> values) {
			addCriterion("ppr_update_time not in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeBetween(Date value1, Date value2) {
			addCriterion("ppr_update_time between", value1, value2, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
			addCriterion("ppr_update_time not between", value1, value2, "updateTime");
			return (Criteria) this;
		}

		public Criteria andScoreIsNull() {
			addCriterion("ppr_score is null");
			return (Criteria) this;
		}

		public Criteria andScoreIsNotNull() {
			addCriterion("ppr_score is not null");
			return (Criteria) this;
		}

		public Criteria andScoreEqualTo(Integer value) {
			addCriterion("ppr_score =", value, "score");
			return (Criteria) this;
		}

		public Criteria andScoreNotEqualTo(Integer value) {
			addCriterion("ppr_score <>", value, "score");
			return (Criteria) this;
		}

		public Criteria andScoreGreaterThan(Integer value) {
			addCriterion("ppr_score >", value, "score");
			return (Criteria) this;
		}

		public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
			addCriterion("ppr_score >=", value, "score");
			return (Criteria) this;
		}

		public Criteria andScoreLessThan(Integer value) {
			addCriterion("ppr_score <", value, "score");
			return (Criteria) this;
		}

		public Criteria andScoreLessThanOrEqualTo(Integer value) {
			addCriterion("ppr_score <=", value, "score");
			return (Criteria) this;
		}

		public Criteria andScoreIn(List<Integer> values) {
			addCriterion("ppr_score in", values, "score");
			return (Criteria) this;
		}

		public Criteria andScoreNotIn(List<Integer> values) {
			addCriterion("ppr_score not in", values, "score");
			return (Criteria) this;
		}

		public Criteria andScoreBetween(Integer value1, Integer value2) {
			addCriterion("ppr_score between", value1, value2, "score");
			return (Criteria) this;
		}

		public Criteria andScoreNotBetween(Integer value1, Integer value2) {
			addCriterion("ppr_score not between", value1, value2, "score");
			return (Criteria) this;
		}

		public Criteria andTotalIsNull() {
			addCriterion("ppr_total is null");
			return (Criteria) this;
		}

		public Criteria andTotalIsNotNull() {
			addCriterion("ppr_total is not null");
			return (Criteria) this;
		}

		public Criteria andTotalEqualTo(Integer value) {
			addCriterion("ppr_total =", value, "total");
			return (Criteria) this;
		}

		public Criteria andTotalNotEqualTo(Integer value) {
			addCriterion("ppr_total <>", value, "total");
			return (Criteria) this;
		}

		public Criteria andTotalGreaterThan(Integer value) {
			addCriterion("ppr_total >", value, "total");
			return (Criteria) this;
		}

		public Criteria andTotalGreaterThanOrEqualTo(Integer value) {
			addCriterion("ppr_total >=", value, "total");
			return (Criteria) this;
		}

		public Criteria andTotalLessThan(Integer value) {
			addCriterion("ppr_total <", value, "total");
			return (Criteria) this;
		}

		public Criteria andTotalLessThanOrEqualTo(Integer value) {
			addCriterion("ppr_total <=", value, "total");
			return (Criteria) this;
		}

		public Criteria andTotalIn(List<Integer> values) {
			addCriterion("ppr_total in", values, "total");
			return (Criteria) this;
		}

		public Criteria andTotalNotIn(List<Integer> values) {
			addCriterion("ppr_total not in", values, "total");
			return (Criteria) this;
		}

		public Criteria andTotalBetween(Integer value1, Integer value2) {
			addCriterion("ppr_total between", value1, value2, "total");
			return (Criteria) this;
		}

		public Criteria andTotalNotBetween(Integer value1, Integer value2) {
			addCriterion("ppr_total not between", value1, value2, "total");
			return (Criteria) this;
		}

		public Criteria andIndexIsNull() {
			addCriterion("ppr_index is null");
			return (Criteria) this;
		}

		public Criteria andIndexIsNotNull() {
			addCriterion("ppr_index is not null");
			return (Criteria) this;
		}

		public Criteria andIndexEqualTo(Integer value) {
			addCriterion("ppr_index =", value, "index");
			return (Criteria) this;
		}

		public Criteria andIndexNotEqualTo(Integer value) {
			addCriterion("ppr_index <>", value, "index");
			return (Criteria) this;
		}

		public Criteria andIndexGreaterThan(Integer value) {
			addCriterion("ppr_index >", value, "index");
			return (Criteria) this;
		}

		public Criteria andIndexGreaterThanOrEqualTo(Integer value) {
			addCriterion("ppr_index >=", value, "index");
			return (Criteria) this;
		}

		public Criteria andIndexLessThan(Integer value) {
			addCriterion("ppr_index <", value, "index");
			return (Criteria) this;
		}

		public Criteria andIndexLessThanOrEqualTo(Integer value) {
			addCriterion("ppr_index <=", value, "index");
			return (Criteria) this;
		}

		public Criteria andIndexIn(List<Integer> values) {
			addCriterion("ppr_index in", values, "index");
			return (Criteria) this;
		}

		public Criteria andIndexNotIn(List<Integer> values) {
			addCriterion("ppr_index not in", values, "index");
			return (Criteria) this;
		}

		public Criteria andIndexBetween(Integer value1, Integer value2) {
			addCriterion("ppr_index between", value1, value2, "index");
			return (Criteria) this;
		}

		public Criteria andIndexNotBetween(Integer value1, Integer value2) {
			addCriterion("ppr_index not between", value1, value2, "index");
			return (Criteria) this;
		}

		public Criteria andSessionIsNull() {
			addCriterion("ppr_session is null");
			return (Criteria) this;
		}

		public Criteria andSessionIsNotNull() {
			addCriterion("ppr_session is not null");
			return (Criteria) this;
		}

		public Criteria andSessionEqualTo(Date value) {
			addCriterion("ppr_session =", value, "session");
			return (Criteria) this;
		}

		public Criteria andSessionNotEqualTo(Date value) {
			addCriterion("ppr_session <>", value, "session");
			return (Criteria) this;
		}

		public Criteria andSessionGreaterThan(Date value) {
			addCriterion("ppr_session >", value, "session");
			return (Criteria) this;
		}

		public Criteria andSessionGreaterThanOrEqualTo(Date value) {
			addCriterion("ppr_session >=", value, "session");
			return (Criteria) this;
		}

		public Criteria andSessionLessThan(Date value) {
			addCriterion("ppr_session <", value, "session");
			return (Criteria) this;
		}

		public Criteria andSessionLessThanOrEqualTo(Date value) {
			addCriterion("ppr_session <=", value, "session");
			return (Criteria) this;
		}

		public Criteria andSessionIn(List<Date> values) {
			addCriterion("ppr_session in", values, "session");
			return (Criteria) this;
		}

		public Criteria andSessionNotIn(List<Date> values) {
			addCriterion("ppr_session not in", values, "session");
			return (Criteria) this;
		}

		public Criteria andSessionBetween(Date value1, Date value2) {
			addCriterion("ppr_session between", value1, value2, "session");
			return (Criteria) this;
		}

		public Criteria andSessionNotBetween(Date value1, Date value2) {
			addCriterion("ppr_session not between", value1, value2, "session");
			return (Criteria) this;
		}

		public Criteria andActiveIsNull() {
			addCriterion("ppr_active is null");
			return (Criteria) this;
		}

		public Criteria andActiveIsNotNull() {
			addCriterion("ppr_active is not null");
			return (Criteria) this;
		}

		public Criteria andActiveEqualTo(Boolean value) {
			addCriterion("ppr_active =", value, "active");
			return (Criteria) this;
		}

		public Criteria andActiveNotEqualTo(Boolean value) {
			addCriterion("ppr_active <>", value, "active");
			return (Criteria) this;
		}

		public Criteria andActiveGreaterThan(Boolean value) {
			addCriterion("ppr_active >", value, "active");
			return (Criteria) this;
		}

		public Criteria andActiveGreaterThanOrEqualTo(Boolean value) {
			addCriterion("ppr_active >=", value, "active");
			return (Criteria) this;
		}

		public Criteria andActiveLessThan(Boolean value) {
			addCriterion("ppr_active <", value, "active");
			return (Criteria) this;
		}

		public Criteria andActiveLessThanOrEqualTo(Boolean value) {
			addCriterion("ppr_active <=", value, "active");
			return (Criteria) this;
		}

		public Criteria andActiveIn(List<Boolean> values) {
			addCriterion("ppr_active in", values, "active");
			return (Criteria) this;
		}

		public Criteria andActiveNotIn(List<Boolean> values) {
			addCriterion("ppr_active not in", values, "active");
			return (Criteria) this;
		}

		public Criteria andActiveBetween(Boolean value1, Boolean value2) {
			addCriterion("ppr_active between", value1, value2, "active");
			return (Criteria) this;
		}

		public Criteria andActiveNotBetween(Boolean value1, Boolean value2) {
			addCriterion("ppr_active not between", value1, value2, "active");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table public.la_paper
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table public.la_paper
     *
     * @mbg.generated do_not_delete_during_merge Tue Mar 13 14:52:35 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}