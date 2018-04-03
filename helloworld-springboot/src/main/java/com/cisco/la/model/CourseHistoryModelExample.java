package com.cisco.la.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class CourseHistoryModelExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table public.la_crs_history
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table public.la_crs_history
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table public.la_crs_history
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_crs_history
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	public CourseHistoryModelExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_crs_history
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_crs_history
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_crs_history
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_crs_history
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_crs_history
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_crs_history
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_crs_history
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_crs_history
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_crs_history
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_crs_history
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table public.la_crs_history
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

		public Criteria andUserIDIsNull() {
			addCriterion("hstr_usr_id is null");
			return (Criteria) this;
		}

		public Criteria andUserIDIsNotNull() {
			addCriterion("hstr_usr_id is not null");
			return (Criteria) this;
		}

		public Criteria andUserIDEqualTo(String value) {
			addCriterion("hstr_usr_id =", value, "userID");
			return (Criteria) this;
		}

		public Criteria andUserIDNotEqualTo(String value) {
			addCriterion("hstr_usr_id <>", value, "userID");
			return (Criteria) this;
		}

		public Criteria andUserIDGreaterThan(String value) {
			addCriterion("hstr_usr_id >", value, "userID");
			return (Criteria) this;
		}

		public Criteria andUserIDGreaterThanOrEqualTo(String value) {
			addCriterion("hstr_usr_id >=", value, "userID");
			return (Criteria) this;
		}

		public Criteria andUserIDLessThan(String value) {
			addCriterion("hstr_usr_id <", value, "userID");
			return (Criteria) this;
		}

		public Criteria andUserIDLessThanOrEqualTo(String value) {
			addCriterion("hstr_usr_id <=", value, "userID");
			return (Criteria) this;
		}

		public Criteria andUserIDLike(String value) {
			addCriterion("hstr_usr_id like", value, "userID");
			return (Criteria) this;
		}

		public Criteria andUserIDNotLike(String value) {
			addCriterion("hstr_usr_id not like", value, "userID");
			return (Criteria) this;
		}

		public Criteria andUserIDIn(List<String> values) {
			addCriterion("hstr_usr_id in", values, "userID");
			return (Criteria) this;
		}

		public Criteria andUserIDNotIn(List<String> values) {
			addCriterion("hstr_usr_id not in", values, "userID");
			return (Criteria) this;
		}

		public Criteria andUserIDBetween(String value1, String value2) {
			addCriterion("hstr_usr_id between", value1, value2, "userID");
			return (Criteria) this;
		}

		public Criteria andUserIDNotBetween(String value1, String value2) {
			addCriterion("hstr_usr_id not between", value1, value2, "userID");
			return (Criteria) this;
		}

		public Criteria andCourseIDIsNull() {
			addCriterion("hstr_crs_id is null");
			return (Criteria) this;
		}

		public Criteria andCourseIDIsNotNull() {
			addCriterion("hstr_crs_id is not null");
			return (Criteria) this;
		}

		public Criteria andCourseIDEqualTo(Integer value) {
			addCriterion("hstr_crs_id =", value, "CourseID");
			return (Criteria) this;
		}

		public Criteria andCourseIDNotEqualTo(Integer value) {
			addCriterion("hstr_crs_id <>", value, "CourseID");
			return (Criteria) this;
		}

		public Criteria andCourseIDGreaterThan(Integer value) {
			addCriterion("hstr_crs_id >", value, "CourseID");
			return (Criteria) this;
		}

		public Criteria andCourseIDGreaterThanOrEqualTo(Integer value) {
			addCriterion("hstr_crs_id >=", value, "CourseID");
			return (Criteria) this;
		}

		public Criteria andCourseIDLessThan(Integer value) {
			addCriterion("hstr_crs_id <", value, "CourseID");
			return (Criteria) this;
		}

		public Criteria andCourseIDLessThanOrEqualTo(Integer value) {
			addCriterion("hstr_crs_id <=", value, "CourseID");
			return (Criteria) this;
		}

		public Criteria andCourseIDIn(List<Integer> values) {
			addCriterion("hstr_crs_id in", values, "CourseID");
			return (Criteria) this;
		}

		public Criteria andCourseIDNotIn(List<Integer> values) {
			addCriterion("hstr_crs_id not in", values, "CourseID");
			return (Criteria) this;
		}

		public Criteria andCourseIDBetween(Integer value1, Integer value2) {
			addCriterion("hstr_crs_id between", value1, value2, "CourseID");
			return (Criteria) this;
		}

		public Criteria andCourseIDNotBetween(Integer value1, Integer value2) {
			addCriterion("hstr_crs_id not between", value1, value2, "CourseID");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIsNull() {
			addCriterion("hstr_update_time is null");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIsNotNull() {
			addCriterion("hstr_update_time is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeEqualTo(Date value) {
			addCriterion("hstr_update_time =", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotEqualTo(Date value) {
			addCriterion("hstr_update_time <>", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThan(Date value) {
			addCriterion("hstr_update_time >", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("hstr_update_time >=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThan(Date value) {
			addCriterion("hstr_update_time <", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
			addCriterion("hstr_update_time <=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIn(List<Date> values) {
			addCriterion("hstr_update_time in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotIn(List<Date> values) {
			addCriterion("hstr_update_time not in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeBetween(Date value1, Date value2) {
			addCriterion("hstr_update_time between", value1, value2, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
			addCriterion("hstr_update_time not between", value1, value2, "updateTime");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table public.la_crs_history
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
     * This class corresponds to the database table public.la_crs_history
     *
     * @mbg.generated do_not_delete_during_merge Thu Jan 18 09:51:37 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}