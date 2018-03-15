package com.cisco.la.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Iterator;

public class UserModelExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table public.la_user
	 * @mbg.generated  Wed Mar 14 16:19:03 CST 2018
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table public.la_user
	 * @mbg.generated  Wed Mar 14 16:19:03 CST 2018
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table public.la_user
	 * @mbg.generated  Wed Mar 14 16:19:03 CST 2018
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_user
	 * @mbg.generated  Wed Mar 14 16:19:03 CST 2018
	 */
	public UserModelExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_user
	 * @mbg.generated  Wed Mar 14 16:19:03 CST 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_user
	 * @mbg.generated  Wed Mar 14 16:19:03 CST 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_user
	 * @mbg.generated  Wed Mar 14 16:19:03 CST 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_user
	 * @mbg.generated  Wed Mar 14 16:19:03 CST 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_user
	 * @mbg.generated  Wed Mar 14 16:19:03 CST 2018
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_user
	 * @mbg.generated  Wed Mar 14 16:19:03 CST 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_user
	 * @mbg.generated  Wed Mar 14 16:19:03 CST 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_user
	 * @mbg.generated  Wed Mar 14 16:19:03 CST 2018
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_user
	 * @mbg.generated  Wed Mar 14 16:19:03 CST 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_user
	 * @mbg.generated  Wed Mar 14 16:19:03 CST 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table public.la_user
	 * @mbg.generated  Wed Mar 14 16:19:03 CST 2018
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
			addCriterion("usr_id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("usr_id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(String value) {
			addCriterion("usr_id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(String value) {
			addCriterion("usr_id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(String value) {
			addCriterion("usr_id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(String value) {
			addCriterion("usr_id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(String value) {
			addCriterion("usr_id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(String value) {
			addCriterion("usr_id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLike(String value) {
			addCriterion("usr_id like", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotLike(String value) {
			addCriterion("usr_id not like", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<String> values) {
			addCriterion("usr_id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<String> values) {
			addCriterion("usr_id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(String value1, String value2) {
			addCriterion("usr_id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(String value1, String value2) {
			addCriterion("usr_id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andNameIsNull() {
			addCriterion("usr_name is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("usr_name is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("usr_name =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("usr_name <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("usr_name >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("usr_name >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("usr_name <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("usr_name <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("usr_name like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("usr_name not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("usr_name in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("usr_name not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("usr_name between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("usr_name not between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andBudgetIsNull() {
			addCriterion("usr_budget is null");
			return (Criteria) this;
		}

		public Criteria andBudgetIsNotNull() {
			addCriterion("usr_budget is not null");
			return (Criteria) this;
		}

		public Criteria andBudgetEqualTo(Double value) {
			addCriterion("usr_budget =", value, "budget");
			return (Criteria) this;
		}

		public Criteria andBudgetNotEqualTo(Double value) {
			addCriterion("usr_budget <>", value, "budget");
			return (Criteria) this;
		}

		public Criteria andBudgetGreaterThan(Double value) {
			addCriterion("usr_budget >", value, "budget");
			return (Criteria) this;
		}

		public Criteria andBudgetGreaterThanOrEqualTo(Double value) {
			addCriterion("usr_budget >=", value, "budget");
			return (Criteria) this;
		}

		public Criteria andBudgetLessThan(Double value) {
			addCriterion("usr_budget <", value, "budget");
			return (Criteria) this;
		}

		public Criteria andBudgetLessThanOrEqualTo(Double value) {
			addCriterion("usr_budget <=", value, "budget");
			return (Criteria) this;
		}

		public Criteria andBudgetIn(List<Double> values) {
			addCriterion("usr_budget in", values, "budget");
			return (Criteria) this;
		}

		public Criteria andBudgetNotIn(List<Double> values) {
			addCriterion("usr_budget not in", values, "budget");
			return (Criteria) this;
		}

		public Criteria andBudgetBetween(Double value1, Double value2) {
			addCriterion("usr_budget between", value1, value2, "budget");
			return (Criteria) this;
		}

		public Criteria andBudgetNotBetween(Double value1, Double value2) {
			addCriterion("usr_budget not between", value1, value2, "budget");
			return (Criteria) this;
		}

		public Criteria andBalanceIsNull() {
			addCriterion("usr_balance is null");
			return (Criteria) this;
		}

		public Criteria andBalanceIsNotNull() {
			addCriterion("usr_balance is not null");
			return (Criteria) this;
		}

		public Criteria andBalanceEqualTo(Double value) {
			addCriterion("usr_balance =", value, "balance");
			return (Criteria) this;
		}

		public Criteria andBalanceNotEqualTo(Double value) {
			addCriterion("usr_balance <>", value, "balance");
			return (Criteria) this;
		}

		public Criteria andBalanceGreaterThan(Double value) {
			addCriterion("usr_balance >", value, "balance");
			return (Criteria) this;
		}

		public Criteria andBalanceGreaterThanOrEqualTo(Double value) {
			addCriterion("usr_balance >=", value, "balance");
			return (Criteria) this;
		}

		public Criteria andBalanceLessThan(Double value) {
			addCriterion("usr_balance <", value, "balance");
			return (Criteria) this;
		}

		public Criteria andBalanceLessThanOrEqualTo(Double value) {
			addCriterion("usr_balance <=", value, "balance");
			return (Criteria) this;
		}

		public Criteria andBalanceIn(List<Double> values) {
			addCriterion("usr_balance in", values, "balance");
			return (Criteria) this;
		}

		public Criteria andBalanceNotIn(List<Double> values) {
			addCriterion("usr_balance not in", values, "balance");
			return (Criteria) this;
		}

		public Criteria andBalanceBetween(Double value1, Double value2) {
			addCriterion("usr_balance between", value1, value2, "balance");
			return (Criteria) this;
		}

		public Criteria andBalanceNotBetween(Double value1, Double value2) {
			addCriterion("usr_balance not between", value1, value2, "balance");
			return (Criteria) this;
		}

		public Criteria andBuIsNull() {
			addCriterion("usr_bu is null");
			return (Criteria) this;
		}

		public Criteria andBuIsNotNull() {
			addCriterion("usr_bu is not null");
			return (Criteria) this;
		}

		public Criteria andBuEqualTo(String value) {
			addCriterion("usr_bu =", value, "bu");
			return (Criteria) this;
		}

		public Criteria andBuNotEqualTo(String value) {
			addCriterion("usr_bu <>", value, "bu");
			return (Criteria) this;
		}

		public Criteria andBuGreaterThan(String value) {
			addCriterion("usr_bu >", value, "bu");
			return (Criteria) this;
		}

		public Criteria andBuGreaterThanOrEqualTo(String value) {
			addCriterion("usr_bu >=", value, "bu");
			return (Criteria) this;
		}

		public Criteria andBuLessThan(String value) {
			addCriterion("usr_bu <", value, "bu");
			return (Criteria) this;
		}

		public Criteria andBuLessThanOrEqualTo(String value) {
			addCriterion("usr_bu <=", value, "bu");
			return (Criteria) this;
		}

		public Criteria andBuLike(String value) {
			addCriterion("usr_bu like", value, "bu");
			return (Criteria) this;
		}

		public Criteria andBuNotLike(String value) {
			addCriterion("usr_bu not like", value, "bu");
			return (Criteria) this;
		}

		public Criteria andBuIn(List<String> values) {
			addCriterion("usr_bu in", values, "bu");
			return (Criteria) this;
		}

		public Criteria andBuNotIn(List<String> values) {
			addCriterion("usr_bu not in", values, "bu");
			return (Criteria) this;
		}

		public Criteria andBuBetween(String value1, String value2) {
			addCriterion("usr_bu between", value1, value2, "bu");
			return (Criteria) this;
		}

		public Criteria andBuNotBetween(String value1, String value2) {
			addCriterion("usr_bu not between", value1, value2, "bu");
			return (Criteria) this;
		}

		public Criteria andTitleIsNull() {
			addCriterion("usr_title is null");
			return (Criteria) this;
		}

		public Criteria andTitleIsNotNull() {
			addCriterion("usr_title is not null");
			return (Criteria) this;
		}

		public Criteria andTitleEqualTo(String value) {
			addCriterion("usr_title =", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotEqualTo(String value) {
			addCriterion("usr_title <>", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleGreaterThan(String value) {
			addCriterion("usr_title >", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleGreaterThanOrEqualTo(String value) {
			addCriterion("usr_title >=", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLessThan(String value) {
			addCriterion("usr_title <", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLessThanOrEqualTo(String value) {
			addCriterion("usr_title <=", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLike(String value) {
			addCriterion("usr_title like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotLike(String value) {
			addCriterion("usr_title not like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleIn(List<String> values) {
			addCriterion("usr_title in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotIn(List<String> values) {
			addCriterion("usr_title not in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleBetween(String value1, String value2) {
			addCriterion("usr_title between", value1, value2, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotBetween(String value1, String value2) {
			addCriterion("usr_title not between", value1, value2, "title");
			return (Criteria) this;
		}

		public Criteria andGradeIsNull() {
			addCriterion("usr_grade is null");
			return (Criteria) this;
		}

		public Criteria andGradeIsNotNull() {
			addCriterion("usr_grade is not null");
			return (Criteria) this;
		}

		public Criteria andGradeEqualTo(String value) {
			addCriterion("usr_grade =", value, "grade");
			return (Criteria) this;
		}

		public Criteria andGradeNotEqualTo(String value) {
			addCriterion("usr_grade <>", value, "grade");
			return (Criteria) this;
		}

		public Criteria andGradeGreaterThan(String value) {
			addCriterion("usr_grade >", value, "grade");
			return (Criteria) this;
		}

		public Criteria andGradeGreaterThanOrEqualTo(String value) {
			addCriterion("usr_grade >=", value, "grade");
			return (Criteria) this;
		}

		public Criteria andGradeLessThan(String value) {
			addCriterion("usr_grade <", value, "grade");
			return (Criteria) this;
		}

		public Criteria andGradeLessThanOrEqualTo(String value) {
			addCriterion("usr_grade <=", value, "grade");
			return (Criteria) this;
		}

		public Criteria andGradeLike(String value) {
			addCriterion("usr_grade like", value, "grade");
			return (Criteria) this;
		}

		public Criteria andGradeNotLike(String value) {
			addCriterion("usr_grade not like", value, "grade");
			return (Criteria) this;
		}

		public Criteria andGradeIn(List<String> values) {
			addCriterion("usr_grade in", values, "grade");
			return (Criteria) this;
		}

		public Criteria andGradeNotIn(List<String> values) {
			addCriterion("usr_grade not in", values, "grade");
			return (Criteria) this;
		}

		public Criteria andGradeBetween(String value1, String value2) {
			addCriterion("usr_grade between", value1, value2, "grade");
			return (Criteria) this;
		}

		public Criteria andGradeNotBetween(String value1, String value2) {
			addCriterion("usr_grade not between", value1, value2, "grade");
			return (Criteria) this;
		}

		public Criteria andRoleIDIsNull() {
			addCriterion("usr_rl_id is null");
			return (Criteria) this;
		}

		public Criteria andRoleIDIsNotNull() {
			addCriterion("usr_rl_id is not null");
			return (Criteria) this;
		}

		public Criteria andRoleIDEqualTo(Integer value) {
			addCriterion("usr_rl_id =", value, "roleID");
			return (Criteria) this;
		}

		public Criteria andRoleIDNotEqualTo(Integer value) {
			addCriterion("usr_rl_id <>", value, "roleID");
			return (Criteria) this;
		}

		public Criteria andRoleIDGreaterThan(Integer value) {
			addCriterion("usr_rl_id >", value, "roleID");
			return (Criteria) this;
		}

		public Criteria andRoleIDGreaterThanOrEqualTo(Integer value) {
			addCriterion("usr_rl_id >=", value, "roleID");
			return (Criteria) this;
		}

		public Criteria andRoleIDLessThan(Integer value) {
			addCriterion("usr_rl_id <", value, "roleID");
			return (Criteria) this;
		}

		public Criteria andRoleIDLessThanOrEqualTo(Integer value) {
			addCriterion("usr_rl_id <=", value, "roleID");
			return (Criteria) this;
		}

		public Criteria andRoleIDIn(List<Integer> values) {
			addCriterion("usr_rl_id in", values, "roleID");
			return (Criteria) this;
		}

		public Criteria andRoleIDNotIn(List<Integer> values) {
			addCriterion("usr_rl_id not in", values, "roleID");
			return (Criteria) this;
		}

		public Criteria andRoleIDBetween(Integer value1, Integer value2) {
			addCriterion("usr_rl_id between", value1, value2, "roleID");
			return (Criteria) this;
		}

		public Criteria andRoleIDNotBetween(Integer value1, Integer value2) {
			addCriterion("usr_rl_id not between", value1, value2, "roleID");
			return (Criteria) this;
		}

		public Criteria andActiveIsNull() {
			addCriterion("usr_active is null");
			return (Criteria) this;
		}

		public Criteria andActiveIsNotNull() {
			addCriterion("usr_active is not null");
			return (Criteria) this;
		}

		public Criteria andActiveEqualTo(Boolean value) {
			addCriterion("usr_active =", value, "active");
			return (Criteria) this;
		}

		public Criteria andActiveNotEqualTo(Boolean value) {
			addCriterion("usr_active <>", value, "active");
			return (Criteria) this;
		}

		public Criteria andActiveGreaterThan(Boolean value) {
			addCriterion("usr_active >", value, "active");
			return (Criteria) this;
		}

		public Criteria andActiveGreaterThanOrEqualTo(Boolean value) {
			addCriterion("usr_active >=", value, "active");
			return (Criteria) this;
		}

		public Criteria andActiveLessThan(Boolean value) {
			addCriterion("usr_active <", value, "active");
			return (Criteria) this;
		}

		public Criteria andActiveLessThanOrEqualTo(Boolean value) {
			addCriterion("usr_active <=", value, "active");
			return (Criteria) this;
		}

		public Criteria andActiveIn(List<Boolean> values) {
			addCriterion("usr_active in", values, "active");
			return (Criteria) this;
		}

		public Criteria andActiveNotIn(List<Boolean> values) {
			addCriterion("usr_active not in", values, "active");
			return (Criteria) this;
		}

		public Criteria andActiveBetween(Boolean value1, Boolean value2) {
			addCriterion("usr_active between", value1, value2, "active");
			return (Criteria) this;
		}

		public Criteria andActiveNotBetween(Boolean value1, Boolean value2) {
			addCriterion("usr_active not between", value1, value2, "active");
			return (Criteria) this;
		}

		public Criteria andSessionIsNull() {
			addCriterion("usr_session is null");
			return (Criteria) this;
		}

		public Criteria andSessionIsNotNull() {
			addCriterion("usr_session is not null");
			return (Criteria) this;
		}

		public Criteria andSessionEqualTo(Date value) {
			addCriterion("usr_session =", value, "session");
			return (Criteria) this;
		}

		public Criteria andSessionNotEqualTo(Date value) {
			addCriterion("usr_session <>", value, "session");
			return (Criteria) this;
		}

		public Criteria andSessionGreaterThan(Date value) {
			addCriterion("usr_session >", value, "session");
			return (Criteria) this;
		}

		public Criteria andSessionGreaterThanOrEqualTo(Date value) {
			addCriterion("usr_session >=", value, "session");
			return (Criteria) this;
		}

		public Criteria andSessionLessThan(Date value) {
			addCriterion("usr_session <", value, "session");
			return (Criteria) this;
		}

		public Criteria andSessionLessThanOrEqualTo(Date value) {
			addCriterion("usr_session <=", value, "session");
			return (Criteria) this;
		}

		public Criteria andSessionIn(List<Date> values) {
			addCriterion("usr_session in", values, "session");
			return (Criteria) this;
		}

		public Criteria andSessionNotIn(List<Date> values) {
			addCriterion("usr_session not in", values, "session");
			return (Criteria) this;
		}

		public Criteria andSessionBetween(Date value1, Date value2) {
			addCriterion("usr_session between", value1, value2, "session");
			return (Criteria) this;
		}

		public Criteria andSessionNotBetween(Date value1, Date value2) {
			addCriterion("usr_session not between", value1, value2, "session");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table public.la_user
	 * @mbg.generated  Wed Mar 14 16:19:03 CST 2018
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
     * This class corresponds to the database table public.la_user
     *
     * @mbg.generated do_not_delete_during_merge Thu Jan 18 09:51:37 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}