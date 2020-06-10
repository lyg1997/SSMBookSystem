package po;

import java.util.ArrayList;
import java.util.List;

public class TbRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbRecordExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andBookIdIsNull() {
            addCriterion("book_id is null");
            return (Criteria) this;
        }

        public Criteria andBookIdIsNotNull() {
            addCriterion("book_id is not null");
            return (Criteria) this;
        }

        public Criteria andBookIdEqualTo(Integer value) {
            addCriterion("book_id =", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotEqualTo(Integer value) {
            addCriterion("book_id <>", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThan(Integer value) {
            addCriterion("book_id >", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_id >=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThan(Integer value) {
            addCriterion("book_id <", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThanOrEqualTo(Integer value) {
            addCriterion("book_id <=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdIn(List<Integer> values) {
            addCriterion("book_id in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotIn(List<Integer> values) {
            addCriterion("book_id not in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdBetween(Integer value1, Integer value2) {
            addCriterion("book_id between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotBetween(Integer value1, Integer value2) {
            addCriterion("book_id not between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andRecorddateIsNull() {
            addCriterion("recordDate is null");
            return (Criteria) this;
        }

        public Criteria andRecorddateIsNotNull() {
            addCriterion("recordDate is not null");
            return (Criteria) this;
        }

        public Criteria andRecorddateEqualTo(Long value) {
            addCriterion("recordDate =", value, "recorddate");
            return (Criteria) this;
        }

        public Criteria andRecorddateNotEqualTo(Long value) {
            addCriterion("recordDate <>", value, "recorddate");
            return (Criteria) this;
        }

        public Criteria andRecorddateGreaterThan(Long value) {
            addCriterion("recordDate >", value, "recorddate");
            return (Criteria) this;
        }

        public Criteria andRecorddateGreaterThanOrEqualTo(Long value) {
            addCriterion("recordDate >=", value, "recorddate");
            return (Criteria) this;
        }

        public Criteria andRecorddateLessThan(Long value) {
            addCriterion("recordDate <", value, "recorddate");
            return (Criteria) this;
        }

        public Criteria andRecorddateLessThanOrEqualTo(Long value) {
            addCriterion("recordDate <=", value, "recorddate");
            return (Criteria) this;
        }

        public Criteria andRecorddateIn(List<Long> values) {
            addCriterion("recordDate in", values, "recorddate");
            return (Criteria) this;
        }

        public Criteria andRecorddateNotIn(List<Long> values) {
            addCriterion("recordDate not in", values, "recorddate");
            return (Criteria) this;
        }

        public Criteria andRecorddateBetween(Long value1, Long value2) {
            addCriterion("recordDate between", value1, value2, "recorddate");
            return (Criteria) this;
        }

        public Criteria andRecorddateNotBetween(Long value1, Long value2) {
            addCriterion("recordDate not between", value1, value2, "recorddate");
            return (Criteria) this;
        }

        public Criteria andBackdateIsNull() {
            addCriterion("backDate is null");
            return (Criteria) this;
        }

        public Criteria andBackdateIsNotNull() {
            addCriterion("backDate is not null");
            return (Criteria) this;
        }

        public Criteria andBackdateEqualTo(Long value) {
            addCriterion("backDate =", value, "backdate");
            return (Criteria) this;
        }

        public Criteria andBackdateNotEqualTo(Long value) {
            addCriterion("backDate <>", value, "backdate");
            return (Criteria) this;
        }

        public Criteria andBackdateGreaterThan(Long value) {
            addCriterion("backDate >", value, "backdate");
            return (Criteria) this;
        }

        public Criteria andBackdateGreaterThanOrEqualTo(Long value) {
            addCriterion("backDate >=", value, "backdate");
            return (Criteria) this;
        }

        public Criteria andBackdateLessThan(Long value) {
            addCriterion("backDate <", value, "backdate");
            return (Criteria) this;
        }

        public Criteria andBackdateLessThanOrEqualTo(Long value) {
            addCriterion("backDate <=", value, "backdate");
            return (Criteria) this;
        }

        public Criteria andBackdateIn(List<Long> values) {
            addCriterion("backDate in", values, "backdate");
            return (Criteria) this;
        }

        public Criteria andBackdateNotIn(List<Long> values) {
            addCriterion("backDate not in", values, "backdate");
            return (Criteria) this;
        }

        public Criteria andBackdateBetween(Long value1, Long value2) {
            addCriterion("backDate between", value1, value2, "backdate");
            return (Criteria) this;
        }

        public Criteria andBackdateNotBetween(Long value1, Long value2) {
            addCriterion("backDate not between", value1, value2, "backdate");
            return (Criteria) this;
        }

        public Criteria andReturnbookIsNull() {
            addCriterion("returnbook is null");
            return (Criteria) this;
        }

        public Criteria andReturnbookIsNotNull() {
            addCriterion("returnbook is not null");
            return (Criteria) this;
        }

        public Criteria andReturnbookEqualTo(Integer value) {
            addCriterion("returnbook =", value, "returnbook");
            return (Criteria) this;
        }

        public Criteria andReturnbookNotEqualTo(Integer value) {
            addCriterion("returnbook <>", value, "returnbook");
            return (Criteria) this;
        }

        public Criteria andReturnbookGreaterThan(Integer value) {
            addCriterion("returnbook >", value, "returnbook");
            return (Criteria) this;
        }

        public Criteria andReturnbookGreaterThanOrEqualTo(Integer value) {
            addCriterion("returnbook >=", value, "returnbook");
            return (Criteria) this;
        }

        public Criteria andReturnbookLessThan(Integer value) {
            addCriterion("returnbook <", value, "returnbook");
            return (Criteria) this;
        }

        public Criteria andReturnbookLessThanOrEqualTo(Integer value) {
            addCriterion("returnbook <=", value, "returnbook");
            return (Criteria) this;
        }

        public Criteria andReturnbookIn(List<Integer> values) {
            addCriterion("returnbook in", values, "returnbook");
            return (Criteria) this;
        }

        public Criteria andReturnbookNotIn(List<Integer> values) {
            addCriterion("returnbook not in", values, "returnbook");
            return (Criteria) this;
        }

        public Criteria andReturnbookBetween(Integer value1, Integer value2) {
            addCriterion("returnbook between", value1, value2, "returnbook");
            return (Criteria) this;
        }

        public Criteria andReturnbookNotBetween(Integer value1, Integer value2) {
            addCriterion("returnbook not between", value1, value2, "returnbook");
            return (Criteria) this;
        }

        public Criteria andTicketffeeIsNull() {
            addCriterion("ticketFfee is null");
            return (Criteria) this;
        }

        public Criteria andTicketffeeIsNotNull() {
            addCriterion("ticketFfee is not null");
            return (Criteria) this;
        }

        public Criteria andTicketffeeEqualTo(Float value) {
            addCriterion("ticketFfee =", value, "ticketffee");
            return (Criteria) this;
        }

        public Criteria andTicketffeeNotEqualTo(Float value) {
            addCriterion("ticketFfee <>", value, "ticketffee");
            return (Criteria) this;
        }

        public Criteria andTicketffeeGreaterThan(Float value) {
            addCriterion("ticketFfee >", value, "ticketffee");
            return (Criteria) this;
        }

        public Criteria andTicketffeeGreaterThanOrEqualTo(Float value) {
            addCriterion("ticketFfee >=", value, "ticketffee");
            return (Criteria) this;
        }

        public Criteria andTicketffeeLessThan(Float value) {
            addCriterion("ticketFfee <", value, "ticketffee");
            return (Criteria) this;
        }

        public Criteria andTicketffeeLessThanOrEqualTo(Float value) {
            addCriterion("ticketFfee <=", value, "ticketffee");
            return (Criteria) this;
        }

        public Criteria andTicketffeeIn(List<Float> values) {
            addCriterion("ticketFfee in", values, "ticketffee");
            return (Criteria) this;
        }

        public Criteria andTicketffeeNotIn(List<Float> values) {
            addCriterion("ticketFfee not in", values, "ticketffee");
            return (Criteria) this;
        }

        public Criteria andTicketffeeBetween(Float value1, Float value2) {
            addCriterion("ticketFfee between", value1, value2, "ticketffee");
            return (Criteria) this;
        }

        public Criteria andTicketffeeNotBetween(Float value1, Float value2) {
            addCriterion("ticketFfee not between", value1, value2, "ticketffee");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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
}