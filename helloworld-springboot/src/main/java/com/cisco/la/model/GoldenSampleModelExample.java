package com.cisco.la.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoldenSampleModelExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table public.la_golden_sample
	 * @mbg.generated  Mon Feb 12 10:00:19 CST 2018
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table public.la_golden_sample
	 * @mbg.generated  Mon Feb 12 10:00:19 CST 2018
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table public.la_golden_sample
	 * @mbg.generated  Mon Feb 12 10:00:19 CST 2018
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_golden_sample
	 * @mbg.generated  Mon Feb 12 10:00:19 CST 2018
	 */
	public GoldenSampleModelExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_golden_sample
	 * @mbg.generated  Mon Feb 12 10:00:19 CST 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_golden_sample
	 * @mbg.generated  Mon Feb 12 10:00:19 CST 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_golden_sample
	 * @mbg.generated  Mon Feb 12 10:00:19 CST 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_golden_sample
	 * @mbg.generated  Mon Feb 12 10:00:19 CST 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_golden_sample
	 * @mbg.generated  Mon Feb 12 10:00:19 CST 2018
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_golden_sample
	 * @mbg.generated  Mon Feb 12 10:00:19 CST 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_golden_sample
	 * @mbg.generated  Mon Feb 12 10:00:19 CST 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_golden_sample
	 * @mbg.generated  Mon Feb 12 10:00:19 CST 2018
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_golden_sample
	 * @mbg.generated  Mon Feb 12 10:00:19 CST 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_golden_sample
	 * @mbg.generated  Mon Feb 12 10:00:19 CST 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table public.la_golden_sample
	 * @mbg.generated  Mon Feb 12 10:00:19 CST 2018
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
			addCriterion("smpl_id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("smpl_id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(int value) {
			addCriterion("smpl_id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(int value) {
			addCriterion("smpl_id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(int value) {
			addCriterion("smpl_id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(int value) {
			addCriterion("smpl_id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(int value) {
			addCriterion("smpl_id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(int value) {
			addCriterion("smpl_id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("smpl_id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("smpl_id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(int value1, int value2) {
			addCriterion("smpl_id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(int value1, int value2) {
			addCriterion("smpl_id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andGoldenSampleNameIsNull() {
			addCriterion("smpl_name is null");
			return (Criteria) this;
		}

		public Criteria andGoldenSampleNameIsNotNull() {
			addCriterion("smpl_name is not null");
			return (Criteria) this;
		}

		public Criteria andGoldenSampleNameEqualTo(String value) {
			addCriterion("smpl_name =", value, "goldenSampleName");
			return (Criteria) this;
		}

		public Criteria andGoldenSampleNameNotEqualTo(String value) {
			addCriterion("smpl_name <>", value, "goldenSampleName");
			return (Criteria) this;
		}

		public Criteria andGoldenSampleNameGreaterThan(String value) {
			addCriterion("smpl_name >", value, "goldenSampleName");
			return (Criteria) this;
		}

		public Criteria andGoldenSampleNameGreaterThanOrEqualTo(String value) {
			addCriterion("smpl_name >=", value, "goldenSampleName");
			return (Criteria) this;
		}

		public Criteria andGoldenSampleNameLessThan(String value) {
			addCriterion("smpl_name <", value, "goldenSampleName");
			return (Criteria) this;
		}

		public Criteria andGoldenSampleNameLessThanOrEqualTo(String value) {
			addCriterion("smpl_name <=", value, "goldenSampleName");
			return (Criteria) this;
		}

		public Criteria andGoldenSampleNameLike(String value) {
			addCriterion("smpl_name like", value, "goldenSampleName");
			return (Criteria) this;
		}

		public Criteria andGoldenSampleNameNotLike(String value) {
			addCriterion("smpl_name not like", value, "goldenSampleName");
			return (Criteria) this;
		}

		public Criteria andGoldenSampleNameIn(List<String> values) {
			addCriterion("smpl_name in", values, "goldenSampleName");
			return (Criteria) this;
		}

		public Criteria andGoldenSampleNameNotIn(List<String> values) {
			addCriterion("smpl_name not in", values, "goldenSampleName");
			return (Criteria) this;
		}

		public Criteria andGoldenSampleNameBetween(String value1, String value2) {
			addCriterion("smpl_name between", value1, value2, "goldenSampleName");
			return (Criteria) this;
		}

		public Criteria andGoldenSampleNameNotBetween(String value1, String value2) {
			addCriterion("smpl_name not between", value1, value2, "goldenSampleName");
			return (Criteria) this;
		}

		public Criteria andRoleIDIsNull() {
			addCriterion("smpl_rl_id is null");
			return (Criteria) this;
		}

		public Criteria andRoleIDIsNotNull() {
			addCriterion("smpl_rl_id is not null");
			return (Criteria) this;
		}

		public Criteria andRoleIDEqualTo(Integer value) {
			addCriterion("smpl_rl_id =", value, "roleID");
			return (Criteria) this;
		}

		public Criteria andRoleIDNotEqualTo(Integer value) {
			addCriterion("smpl_rl_id <>", value, "roleID");
			return (Criteria) this;
		}

		public Criteria andRoleIDGreaterThan(Integer value) {
			addCriterion("smpl_rl_id >", value, "roleID");
			return (Criteria) this;
		}

		public Criteria andRoleIDGreaterThanOrEqualTo(Integer value) {
			addCriterion("smpl_rl_id >=", value, "roleID");
			return (Criteria) this;
		}

		public Criteria andRoleIDLessThan(Integer value) {
			addCriterion("smpl_rl_id <", value, "roleID");
			return (Criteria) this;
		}

		public Criteria andRoleIDLessThanOrEqualTo(Integer value) {
			addCriterion("smpl_rl_id <=", value, "roleID");
			return (Criteria) this;
		}

		public Criteria andRoleIDIn(List<Integer> values) {
			addCriterion("smpl_rl_id in", values, "roleID");
			return (Criteria) this;
		}

		public Criteria andRoleIDNotIn(List<Integer> values) {
			addCriterion("smpl_rl_id not in", values, "roleID");
			return (Criteria) this;
		}

		public Criteria andRoleIDBetween(Integer value1, Integer value2) {
			addCriterion("smpl_rl_id between", value1, value2, "roleID");
			return (Criteria) this;
		}

		public Criteria andRoleIDNotBetween(Integer value1, Integer value2) {
			addCriterion("smpl_rl_id not between", value1, value2, "roleID");
			return (Criteria) this;
		}

		public Criteria andMandatoryIsNull() {
			addCriterion("smpl_mandatory is null");
			return (Criteria) this;
		}

		public Criteria andMandatoryIsNotNull() {
			addCriterion("smpl_mandatory is not null");
			return (Criteria) this;
		}

		public Criteria andMandatoryEqualTo(String value) {
			addCriterion("smpl_mandatory =", value, "mandatory");
			return (Criteria) this;
		}

		public Criteria andMandatoryNotEqualTo(String value) {
			addCriterion("smpl_mandatory <>", value, "mandatory");
			return (Criteria) this;
		}

		public Criteria andMandatoryGreaterThan(String value) {
			addCriterion("smpl_mandatory >", value, "mandatory");
			return (Criteria) this;
		}

		public Criteria andMandatoryGreaterThanOrEqualTo(String value) {
			addCriterion("smpl_mandatory >=", value, "mandatory");
			return (Criteria) this;
		}

		public Criteria andMandatoryLessThan(String value) {
			addCriterion("smpl_mandatory <", value, "mandatory");
			return (Criteria) this;
		}

		public Criteria andMandatoryLessThanOrEqualTo(String value) {
			addCriterion("smpl_mandatory <=", value, "mandatory");
			return (Criteria) this;
		}

		public Criteria andMandatoryLike(String value) {
			addCriterion("smpl_mandatory like", value, "mandatory");
			return (Criteria) this;
		}

		public Criteria andMandatoryNotLike(String value) {
			addCriterion("smpl_mandatory not like", value, "mandatory");
			return (Criteria) this;
		}

		public Criteria andMandatoryIn(List<String> values) {
			addCriterion("smpl_mandatory in", values, "mandatory");
			return (Criteria) this;
		}

		public Criteria andMandatoryNotIn(List<String> values) {
			addCriterion("smpl_mandatory not in", values, "mandatory");
			return (Criteria) this;
		}

		public Criteria andMandatoryBetween(String value1, String value2) {
			addCriterion("smpl_mandatory between", value1, value2, "mandatory");
			return (Criteria) this;
		}

		public Criteria andMandatoryNotBetween(String value1, String value2) {
			addCriterion("smpl_mandatory not between", value1, value2, "mandatory");
			return (Criteria) this;
		}

		public Criteria andOptionalIsNull() {
			addCriterion("smpl_optional is null");
			return (Criteria) this;
		}

		public Criteria andOptionalIsNotNull() {
			addCriterion("smpl_optional is not null");
			return (Criteria) this;
		}

		public Criteria andOptionalEqualTo(String value) {
			addCriterion("smpl_optional =", value, "optional");
			return (Criteria) this;
		}

		public Criteria andOptionalNotEqualTo(String value) {
			addCriterion("smpl_optional <>", value, "optional");
			return (Criteria) this;
		}

		public Criteria andOptionalGreaterThan(String value) {
			addCriterion("smpl_optional >", value, "optional");
			return (Criteria) this;
		}

		public Criteria andOptionalGreaterThanOrEqualTo(String value) {
			addCriterion("smpl_optional >=", value, "optional");
			return (Criteria) this;
		}

		public Criteria andOptionalLessThan(String value) {
			addCriterion("smpl_optional <", value, "optional");
			return (Criteria) this;
		}

		public Criteria andOptionalLessThanOrEqualTo(String value) {
			addCriterion("smpl_optional <=", value, "optional");
			return (Criteria) this;
		}

		public Criteria andOptionalLike(String value) {
			addCriterion("smpl_optional like", value, "optional");
			return (Criteria) this;
		}

		public Criteria andOptionalNotLike(String value) {
			addCriterion("smpl_optional not like", value, "optional");
			return (Criteria) this;
		}

		public Criteria andOptionalIn(List<String> values) {
			addCriterion("smpl_optional in", values, "optional");
			return (Criteria) this;
		}

		public Criteria andOptionalNotIn(List<String> values) {
			addCriterion("smpl_optional not in", values, "optional");
			return (Criteria) this;
		}

		public Criteria andOptionalBetween(String value1, String value2) {
			addCriterion("smpl_optional between", value1, value2, "optional");
			return (Criteria) this;
		}

		public Criteria andOptionalNotBetween(String value1, String value2) {
			addCriterion("smpl_optional not between", value1, value2, "optional");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIsNull() {
			addCriterion("smpl_update_time is null");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIsNotNull() {
			addCriterion("smpl_update_time is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeEqualTo(Date value) {
			addCriterion("smpl_update_time =", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotEqualTo(Date value) {
			addCriterion("smpl_update_time <>", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThan(Date value) {
			addCriterion("smpl_update_time >", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("smpl_update_time >=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThan(Date value) {
			addCriterion("smpl_update_time <", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
			addCriterion("smpl_update_time <=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIn(List<Date> values) {
			addCriterion("smpl_update_time in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotIn(List<Date> values) {
			addCriterion("smpl_update_time not in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeBetween(Date value1, Date value2) {
			addCriterion("smpl_update_time between", value1, value2, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
			addCriterion("smpl_update_time not between", value1, value2, "updateTime");
			return (Criteria) this;
		}

		public Criteria andActiveIsNull() {
			addCriterion("smpl_active is null");
			return (Criteria) this;
		}

		public Criteria andActiveIsNotNull() {
			addCriterion("smpl_active is not null");
			return (Criteria) this;
		}

		public Criteria andActiveEqualTo(Boolean value) {
			addCriterion("smpl_active =", value, "active");
			return (Criteria) this;
		}

		public Criteria andActiveNotEqualTo(Boolean value) {
			addCriterion("smpl_active <>", value, "active");
			return (Criteria) this;
		}

		public Criteria andActiveGreaterThan(Boolean value) {
			addCriterion("smpl_active >", value, "active");
			return (Criteria) this;
		}

		public Criteria andActiveGreaterThanOrEqualTo(Boolean value) {
			addCriterion("smpl_active >=", value, "active");
			return (Criteria) this;
		}

		public Criteria andActiveLessThan(Boolean value) {
			addCriterion("smpl_active <", value, "active");
			return (Criteria) this;
		}

		public Criteria andActiveLessThanOrEqualTo(Boolean value) {
			addCriterion("smpl_active <=", value, "active");
			return (Criteria) this;
		}

		public Criteria andActiveIn(List<Boolean> values) {
			addCriterion("smpl_active in", values, "active");
			return (Criteria) this;
		}

		public Criteria andActiveNotIn(List<Boolean> values) {
			addCriterion("smpl_active not in", values, "active");
			return (Criteria) this;
		}

		public Criteria andActiveBetween(Boolean value1, Boolean value2) {
			addCriterion("smpl_active between", value1, value2, "active");
			return (Criteria) this;
		}

		public Criteria andActiveNotBetween(Boolean value1, Boolean value2) {
			addCriterion("smpl_active not between", value1, value2, "active");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table public.la_golden_sample
	 * @mbg.generated  Mon Feb 12 10:00:19 CST 2018
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
     * This class corresponds to the database table public.la_golden_sample
     *
     * @mbg.generated do_not_delete_during_merge Thu Jan 18 09:51:37 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}