/**
 * <copyright>
 * </copyright>
 *

 */
package org.xtuml.bp.xtext.oal.xoal.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.xtuml.bp.xtext.oal.xoal.XoalPackage;
import org.xtuml.bp.xtext.oal.xoal.multiplication;
import org.xtuml.bp.xtext.oal.xoal.sign_expr;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>multiplication</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xtuml.bp.xtext.oal.xoal.impl.multiplicationImpl#getA1 <em>A1</em>}</li>
 *   <li>{@link org.xtuml.bp.xtext.oal.xoal.impl.multiplicationImpl#getA2 <em>A2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class multiplicationImpl extends MinimalEObjectImpl.Container implements multiplication
{
  /**
   * The cached value of the '{@link #getA1() <em>A1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getA1()
   * @generated
   * @ordered
   */
  protected sign_expr a1;

  /**
   * The cached value of the '{@link #getA2() <em>A2</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getA2()
   * @generated
   * @ordered
   */
  protected EList<sign_expr> a2;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected multiplicationImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return XoalPackage.Literals.MULTIPLICATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public sign_expr getA1()
  {
    return a1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetA1(sign_expr newA1, NotificationChain msgs)
  {
    sign_expr oldA1 = a1;
    a1 = newA1;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XoalPackage.MULTIPLICATION__A1, oldA1, newA1);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setA1(sign_expr newA1)
  {
    if (newA1 != a1)
    {
      NotificationChain msgs = null;
      if (a1 != null)
        msgs = ((InternalEObject)a1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XoalPackage.MULTIPLICATION__A1, null, msgs);
      if (newA1 != null)
        msgs = ((InternalEObject)newA1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XoalPackage.MULTIPLICATION__A1, null, msgs);
      msgs = basicSetA1(newA1, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XoalPackage.MULTIPLICATION__A1, newA1, newA1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<sign_expr> getA2()
  {
    if (a2 == null)
    {
      a2 = new EObjectContainmentEList<sign_expr>(sign_expr.class, this, XoalPackage.MULTIPLICATION__A2);
    }
    return a2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case XoalPackage.MULTIPLICATION__A1:
        return basicSetA1(null, msgs);
      case XoalPackage.MULTIPLICATION__A2:
        return ((InternalEList<?>)getA2()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case XoalPackage.MULTIPLICATION__A1:
        return getA1();
      case XoalPackage.MULTIPLICATION__A2:
        return getA2();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case XoalPackage.MULTIPLICATION__A1:
        setA1((sign_expr)newValue);
        return;
      case XoalPackage.MULTIPLICATION__A2:
        getA2().clear();
        getA2().addAll((Collection<? extends sign_expr>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case XoalPackage.MULTIPLICATION__A1:
        setA1((sign_expr)null);
        return;
      case XoalPackage.MULTIPLICATION__A2:
        getA2().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case XoalPackage.MULTIPLICATION__A1:
        return a1 != null;
      case XoalPackage.MULTIPLICATION__A2:
        return a2 != null && !a2.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //multiplicationImpl
