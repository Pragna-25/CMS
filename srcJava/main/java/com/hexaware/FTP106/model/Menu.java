package com.hexaware.FTP106.model;

import java.util.Objects;

/**
 * Menu class used to display menu information.
 * @author hexware
 */
public class Menu {
  private int foodId;
  private String foodName;
  private int vId;
  private String foodCategory;
  private int foodPrice;
  private String foodDescription;

  /**
   * @return foodId
   */
  public final int getFoodId() {
    return foodId;
  }

  /**
   * @param argFoodId is intiatialized
   */
  public final void setFoodId(final int argFoodId) {
    this.foodId = argFoodId;
  }

  /**
   * @return foodName
   */
  public final String getFoodName() {
    return foodName;
  }

  /**
   * @param argFoodName for initialization
   */
  public final void setFoodName(final String argFoodName) {
    this.foodName = argFoodName;
  }

  /**
   * @return VId
   */
  public final int getVId() {
    return vId;
  }

  /**
   * @param argVId for initialization
   */
  public final void setVId(final int argVId) {
    this.vId = argVId;
  }

  /**
   * @return FoodCategory
   */
  public final String getFoodCategory() {
    return foodCategory;
  }

  /**
   * @param argFoodCategory for initialization
   */
  public final void setFoodCategory(final String argFoodCategory) {
    this.foodCategory = argFoodCategory;
  }

  /**
   * @return FoodPrice
   */
  public final int getFoodPrice() {
    return foodPrice;
  }

  /**
   * @param argFoodPrice for initialization
   */
  public final void setFoodPrice(final int argFoodPrice) {
    this.foodPrice = argFoodPrice;
  }

  /**
   * @return FoodDescription
   */
  public final String getFoodDescription() {
    return foodDescription;
  }

  /**
   * @param argFoodDescription for initialization
   */
  public final void setFoodDescription(final String argFoodDescription) {
    this.foodDescription = argFoodDescription;
  }

  /**
   * Default Constructor.
   */
  public Menu() {
  }

  /**
   * @param argFoodName        to initialize food name.
   * @param argFoodId          to initialize food id.
   * @param argFoodDescription to initialize food description.
   * @param argFoodCategory    to initialize food category.
   * @param argFoodPrice       to initialize food price.
   * @param argVId             to initialize VId.
   */
  public Menu(final int argFoodId, final String argFoodName, final int argVId, final int argFoodPrice,
      final String argFoodDescription, final String argFoodCategory) {
    this.foodId = argFoodId;
    this.foodName = argFoodName;
    this.vId = argVId;
    this.foodPrice = argFoodPrice;
    this.foodDescription = argFoodDescription;
    this.foodCategory = argFoodCategory;
  }

  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Menu menu = (Menu) obj;
    if (Objects.equals(foodId, menu.foodId) && Objects.equals(foodName, menu.foodName) && Objects.equals(vId, menu.vId)
        && Objects.equals(foodCategory, menu.foodCategory) && Objects.equals(foodDescription, menu.foodDescription)
        && Objects.equals(foodPrice, menu.foodPrice)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(foodId, foodName, vId, foodCategory, foodDescription, foodPrice);
  }

  /**
   * @return tostring
   */
  @Override
  public final String toString() {
    return foodId + "  " + foodName + "  " + vId + "  " + foodCategory + "  " + foodDescription + "  " + foodPrice;
  }
}
