package com.zyw.manage.domain.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`manage_product`")
public class ProductEntity {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manage_product.id
     *
     * @mbg.generated Sun Nov 10 20:58:01 CST 2019
     */
    @Id
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manage_product.product_name
     *
     * @mbg.generated Sun Nov 10 20:58:01 CST 2019
     */
    private String productName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manage_product.unit
     *
     * @mbg.generated Sun Nov 10 20:58:01 CST 2019
     */
    private String unit;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manage_product.is_deleted
     *
     * @mbg.generated Sun Nov 10 20:58:01 CST 2019
     */
    private String isDeleted;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manage_product.creator
     *
     * @mbg.generated Sun Nov 10 20:58:01 CST 2019
     */
    private String creator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manage_product.gmt_created
     *
     * @mbg.generated Sun Nov 10 20:58:01 CST 2019
     */
    private Date gmtCreated;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manage_product.modifier
     *
     * @mbg.generated Sun Nov 10 20:58:01 CST 2019
     */
    private String modifier;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manage_product.gmt_modified
     *
     * @mbg.generated Sun Nov 10 20:58:01 CST 2019
     */
    private Date gmtModified;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manage_product.id
     *
     * @return the value of manage_product.id
     *
     * @mbg.generated Sun Nov 10 20:58:01 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manage_product.id
     *
     * @param id the value for manage_product.id
     *
     * @mbg.generated Sun Nov 10 20:58:01 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manage_product.product_name
     *
     * @return the value of manage_product.product_name
     *
     * @mbg.generated Sun Nov 10 20:58:01 CST 2019
     */
    public String getProductName() {
        return productName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manage_product.product_name
     *
     * @param productName the value for manage_product.product_name
     *
     * @mbg.generated Sun Nov 10 20:58:01 CST 2019
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manage_product.unit
     *
     * @return the value of manage_product.unit
     *
     * @mbg.generated Sun Nov 10 20:58:01 CST 2019
     */
    public String getUnit() {
        return unit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manage_product.unit
     *
     * @param unit the value for manage_product.unit
     *
     * @mbg.generated Sun Nov 10 20:58:01 CST 2019
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manage_product.is_deleted
     *
     * @return the value of manage_product.is_deleted
     *
     * @mbg.generated Sun Nov 10 20:58:01 CST 2019
     */
    public String getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manage_product.is_deleted
     *
     * @param isDeleted the value for manage_product.is_deleted
     *
     * @mbg.generated Sun Nov 10 20:58:01 CST 2019
     */
    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manage_product.creator
     *
     * @return the value of manage_product.creator
     *
     * @mbg.generated Sun Nov 10 20:58:01 CST 2019
     */
    public String getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manage_product.creator
     *
     * @param creator the value for manage_product.creator
     *
     * @mbg.generated Sun Nov 10 20:58:01 CST 2019
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manage_product.gmt_created
     *
     * @return the value of manage_product.gmt_created
     *
     * @mbg.generated Sun Nov 10 20:58:01 CST 2019
     */
    public Date getGmtCreated() {
        return gmtCreated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manage_product.gmt_created
     *
     * @param gmtCreated the value for manage_product.gmt_created
     *
     * @mbg.generated Sun Nov 10 20:58:01 CST 2019
     */
    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manage_product.modifier
     *
     * @return the value of manage_product.modifier
     *
     * @mbg.generated Sun Nov 10 20:58:01 CST 2019
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manage_product.modifier
     *
     * @param modifier the value for manage_product.modifier
     *
     * @mbg.generated Sun Nov 10 20:58:01 CST 2019
     */
    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manage_product.gmt_modified
     *
     * @return the value of manage_product.gmt_modified
     *
     * @mbg.generated Sun Nov 10 20:58:01 CST 2019
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manage_product.gmt_modified
     *
     * @param gmtModified the value for manage_product.gmt_modified
     *
     * @mbg.generated Sun Nov 10 20:58:01 CST 2019
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}