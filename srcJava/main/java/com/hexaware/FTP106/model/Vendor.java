package com.hexaware.FTP106.model;
import java.util.Objects;
/**
 * Vendor class used to display vendor information.
 * @author hexware
 */
public class Vendor {
/**
 * vId to store vId.
 */
  private int vId;
  private String vName;
  private String vUsername;
  private String vPassword;
  private String vEmail;
  private int vPhone;
  private String vAddress;
/**
 * Constructor.
 */
  public Vendor() {

  }
/**
 * @param argVId to initialize vendorId.
 * @param argVName to initialize vendorName.
 * @param argVUserName to initialize vendorUsername.
 * @param argVPassword to initialize vendorpassword.
 * @param argVEmail to initialize vendorEmail.
 * @param argVPhone to initialize vendorPhone.
 * @param argVAddress to initialize vendor address.
 */
  public Vendor(final int argVId, final String argVName, final String argVUserName,
      final String argVPassword, final String argVEmail, final int argVPhone, final String argVAddress) {
    this.vId = argVId;
    this.vName = argVName;
    this.vUsername = argVUserName;
    this.vPassword = argVPassword;
    this.vEmail = argVEmail;
    this.vPhone = argVPhone;
    this.vAddress = argVAddress;
  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Vendor vendor = (Vendor) obj;
    if (Objects.equals(vId, vendor.vId) && Objects.equals(vName, vendor.vName) && Objects.equals(vUsername, vendor.vUsername)
        && Objects.equals(vPassword, vendor.vPassword) && Objects.equals(vEmail, vendor.vEmail) && Objects.equals(vPhone, vendor.vPhone)
        && Objects.equals(vAddress, vendor.vAddress)) {
      return true;
    }
    return false;
  }
  @Override
  public final int hashCode() {
    return Objects.hash(vId, vName, vUsername, vPassword, vEmail, vPhone, vAddress);
  }
/**
 * @return the vId.
 */
  public final int getVId() {
    return vId;
  }
/**
 * @param argVId to store vId.
 */
  public final  void setVId(final int argVId) {
    this.vId = argVId;
  }
/**
 * @return VName.
 */
  public final String getVName() {
    return vName;
  }
  /**
 * @param argVName to store VName.
 */
  public final void setVName(final String argVName) {
    this.vName = argVName;
  }
/**
 * @return VUsername.
 */
  public final String getVUsername() {
    return vUsername;
  }
/**
 * @param argVUserName to store VUserName
 */
  public final void setVUsername(final String argVUserName) {
    this.vUsername = argVUserName;
  }
/**
 * @return VPassword.
 */
  public final String getVPassword() {
    return vPassword;
  }
/**
 * @param argVPassword to store VPassword.
 */
  public final void setVPassword(final String argVPassword) {
    this.vPassword = argVPassword;
  }
/**
 * @return EMail.
 */
  public final String getVEmail() {
    return vEmail;
  }
/**
 * @param argVEmail to store VEmail.
 */
  public final void setVEmail(final String argVEmail) {
    this.vEmail = argVEmail;
  }
/**
 * @return VPhone.
 */
  public final int getVPhone() {
    return vPhone;
  }
/**
 * @param argVPhone to store VPhone.
 */
  public final void setVPhone(final int argVPhone) {
    this.vPhone = argVPhone;
  }
/**
 * @return VAddress.
 */
  public final String getVAddress() {
    return vAddress;
  }
/**
 * @param argVAddress to store VAddress.
 */
  public final void setVAddress(final String argVAddress) {
    this.vAddress = argVAddress;
  }
/**
 * @return toString
 */
  @Override
  public final String toString() {
    return vId + " " + vName + " " + vUsername + " " + vPassword + " " + vEmail + " " + vPhone + " " + vAddress;
  }
}
