package com.mapper;

import com.entity.Brand;
import com.entity.BrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BrandMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table brand
     *
     * @mbggenerated Mon Apr 08 22:05:46 CST 2019
     */
    int countByExample(BrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table brand
     *
     * @mbggenerated Mon Apr 08 22:05:46 CST 2019
     */
    int deleteByExample(BrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table brand
     *
     * @mbggenerated Mon Apr 08 22:05:46 CST 2019
     */
    int deleteByPrimaryKey(Integer brandId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table brand
     *
     * @mbggenerated Mon Apr 08 22:05:46 CST 2019
     */
    int insert(Brand record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table brand
     *
     * @mbggenerated Mon Apr 08 22:05:46 CST 2019
     */
    int insertSelective(Brand record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table brand
     *
     * @mbggenerated Mon Apr 08 22:05:46 CST 2019
     */
    List<Brand> selectByExample(BrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table brand
     *
     * @mbggenerated Mon Apr 08 22:05:46 CST 2019
     */
    Brand selectByPrimaryKey(Integer brandId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table brand
     *
     * @mbggenerated Mon Apr 08 22:05:46 CST 2019
     */
    int updateByExampleSelective(@Param("record") Brand record, @Param("example") BrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table brand
     *
     * @mbggenerated Mon Apr 08 22:05:46 CST 2019
     */
    int updateByExample(@Param("record") Brand record, @Param("example") BrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table brand
     *
     * @mbggenerated Mon Apr 08 22:05:46 CST 2019
     */
    int updateByPrimaryKeySelective(Brand record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table brand
     *
     * @mbggenerated Mon Apr 08 22:05:46 CST 2019
     */
    int updateByPrimaryKey(Brand record);
}