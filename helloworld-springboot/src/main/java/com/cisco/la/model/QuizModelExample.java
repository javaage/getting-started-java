package com.cisco.la.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuizModelExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table public.la_quiz
	 * @mbg.generated  Thu Apr 12 17:19:19 CST 2018
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table public.la_quiz
	 * @mbg.generated  Thu Apr 12 17:19:19 CST 2018
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table public.la_quiz
	 * @mbg.generated  Thu Apr 12 17:19:19 CST 2018
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_quiz
	 * @mbg.generated  Thu Apr 12 17:19:19 CST 2018
	 */
	public QuizModelExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_quiz
	 * @mbg.generated  Thu Apr 12 17:19:19 CST 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_quiz
	 * @mbg.generated  Thu Apr 12 17:19:19 CST 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_quiz
	 * @mbg.generated  Thu Apr 12 17:19:19 CST 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_quiz
	 * @mbg.generated  Thu Apr 12 17:19:19 CST 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_quiz
	 * @mbg.generated  Thu Apr 12 17:19:19 CST 2018
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_quiz
	 * @mbg.generated  Thu Apr 12 17:19:19 CST 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_quiz
	 * @mbg.generated  Thu Apr 12 17:19:19 CST 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_quiz
	 * @mbg.generated  Thu Apr 12 17:19:19 CST 2018
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_quiz
	 * @mbg.generated  Thu Apr 12 17:19:19 CST 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_quiz
	 * @mbg.generated  Thu Apr 12 17:19:19 CST 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table public.la_quiz
	 * @mbg.generated  Thu Apr 12 17:19:19 CST 2018
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
			addCriterion("quz_id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("quz_id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("quz_id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("quz_id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("quz_id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("quz_id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("quz_id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("quz_id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("quz_id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("quz_id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("quz_id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("quz_id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andCourseIDIsNull() {
			addCriterion("quz_crs_id is null");
			return (Criteria) this;
		}

		public Criteria andCourseIDIsNotNull() {
			addCriterion("quz_crs_id is not null");
			return (Criteria) this;
		}

		public Criteria andCourseIDEqualTo(Integer value) {
			addCriterion("quz_crs_id =", value, "courseID");
			return (Criteria) this;
		}

		public Criteria andCourseIDNotEqualTo(Integer value) {
			addCriterion("quz_crs_id <>", value, "courseID");
			return (Criteria) this;
		}

		public Criteria andCourseIDGreaterThan(Integer value) {
			addCriterion("quz_crs_id >", value, "courseID");
			return (Criteria) this;
		}

		public Criteria andCourseIDGreaterThanOrEqualTo(Integer value) {
			addCriterion("quz_crs_id >=", value, "courseID");
			return (Criteria) this;
		}

		public Criteria andCourseIDLessThan(Integer value) {
			addCriterion("quz_crs_id <", value, "courseID");
			return (Criteria) this;
		}

		public Criteria andCourseIDLessThanOrEqualTo(Integer value) {
			addCriterion("quz_crs_id <=", value, "courseID");
			return (Criteria) this;
		}

		public Criteria andCourseIDIn(List<Integer> values) {
			addCriterion("quz_crs_id in", values, "courseID");
			return (Criteria) this;
		}

		public Criteria andCourseIDNotIn(List<Integer> values) {
			addCriterion("quz_crs_id not in", values, "courseID");
			return (Criteria) this;
		}

		public Criteria andCourseIDBetween(Integer value1, Integer value2) {
			addCriterion("quz_crs_id between", value1, value2, "courseID");
			return (Criteria) this;
		}

		public Criteria andCourseIDNotBetween(Integer value1, Integer value2) {
			addCriterion("quz_crs_id not between", value1, value2, "courseID");
			return (Criteria) this;
		}

		public Criteria andActiveTimeIsNull() {
			addCriterion("quz_active_time is null");
			return (Criteria) this;
		}

		public Criteria andActiveTimeIsNotNull() {
			addCriterion("quz_active_time is not null");
			return (Criteria) this;
		}

		public Criteria andActiveTimeEqualTo(Date value) {
			addCriterion("quz_active_time =", value, "activeTime");
			return (Criteria) this;
		}

		public Criteria andActiveTimeNotEqualTo(Date value) {
			addCriterion("quz_active_time <>", value, "activeTime");
			return (Criteria) this;
		}

		public Criteria andActiveTimeGreaterThan(Date value) {
			addCriterion("quz_active_time >", value, "activeTime");
			return (Criteria) this;
		}

		public Criteria andActiveTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("quz_active_time >=", value, "activeTime");
			return (Criteria) this;
		}

		public Criteria andActiveTimeLessThan(Date value) {
			addCriterion("quz_active_time <", value, "activeTime");
			return (Criteria) this;
		}

		public Criteria andActiveTimeLessThanOrEqualTo(Date value) {
			addCriterion("quz_active_time <=", value, "activeTime");
			return (Criteria) this;
		}

		public Criteria andActiveTimeIn(List<Date> values) {
			addCriterion("quz_active_time in", values, "activeTime");
			return (Criteria) this;
		}

		public Criteria andActiveTimeNotIn(List<Date> values) {
			addCriterion("quz_active_time not in", values, "activeTime");
			return (Criteria) this;
		}

		public Criteria andActiveTimeBetween(Date value1, Date value2) {
			addCriterion("quz_active_time between", value1, value2, "activeTime");
			return (Criteria) this;
		}

		public Criteria andActiveTimeNotBetween(Date value1, Date value2) {
			addCriterion("quz_active_time not between", value1, value2, "activeTime");
			return (Criteria) this;
		}

		public Criteria andAudienceTypeIsNull() {
			addCriterion("quz_audience_type is null");
			return (Criteria) this;
		}

		public Criteria andAudienceTypeIsNotNull() {
			addCriterion("quz_audience_type is not null");
			return (Criteria) this;
		}

		public Criteria andAudienceTypeEqualTo(String value) {
			addCriterion("quz_audience_type =", value, "audienceType");
			return (Criteria) this;
		}

		public Criteria andAudienceTypeNotEqualTo(String value) {
			addCriterion("quz_audience_type <>", value, "audienceType");
			return (Criteria) this;
		}

		public Criteria andAudienceTypeGreaterThan(String value) {
			addCriterion("quz_audience_type >", value, "audienceType");
			return (Criteria) this;
		}

		public Criteria andAudienceTypeGreaterThanOrEqualTo(String value) {
			addCriterion("quz_audience_type >=", value, "audienceType");
			return (Criteria) this;
		}

		public Criteria andAudienceTypeLessThan(String value) {
			addCriterion("quz_audience_type <", value, "audienceType");
			return (Criteria) this;
		}

		public Criteria andAudienceTypeLessThanOrEqualTo(String value) {
			addCriterion("quz_audience_type <=", value, "audienceType");
			return (Criteria) this;
		}

		public Criteria andAudienceTypeLike(String value) {
			addCriterion("quz_audience_type like", value, "audienceType");
			return (Criteria) this;
		}

		public Criteria andAudienceTypeNotLike(String value) {
			addCriterion("quz_audience_type not like", value, "audienceType");
			return (Criteria) this;
		}

		public Criteria andAudienceTypeIn(List<String> values) {
			addCriterion("quz_audience_type in", values, "audienceType");
			return (Criteria) this;
		}

		public Criteria andAudienceTypeNotIn(List<String> values) {
			addCriterion("quz_audience_type not in", values, "audienceType");
			return (Criteria) this;
		}

		public Criteria andAudienceTypeBetween(String value1, String value2) {
			addCriterion("quz_audience_type between", value1, value2, "audienceType");
			return (Criteria) this;
		}

		public Criteria andAudienceTypeNotBetween(String value1, String value2) {
			addCriterion("quz_audience_type not between", value1, value2, "audienceType");
			return (Criteria) this;
		}

		public Criteria andAudienceListIsNull() {
			addCriterion("quz_audience_list is null");
			return (Criteria) this;
		}

		public Criteria andAudienceListIsNotNull() {
			addCriterion("quz_audience_list is not null");
			return (Criteria) this;
		}

		public Criteria andAudienceListEqualTo(String value) {
			addCriterion("quz_audience_list =", value, "audienceList");
			return (Criteria) this;
		}

		public Criteria andAudienceListNotEqualTo(String value) {
			addCriterion("quz_audience_list <>", value, "audienceList");
			return (Criteria) this;
		}

		public Criteria andAudienceListGreaterThan(String value) {
			addCriterion("quz_audience_list >", value, "audienceList");
			return (Criteria) this;
		}

		public Criteria andAudienceListGreaterThanOrEqualTo(String value) {
			addCriterion("quz_audience_list >=", value, "audienceList");
			return (Criteria) this;
		}

		public Criteria andAudienceListLessThan(String value) {
			addCriterion("quz_audience_list <", value, "audienceList");
			return (Criteria) this;
		}

		public Criteria andAudienceListLessThanOrEqualTo(String value) {
			addCriterion("quz_audience_list <=", value, "audienceList");
			return (Criteria) this;
		}

		public Criteria andAudienceListLike(String value) {
			addCriterion("quz_audience_list like", value, "audienceList");
			return (Criteria) this;
		}

		public Criteria andAudienceListNotLike(String value) {
			addCriterion("quz_audience_list not like", value, "audienceList");
			return (Criteria) this;
		}

		public Criteria andAudienceListIn(List<String> values) {
			addCriterion("quz_audience_list in", values, "audienceList");
			return (Criteria) this;
		}

		public Criteria andAudienceListNotIn(List<String> values) {
			addCriterion("quz_audience_list not in", values, "audienceList");
			return (Criteria) this;
		}

		public Criteria andAudienceListBetween(String value1, String value2) {
			addCriterion("quz_audience_list between", value1, value2, "audienceList");
			return (Criteria) this;
		}

		public Criteria andAudienceListNotBetween(String value1, String value2) {
			addCriterion("quz_audience_list not between", value1, value2, "audienceList");
			return (Criteria) this;
		}

		public Criteria andActiveIsNull() {
			addCriterion("quz_active is null");
			return (Criteria) this;
		}

		public Criteria andActiveIsNotNull() {
			addCriterion("quz_active is not null");
			return (Criteria) this;
		}

		public Criteria andActiveEqualTo(Boolean value) {
			addCriterion("quz_active =", value, "active");
			return (Criteria) this;
		}

		public Criteria andActiveNotEqualTo(Boolean value) {
			addCriterion("quz_active <>", value, "active");
			return (Criteria) this;
		}

		public Criteria andActiveGreaterThan(Boolean value) {
			addCriterion("quz_active >", value, "active");
			return (Criteria) this;
		}

		public Criteria andActiveGreaterThanOrEqualTo(Boolean value) {
			addCriterion("quz_active >=", value, "active");
			return (Criteria) this;
		}

		public Criteria andActiveLessThan(Boolean value) {
			addCriterion("quz_active <", value, "active");
			return (Criteria) this;
		}

		public Criteria andActiveLessThanOrEqualTo(Boolean value) {
			addCriterion("quz_active <=", value, "active");
			return (Criteria) this;
		}

		public Criteria andActiveIn(List<Boolean> values) {
			addCriterion("quz_active in", values, "active");
			return (Criteria) this;
		}

		public Criteria andActiveNotIn(List<Boolean> values) {
			addCriterion("quz_active not in", values, "active");
			return (Criteria) this;
		}

		public Criteria andActiveBetween(Boolean value1, Boolean value2) {
			addCriterion("quz_active between", value1, value2, "active");
			return (Criteria) this;
		}

		public Criteria andActiveNotBetween(Boolean value1, Boolean value2) {
			addCriterion("quz_active not between", value1, value2, "active");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIsNull() {
			addCriterion("quz_update_time is null");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIsNotNull() {
			addCriterion("quz_update_time is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeEqualTo(Date value) {
			addCriterion("quz_update_time =", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotEqualTo(Date value) {
			addCriterion("quz_update_time <>", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThan(Date value) {
			addCriterion("quz_update_time >", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("quz_update_time >=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThan(Date value) {
			addCriterion("quz_update_time <", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
			addCriterion("quz_update_time <=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIn(List<Date> values) {
			addCriterion("quz_update_time in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotIn(List<Date> values) {
			addCriterion("quz_update_time not in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeBetween(Date value1, Date value2) {
			addCriterion("quz_update_time between", value1, value2, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
			addCriterion("quz_update_time not between", value1, value2, "updateTime");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table public.la_quiz
	 * @mbg.generated  Thu Apr 12 17:19:19 CST 2018
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
     * This class corresponds to the database table public.la_quiz
     *
     * @mbg.generated do_not_delete_during_merge Wed Mar 07 15:35:21 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}