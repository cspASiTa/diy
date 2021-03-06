package com.hycxkj.postage.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PostageCarryModeExample implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table postage_carry_mode
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table postage_carry_mode
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table postage_carry_mode
     */
    protected List<Criteria> oredCriteria;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table postage_carry_mode
     */
    private static final long serialVersionUID = 1L;

    public PostageCarryModeExample() {
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

    protected abstract static class GeneratedCriteria implements Serializable {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPostageTemplateIdIsNull() {
            addCriterion("postage_template_id is null");
            return (Criteria) this;
        }

        public Criteria andPostageTemplateIdIsNotNull() {
            addCriterion("postage_template_id is not null");
            return (Criteria) this;
        }

        public Criteria andPostageTemplateIdEqualTo(Long value) {
            addCriterion("postage_template_id =", value, "postageTemplateId");
            return (Criteria) this;
        }

        public Criteria andPostageTemplateIdNotEqualTo(Long value) {
            addCriterion("postage_template_id <>", value, "postageTemplateId");
            return (Criteria) this;
        }

        public Criteria andPostageTemplateIdGreaterThan(Long value) {
            addCriterion("postage_template_id >", value, "postageTemplateId");
            return (Criteria) this;
        }

        public Criteria andPostageTemplateIdGreaterThanOrEqualTo(Long value) {
            addCriterion("postage_template_id >=", value, "postageTemplateId");
            return (Criteria) this;
        }

        public Criteria andPostageTemplateIdLessThan(Long value) {
            addCriterion("postage_template_id <", value, "postageTemplateId");
            return (Criteria) this;
        }

        public Criteria andPostageTemplateIdLessThanOrEqualTo(Long value) {
            addCriterion("postage_template_id <=", value, "postageTemplateId");
            return (Criteria) this;
        }

        public Criteria andPostageTemplateIdIn(List<Long> values) {
            addCriterion("postage_template_id in", values, "postageTemplateId");
            return (Criteria) this;
        }

        public Criteria andPostageTemplateIdNotIn(List<Long> values) {
            addCriterion("postage_template_id not in", values, "postageTemplateId");
            return (Criteria) this;
        }

        public Criteria andPostageTemplateIdBetween(Long value1, Long value2) {
            addCriterion("postage_template_id between", value1, value2, "postageTemplateId");
            return (Criteria) this;
        }

        public Criteria andPostageTemplateIdNotBetween(Long value1, Long value2) {
            addCriterion("postage_template_id not between", value1, value2, "postageTemplateId");
            return (Criteria) this;
        }

        public Criteria andRegionIsNull() {
            addCriterion("region is null");
            return (Criteria) this;
        }

        public Criteria andRegionIsNotNull() {
            addCriterion("region is not null");
            return (Criteria) this;
        }

        public Criteria andRegionEqualTo(String value) {
            addCriterion("region =", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotEqualTo(String value) {
            addCriterion("region <>", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThan(String value) {
            addCriterion("region >", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThanOrEqualTo(String value) {
            addCriterion("region >=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThan(String value) {
            addCriterion("region <", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThanOrEqualTo(String value) {
            addCriterion("region <=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLike(String value) {
            addCriterion("region like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotLike(String value) {
            addCriterion("region not like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionIn(List<String> values) {
            addCriterion("region in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotIn(List<String> values) {
            addCriterion("region not in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionBetween(String value1, String value2) {
            addCriterion("region between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotBetween(String value1, String value2) {
            addCriterion("region not between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andFirstPieceIsNull() {
            addCriterion("first_piece is null");
            return (Criteria) this;
        }

        public Criteria andFirstPieceIsNotNull() {
            addCriterion("first_piece is not null");
            return (Criteria) this;
        }

        public Criteria andFirstPieceEqualTo(Integer value) {
            addCriterion("first_piece =", value, "firstPiece");
            return (Criteria) this;
        }

        public Criteria andFirstPieceNotEqualTo(Integer value) {
            addCriterion("first_piece <>", value, "firstPiece");
            return (Criteria) this;
        }

        public Criteria andFirstPieceGreaterThan(Integer value) {
            addCriterion("first_piece >", value, "firstPiece");
            return (Criteria) this;
        }

        public Criteria andFirstPieceGreaterThanOrEqualTo(Integer value) {
            addCriterion("first_piece >=", value, "firstPiece");
            return (Criteria) this;
        }

        public Criteria andFirstPieceLessThan(Integer value) {
            addCriterion("first_piece <", value, "firstPiece");
            return (Criteria) this;
        }

        public Criteria andFirstPieceLessThanOrEqualTo(Integer value) {
            addCriterion("first_piece <=", value, "firstPiece");
            return (Criteria) this;
        }

        public Criteria andFirstPieceIn(List<Integer> values) {
            addCriterion("first_piece in", values, "firstPiece");
            return (Criteria) this;
        }

        public Criteria andFirstPieceNotIn(List<Integer> values) {
            addCriterion("first_piece not in", values, "firstPiece");
            return (Criteria) this;
        }

        public Criteria andFirstPieceBetween(Integer value1, Integer value2) {
            addCriterion("first_piece between", value1, value2, "firstPiece");
            return (Criteria) this;
        }

        public Criteria andFirstPieceNotBetween(Integer value1, Integer value2) {
            addCriterion("first_piece not between", value1, value2, "firstPiece");
            return (Criteria) this;
        }

        public Criteria andFirstWeightIsNull() {
            addCriterion("first_weight is null");
            return (Criteria) this;
        }

        public Criteria andFirstWeightIsNotNull() {
            addCriterion("first_weight is not null");
            return (Criteria) this;
        }

        public Criteria andFirstWeightEqualTo(Long value) {
            addCriterion("first_weight =", value, "firstWeight");
            return (Criteria) this;
        }

        public Criteria andFirstWeightNotEqualTo(Long value) {
            addCriterion("first_weight <>", value, "firstWeight");
            return (Criteria) this;
        }

        public Criteria andFirstWeightGreaterThan(Long value) {
            addCriterion("first_weight >", value, "firstWeight");
            return (Criteria) this;
        }

        public Criteria andFirstWeightGreaterThanOrEqualTo(Long value) {
            addCriterion("first_weight >=", value, "firstWeight");
            return (Criteria) this;
        }

        public Criteria andFirstWeightLessThan(Long value) {
            addCriterion("first_weight <", value, "firstWeight");
            return (Criteria) this;
        }

        public Criteria andFirstWeightLessThanOrEqualTo(Long value) {
            addCriterion("first_weight <=", value, "firstWeight");
            return (Criteria) this;
        }

        public Criteria andFirstWeightIn(List<Long> values) {
            addCriterion("first_weight in", values, "firstWeight");
            return (Criteria) this;
        }

        public Criteria andFirstWeightNotIn(List<Long> values) {
            addCriterion("first_weight not in", values, "firstWeight");
            return (Criteria) this;
        }

        public Criteria andFirstWeightBetween(Long value1, Long value2) {
            addCriterion("first_weight between", value1, value2, "firstWeight");
            return (Criteria) this;
        }

        public Criteria andFirstWeightNotBetween(Long value1, Long value2) {
            addCriterion("first_weight not between", value1, value2, "firstWeight");
            return (Criteria) this;
        }

        public Criteria andFirstBulkIsNull() {
            addCriterion("first_bulk is null");
            return (Criteria) this;
        }

        public Criteria andFirstBulkIsNotNull() {
            addCriterion("first_bulk is not null");
            return (Criteria) this;
        }

        public Criteria andFirstBulkEqualTo(Long value) {
            addCriterion("first_bulk =", value, "firstBulk");
            return (Criteria) this;
        }

        public Criteria andFirstBulkNotEqualTo(Long value) {
            addCriterion("first_bulk <>", value, "firstBulk");
            return (Criteria) this;
        }

        public Criteria andFirstBulkGreaterThan(Long value) {
            addCriterion("first_bulk >", value, "firstBulk");
            return (Criteria) this;
        }

        public Criteria andFirstBulkGreaterThanOrEqualTo(Long value) {
            addCriterion("first_bulk >=", value, "firstBulk");
            return (Criteria) this;
        }

        public Criteria andFirstBulkLessThan(Long value) {
            addCriterion("first_bulk <", value, "firstBulk");
            return (Criteria) this;
        }

        public Criteria andFirstBulkLessThanOrEqualTo(Long value) {
            addCriterion("first_bulk <=", value, "firstBulk");
            return (Criteria) this;
        }

        public Criteria andFirstBulkIn(List<Long> values) {
            addCriterion("first_bulk in", values, "firstBulk");
            return (Criteria) this;
        }

        public Criteria andFirstBulkNotIn(List<Long> values) {
            addCriterion("first_bulk not in", values, "firstBulk");
            return (Criteria) this;
        }

        public Criteria andFirstBulkBetween(Long value1, Long value2) {
            addCriterion("first_bulk between", value1, value2, "firstBulk");
            return (Criteria) this;
        }

        public Criteria andFirstBulkNotBetween(Long value1, Long value2) {
            addCriterion("first_bulk not between", value1, value2, "firstBulk");
            return (Criteria) this;
        }

        public Criteria andFirstAmountIsNull() {
            addCriterion("first_amount is null");
            return (Criteria) this;
        }

        public Criteria andFirstAmountIsNotNull() {
            addCriterion("first_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFirstAmountEqualTo(Long value) {
            addCriterion("first_amount =", value, "firstAmount");
            return (Criteria) this;
        }

        public Criteria andFirstAmountNotEqualTo(Long value) {
            addCriterion("first_amount <>", value, "firstAmount");
            return (Criteria) this;
        }

        public Criteria andFirstAmountGreaterThan(Long value) {
            addCriterion("first_amount >", value, "firstAmount");
            return (Criteria) this;
        }

        public Criteria andFirstAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("first_amount >=", value, "firstAmount");
            return (Criteria) this;
        }

        public Criteria andFirstAmountLessThan(Long value) {
            addCriterion("first_amount <", value, "firstAmount");
            return (Criteria) this;
        }

        public Criteria andFirstAmountLessThanOrEqualTo(Long value) {
            addCriterion("first_amount <=", value, "firstAmount");
            return (Criteria) this;
        }

        public Criteria andFirstAmountIn(List<Long> values) {
            addCriterion("first_amount in", values, "firstAmount");
            return (Criteria) this;
        }

        public Criteria andFirstAmountNotIn(List<Long> values) {
            addCriterion("first_amount not in", values, "firstAmount");
            return (Criteria) this;
        }

        public Criteria andFirstAmountBetween(Long value1, Long value2) {
            addCriterion("first_amount between", value1, value2, "firstAmount");
            return (Criteria) this;
        }

        public Criteria andFirstAmountNotBetween(Long value1, Long value2) {
            addCriterion("first_amount not between", value1, value2, "firstAmount");
            return (Criteria) this;
        }

        public Criteria andSecondPieceIsNull() {
            addCriterion("second_piece is null");
            return (Criteria) this;
        }

        public Criteria andSecondPieceIsNotNull() {
            addCriterion("second_piece is not null");
            return (Criteria) this;
        }

        public Criteria andSecondPieceEqualTo(Integer value) {
            addCriterion("second_piece =", value, "secondPiece");
            return (Criteria) this;
        }

        public Criteria andSecondPieceNotEqualTo(Integer value) {
            addCriterion("second_piece <>", value, "secondPiece");
            return (Criteria) this;
        }

        public Criteria andSecondPieceGreaterThan(Integer value) {
            addCriterion("second_piece >", value, "secondPiece");
            return (Criteria) this;
        }

        public Criteria andSecondPieceGreaterThanOrEqualTo(Integer value) {
            addCriterion("second_piece >=", value, "secondPiece");
            return (Criteria) this;
        }

        public Criteria andSecondPieceLessThan(Integer value) {
            addCriterion("second_piece <", value, "secondPiece");
            return (Criteria) this;
        }

        public Criteria andSecondPieceLessThanOrEqualTo(Integer value) {
            addCriterion("second_piece <=", value, "secondPiece");
            return (Criteria) this;
        }

        public Criteria andSecondPieceIn(List<Integer> values) {
            addCriterion("second_piece in", values, "secondPiece");
            return (Criteria) this;
        }

        public Criteria andSecondPieceNotIn(List<Integer> values) {
            addCriterion("second_piece not in", values, "secondPiece");
            return (Criteria) this;
        }

        public Criteria andSecondPieceBetween(Integer value1, Integer value2) {
            addCriterion("second_piece between", value1, value2, "secondPiece");
            return (Criteria) this;
        }

        public Criteria andSecondPieceNotBetween(Integer value1, Integer value2) {
            addCriterion("second_piece not between", value1, value2, "secondPiece");
            return (Criteria) this;
        }

        public Criteria andSecondWeightIsNull() {
            addCriterion("second_weight is null");
            return (Criteria) this;
        }

        public Criteria andSecondWeightIsNotNull() {
            addCriterion("second_weight is not null");
            return (Criteria) this;
        }

        public Criteria andSecondWeightEqualTo(Long value) {
            addCriterion("second_weight =", value, "secondWeight");
            return (Criteria) this;
        }

        public Criteria andSecondWeightNotEqualTo(Long value) {
            addCriterion("second_weight <>", value, "secondWeight");
            return (Criteria) this;
        }

        public Criteria andSecondWeightGreaterThan(Long value) {
            addCriterion("second_weight >", value, "secondWeight");
            return (Criteria) this;
        }

        public Criteria andSecondWeightGreaterThanOrEqualTo(Long value) {
            addCriterion("second_weight >=", value, "secondWeight");
            return (Criteria) this;
        }

        public Criteria andSecondWeightLessThan(Long value) {
            addCriterion("second_weight <", value, "secondWeight");
            return (Criteria) this;
        }

        public Criteria andSecondWeightLessThanOrEqualTo(Long value) {
            addCriterion("second_weight <=", value, "secondWeight");
            return (Criteria) this;
        }

        public Criteria andSecondWeightIn(List<Long> values) {
            addCriterion("second_weight in", values, "secondWeight");
            return (Criteria) this;
        }

        public Criteria andSecondWeightNotIn(List<Long> values) {
            addCriterion("second_weight not in", values, "secondWeight");
            return (Criteria) this;
        }

        public Criteria andSecondWeightBetween(Long value1, Long value2) {
            addCriterion("second_weight between", value1, value2, "secondWeight");
            return (Criteria) this;
        }

        public Criteria andSecondWeightNotBetween(Long value1, Long value2) {
            addCriterion("second_weight not between", value1, value2, "secondWeight");
            return (Criteria) this;
        }

        public Criteria andSecondAmountIsNull() {
            addCriterion("second_amount is null");
            return (Criteria) this;
        }

        public Criteria andSecondAmountIsNotNull() {
            addCriterion("second_amount is not null");
            return (Criteria) this;
        }

        public Criteria andSecondAmountEqualTo(Long value) {
            addCriterion("second_amount =", value, "secondAmount");
            return (Criteria) this;
        }

        public Criteria andSecondAmountNotEqualTo(Long value) {
            addCriterion("second_amount <>", value, "secondAmount");
            return (Criteria) this;
        }

        public Criteria andSecondAmountGreaterThan(Long value) {
            addCriterion("second_amount >", value, "secondAmount");
            return (Criteria) this;
        }

        public Criteria andSecondAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("second_amount >=", value, "secondAmount");
            return (Criteria) this;
        }

        public Criteria andSecondAmountLessThan(Long value) {
            addCriterion("second_amount <", value, "secondAmount");
            return (Criteria) this;
        }

        public Criteria andSecondAmountLessThanOrEqualTo(Long value) {
            addCriterion("second_amount <=", value, "secondAmount");
            return (Criteria) this;
        }

        public Criteria andSecondAmountIn(List<Long> values) {
            addCriterion("second_amount in", values, "secondAmount");
            return (Criteria) this;
        }

        public Criteria andSecondAmountNotIn(List<Long> values) {
            addCriterion("second_amount not in", values, "secondAmount");
            return (Criteria) this;
        }

        public Criteria andSecondAmountBetween(Long value1, Long value2) {
            addCriterion("second_amount between", value1, value2, "secondAmount");
            return (Criteria) this;
        }

        public Criteria andSecondAmountNotBetween(Long value1, Long value2) {
            addCriterion("second_amount not between", value1, value2, "secondAmount");
            return (Criteria) this;
        }

        public Criteria andSecondBulkIsNull() {
            addCriterion("second_bulk is null");
            return (Criteria) this;
        }

        public Criteria andSecondBulkIsNotNull() {
            addCriterion("second_bulk is not null");
            return (Criteria) this;
        }

        public Criteria andSecondBulkEqualTo(Long value) {
            addCriterion("second_bulk =", value, "secondBulk");
            return (Criteria) this;
        }

        public Criteria andSecondBulkNotEqualTo(Long value) {
            addCriterion("second_bulk <>", value, "secondBulk");
            return (Criteria) this;
        }

        public Criteria andSecondBulkGreaterThan(Long value) {
            addCriterion("second_bulk >", value, "secondBulk");
            return (Criteria) this;
        }

        public Criteria andSecondBulkGreaterThanOrEqualTo(Long value) {
            addCriterion("second_bulk >=", value, "secondBulk");
            return (Criteria) this;
        }

        public Criteria andSecondBulkLessThan(Long value) {
            addCriterion("second_bulk <", value, "secondBulk");
            return (Criteria) this;
        }

        public Criteria andSecondBulkLessThanOrEqualTo(Long value) {
            addCriterion("second_bulk <=", value, "secondBulk");
            return (Criteria) this;
        }

        public Criteria andSecondBulkIn(List<Long> values) {
            addCriterion("second_bulk in", values, "secondBulk");
            return (Criteria) this;
        }

        public Criteria andSecondBulkNotIn(List<Long> values) {
            addCriterion("second_bulk not in", values, "secondBulk");
            return (Criteria) this;
        }

        public Criteria andSecondBulkBetween(Long value1, Long value2) {
            addCriterion("second_bulk between", value1, value2, "secondBulk");
            return (Criteria) this;
        }

        public Criteria andSecondBulkNotBetween(Long value1, Long value2) {
            addCriterion("second_bulk not between", value1, value2, "secondBulk");
            return (Criteria) this;
        }

        public Criteria andCarryAwayIsNull() {
            addCriterion("carry_away is null");
            return (Criteria) this;
        }

        public Criteria andCarryAwayIsNotNull() {
            addCriterion("carry_away is not null");
            return (Criteria) this;
        }

        public Criteria andCarryAwayEqualTo(Byte value) {
            addCriterion("carry_away =", value, "carryAway");
            return (Criteria) this;
        }

        public Criteria andCarryAwayNotEqualTo(Byte value) {
            addCriterion("carry_away <>", value, "carryAway");
            return (Criteria) this;
        }

        public Criteria andCarryAwayGreaterThan(Byte value) {
            addCriterion("carry_away >", value, "carryAway");
            return (Criteria) this;
        }

        public Criteria andCarryAwayGreaterThanOrEqualTo(Byte value) {
            addCriterion("carry_away >=", value, "carryAway");
            return (Criteria) this;
        }

        public Criteria andCarryAwayLessThan(Byte value) {
            addCriterion("carry_away <", value, "carryAway");
            return (Criteria) this;
        }

        public Criteria andCarryAwayLessThanOrEqualTo(Byte value) {
            addCriterion("carry_away <=", value, "carryAway");
            return (Criteria) this;
        }

        public Criteria andCarryAwayIn(List<Byte> values) {
            addCriterion("carry_away in", values, "carryAway");
            return (Criteria) this;
        }

        public Criteria andCarryAwayNotIn(List<Byte> values) {
            addCriterion("carry_away not in", values, "carryAway");
            return (Criteria) this;
        }

        public Criteria andCarryAwayBetween(Byte value1, Byte value2) {
            addCriterion("carry_away between", value1, value2, "carryAway");
            return (Criteria) this;
        }

        public Criteria andCarryAwayNotBetween(Byte value1, Byte value2) {
            addCriterion("carry_away not between", value1, value2, "carryAway");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIsNull() {
            addCriterion("is_default is null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIsNotNull() {
            addCriterion("is_default is not null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultEqualTo(Boolean value) {
            addCriterion("is_default =", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotEqualTo(Boolean value) {
            addCriterion("is_default <>", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultGreaterThan(Boolean value) {
            addCriterion("is_default >", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_default >=", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLessThan(Boolean value) {
            addCriterion("is_default <", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLessThanOrEqualTo(Boolean value) {
            addCriterion("is_default <=", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIn(List<Boolean> values) {
            addCriterion("is_default in", values, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotIn(List<Boolean> values) {
            addCriterion("is_default not in", values, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultBetween(Boolean value1, Boolean value2) {
            addCriterion("is_default between", value1, value2, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_default not between", value1, value2, "isDefault");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table postage_carry_mode
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {
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