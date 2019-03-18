package com.hexaware.FTP106.model;
import java.util.Objects;
/**
 * Menu class used to display menu information.
 * @author hexware
 */
public class Customer {
  private int cId;
  private String cName;
  private String cUserName;
  private String cPhone;
  private String cEmail;
  private float cWallet;
  private String cPassword;
/**
 * Default Constructor.
 */
  public Customer() {
  }
/**
 * @param argCId to initialise argCId.
 * @param argCName to initialise argCName.
 *  * @param argCUserName to initialise argCName.
 * @param argCPhone to initialise argCPhone.
 * @param argCEmail to initialise argCEmail.
 * @param argCWallet to initialise argCWallet.
 * @param argCPassword to initialise argCPassword.
 */
  public Customer(final int argCId, final String argCName, final String argCUserName,
      final String argCPhone, final String argCEmail,
      final float argCWallet, final String argCPassword) {
    this.cId = argCId;
    this.cName = argCName;
    this.cUserName = argCUserName;
    this.cPhone = argCPhone;
    this.cEmail = argCEmail;
    this.cWallet = argCWallet;
    this.cPassword = argCPassword;
  }
/**
* @param argFoodId to initialize food id.
* used to get details through constructor.
*/
  @Override
   public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Customer customer = (Customer) obj;
    if (Objects.equals(cId, customer.cId) && Objects.equals(cName, customer.cName) && Objects.equals(cUserName, customer.cUserName) && Objects.equals(cPhone, customer.cPhone)
        && Objects.equals(cEmail, customer.cEmail) && Objects.equals(cWallet, customer.cWallet)
        && Objects.equals(cPassword, customer.cPassword)) {
      return true;
    }
    return false;
  }
  @Override
     public final int hashCode() {
    return Objects.hash(cId, cName, cUserName, cPhone, cEmail, cWallet, cPassword);
  }
  /**
   @return tostring
   */
  @Override
  public final String toString() {
    return cId + "  " + cName + "  " + cUserName + "  " + cPhone + "  " + cEmail + "  " + cWallet + "  " + cPassword;
  }

 /**
 * @param argCId to set.
 */
  public final void setCId(final int argCId) {
    this.cId = argCId;
  }
/**
* @return cId.
*/
  public final int getCId() {
    return cId;
  }
/**
* @param argCName the cName to set.
*/
  public final void setCName(final String argCName) {
    this.cName = argCName;
  }
/**
* @return cName.
*/
  public final String getCName() {
    return cName;
  }
/**
* @param argCUserName the cName to set.
*/
  public final void setCUserName(final String argCUserName) {
    this.cUserName = argCUserName;
  }
/**
* @return cUserName.
*/
  public final String getCUserName() {
    return cUserName;
  }
/**
* @param argCPhone the cPhone to set.
*/
  public final void setCPhone(final String argCPhone) {
    this.cPhone = argCPhone;
  }
/**
 * @return the argcPhone.
 */
  public final String getCPhone() {
    return cPhone;
  }
/**
* @param argCEmail the cEmail to set.
*/
  public final void setCEmail(final String argCEmail) {
    this.cEmail = argCEmail;
  }
/**
* @return the argCEmail
*/
  public final String getCEmail() {
    return cEmail;
  }
/**
* @param argCWallet the cWallet to set
*/
  public final void setCWallet(final float argCWallet) {
    this.cWallet = argCWallet;
  }
/**
 * @return the argCWallet.
*/
  public final float getCWallet() {
    return cWallet;
  }
/**
* @param argCPassword the cPassword to set.
*/
  public final void setCPassword(final String argCPassword) {
    this.cPassword = argCPassword;
  }
/**
 * @return the argCPassword.
 */
  public final String getCPassword() {
    return cPassword;
  }
}
