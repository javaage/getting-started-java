package com.cisco.la.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecordModelExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table public.la_record
	 * @mbg.generated  Mon Jan 22 13:40:04 CST 2018
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table public.la_record
	 * @mbg.generated  Mon Jan 22 13:40:04 CST 2018
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table public.la_record
	 * @mbg.generated  Mon Jan 22 13:40:04 CST 2018
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_record
	 * @mbg.generated  Mon Jan 22 13:40:04 CST 2018
	 */
	public RecordModelExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_record
	 * @mbg.generated  Mon Jan 22 13:40:04 CST 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_record
	 * @mbg.generated  Mon Jan 22 13:40:04 CST 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_record
	 * @mbg.generated  Mon Jan 22 13:40:04 CST 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_record
	 * @mbg.generated  Mon Jan 22 13:40:04 CST 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_record
	 * @mbg.generated  Mon Jan 22 13:40:04 CST 2018
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_record
	 * @mbg.generated  Mon Jan 22 13:40:04 CST 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_record
	 * @mbg.generated  Mon Jan 22 13:40:04 CST 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_record
	 * @mbg.generated  Mon Jan 22 13:40:04 CST 2018
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_record
	 * @mbg.generated  Mon Jan 22 13:40:04 CST 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_record
	 * @mbg.generated  Mon Jan 22 13:40:04 CST 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table public.la_record
	 * @mbg.generated  Mon Jan 22 13:40:04 CST 2018
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
			addCriterion("crd_id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("crd_id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("crd_id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("crd_id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("crd_id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("crd_id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("crd_id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("crd_id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("crd_id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("crd_id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("crd_id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("crd_id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andRequestIsNull() {
			addCriterion("crd_request is null");
			return (Criteria) this;
		}

		public Criteria andRequestIsNotNull() {
			addCriterion("crd_request is not null");
			return (Criteria) this;
		}

		public Criteria andRequestEqualTo(String value) {
			addCriterion("crd_request =", value, "request");
			return (Criteria) this;
		}

		public Criteria andRequestNotEqualTo(String value) {
			addCriterion("crd_request <>", value, "request");
			return (Criteria) this;
		}

		public Criteria andRequestGreaterThan(String value) {
			addCriterion("crd_request >", value, "request");
			return (Criteria) this;
		}

		public Criteria andRequestGreaterThanOrEqualTo(String value) {
			addCriterion("crd_request >=", value, "request");
			return (Criteria) this;
		}

		public Criteria andRequestLessThan(String value) {
			addCriterion("crd_request <", value, "request");
			return (Criteria) this;
		}

		public Criteria andRequestLessThanOrEqualTo(String value) {
			addCriterion("crd_request <=", value, "request");
			return (Criteria) this;
		}

		public Criteria andRequestLike(String value) {
			addCriterion("crd_request like", value, "request");
			return (Criteria) this;
		}

		public Criteria andRequestNotLike(String value) {
			addCriterion("crd_request not like", value, "request");
			return (Criteria) this;
		}

		public Criteria andRequestIn(List<String> values) {
			addCriterion("crd_request in", values, "request");
			return (Criteria) this;
		}

		public Criteria andRequestNotIn(List<String> values) {
			addCriterion("crd_request not in", values, "request");
			return (Criteria) this;
		}

		public Criteria andRequestBetween(String value1, String value2) {
			addCriterion("crd_request between", value1, value2, "request");
			return (Criteria) this;
		}

		public Criteria andRequestNotBetween(String value1, String value2) {
			addCriterion("crd_request not between", value1, value2, "request");
			return (Criteria) this;
		}

		public Criteria andResponseIsNull() {
			addCriterion("crd_response is null");
			return (Criteria) this;
		}

		public Criteria andResponseIsNotNull() {
			addCriterion("crd_response is not null");
			return (Criteria) this;
		}

		public Criteria andResponseEqualTo(String value) {
			addCriterion("crd_response =", value, "response");
			return (Criteria) this;
		}

		public Criteria andResponseNotEqualTo(String value) {
			addCriterion("crd_response <>", value, "response");
			return (Criteria) this;
		}

		public Criteria andResponseGreaterThan(String value) {
			addCriterion("crd_response >", value, "response");
			return (Criteria) this;
		}

		public Criteria andResponseGreaterThanOrEqualTo(String value) {
			addCriterion("crd_response >=", value, "response");
			return (Criteria) this;
		}

		public Criteria andResponseLessThan(String value) {
			addCriterion("crd_response <", value, "response");
			return (Criteria) this;
		}

		public Criteria andResponseLessThanOrEqualTo(String value) {
			addCriterion("crd_response <=", value, "response");
			return (Criteria) this;
		}

		public Criteria andResponseLike(String value) {
			addCriterion("crd_response like", value, "response");
			return (Criteria) this;
		}

		public Criteria andResponseNotLike(String value) {
			addCriterion("crd_response not like", value, "response");
			return (Criteria) this;
		}

		public Criteria andResponseIn(List<String> values) {
			addCriterion("crd_response in", values, "response");
			return (Criteria) this;
		}

		public Criteria andResponseNotIn(List<String> values) {
			addCriterion("crd_response not in", values, "response");
			return (Criteria) this;
		}

		public Criteria andResponseBetween(String value1, String value2) {
			addCriterion("crd_response between", value1, value2, "response");
			return (Criteria) this;
		}

		public Criteria andResponseNotBetween(String value1, String value2) {
			addCriterion("crd_response not between", value1, value2, "response");
			return (Criteria) this;
		}

		public Criteria andTimeIsNull() {
			addCriterion("crd_time is null");
			return (Criteria) this;
		}

		public Criteria andTimeIsNotNull() {
			addCriterion("crd_time is not null");
			return (Criteria) this;
		}

		public Criteria andTimeEqualTo(Date value) {
			addCriterion("crd_time =", value, "time");
			return (Criteria) this;
		}

		public Criteria andTimeNotEqualTo(Date value) {
			addCriterion("crd_time <>", value, "time");
			return (Criteria) this;
		}

		public Criteria andTimeGreaterThan(Date value) {
			addCriterion("crd_time >", value, "time");
			return (Criteria) this;
		}

		public Criteria andTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("crd_time >=", value, "time");
			return (Criteria) this;
		}

		public Criteria andTimeLessThan(Date value) {
			addCriterion("crd_time <", value, "time");
			return (Criteria) this;
		}

		public Criteria andTimeLessThanOrEqualTo(Date value) {
			addCriterion("crd_time <=", value, "time");
			return (Criteria) this;
		}

		public Criteria andTimeIn(List<Date> values) {
			addCriterion("crd_time in", values, "time");
			return (Criteria) this;
		}

		public Criteria andTimeNotIn(List<Date> values) {
			addCriterion("crd_time not in", values, "time");
			return (Criteria) this;
		}

		public Criteria andTimeBetween(Date value1, Date value2) {
			addCriterion("crd_time between", value1, value2, "time");
			return (Criteria) this;
		}

		public Criteria andTimeNotBetween(Date value1, Date value2) {
			addCriterion("crd_time not between", value1, value2, "time");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table public.la_record
	 * @mbg.generated  Mon Jan 22 13:40:04 CST 2018
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
     * This class corresponds to the database table public.la_record
     *
     * @mbg.generated do_not_delete_during_merge Fri Jan 19 17:01:45 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}